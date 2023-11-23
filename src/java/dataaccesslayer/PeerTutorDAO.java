/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package dataaccesslayer;

import java.util.List;
import transferobject.PeerTutor;
import transferobject.Student;

/**
 * Interface for accessing and manipulating Peer Tutor data.
 */
public interface PeerTutorDAO {
    /**
     * Checks whether a peer tutor is registered in the system.
     *
     * @param peerTutor The PeerTutor object to check.
     * @return true if the peer tutor is registered, false otherwise.
     */
    boolean isPeerTutorRegistered(PeerTutor peerTutor);
    /**
     * Validates whether a course code is valid.
     *
     * @param courseCode The course code to validate.
     * @return true if the course code is valid, false otherwise.
     */
    boolean isCourseValid(String courseCode);
     /**
     * Determines if a peer tutor has taken a specific course.
     *
     * @param peerTutor   The PeerTutor object.
     * @param courseCode The course code to check against.
     * @return true if the peer tutor has taken the course, false otherwise.
     */
    boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode);
    /**
     * Retrieves the letter grade obtained by a peer tutor in a specific course.
     *
     * @param peerTutor   The PeerTutor object.
     * @param courseCode The course code.
     * @return The letter grade obtained by the peer tutor.
     */
    String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode);
     /**
     * Checks if a course is already assigned to a peer tutor.
     *
     * @param peerTutor   The PeerTutor object.
     * @param courseCode The course code to check.
     * @return true if the course is already assigned, false otherwise.
     */
    boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode);
     /**
     * Assigns a course to a peer tutor.
     *
     * @param peerTutor  The PeerTutor to assign the course to.
     * @param courseCode The course code to assign.
     * @return An integer indicating the result of the operation.
     */
    int assignCourseToPeerTutor(PeerTutor peerTutor, String courseCOde);
      /**
     * Retrieves a list of all peer tutors for a specified course.
     *
     * @param courseCode The course code.
     * @return A list of PeerTutor objects for the specified course.
     */
    List<PeerTutor> getAllPeerTutorsForCourse(String courseCode);
    /**
     * Deletes a peer tutor from the system.
     *
     * @param peerTutor The PeerTutor to delete.
     * @return An integer indicating the result of the operation.
     */
    int deletePeerTutor(PeerTutor peerTutor);
     /**
     * Retrieves the ID of a peer tutor.
     *
     * @param peerTutor The PeerTutor whose ID is to be retrieved.
     * @return The ID of the peer tutor.
     */
    int getPeerTutorID(PeerTutor peerTutor);
//    /**
//     * Updates the information of a student in the system.
//     *
//     * @param oldStudent The current Student object before the update.
//     * @param newStudent The new Student object with updated information.
//     * @return An integer indicating the result of the update operation.
//     */
//    int updateStudent(Student oldStudent, Student newStudent);
}

