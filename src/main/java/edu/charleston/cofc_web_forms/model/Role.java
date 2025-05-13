package edu.charleston.cofc_web_forms.model;

public enum Role {
    ADMIN("Admin", 0),
    DEPARTMENT_ADMIN("Department Admin", 1),
    DEPARTMENT_USER("Department User", 2),
    DEPARTMENT_APPROVER("Department Approver", 3),
    DEPARTMENT_VIEWER("Department Viewer", 4),
    DEPARTMENT_SUBMITTER("Department Submitter", 5),
    STUDENT("Student", 6);

    private String role;
    private Integer index;

    Role(String role, Integer index) {
        this.role = role;
        this.index = index;

    }

    public String getRole() {
        return role;
    }

    public Integer getIndex() {
        return index;
    }
}
