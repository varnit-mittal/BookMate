package com.schoolmanagement.dao;

import com.schoolmanagement.models.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO<Student> {

    public StudentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Student student) throws SQLException {
        String query = "INSERT INTO students (id, roll_number, name, dob, address, cgpa) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = createPreparedStatement(query, student.getId(), student.getRollNumber(), student.getName(), student.getDob(), student.getAddress(), student.getCgpa())) {
            ps.executeUpdate();
        }
    }

    @Override
    public Student read(int id) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
        }
        return null;
    }

    @Override
    public void update(Student student) throws SQLException {
        String query = "UPDATE students SET roll_number = ?, name = ?, dob = ?, address = ?, cgpa = ? WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, student.getRollNumber(), student.getName(), student.getDob(), student.getAddress(), student.getCgpa(), student.getId())) {
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id)) {
            ps.executeUpdate();
        }
    }

    @Override
    protected Student mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Student(
            rs.getInt("id"),
            rs.getString("roll_number"),
            rs.getString("name"),
            rs.getString("dob"),
            rs.getString("address"),
            rs.getFloat("cgpa")
        );
    }

    @Override
    public List<Student> mapResultSetToList(ResultSet rs) throws SQLException {
        String queString = "SELECT * FROM Students";
        rs = connection.prepareStatement(queString).executeQuery();
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(mapResultSetToEntity(rs));
        }
        return students;
    }
}
