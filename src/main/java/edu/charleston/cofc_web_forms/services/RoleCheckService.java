package edu.charleston.cofc_web_forms.services;

public class RoleCheckService {

    private CofCRestService cofCRestService;

    public RoleCheckService(CofCRestService cofCRestService) {
        this.cofCRestService = cofCRestService;
    }

    public static boolean userHasRole(String role, String userRoles) {

        if (userRoles == null || userRoles.isEmpty()) {
            return false;
        }
        

        List<WorkflowRole> roles = CofCRestService
        for (String r : roles) {
            if (r.trim().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

}
