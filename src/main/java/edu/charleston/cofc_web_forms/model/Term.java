package edu.charleston.cofc_web_forms.model;

/**
 * Represents term information.
 */
public class Term {

    private String code;
    private String description;
    private String startDate;
    private String partTermDesc;
    private String partTermCode;

    /**
     * Gets the term code.
     *
     * @return The term code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the term code.
     *
     * @param code The term code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the term description.
     *
     * @return The term description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the term description.
     *
     * @param description The term description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the start date.
     *
     * @return The start date.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the part term description.
     *
     * @return The part term description.
     */
    public String getPartTermDesc() {
        return partTermDesc;
    }

    /**
     * Sets the part term description.
     *
     * @param partTermDesc The part term description to set.
     */
    public void setPartTermDesc(String partTermDesc) {
        this.partTermDesc = partTermDesc;
    }

    /**
     * Gets the part term code.
     *
     * @return The part term code.
     */
    public String getPartTermCode() {
        return partTermCode;
    }

    /**
     * Sets the part term code.
     *
     * @param partTermCode The part term code to set.
     */
    public void setPartTermCode(String partTermCode) {
        this.partTermCode = partTermCode;
    }
}