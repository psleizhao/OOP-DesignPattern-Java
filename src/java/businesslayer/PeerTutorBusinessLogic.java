package businesslayer;

import dataaccesslayer.PeerTutorDAO;
import dataaccesslayer.PeerTutorDAOImpl;
import dataaccesslayer.StudentDAO;
import dataaccesslayer.StudentDAOImpl;
import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

public class PeerTutorBusinessLogic {
    private PeerTutorDAO peerTutorDAO = null;
    private StudentDAO studentDAO = null;
    
    public PeerTutorBusinessLogic() {
        // TODO:  Add your code here.  Need to instantiate a DAO object here.
        peerTutorDAO = new PeerTutorDAOImpl();
        studentDAO = new StudentDAOImpl();
    }
    
    public synchronized boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isPeerTutorRegistered(peerTutor);
    }
    
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseValid(courseCode);
    }
    
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.hasPeerTutorTakenCourse(peerTutor, courseCode);
    }
    
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);
    }
    
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode);
    }
    
    public int assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.assignCourseToPeerTutor(peerTutor, courseCode);
    }
    
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getAllPeerTutorsForCourse(courseCode);
    }
    
    public int getPeerTutorID(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.getPeerTutorID(peerTutor);
    }
    
    public int deletePeerTutor(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Need to call the appropriate DAO method.
        return peerTutorDAO.deletePeerTutor(peerTutor);
    }
    
    public int updateStudent(Student oldStudent, Student newStudent){
        return peerTutorDAO.updateStudent(oldStudent, newStudent);
    }
    
    public int getStudentID(Student student){
        return studentDAO.getStudentID(student);
    }
    
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

}
