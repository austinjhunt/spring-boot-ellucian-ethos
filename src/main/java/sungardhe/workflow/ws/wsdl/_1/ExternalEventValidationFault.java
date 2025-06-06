
package sungardhe.workflow.ws.wsdl._1;

import jakarta.xml.ws.WebFault;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ExternalEventValidationFault", targetNamespace = "urn:sungardhe:workflow:ws:messages:1.1")
public class ExternalEventValidationFault
        extends Exception {

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private sungardhe.workflow.ws.messages._1.ExternalEventValidationFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExternalEventValidationFault(String message,
            sungardhe.workflow.ws.messages._1.ExternalEventValidationFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ExternalEventValidationFault(String message,
            sungardhe.workflow.ws.messages._1.ExternalEventValidationFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *         returns fault bean:
     *         sungardhe.workflow.ws.messages._1.ExternalEventValidationFault
     */
    public sungardhe.workflow.ws.messages._1.ExternalEventValidationFault getFaultInfo() {
        return faultInfo;
    }

}
