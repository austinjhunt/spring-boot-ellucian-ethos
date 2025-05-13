
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Authentication complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Authentication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="credential" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authentication", propOrder = {
        "principal",
        "credential"
})
public class Authentication {

    @XmlElement(required = true)
    protected String principal;
    @XmlElement(required = true)
    protected String credential;

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setPrincipal(String value) {
        this.principal = value;
    }

    /**
     * Gets the value of the credential property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getCredential() {
        return credential;
    }

    /**
     * Sets the value of the credential property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setCredential(String value) {
        this.credential = value;
    }

}
