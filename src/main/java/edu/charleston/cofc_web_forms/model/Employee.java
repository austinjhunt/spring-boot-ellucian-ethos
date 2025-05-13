package edu.charleston.cofc_web_forms.model;

/**
 * Represents employee data, including salary, hourly rate, position ID, and
 * position description.
 */
public class Employee {

    private String salary;
    private String hourlyRate;
    private String positionId;
    private String positionDesc;

    /**
     * Constructs a new EmplData instance and initializes all fields to empty
     * strings.
     */
    public Employee() {
        salary = "";
        hourlyRate = "";
        positionId = "";
        positionDesc = "";
    }

    /**
     * Gets the employee's salary.
     *
     * @return The salary.
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Sets the employee's salary.
     *
     * @param salary The salary to set.
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Gets the employee's hourly rate.
     *
     * @return The hourly rate.
     */
    public String getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the employee's hourly rate.
     *
     * @param hourlyRate The hourly rate to set.
     */
    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Gets the employee's position ID.
     *
     * @return The position ID.
     */
    public String getPositionId() {
        return positionId;
    }

    /**
     * Sets the employee's position ID.
     *
     * @param positionId The position ID to set.
     */
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    /**
     * Gets the employee's position description.
     *
     * @return The position description.
     */
    public String getPositionDesc() {
        return positionDesc;
    }

    /**
     * Sets the employee's position description.
     *
     * @param positionDesc The position description to set.
     */
    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }
}
