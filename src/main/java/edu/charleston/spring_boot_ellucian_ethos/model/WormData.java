package edu.charleston.spring_boot_ellucian_ethos.model;

/**
 * Represents worm data with form ID, action, user information, and roles.
 */
public class WormData {

    private String formId;
    private String action;
    private String userName;
    private String userCwid;
    private String ownerRole;
    private String role;

    /**
     * Gets the form ID.
     *
     * @return The form ID.
     */
    public String getFormId() {
        return formId;
    }

    /**
     * Sets the form ID.
     *
     * @param formId The form ID to set.
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * Gets the action.
     *
     * @return The action.
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the action.
     *
     * @param action The action to set.
     */
    public void setAction(String action) {
        this.action = action;
    }

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
     * Gets the user CWID.
     *
     * @return The user CWID.
     */
    public String getUserCwid() {
        return userCwid;
    }

    /**
     * Sets the user CWID.
     *
     * @param userCwid The user CWID to set.
     */
    public void setUserCwid(String userCwid) {
        this.userCwid = userCwid;
    }

    /**
     * Gets the owner role.
     *
     * @return The owner role.
     */
    public String getOwnerRole() {
        return ownerRole;
    }

    /**
     * Sets the owner role.
     *
     * @param ownerRole The owner role to set.
     */
    public void setOwnerRole(String ownerRole) {
        this.ownerRole = ownerRole;
    }

    /**
     * Gets the role.
     *
     * @return The role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
