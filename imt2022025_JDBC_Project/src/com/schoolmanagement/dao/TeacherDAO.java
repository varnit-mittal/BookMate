package com.schoolmanagement.dao;

import com.schoolmanagement.models.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO extends BaseDAO<Teacher> {

    public TeacherDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Teacher teacher) throws SQLException {
        String query = "INSERT INTO teachers (id, emp_id, name, dob, address, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = createPreparedStatement(query, teacher.getId(), teacher.getEmpId(), teacher.getName(), teacher.getDob(), teacher.getAddress(), teacher.getSalary())) {
            ps.executeUpdate();
        }
    }

    @Override
    public Teacher read(int id) throws SQLException {
        String query = "SELECT * FROM teachers WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return mapResultSetToEntity(rs);
            }
        }
        return null;
    }

    @Override
    public void update(Teacher teacher) throws SQLException {
        String query = "UPDATE teachers SET emp_id = ?, name = ?, dob = ?, address = ?, salary = ? WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, teacher.getEmpId(), teacher.getName(), teacher.getDob(), teacher.getAddress(), teacher.getSalary(), teacher.getId())) {
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM teachers WHERE id = ?";
        try (PreparedStatement ps = createPreparedStatement(query, id)) {
            ps.executeUpdate();
        }
    }

    @Override
    protected Teacher mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Teacher(
            rs.getInt("id"),
            rs.getString("emp_id"),
            rs.getString("name"),
            rs.getString("dob"),
            rs.getString("address"),
            rs.getFloat("salary")
        );
    }

    @Override
    public List<Teacher> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            teachers.add(mapResultSetToEntity(rs));
        }
        return teachers;
    }
}
