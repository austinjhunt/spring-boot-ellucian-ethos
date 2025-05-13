package edu.charleston.cofc_web_forms.services;

/** 
Miscellaneous utility methods 
@author Austin Hunt huntaj@cofc.edu

**/

import java.text.DecimalFormat;
import java.util.UUID;

public class UtilityService {

    public static String generateUniqueKey() {
        UUID uuid = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        return uuid.toString().replace("-", "") + timestamp;
    }

    public static String formatMoneyNoDot(String value) {
        try {
            double amount = Double.parseDouble(value);
            DecimalFormat formatter = new DecimalFormat("$#,###");
            return formatter.format(amount);
        } catch (NumberFormatException e) {
            return "Invalid Amount";
        }
    }

    public static String formatMoney(String value) {
        try {
            double amount = Double.parseDouble(value);
            DecimalFormat formatter = new DecimalFormat("$#,##0.00");
            return formatter.format(amount);
        } catch (NumberFormatException e) {
            return "Invalid Amount";
        }
    }

    public static boolean isIntegerValid(String intValue) {
        try {
            Integer.parseInt(intValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIntegerValid(String intValue, int length) {
        return intValue.length() == length && isIntegerValid(intValue);
    }

    public static boolean isStudentIDValid(String studentID) {
        return isIntegerValid(studentID, 8);
    }

    public static boolean isYearValid(String year) {
        return (year.startsWith("19") || year.startsWith("20")) && isIntegerValid(year, 4);
    }

    public static boolean isMoneyValid(String money) {
        money = money.replace(",", "").replace("$", "");
        try {
            Double.parseDouble(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String checkForEmptyValue(String value) {
        return (value == null || value.trim().isEmpty()) ? "N/A" : value.trim();
    }
}
