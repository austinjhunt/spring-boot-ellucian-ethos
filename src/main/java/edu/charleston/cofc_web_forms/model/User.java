package edu.charleston.cofc_web_forms.model;

import java.util.List;

public class User {
    private List<Role> roles;
    private String cwid;
    private String firstName;
    private String lastName;
    private String email;

    public User(String cwid, String firstName, String lastName, String email, List<Role> roles) {
        this.cwid = cwid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public String getCwid() {
        return cwid;
    }

    public void setCwid(String cwid) {
        this.cwid = cwid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFullNameWithCWID() {
        return firstName + " " + lastName + " (" + cwid + ")";
    }

    public String getFullNameWithEmail() {
        return firstName + " " + lastName + " (" + email + ")";
    }

    public String getFullNameWithCWIDAndEmail() {
        return firstName + " " + lastName + " (" + cwid + ", " + email + ")";
    }

}
