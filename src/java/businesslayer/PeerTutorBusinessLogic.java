/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */
package businesslayer;

import dataaccesslayer.PeerTutorDAO;
import dataaccesslayer.PeerTutorDAOImpl;
import dataaccesslayer.StudentDAO;
import dataaccesslayer.StudentDAOImpl;
import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

/**
 * Business Logic class for handling operations related to Peer Tutors.
 */
public class PeerTutorBusinessLogic {
    private PeerTutorDAO peerTutorDAO = null;
    private StudentDAO studentDAO = null;
    
     /**
     * Constructor for PeerTutorBusinessLogic.
     * Initializes Data Access Object (DAO) implementations for PeerTutor and Student.
     */
    public PeerTutorBusinessLogic() {
        // TODO:  Add your code here.  Need to instantiate a DAO object here.
        peerTutorDAO = new PeerTutorDAOImpl();
        studentDAO = new StudentDAOImpl();
    }
    
    /**
     * Checks if a peer tutor is already registered.
     *
     * @param peerTutor The PeerTutor object to check.
     * @return true if the peer tutor is registered, false otherwise.
     */
    public synchronized boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isPeerTutorRegistered(peerTutor);
    }
    
    /**
     * Validates if the given course code is valid.
     *
     * @param courseCode The course code to validate.
     * @return true if the course code is valid, false otherwise.
     */
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseValid(courseCode);
    }
    
    /**
     * Checks if a peer tutor has taken a specific course.
     *
     * @param peerTutor   The PeerTutor object to check.
     * @param courseCode The course code to check against the peer tutor's record.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.hasPeerTutorTakenCourse(peerTutor, courseCode);
    }
    
     /**
     * Retrieves the letter grade of a peer tutor for a specific course.
     *
     * @param peerTutor   The PeerTutor object.
     * @param courseCode The course code.
     * @return The letter grade obtained by the peer tutor in the specified course.
     */
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
    }
    /**
     * Checks if a course is already assigned to a peer tutor.
     *
     * @param peerTutor   The PeerTutor object.
     * @param courseCode The course code to check.
     * @return true if the course is already assigned to the peer tutor, false otherwise.
     */
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
    }
    
    /**
     * Assigns a course to a peer tutor.
     *
     * @param peerTutor   The PeerTutor to whom the course will be assigned.
     * @param courseCode The course code to assign.
     * @return An integer indicating the result of the operation (usually 1 for success or 0 for failure).
     */
    public int assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.assignCourseToPeerTutor(peerTutor, courseCode);
    }
    
    /**
     * Retrieves a list of all peer tutors for a specific course.
     *
     * @param courseCode The course code.
     * @return A list of PeerTutor objects who are tutoring the specified course.
     */
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getAllPeerTutorsForCourse(courseCode);
    }
    
    /**
     * Retrieves the ID of a specific peer tutor.
     *
     * @param peerTutor The PeerTutor whose ID is to be retrieved.
     * @return The ID of the specified peer tutor.
     */
    public int getPeerTutorID(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorID(peerTutor);
    }
    
    /**
     * Deletes a peer tutor from the system.
     *
     * @param peerTutor The PeerTutor to be deleted.
     * @return An integer indicating the result of the delete operation.
     */
    public int deletePeerTutor(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.deletePeerTutor(peerTutor);
    }
    
    /**
     * Updates the information of a student in the system.
     *
     * @param oldStudent The current Student object before the update.
     * @param newStudent The new Student object with updated information.
     * @return An integer indicating the result of the update operation.
     */
    public int updateStudent(Student oldStudent, Student newStudent){
        return peerTutorDAO.updateStudent(oldStudent, newStudent);
    }
    
     /**
     * Retrieves the ID of a specific student.
     *
     * @param student The Student whose ID is to be retrieved.
     * @return The ID of the specified student.
     */
    public int getStudentID(Student student){
        return studentDAO.getStudentID(student);
    }
    
    /**
     * Retrieves a list of all students in the system.
     *
     * @return A list of Student objects.
     */
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

}
