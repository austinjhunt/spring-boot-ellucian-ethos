
package sungardhe.workflow.ws.messages._1;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PostExternalEventRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="PostExternalEventRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="eventName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="workflowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameter" type="{urn:sungardhe:workflow:ws:messages:1.1}NameParameterValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostExternalEventRequest", propOrder = {
        "authentication",
        "eventName",
        "productTypeName",
        "externalSource",
        "externalID",
        "externalDate",
        "workflowName",
        "parameter"
})
public class PostExternalEventRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected String eventName;
    @XmlElement(required = true)
    protected String productTypeName;
    @XmlElement(required = true)
    protected String externalSource;
    @XmlElement(required = true)
    protected String externalID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar externalDate;
    protected String workflowName;
    protected List<NameParameterValuePair> parameter;

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
     * Gets the value of the eventName property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the productTypeName property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getProductTypeName() {
        return productTypeName;
    }

    /**
     * Sets the value of the productTypeName property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setProductTypeName(String value) {
        this.productTypeName = value;
    }

    /**
     * Gets the value of the externalSource property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getExternalSource() {
        return externalSource;
    }

    /**
     * Sets the value of the externalSource property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setExternalSource(String value) {
        this.externalSource = value;
    }

    /**
     * Gets the value of the externalID property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getExternalID() {
        return externalID;
    }

    /**
     * Sets the value of the externalID property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setExternalID(String value) {
        this.externalID = value;
    }

    /**
     * Gets the value of the externalDate property.
     * 
     * @return
     *         possible object is
     *         {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getExternalDate() {
        return externalDate;
    }

    /**
     * Sets the value of the externalDate property.
     * 
     * @param value
     *              allowed object is
     *              {@link XMLGregorianCalendar }
     * 
     */
    public void setExternalDate(XMLGregorianCalendar value) {
        this.externalDate = value;
    }

    /**
     * Gets the value of the workflowName property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getWorkflowName() {
        return workflowName;
    }

    /**
     * Sets the value of the workflowName property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setWorkflowName(String value) {
        this.workflowName = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter
     * property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameParameterValuePair }
     * 
     * 
     */
    public List<NameParameterValuePair> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<NameParameterValuePair>();
        }
        return this.parameter;
    }

}
