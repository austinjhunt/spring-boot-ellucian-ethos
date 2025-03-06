package edu.charleston.spring_boot_ellucian_ethos.model;

/**
 * Represents form data with various attributes.
 */
public class FormData {

    private String id;
    private String cwidBy;
    private String cwidFor;
    private String ipInfo;
    private String formId;
    private String formDataFields;
    private String dateEntered;
    private String accessKey;
    private String formTitle;
    private String formSubTitle;
    private String formUrl;
    private String workflowEvent;

    /**
     * Constructs a new FormData instance and clears its fields.
     */
    public FormData() {
        this.clear();
    }

    /**
     * Clears all fields of the FormData object.
     */
    public void clear() {
        id = "";
        cwidBy = "";
        cwidFor = "";
        ipInfo = "";
        formId = "";
        formDataFields = "";
        dateEntered = "";
        accessKey = "";
        formTitle = "";
        formSubTitle = "";
        formUrl = "";
        workflowEvent = "";
    }

    /**
     * Gets the ID.
     *
     * @return The ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID.
     *
     * @param id The ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the CWID by.
     *
     * @return The CWID by.
     */
    public String getCwidBy() {
        return cwidBy;
    }

    /**
     * Sets the CWID by.
     *
     * @param cwidBy The CWID by to set.
     */
    public void setCwidBy(String cwidBy) {
        this.cwidBy = cwidBy;
    }

    /**
     * Gets the CWID for.
     *
     * @return The CWID for.
     */
    public String getCwidFor() {
        return cwidFor;
    }

    /**
     * Sets the CWID for.
     *
     * @param cwidFor The CWID for to set.
     */
    public void setCwidFor(String cwidFor) {
        this.cwidFor = cwidFor;
    }

    /**
     * Gets the IP information.
     *
     * @return The IP information.
     */
    public String getIpInfo() {
        return ipInfo;
    }

    /**
     * Sets the IP information.
     *
     * @param ipInfo The IP information to set.
     */
    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
    }

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
     * Gets the form data fields.
     *
     * @return The form data fields.
     */
    public String getFormDataFields() {
        return formDataFields;
    }

    /**
     * Sets the form data fields.
     *
     * @param formDataFields The form data fields to set.
     */
    public void setFormDataFields(String formDataFields) {
        this.formDataFields = formDataFields;
    }

    /**
     * Gets the date entered.
     *
     * @return The date entered.
     */
    public String getDateEntered() {
        return dateEntered;
    }

    /**
     * Sets the date entered.
     *
     * @param dateEntered The date entered to set.
     */
    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    /**
     * Gets the access key.
     *
     * @return The access key.
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Sets the access key.
     *
     * @param accessKey The access key to set.
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * Gets the form title.
     *
     * @return The form title.
     */
    public String getFormTitle() {
        return formTitle;
    }

    /**
     * Sets the form title.
     *
     * @param formTitle The form title to set.
     */
    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    /**
     * Gets the form subtitle.
     *
     * @return The form subtitle.
     */
    public String getFormSubTitle() {
        return formSubTitle;
    }

    /**
     * Sets the form subtitle.
     *
     * @param formSubTitle The form subtitle to set.
     */
    public void setFormSubTitle(String formSubTitle) {
        this.formSubTitle = formSubTitle;
    }

    /**
     * Gets the form URL.
     *
     * @return The form URL.
     */
    public String getFormUrl() {
        return formUrl;
    }

    /**
     * Sets the form URL.
     *
     * @param formUrl The form URL to set.
     */
    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }

    /**
     * Gets the workflow event.
     *
     * @return The workflow event.
     */
    public String getWorkflowEvent() {
        return workflowEvent;
    }

    /**
     * Sets the workflow event.
     *
     * @param workflowEvent The workflow event to set.
     */
    public void setWorkflowEvent(String workflowEvent) {
        this.workflowEvent = workflowEvent;
    }
}
