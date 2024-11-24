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
            // Student student = new Student(1, "S123", "Alice", "2000-01-01", "123 Elm Street", 3.8f);
            // schoolService.addStudent(student);

            // // 2. Add a new teacher
            // Teacher teacher = new Teacher(1, "T123", "Dr. Smith", "1980-01-01", "456 Oak Street", 50000f);
            // schoolService.addTeacher(teacher);

            // // 3. Add a new course
            // Course course = new Course(1, "C123", "Mathematics", "Advanced Math");
            // schoolService.addCourse(course);

            // 6. Add a new library
            // Library library = new Library(1, "Central Library");
            // schoolService.addLibrary(library);

            // 4. Add a new book
            // Book book = new Book(1, "B123", "Mathematics for Dummies", "John Doe", 1);
            // System.out.println(book);
            // schoolService.addBook(book);

            // // 5. Add book to course
            // schoolService.markBookWithCourse(1, 1);


            // // 7. Get topper of the class
            // schoolService.getTopper();

            // // 8. Get all students
            // schoolService.getAllStudents();
            
            // // // 9. Get all teachers
            // schoolService.getAllTeachers();

            // // // 10. Get all courses
            // schoolService.getAllCourses();

            // // // 11. Get all books
            // schoolService.getAllBooks();

            // // 12. Get all books for a course
            // schoolService.getCourseBooks(1);

            // // 16. Enroll student in a course
            // schoolService.addStudentToCourse(1, 1);
            
            // // 13. Get all books for a student
            
            // // // 14. Update student CGPA
            // schoolService.updateCGPA(1, 4.0f);
            
            // // // // 15. Update teacher salary
            // schoolService.incrementSalary(1, 10000f);
            
            // // 17. Remove student from a course
            // schoolService.removeStudentFromCourse(1, 1);

            // schoolService.getStudentbooks(1);

            // schoolService.getHighestPaidTeacher();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
