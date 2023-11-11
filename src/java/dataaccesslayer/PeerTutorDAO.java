package dataaccesslayer;

import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

public interface PeerTutorDAO {
    boolean isPeerTutorRegistered(PeerTutor peerTutor);
    boolean isCourseValid(String courseCode);
    boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode);
    String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode);
    boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode);
    int assignCourseToPeerTutor(PeerTutor peerTutor, String courseCOde);
    List<PeerTutor> getAllPeerTutorsForCourse(String courseCode);
    int deletePeerTutor(PeerTutor peerTutor);
    int getPeerTutorID(PeerTutor peerTutor);
    int updateStudent(Student oldStudent, Student newStudent);
}

