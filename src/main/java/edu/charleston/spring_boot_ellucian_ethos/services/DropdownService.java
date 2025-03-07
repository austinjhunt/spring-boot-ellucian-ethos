package edu.charleston.spring_boot_ellucian_ethos.services;

import javax.swing.*;

import java.util.Calendar;
import java.util.List;

/**
 * Utility class for handling dropdown (JComboBox) and list box (JList) operations.
 */
public class DropdownService {

    /**
     * Enum representing different types of dropdown categories.
     */
    public enum Types {
        BONUS_REQUEST_TYPES, BONUS_REQUEST_SOURCES, BONUS_REQUEST_REASONS, SALARY_CHANGE_TYPES,
        MONTHS, YEARS, STATES, LAWFUL_PRESENCE_DOCS, YES_NO, EHHPC_CLINICAL_SUBJECT,
        EHHPC_CLINICAL_LEVEL, EHHPC_CLINICAL_PRACTICE_TERM
    }

    /**
     * Clears all items from a JComboBox.
     *
     * @param comboBox the JComboBox to clear
     */
    public static void clearComboBox(JComboBox<String> comboBox) {
        if (comboBox != null) {
            comboBox.removeAllItems();
        }
    }

    /**
     * Clears all items from a JList.
     *
     * @param list the JList to clear
     */
    public static void clearList(JList<String> list) {
        if (list != null) {
            list.setListData(new String[0]);
        }
    }

    /**
     * Adds an empty selection option to a JComboBox.
     *
     * @param comboBox  the JComboBox to modify
     * @param emptyText the text for the empty selection
     */
    public static void addEmptySelection(JComboBox<String> comboBox, String emptyText) {
        if (comboBox != null) {
            comboBox.insertItemAt(emptyText, 0);
        }
    }

    /**
     * Adds an "Other" selection option to a JComboBox.
     *
     * @param comboBox   the JComboBox to modify
     * @param otherValue the text for the "Other" selection
     */
    public static void addOtherSelection(JComboBox<String> comboBox, String otherValue) {
        if (comboBox != null && otherValue != null && !otherValue.isEmpty()) {
            comboBox.addItem(otherValue);
        }
    }

    /**
     * Loads a JComboBox with a list of items.
     *
     * @param comboBox    the JComboBox to load
     * @param listToLoad  the list of items to load
     * @param emptyValue  the text for an empty selection
     * @param otherValue  the text for an "Other" selection
     */
    public static <T> void loadComboBox(JComboBox<String> comboBox, List<T> listToLoad, String emptyValue, String otherValue) {
        if (comboBox != null && listToLoad != null) {
            addEmptySelection(comboBox, emptyValue);
            
            for (T item : listToLoad) {
                comboBox.addItem(item.toString());
            }
            
            if (otherValue != null && !otherValue.isEmpty()) {
                addOtherSelection(comboBox, otherValue);
            }
        }
    }

    /**
     * Checks if a valid selection is made in a JComboBox.
     *
     * @param comboBox the JComboBox to check
     * @return true if a valid selection is made, false otherwise
     */
    public static boolean isSelectedComboBox(JComboBox<String> comboBox) {
        return comboBox != null && comboBox.getSelectedItem() != null && !comboBox.getSelectedItem().equals("0");
    }

    /**
     * Checks if the "Other" option is selected in a JComboBox.
     *
     * @param comboBox the JComboBox to check
     * @return true if "Other" is selected, false otherwise
     */
    public static boolean isOtherSelectedComboBox(JComboBox<String> comboBox) {
        return comboBox != null && "99999".equals(comboBox.getSelectedItem());
    }

    /**
     * Checks if a valid selection is made in a JList.
     *
     * @param list the JList to check
     * @return true if a valid selection is made, false otherwise
     */
    public static boolean isSelectedList(JList<String> list) {
        return list != null && list.getSelectedValue() != null && !list.getSelectedValue().equals("0");
    }

    /**
     * Sets the selected value of a JComboBox.
     *
     * @param comboBox The JComboBox to modify.
     * @param value    The value to select.
     */
    public static void setSelectedValue(JComboBox<String> comboBox, String value) {
        if (comboBox != null) {
            for (int i = 0; i < comboBox.getItemCount(); i++) {
                if (comboBox.getItemAt(i).equals(value)) {
                    comboBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    /**
     * Sets a default selected value in a JComboBox.
     *
     * @param comboBox The JComboBox to modify.
     * @return true if a default selection was made, false otherwise.
     */
    public static boolean setDefaultSelectedValue(JComboBox<String> comboBox) {
        if (comboBox != null && comboBox.getItemCount() > 0) {
            if (comboBox.getItemAt(0).equals("0")) {
                if (comboBox.getItemCount() == 2) {
                    comboBox.setSelectedIndex(1);
                    return true;
                }
            } else if (comboBox.getItemCount() == 1) {
                comboBox.setSelectedIndex(0);
                return true;
            }
        }
        return false;
    }

    /**
     * Loads data into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     * @param data     The data array to load.
     */
    private static void loadComboBox(JComboBox<String> comboBox, String[][] data) {
        comboBox.removeAllItems();
        for (String[] entry : data) {
            comboBox.addItem(entry[0]);
        }
        comboBox.setSelectedIndex(0);
    }

    /**
     * Loads data into a JComboBox with a specified default selection.
     *
     * @param comboBox    The JComboBox to populate.
     * @param data        The data array to load.
     * @param selectedIdx The index to select.
     */
    private static void loadComboBox(JComboBox<String> comboBox, String[][] data, int selectedIdx) {
        comboBox.removeAllItems();
        for (String[] entry : data) {
            comboBox.addItem(entry[0]);
        }
        comboBox.setSelectedIndex(selectedIdx);
    }

    /**
     * Retrieves additional text associated with a selected item.
     *
     * @param data        The data array.
     * @param selectedIdx The selected index.
     * @return The additional text, if available.
     */
    public static String getSelectedExtraText(String[][] data, int selectedIdx) {
        if (selectedIdx < data.length && data[selectedIdx].length > 2) {
            return data[selectedIdx][2];
        }
        return "";
    }

    /**
     * Returns an array of U.S. states with abbreviations.
     *
     * @return A 2D array of state names and their abbreviations.
     */
    public static String[][] getStates() {
        return new String[][] {
            {"Select one...", ""},
            {"Alabama", "AL"},
            {"Alaska", "AK"},
            {"Arizona", "AZ"},
            {"Arkansas", "AR"},
            {"California", "CA"},
            {"Colorado", "CO"},
            {"Connecticut", "CT"},
            {"Delaware", "DE"},
            {"Florida", "FL"},
            {"Georgia", "GA"},
            {"Hawaii", "HI"},
            {"Idaho", "ID"},
            {"Illinois", "IL"},
            {"Indiana", "IN"},
            {"Iowa", "IA"},
            {"Kansas", "KS"},
            {"Kentucky", "KY"},
            {"Louisiana", "LA"},
            {"Maine", "ME"},
            {"Maryland", "MD"},
            {"Massachusetts", "MA"},
            {"Michigan", "MI"},
            {"Minnesota", "MN"},
            {"Mississippi", "MS"},
            {"Missouri", "MO"},
            {"Montana", "MT"},
            {"Nebraska", "NE"},
            {"Nevada", "NV"},
            {"New Hampshire", "NH"},
            {"New Jersey", "NJ"},
            {"New Mexico", "NM"},
            {"New York", "NY"},
            {"North Carolina", "NC"},
            {"North Dakota", "ND"},
            {"Ohio", "OH"},
            {"Oklahoma", "OK"},
            {"Oregon", "OR"},
            {"Pennsylvania", "PA"},
            {"Rhode Island", "RI"},
            {"South Carolina", "SC"},
            {"South Dakota", "SD"},
            {"Tennessee", "TN"},
            {"Texas", "TX"},
            {"Utah", "UT"},
            {"Vermont", "VT"},
            {"Virginia", "VA"},
            {"Washington", "WA"},
            {"West Virginia", "WV"},
            {"Wisconsin", "WI"},
            {"Wyoming", "WY"}
        };
    }

    /**
     * Loads U.S. states into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadStatesComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getStates());
    }

    /**
     * Loads U.S. state abbreviations into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadStatesShortComboBox(JComboBox<String> comboBox) {
        String[][] states = getStates();
        String[][] shortStates = new String[states.length][2];
        for (int i = 0; i < states.length; i++) {
            shortStates[i] = new String[] {states[i][1], states[i][1]};
        }
        loadComboBox(comboBox, shortStates);
    }


     /**
     * Generates an array of the next 10 years including a placeholder.
     *
     * @return A 2D array of years.
     */
    public static String[][] getYears() {
        String[][] tenYears = new String[10][];
        int year = Calendar.getInstance().get(Calendar.YEAR);
        tenYears[0] = new String[]{"Year", "0"};
        for (int i = 1; i < tenYears.length; i++) {
            tenYears[i] = new String[]{String.valueOf(year), String.valueOf(year)};
            year++;
        }
        return tenYears;
    }

    /**
     * Returns an array of months.
     *
     * @return A 2D array of months.
     */
    public static String[][] getMonths() {
        return new String[][] {
            {"Month", "0"},
            {"01", "01"},
            {"02", "02"},
            {"03", "03"},
            {"04", "04"},
            {"05", "05"},
            {"06", "06"},
            {"07", "07"},
            {"08", "08"},
            {"09", "09"},
            {"10", "10"},
            {"11", "11"},
            {"12", "12"}
        };
    }

    /**
     * Loads months into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadMonthComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getMonths());
    } 

    /**
     * Loads years into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadYearComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getYears());
    }

    /**
     * Returns an array of grades.
     *
     * @return A 2D array of grades.
     */
    public static String[][] getGrades() {
        return new String[][] {
            {"Select Grade...", "0"},
            {"A", "A"},
            {"B", "B"},
            {"C", "C"},
            {"D", "D"},
            {"E", "E"}
        };
    }

    /**
     * Loads grades into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadGradesComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getGrades());
    }

    /**
     * Returns an array of salary change types.
     *
     * @return A 2D array of salary change types.
     */
    public static String[][] getSalaryChangeTypes() {
        return new String[][] {
            {"Please Select...", "0", ""},
            {"Promotion", "1", ""},
            {"Reclassification", "2", ""},
            {"Performance", "3", ""},
            {"Retention", "4", ""},
            {"Transfer", "5", ""},
            {"Additional Duties/Skills", "6", ""},
            {"Salary Decrease", "7", ""},
            {"Special Pay", "8", "(Funds must be available from existing budget)"}
        };
    }

    /**
     * Loads salary change types into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadSalaryChangeTypesComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getSalaryChangeTypes());
    }

    /**
     * Returns an array of bonus request types.
     *
     * @return A 2D array of bonus request types.
     */
    public static String[][] getBonusRequestTypes() {
        return new String[][] {
            {"Please Select...", "0", ""},
            {"Standard employee bonus in accordance with State Bonus Proviso", "1", ""},
            {"Board of Trustees Award Plan", "2", ""}
        };
    }

    /**
     * Loads bonus request types into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadBonusRequestTypesComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getBonusRequestTypes());
    }

     /** Returns an array of bonus request sources. */
     public static String[][] getBonusRequestSources() {
        return new String[][] {
            {"Please Select...", "0", ""},
            {"State", "1", ""},
            {"Federal", "2", ""},
            {"Other", "3", ""}
        };
    }
    public static void loadBonusRequestSourcesComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getBonusRequestSources());
    }

    /** Returns an array of bonus request reasons. */
    public static String[][] getBonusRequestReasons() {
        return new String[][] {
            {"Please Select...", "0", ""},
            {"Contributions to increased organizational productivity", "1", ""},
            {"Development and/or implementation of improved work processes", "2", ""},
            {"Exceptional customer service", "3", ""},
            {"Realized cost savings", "4", ""},
            {"Faculty/Staff Award Plan", "5", ""},
            {"Other – Explanation required below", "6", ""}
        };
    }
    public static void loadBonusRequestReasonsComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getBonusRequestReasons());
    }


    /**
     * Returns an array of yes/no options.
     *
     * @return A 2D array of yes/no options.
     */
    public static String[][] getYesNoOptions() {
        return new String[][] {
            {"Yes", "Yes"},
            {"No", "No"}
        };
    }

    /**
     * Loads yes/no options into a JComboBox.
     *
     * @param comboBox The JComboBox to populate.
     */
    public static void loadYesNoComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getYesNoOptions());
    }

    /** Returns an array of lawful presence documents. */
    public static String[][] getLawfulPresenceDocs() {
        return new String[][] {
            {"Please Select...", "0", ""},
            {"South Carolina Driver’s License or ID issued after 2002", "1", ""},
            {"Current valid Driver’s License from eligible states", "2", ""},
            {"Current U.S. Passport", "3", ""},
            {"Certified Birth Certificate", "4", ""},
            {"Certificate of Citizenship (N-560/N-561)", "5", ""},
            {"Certificate of Naturalization (N-550/N-570)", "6", ""},
            {"U.S. Government Consular Report of Birth Abroad", "7", ""},
            {"Unexpired U.S. Military ID (DOD DD-2)", "8", ""}
        };
    }
    public static void loadLawfulPresenceDocsComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getLawfulPresenceDocs());
    }

    /** Returns an array of EHHP Clinical Subjects. */
    public static String[][] getEhhpClinicalSubject() {
        return new String[][] {
            {"No Preference", "No Preference"},
            {"Early Childhood - Pre-K", "Early Childhood - Pre-K"},
            {"Middle Grades - Math", "Middle Grades - Math"},
            {"Secondary - Science", "Secondary - Science"},
            {"Physical Education - Middle", "Physical Education - Middle"},
            {"Foreign Language - Elementary", "Foreign Language - Elementary"},
            {"MAT Special Education - LD", "MAT Special Education - LD"}
        };
    }
    public static void loadEhhpClinicalSubjectComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getEhhpClinicalSubject());
    }

    /** Returns an array of EHHP Clinical Levels. */
    public static String[][] getEhhpClinicalLevel() {
        return new String[][] {
            {"Undergraduate", "Undergraduate"},
            {"MAT", "MAT"}
        };
    }
    public static void loadEhhpClinicalLevelComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getEhhpClinicalLevel());
    }

    /** Returns an array of EHHP Clinical Practice Terms. */
    public static String[][] getEhhpClinicalPracticeTerm() {
        return new String[][] {
            {"Undergraduate", "Undergraduate"},
            {"MAT", "MAT"}
        };
    }
    public static void loadEhhpClinicalPracticeTermComboBox(JComboBox<String> comboBox) {
        loadComboBox(comboBox, getEhhpClinicalPracticeTerm());
    }


}
