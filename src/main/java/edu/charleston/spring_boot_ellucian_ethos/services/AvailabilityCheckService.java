package edu.charleston.spring_boot_ellucian_ethos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.charleston.spring_boot_ellucian_ethos.model.SiteConfiguration;

@Service
public class AvailabilityCheckService {

    @Autowired
    private CofCRestService cofCRestService;
    @Autowired
    private WorkflowService workflowService;
    @Autowired
    private SiteConfiguration siteConfiguration; // Assuming you have this configuration class

    public boolean isCofCWebServiceAvailable() {
        return cofCRestService.isAvailable();
    }

    public boolean isWorkFlowAvailable() {
        try {
            return workflowService.isAvailable(
                    siteConfiguration.getWorkFlowPrincipal(),
                    siteConfiguration.getWorkFlowCredential(),
                    siteConfiguration.getWorkFlowPrimaryKey());
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printStackTrace
            return false;
        }
    }
}