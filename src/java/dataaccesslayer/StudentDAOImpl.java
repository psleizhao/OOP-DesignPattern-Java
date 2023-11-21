/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

/**
 * Implementation of the StudentDAO interface.
 * Provides methods for accessing and manipulating student data in the database.
 */
public class StudentDAOImpl implements StudentDAO{
    
     /**
     * Retrieves the ID of a student from the database.
     *
     * @param student The Student object whose ID is to be retrieved.
     * @return The ID of the student, or 0 if not found.
     */
    @Override
    public int getStudentID(Student student){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT StudentID FROM student WHERE LastName = ? AND FirstName = ?");
            pstmt.setString(1, student.getLastName());
            pstmt.setString(2, student.getFirstName());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("StudentID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
    
    /**
     * Retrieves a list of all students from the database.
     *
     * @return A list of Student objects.
     */
    @Override
    public List<Student> getAllStudents(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Student> students = null;
        
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT * FROM student;");
            rs = pstmt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setLastName(rs.getString("LastName"));
                student.setFirstName(rs.getString("FirstName"));
                students.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return students;
    }
}
