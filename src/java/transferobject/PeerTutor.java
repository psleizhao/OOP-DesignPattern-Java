/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package transferobject;

/**
 * Represents a peer tutor in the system.
 * Contains information related to a peer tutor, including ID, last name, and first name.
 */
public class PeerTutor {

    // Here are the fields for a peer tutor.
    private int peerTutorID;
    private String lastName;
    private String firstName;
    
    // TODO:  Add the necessary getters and setters.

    /**
     * Gets the ID of the peer tutor.
     *
     * @return The ID of the peer tutor.
     */
    public int getPeerTutorID() {
        return peerTutorID;
    }

    /**
     * Sets the ID of the peer tutor.
     *
     * @param peerTutorID The ID to be set for the peer tutor.
     */
    public void setPeerTutorID(int peerTutorID) {
        this.peerTutorID = peerTutorID;
    }

    /**
     * Gets the last name of the peer tutor.
     *
     * @return The last name of the peer tutor.
     */
    public String getLastName() {
        return lastName;
    }

     /**
     * Sets the last name of the peer tutor.
     *
     * @param lastName The last name to be set for the peer tutor.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the peer tutor.
     *
     * @return The first name of the peer tutor.
     */
    public String getFirstName() {
        return firstName;
    }

     /**
     * Sets the first name of the peer tutor.
     *
     * @param firstName The first name to be set for the peer tutor.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
