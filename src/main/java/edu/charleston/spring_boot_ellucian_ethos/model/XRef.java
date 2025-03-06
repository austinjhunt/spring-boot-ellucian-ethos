package edu.charleston.spring_boot_ellucian_ethos.model;

/**
 * Represents cross-reference data with account and department information.
 */
public class XRef {

    private String accountCode;
    private String accountTitle;
    private String department;
    private String departmentDesc;
    private String index;
    private String indexTitle;

    /**
     * Constructs a new XRef instance and clears its fields.
     */
    public XRef() {
        accountCode = "";
        accountTitle = "";
        department = "";
        departmentDesc = "";
        index = "";
        indexTitle = "";
    }

    /**
     * Gets the account code.
     *
     * @return The account code.
     */
    public String getAccountCode() {
        return accountCode;
    }

    /**
     * Sets the account code.
     *
     * @param accountCode The account code to set.
     */
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    /**
     * Gets the account title.
     *
     * @return The account title.
     */
    public String getAccountTitle() {
        return accountTitle;
    }

    /**
     * Sets the account title.
     *
     * @param accountTitle The account title to set.
     */
    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    /**
     * Gets the department.
     *
     * @return The department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department The department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the department description.
     *
     * @return The department description.
     */
    public String getDepartmentDesc() {
        return departmentDesc;
    }

    /**
     * Sets the department description.
     *
     * @param departmentDesc The department description to set.
     */
    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    /**
     * Gets the index.
     *
     * @return The index.
     */
    public String getIndex() {
        return index;
    }

    /**
     * Sets the index.
     *
     * @param index The index to set.
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Gets the index title.
     *
     * @
     */
    public String getIndexTitle() {
        return indexTitle;
    }

    /**
     * Sets the index title.
     *
     * @param indexTitle The index title to set.
     */
    public void setIndexTitle(String indexTitle) {
        this.indexTitle = indexTitle;
    }
}
