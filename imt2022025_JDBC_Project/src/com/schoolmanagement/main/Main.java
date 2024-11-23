package com.schoolmanagement.main;

import com.schoolmanagement.models.*;
import com.schoolmanagement.services.SchoolService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Database connection setup
        String jdbcURL = "jdbc:mysql://localhost:3306/school_db"; // Replace with your database URL
        String username = "root";  // Replace with your DB username
        String password = "admin";  // Replace with your DB password

        try {
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create SchoolService to manage all operations
            SchoolService schoolService = new SchoolService(connection);

            // 1. Add a new student
            Student student = new Student(1, "S123", "Alice", "2000-01-01", "123 Elm Street", 3.8f);
            schoolService.addStudent(student);

            // 2. Add a new teacher
            Teacher teacher = new Teacher(1, "T123", "Dr. Smith", "1980-01-01", "456 Oak Street", 50000f);
            schoolService.addTeacher(teacher);

            // 3. Add a new course
            Course course = new Course(1, "C123", "Mathematics", "Advanced Math");
            schoolService.addCourse(course);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
