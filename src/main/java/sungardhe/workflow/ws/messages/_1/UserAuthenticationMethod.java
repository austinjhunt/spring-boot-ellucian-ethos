
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for UserAuthenticationMethod complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="UserAuthenticationMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="externalID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAuthenticationMethod", propOrder = {
        "password",
        "externalID"
})
public class UserAuthenticationMethod {

    protected String password;
    protected String externalID;

    /**
     * Gets the value of the password property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setPassword(String value) {
        this.password = value;
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

}
