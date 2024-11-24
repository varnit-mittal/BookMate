package com.schoolmanagement.tests;

import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.models.Student;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private static Connection connection;
    private static StudentDAO studentDAO;

    @BeforeAll
    static void setupDatabase() throws Exception {
        // Establish database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "admin");
        studentDAO = new StudentDAO(connection);
    }

    @AfterAll
    static void closeDatabase() throws Exception {
        // Close database connection
        if (connection != null) {
            connection.close();
        }
    }

    @BeforeEach
    void setupTestData() throws SQLException {
        // Insert test data before each test
        studentDAO.create(new Student(2, "S1234", "Alicia", "2000-01-01", "123 Elm Street", 3.8f));
    }

    @AfterEach
    void cleanupTestData() throws SQLException {
        // Cleanup test data after each test
        studentDAO.delete(2);
    }

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student(3, "S5678", "Bob", "1999-12-25", "456 Maple Street", 3.2f);
        studentDAO.create(student);

        Student retrieved = studentDAO.read(3);
        assertNotNull(retrieved, "Student should be created and retrievable.");
        assertEquals("Bob", retrieved.getName(), "The student name should match.");
        assertEquals(3.2f, retrieved.getCgpa(), "The student CGPA should match.");

        // Cleanup
        studentDAO.delete(3);
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = studentDAO.read(2);
        assertNotNull(student, "Student should exist before update.");

        student.setCgpa(2.5f);
        studentDAO.update(student);

        Student updatedStudent = studentDAO.read(2);
        assertEquals(2.5f, updatedStudent.getCgpa(), "The updated CGPA should match.");
    }

    @Test
    public void testDeleteStudent() throws Exception {
        studentDAO.delete(2);
        Student student = studentDAO.read(2);
        assertNull(student, "Student should be deleted and not retrievable.");
    }
}
