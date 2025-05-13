package edu.charleston.cofc_web_forms.model;

/**
 * Represents a department with a code and title.
 */
public class Department {

    private String code;
    private String title;

    /**
     * Gets the department code.
     *
     * @return The department code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the department code.
     *
     * @param code The department code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the department title.
     *
     * @return The department title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the department title.
     *
     * @param title The department title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }
}