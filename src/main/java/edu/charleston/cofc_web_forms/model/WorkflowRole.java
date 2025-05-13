package edu.charleston.cofc_web_forms.model;

/**
 * Represents a workflow role with owner and assigned users.
 */
public class WorkflowRole {

    private String owner;
    private String assigned;

    /**
     * Gets the owner.
     *
     * @return The owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner.
     *
     * @param owner The owner to set.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the assigned user.
     *
     * @return The assigned user.
     */
    public String getAssigned() {
        return assigned;
    }

    /**
     * Sets the assigned user.
     *
     * @param assigned The assigned user to set.
     */
    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }
}