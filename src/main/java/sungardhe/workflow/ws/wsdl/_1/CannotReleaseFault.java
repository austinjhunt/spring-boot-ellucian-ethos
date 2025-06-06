
package sungardhe.workflow.ws.wsdl._1;

import jakarta.xml.ws.WebFault;
import sungardhe.workflow.ws.messages._1.CannotReleaseFaultDetail;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CannotReleaseFaultDetail", targetNamespace = "urn:sungardhe:workflow:ws:messages:1.1")
public class CannotReleaseFault
        extends Exception {

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CannotReleaseFaultDetail faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CannotReleaseFault(String message, CannotReleaseFaultDetail faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public CannotReleaseFault(String message, CannotReleaseFaultDetail faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *         returns fault bean:
     *         sungardhe.workflow.ws.messages._1.CannotReleaseFaultDetail
     */
    public CannotReleaseFaultDetail getFaultInfo() {
        return faultInfo;
    }

}
