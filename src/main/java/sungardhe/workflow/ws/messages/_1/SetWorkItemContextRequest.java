
package sungardhe.workflow.ws.messages._1;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SetWorkItemContextRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SetWorkItemContextRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="workItemPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *         &lt;element name="contextParameter" type="{urn:sungardhe:workflow:ws:messages:1.1}NameParameterValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetWorkItemContextRequest", propOrder = {
        "authentication",
        "workItemPK",
        "contextParameter"
})
public class SetWorkItemContextRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected PrimaryKey workItemPK;
    protected List<NameParameterValuePair> contextParameter;

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

    /**
     * Gets the value of the contextParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextParameter
     * property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getContextParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameParameterValuePair }
     * 
     * 
     */
    public List<NameParameterValuePair> getContextParameter() {
        if (contextParameter == null) {
            contextParameter = new ArrayList<NameParameterValuePair>();
        }
        return this.contextParameter;
    }

}
