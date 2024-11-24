package com.schoolmanagement.models;

import java.util.List;

public class Library {
    private int id;
    private String name;
    private List<Book> books;  // One-to-many relationship with Book

    public Library(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Add a single book to the library
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Remove a book by its ID from the library
    public void removeBookById(int bookId) {
        this.books.removeIf(book -> book.getId() == bookId);
    }

    @Override
    public String toString() {
        return "Library [id=" + id + ", name=" + name + ", books=" + books.size() + "]";
    }
}
