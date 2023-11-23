/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package transferobject;

/**
 * Represents a student in the system.
 * Contains information related to a student, including ID, last name, and first name.
 */
public class Student {

    // Here are the fields for a student.
    /**
     * The unique identifier for the student.
     */
    private int studentID;

    /**
     * The last name of the student.
     */
    private String lastName;

    /**
     * The first name of the student.
     */
    private String firstName;
    
    // TODO:  Add the necessary getters and setters.

    /**
     * Gets the ID of the student.
     *
     * @return The ID of the student.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the ID of the student.
     *
     * @param StudentID The ID to be set for the student.
     */
    public void setStudentID(int StudentID) {
        this.studentID = StudentID;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName The last name to be set for the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName The first name to be set for the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
