package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

public class PeerTutorDAOImpl implements PeerTutorDAO {

    @Override
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "SELECT * FROM peertutor WHERE LastName = ? and FirstName = ?");
            pstmt.setString(1, peerTutor.getLastName());
            pstmt.setString(2, peerTutor.getFirstName());

            rs = pstmt.executeQuery();
            // Check if the ResultSet has any rows
            return rs.next(); // There are results
            // No results found

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
        return false;
    }

    @Override
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "SELECT * FROM course WHERE CourseCode = ?");
            //pstmt.setInt(1, receiver.getAwardID());
            pstmt.setString(1, courseCode);

            rs = pstmt.executeQuery();
            return rs.next();
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
        return false;
    }

    @Override
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String rsResult = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "SELECT * FROM student JOIN studentcourse "
                    + "ON student.StudentID = studentcourse.Student_StudentID "
                    + "WHERE student.LastName = ? and student.FirstName = ? and studentcourse.Course_CourseCode = ?");

            pstmt.setString(1, peerTutor.getLastName());
            pstmt.setString(2, peerTutor.getFirstName());
            pstmt.setString(3, courseCode);

            rs = pstmt.executeQuery();
            return rs.next();

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
        return false;

    }

    @Override
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String peerTutorLetterGradeForCourse = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "SELECT student.*, GradeCode FROM student JOIN grade "
                    + "ON student.StudentID = grade.Student_StudentID "
                    + "WHERE student.LastName = ? and student.FirstName = ? and grade.Course_CourseCode = ?");

            pstmt.setString(1, peerTutor.getLastName());
            pstmt.setString(2, peerTutor.getFirstName());
            pstmt.setString(3, courseCode);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                peerTutorLetterGradeForCourse = rs.getString("GradeCode");
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
        if (peerTutorLetterGradeForCourse!=null){
        return peerTutorLetterGradeForCourse;}
        else{return "E";}
    }

    @Override
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String rsResult = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            pstmt = con.prepareStatement(
                    "SELECT * FROM peertutor JOIN peertutorcourse "
                    + "ON peertutor.PeerTutorID = peertutorcourse.PeerTutor_PeerTutorID "
                    + "WHERE peertutor.LastName = ? and peertutor.FirstName = ? and peertutorcourse.Course_CourseCode = ?");

            pstmt.setString(1, peerTutor.getLastName());
            pstmt.setString(2, peerTutor.getFirstName());
            pstmt.setString(3, courseCode);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                rsResult = rs.getString("LastName");
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
        return rsResult != null;
    }

    @Override
    public int assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO peertutorcourse (PeerTutor_PeerTutorID, Course_CourseCode) "
                    + "VALUES(?, ?)");
            //pstmt.setInt(1, receiver.getAwardID());
            pstmt.setInt(1, peerTutor.getPeerTutorID());
            pstmt.setString(2, courseCode);
            int rowAffected = pstmt.executeUpdate();
            return rowAffected;
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

    @Override
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<PeerTutor> peertutors = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT * FROM peertutor "
                    + "JOIN peertutorcourse ON peertutor.PeerTutorID = peertutorcourse.PeerTutor_PeerTutorID "
                    + "WHERE peertutorcourse.Course_CourseCode = ?");
            pstmt.setString(1, courseCode);
            rs = pstmt.executeQuery();
            peertutors = new ArrayList<>();
            while (rs.next()) {
                PeerTutor peerTutor = new PeerTutor();
                peerTutor.setPeerTutorID(rs.getInt("PeerTutorID"));
                peerTutor.setLastName(rs.getString("LastName"));
                peerTutor.setFirstName(rs.getString("FirstName"));
                peertutors.add(peerTutor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
        return peertutors;
    }

    @Override
    public int deletePeerTutor(PeerTutor peerTutor) {
        Connection con = null;       
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            ResultSet rs = null;
            pstmt = con.prepareStatement("SELECT * FROM peertutor "
                    + "WHERE PeerTutorID = ?");
            pstmt.setInt(1, peerTutor.getPeerTutorID());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                peerTutor.setLastName(rs.getString("LastName"));
                peerTutor.setFirstName(rs.getString("FirstName"));
            }
            
            pstmt = con.prepareStatement(
                    "DELETE FROM peertutorcourse WHERE PeerTutor_PeerTutorID = ?");
            pstmt.setInt(1, peerTutor.getPeerTutorID());
            int rowAffected = pstmt.executeUpdate();
            return rowAffected;
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

    @Override
    public int updateStudent(Student oldStudent, Student newStudent) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
//            pstmt = con.prepareStatement(
//                    "UPDATE \"studnet\" SET \"FirstName\" = ?, "
//                    + "\"LastName\" = ? WHERE \"StudentID\" = ?");
            pstmt = con.prepareStatement(
                    "UPDATE student SET FirstName = ?, "
                    + "LastName = ? WHERE FirstName = ? AND LastName = ?");
            pstmt.setString(1, newStudent.getFirstName());
            pstmt.setString(2, newStudent.getLastName());
            pstmt.setString(3, oldStudent.getFirstName());
            pstmt.setString(4, oldStudent.getLastName());
            
            int rowAffected = pstmt.executeUpdate();
            
            pstmt = con.prepareStatement(
                    "UPDATE peertutor SET FirstName = ?, "
                    + "LastName = ? WHERE FirstName = ? AND LastName = ?" );
            pstmt.setString(1, newStudent.getFirstName());
            pstmt.setString(2, newStudent.getLastName());
            pstmt.setString(3, oldStudent.getFirstName());
            pstmt.setString(4, oldStudent.getLastName());
            
            rowAffected += pstmt.executeUpdate();
            return rowAffected;
            
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

    @Override
    public int getPeerTutorID(PeerTutor peerTutor) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT PeerTutorID FROM peertutor WHERE LastName = ? AND FirstName = ?");
            pstmt.setString(1, peerTutor.getLastName());
            pstmt.setString(2, peerTutor.getFirstName());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("PeerTutorID");
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
}
