package edu.charleston.cofc_web_forms.services;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.LoggingUtils;

import edu.charleston.cofc_web_forms.model.SiteConfiguration;
import jakarta.xml.ws.Holder;
import sungardhe.workflow.ws.wsdl._1.WorkflowWSPortType;
import sungardhe.workflow.ws.messages._1.Authentication;
import sungardhe.workflow.ws.messages._1.PrimaryKey;
import sungardhe.workflow.ws.messages._1.UserAttributes;

@Service
public class WorkflowService {

    public boolean isAvailable(
            String principal,
            String credential,
            String primaryKey) {
        Boolean result = false;

        Authentication auth = new Authentication();
        auth.setPrincipal(principal);
        auth.setCredential(primaryKey);
        PrimaryKey userPK = new PrimaryKey();
        userPK.setKey(primaryKey);

        try {
            // Comes from wsdl
            // https://workflow.cofc.edu/wfprod/ws/services/WorkflowWS/v1_1
            WorkflowWSPortType port = new WorkflowWSPortType() {

            };
            UserAttributes attrs = port.getUserAttributes(auth, new Holder(userPK));
            if (attrs != null) {
                result = attrs.isEnabled();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
