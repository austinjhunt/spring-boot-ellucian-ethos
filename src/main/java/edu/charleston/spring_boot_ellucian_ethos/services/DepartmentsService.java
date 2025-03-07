package edu.charleston.spring_boot_ellucian_ethos.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Departments {
    public boolean IsMultiSelection;
    public int SelectedDepartment;
    public List<Department> DepartmentsList = new ArrayList<>();

    /**
     * Constructs a new Departments instance.
     */
    public Departments() {
        clear();
        IsMultiSelection = true;
    }

    /**
     * Clears the department list.
     */
    public void clear() {
        DepartmentsList.clear();
    }

    /**
     * Gets the department information as a string.
     *
     * @return The department information.
     */
    public String getDepartments() {
        return (IsMultiSelection) ? getDepartmentsAsString() : getSelectedDepartment();
    }

    /**
     * Gets the departments as a comma-separated string.
     *
     * @return The departments as a string.
     */
    public String getDepartmentsAsString() {
        return DepartmentsList.stream().map(Department::getTitle).collect(Collectors.joining(", "));
    }

    /**
     * Gets the selected department.
     *
     * @return The selected department.
     */
    public String getSelectedDepartment() {
        if (DepartmentsList.size() > SelectedDepartment) {
            return DepartmentsList.get(SelectedDepartment).getTitle();
        }
        return "";
    }
}
