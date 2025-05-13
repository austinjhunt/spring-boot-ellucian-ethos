
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GetUserAttributesResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GetUserAttributesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *         &lt;element name="attributes" type="{urn:sungardhe:workflow:ws:messages:1.1}UserAttributes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserAttributesResponse", propOrder = {
        "userPK",
        "attributes"
})
public class GetUserAttributesResponse {

    @XmlElement(required = true)
    protected PrimaryKey userPK;
    @XmlElement(required = true)
    protected UserAttributes attributes;

    /**
     * Gets the value of the userPK property.
     * 
     * @return
     *         possible object is
     *         {@link PrimaryKey }
     * 
     */
    public PrimaryKey getUserPK() {
        return userPK;
    }

    /**
     * Sets the value of the userPK property.
     * 
     * @param value
     *              allowed object is
     *              {@link PrimaryKey }
     * 
     */
    public void setUserPK(PrimaryKey value) {
        this.userPK = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *         possible object is
     *         {@link UserAttributes }
     * 
     */
    public UserAttributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *              allowed object is
     *              {@link UserAttributes }
     * 
     */
    public void setAttributes(UserAttributes value) {
        this.attributes = value;
    }

}
