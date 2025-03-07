package edu.charleston.spring_boot_ellucian_ethos.services;

import edu.charleston.spring_boot_ellucian_ethos.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
class DepartmentsService {
    public boolean IsMultiSelection;
    public int SelectedDepartment;
    public List<Department> DepartmentsList = new ArrayList<>();

    /**
     * Constructs a new Departments instance.
     */
    public DepartmentsService() {
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
