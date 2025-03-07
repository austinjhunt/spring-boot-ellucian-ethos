package edu.charleston.spring_boot_ellucian_ethos.services;

import org.springframework.stereotype.Service;
import edu.charleston.spring_boot_ellucian_ethos.model.SiteConfiguration;

@Service
public class WorkflowService {

    public boolean isAvailable(
        String principal, 
        String credential, 
        String primaryKey
    ) {
        Boolean result = false;

        Authentication auth = new Authentication();
        auth.principal = principal;
        auth.credential = credential; 
        PrimaryKey userPK = new PrimaryKey();
        userPK.key = primaryKey;

        try
        {
            WorkflowWSPortTypeClient port = new WorkflowWSPortTypeClient();
            UserAttributes attrs = port.getUserAttributes(auth, ref userPK);
            if (attrs != null)
            {
                result = attrs.enabled;
            }
        }
        catch (Exception ex)
        {
            LoggingUtil.LogErrorByEmail(ex);
        }

        return result;
    }

    // ------------------------------------------------------------------------------
    protected bool IsWorkFlowAvailable()
    {
        bool result = false;

        Authentication auth = new Authentication();
        auth.principal = SiteConfiguration.WorkFlowPrincipal;
        auth.credential = SiteConfiguration.WorkFlowCredential;

        PrimaryKey userPK = new PrimaryKey();
        userPK.key = SiteConfiguration.WorkFlowPrimaryKey;

        try
        {
            WorkflowWSPortTypeClient port = new WorkflowWSPortTypeClient();
            UserAttributes attrs = port.getUserAttributes(auth, ref userPK);
            if (attrs != null)
            {
                result = attrs.enabled;
            }
        }
        catch (Exception ex)
        {
            LoggingUtil.LogErrorByEmail(ex);
        }

        return result;
    }
}
