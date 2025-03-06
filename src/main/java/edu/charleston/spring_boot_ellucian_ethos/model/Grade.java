package edu.charleston.spring_boot_ellucian_ethos.model;

//----------------------------------------------------------------------------------
/**
 * Represents a grade with grade and modification codes.
 */
public class Grade {

    private String gradeCode;
    private String gModCode;

    /**
     * Gets the grade code.
     *
     * @return The grade code.
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * Sets the grade code.
     *
     * @param gradeCode The grade code to set.
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * Gets the grade modification code.
     *
     * @return The grade modification code.
     */
    public String getgModCode() {
        return gModCode;
    }

    /**
     * Sets the grade modification code.
     *
     * @param gModCode The grade modification code to set.
     */
    public void setgModCode(String gModCode) {
        this.gModCode = gModCode;
    }
}
