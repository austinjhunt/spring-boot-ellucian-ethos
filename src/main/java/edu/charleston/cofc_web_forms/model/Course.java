package edu.charleston.cofc_web_forms.model;

/**
 * Represents a course with various attributes.
 */
public class Course {

    public enum CourseLevelCodes {
        GRAD, UNDERGRAD
    }

    private String crn;
    private String courseIdCode;
    private String courseIdNumber;
    private String courseIdSection;
    private String term;
    private String termDesc;
    private String termStartDate;
    private String termEndDate;
    private String maxEnrollment;
    private String enrollment;

    /**
     * Constructs a new Course instance and clears its fields.
     */
    public Course() {
        this.clear();
    }

    /**
     * Clears all fields of the Course object.
     */
    public void clear() {
        crn = "";
        courseIdCode = "";
        courseIdNumber = "";
        courseIdSection = "";
        term = "";
        termDesc = "";
        termStartDate = "";
        termEndDate = "";
        maxEnrollment = "";
        enrollment = "";
    }

    /**
     * Gets the full Course ID, combining code, number, and section.
     *
     * @return The full Course ID, or an empty string if CourseIDCode is empty.
     */
    public String getCourseId() {
        if (courseIdCode == null || courseIdCode.isEmpty()) {
            return "";
        }
        return courseIdCode + "-" + courseIdNumber + "-" + courseIdSection;
    }

    /**
     * Checks if the course attributes are set.
     *
     * @return True if all required course attributes are set, false otherwise.
     */
    public boolean isCourseSet() {
        return crn != null && !crn.isEmpty() &&
                courseIdCode != null && !courseIdCode.isEmpty() &&
                courseIdNumber != null && !courseIdNumber.isEmpty() &&
                courseIdSection != null && !courseIdSection.isEmpty() &&
                term != null && !term.isEmpty() &&
                termDesc != null && !termDesc.isEmpty();
    }

    /**
     * Gets the CRN (Course Reference Number).
     *
     * @return The CRN.
     */
    public String getCrn() {
        return crn;
    }

    /**
     * Sets the CRN (Course Reference Number).
     *
     * @param crn The CRN to set.
     */
    public void setCrn(String crn) {
        this.crn = crn;
    }

    /**
     * Gets the Course ID Code.
     *
     * @return The Course ID Code.
     */
    public String getCourseIdCode() {
        return courseIdCode;
    }

    /**
     * Sets the Course ID Code.
     *
     * @param courseIdCode The Course ID Code to set.
     */
    public void setCourseIdCode(String courseIdCode) {
        this.courseIdCode = courseIdCode;
    }

    /**
     * Gets the Course ID Number.
     *
     * @return The Course ID Number.
     */
    public String getCourseIdNumber() {
        return courseIdNumber;
    }

    /**
     * Sets the Course ID Number.
     *
     * @param courseIdNumber The Course ID Number to set.
     */
    public void setCourseIdNumber(String courseIdNumber) {
        this.courseIdNumber = courseIdNumber;
    }

    /**
     * Gets the Course ID Section.
     *
     * @return The Course ID Section.
     */
    public String getCourseIdSection() {
        return courseIdSection;
    }

    /**
     * Sets the Course ID Section.
     *
     * @param courseIdSection The Course ID Section to set.
     */
    public void setCourseIdSection(String courseIdSection) {
        this.courseIdSection = courseIdSection;
    }

    /**
     * Gets the Term.
     *
     * @return The Term.
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the Term.
     *
     * @param term The Term to set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Gets the Term Description.
     *
     * @return The Term Description.
     */
    public String getTermDesc() {
        return termDesc;
    }

    /**
     * Sets the Term Description.
     *
     * @param termDesc The Term Description to set.
     */
    public void setTermDesc(String termDesc) {
        this.termDesc = termDesc;
    }

    /**
     * Gets the Term Start Date.
     *
     * @return The Term Start Date.
     */
    public String getTermStartDate() {
        return termStartDate;
    }

    /**
     * Sets the Term Start Date.
     *
     * @param termStartDate The Term Start Date to set.
     */
    public void setTermStartDate(String termStartDate) {
        this.termStartDate = termStartDate;
    }

    /**
     * Gets the Term End Date.
     *
     * @return The Term End Date.
     */
    public String getTermEndDate() {
        return termEndDate;
    }

    /**
     * Sets the Term End Date.
     *
     * @param termEndDate The Term End Date to set.
     */
    public void setTermEndDate(String termEndDate) {
        this.termEndDate = termEndDate;
    }

    /**
     * Gets the Max Enrollment.
     *
     * @return The Max Enrollment.
     */
    public String getMaxEnrollment() {
        return maxEnrollment;
    }

    /**
     * Sets the Max Enrollment.
     *
     * @param maxEnrollment The Max Enrollment to set.
     */
    public void setMaxEnrollment(String maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    /**
     * Gets the Enrollment.
     *
     * @return The Enrollment.
     */
    public String getEnrollment() {
        return enrollment;
    }

    /**
     * Sets the Enrollment.
     *
     * @param enrollment The Enrollment to set.
     */
    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }
}
