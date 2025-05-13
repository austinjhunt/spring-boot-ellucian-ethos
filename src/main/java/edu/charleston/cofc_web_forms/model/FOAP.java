package edu.charleston.cofc_web_forms.model;

/**
 * Represents a FOAP (Fund, Organization, Account, Program) object.
 */
public class FOAP {

    private String account;
    private String index;
    private String title;
    private String fund;
    private String organization;
    private String program;

    /**
     * Constructs a new FOAP instance and clears its fields.
     */
    public FOAP() {
        this.clear();
    }

    /**
     * Clears all fields of the FOAP object.
     */
    public void clear() {
        account = "";
        index = "";
        title = "";
        fund = "";
        organization = "";
        program = "";
    }

    /**
     * Gets the account.
     *
     * @return The account.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account.
     *
     * @param account The account to set.
     */
    public void setAccount(String account) {
        this.account = account;
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
     * Gets the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the fund.
     *
     * @return The fund.
     */
    public String getFund() {
        return fund;
    }

    /**
     * Sets the fund.
     *
     * @param fund The fund to set.
     */
    public void setFund(String fund) {
        this.fund = fund;
    }

    /**
     * Gets the organization.
     *
     * @return The organization.
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the organization.
     *
     * @param organization The organization to set.
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Gets the program.
     *
     * @return The program.
     */
    public String getProgram() {
        return program;
    }

    /**
     * Sets the program.
     *
     * @param program The program to set.
     */
    public void setProgram(String program) {
        this.program = program;
    }
}
