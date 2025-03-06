package edu.charleston.spring_boot_ellucian_ethos.model;

//----------------------------------------------------------------------------------
/**
 * Represents student information.
 */
public class Student {

    private String cwid;
    private String pidm;
    private String firstName;
    private String lastName;
    private String userName;
    private String advisorCode;
    private String studentLevel;
    private String classLevel;
    private String emailAddress;
    private String emalCode;
    private String fullAddress;
    private String addressCode;
    private String phoneNumber;
    private String phoneCode;
    private String eClass;
    private String eClassDesc;

    /**
     * Constructs a new Student instance and clears its fields.
     */
    public Student() {
        this.clear();
    }

    /**
     * Clears all fields of the Student object.
     */
    public void clear() {
        cwid = "";
        pidm = "";
        firstName = "";
        lastName = "";
        userName = "";
        advisorCode = "";
        studentLevel = "";
        classLevel = "";
        emailAddress = "";
        emalCode = "";
        fullAddress = "";
        addressCode = "";
        phoneNumber = "";
        phoneCode = "";
        eClass = "";
        eClassDesc = "";
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
     * Gets the PIDM.
     *
     * @return The PIDM.
     */
    public String getPidm() {
        return pidm;
    }

    /**
     * Sets the PIDM.
     *
     * @param pidm The PIDM to set.
     */
    public void setPidm(String pidm) {
        this.pidm = pidm;
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
     * Gets the advisor code.
     *
     * @return The advisor code.
     */
    public String getAdvisorCode() {
        return advisorCode;
    }

    /**
     * Sets the advisor code.
     *
     * @param advisorCode The advisor code to set.
     */
    public void setAdvisorCode(String advisorCode) {
        this.advisorCode = advisorCode;
    }

    /**
     * Gets the student level.
     *
     * @return The student level.
     */
    public String getStudentLevel() {
        return studentLevel;
    }

    /**
     * Sets the student level.
     *
     * @param studentLevel The student level to set.
     */
    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    /**
     * Gets the class level.
     *
     * @return The class level.
     */
    public String getClassLevel() {
        return classLevel;
    }

    /**
     * Sets the class level.
     *
     * @param classLevel The class level to set.
     */
    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    /**
     * Gets the email address.
     *
     * @return The email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress The email address to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the email code.
     *
     * @return The email code.
     */
    public String getEmalCode() {
        return emalCode;
    }

    /**
     * Sets the email code.
     *
     * @param emalCode The email code to set.
     */
    public void setEmalCode(String emalCode) {
        this.emalCode = emalCode;
    }

    /**
     * Gets the full address.
     *
     * @return The full address.
     */
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * Sets the full address.
     *
     * @param fullAddress The full address to set.
     */
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    /**
     * Gets the address code.
     *
     * @return The address code.
     */
    public String getAddressCode() {
        return addressCode;
    }

    /**
     * Sets the address code.
     *
     * @param addressCode The address code to set.
     */
    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the phone code.
     *
     * @return The phone code.
     */
    public String getPhoneCode() {
        return phoneCode;
    }

    /**
     * Sets the phone code.
     *
     * @param phoneCode The phone code to set.
     */
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    /**
     * Gets the EClass.
     *
     * @return The EClass.
     */
    public String getEClass() {
        return eClass;
    }

    /**
     * Sets the EClass.
     *
     * @param eClass The EClass to set.
     */
    public void setEClass(String eClass) {
        this.eClass = eClass;
    }

    /**
     * Gets the EClass description.
     *
     * @return The EClass description.
     */
    public String getEClassDesc() {
        return eClassDesc;
    }

    /**
     * Sets the EClass description.
     *
     * @param eClassDesc The EClass description to set.
     */
    public void setEClassDesc(String eClassDesc) {
        this.eClassDesc = eClassDesc;
    }
}