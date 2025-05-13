package edu.charleston.cofc_web_forms.model;

/**
 * Represents a workflow user with user name, CWID, first name, and last name.
 */
public class WorkflowUser {

    private String userName;
    private String cwid;
    private String firstName;
    private String lastName;

    /**
     * Gets the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName The user name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the CWID.
     *
     * @return The CWID.
     */
    public String getCwid() {
        return cwid;
    }

    /**
     * Sets the CWID.
     *
     * @param cwid The CWID to set.
     */
    public void setCwid(String cwid) {
        this.cwid = cwid;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
