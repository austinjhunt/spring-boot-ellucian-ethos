
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GetWorkItemContextRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GetWorkItemContextRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="workItemPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetWorkItemContextRequest", propOrder = {
        "authentication",
        "workItemPK"
})
public class GetWorkItemContextRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected PrimaryKey workItemPK;

    /**
     * Gets the value of the authentication property.
     * 
     * @return
     *         possible object is
     *         {@link Authentication }
     * 
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     * 
     * @param value
     *              allowed object is
     *              {@link Authentication }
     * 
     */
    public void setAuthentication(Authentication value) {
        this.authentication = value;
    }

    /**
     * Gets the value of the workItemPK property.
     * 
     * @return
     *         possible object is
     *         {@link PrimaryKey }
     * 
     */
    public PrimaryKey getWorkItemPK() {
        return workItemPK;
    }

    /**
     * Sets the value of the workItemPK property.
     * 
     * @param value
     *              allowed object is
     *              {@link PrimaryKey }
     * 
     */
    public void setWorkItemPK(PrimaryKey value) {
        this.workItemPK = value;
    }

}
