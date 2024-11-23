package com.schoolmanagement.dao;

import com.schoolmanagement.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends BaseDAO<Book> {

    public BookDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Book book) throws SQLException {
        String query = "INSERT INTO books (id, book_id, title, author, library_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = createPreparedStatement(query, book.getId(), book.getBookId(), book.getTitle(), book.getAuthor(), book.getLibraryId())) {
            ps.executeUpdate();
        }
    }

    @Override
    public Book read(int id) throws SQLException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
        }
        return null;
    }

    @Override
    public void update(Book book) throws SQLException {
        String query = "UPDATE books SET title = ?, author = ?, library_id = ? WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, book.getTitle(), book.getAuthor(), book.getLibraryId(), book.getId())) {
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id)) {
            ps.executeUpdate();
        }
    }

    @Override
    protected Book mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Book(
            rs.getInt("id"),
            rs.getString("book_id"),
            rs.getString("title"),
            rs.getString("author"),
            rs.getInt("library_id")
        );
    }

    @Override
    public List<Book> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            books.add(mapResultSetToEntity(rs));
        }
        return books;
    }
}
