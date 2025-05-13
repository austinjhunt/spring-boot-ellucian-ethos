package edu.charleston.cofc_web_forms.model;

/**
 * Represents a document with various attributes.
 */
public class Document {

    private String id;
    private String formId;
    private String name;
    private String type;
    private String desc;
    private byte[] data;
    private String dateEntered;

    /**
     * Gets the document ID.
     *
     * @return The document ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the document ID.
     *
     * @param id The document ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the form ID associated with the document.
     *
     * @return The form ID.
     */
    public String getFormId() {
        return formId;
    }

    /**
     * Sets the form ID associated with the document.
     *
     * @param formId The form ID to set.
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * Gets the document name.
     *
     * @return The document name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the document name.
     *
     * @param name The document name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the document type.
     *
     * @return The document type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the document type.
     *
     * @param type The document type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the document description.
     *
     * @return The document description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the document description.
     *
     * @param desc The document description to set.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets the document data as a byte array.
     *
     * @return The document data.
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the document data as a byte array.
     *
     * @param data The document data to set.
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Gets the date the document was entered.
     *
     * @return The date entered.
     */
    public String getDateEntered() {
        return dateEntered;
    }

    /**
     * Sets the date the document was entered.
     *
     * @param dateEntered The date entered to set.
     */
    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }
}
