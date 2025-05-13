
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PostExternalEventResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="PostExternalEventResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="externalEventPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostExternalEventResponse", propOrder = {
        "externalEventPK"
})
public class PostExternalEventResponse {

    @XmlElement(required = true)
    protected PrimaryKey externalEventPK;

    /**
     * Gets the value of the externalEventPK property.
     * 
     * @return
     *         possible object is
     *         {@link PrimaryKey }
     * 
     */
    public PrimaryKey getExternalEventPK() {
        return externalEventPK;
    }

    /**
     * Sets the value of the externalEventPK property.
     * 
     * @param value
     *              allowed object is
     *              {@link PrimaryKey }
     * 
     */
    public void setExternalEventPK(PrimaryKey value) {
        this.externalEventPK = value;
    }

}
