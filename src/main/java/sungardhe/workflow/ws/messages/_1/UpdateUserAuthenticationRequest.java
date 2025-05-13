
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for UpdateUserAuthenticationRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateUserAuthenticationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="userPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *         &lt;element name="authenticationMethod" type="{urn:sungardhe:workflow:ws:messages:1.1}UserAuthenticationMethod"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUserAuthenticationRequest", propOrder = {
        "authentication",
        "userPK",
        "authenticationMethod"
})
public class UpdateUserAuthenticationRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected PrimaryKey userPK;
    @XmlElement(required = true)
    protected UserAuthenticationMethod authenticationMethod;

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
     * Gets the value of the authenticationMethod property.
     * 
     * @return
     *         possible object is
     *         {@link UserAuthenticationMethod }
     * 
     */
    public UserAuthenticationMethod getAuthenticationMethod() {
        return authenticationMethod;
    }

    /**
     * Sets the value of the authenticationMethod property.
     * 
     * @param value
     *              allowed object is
     *              {@link UserAuthenticationMethod }
     * 
     */
    public void setAuthenticationMethod(UserAuthenticationMethod value) {
        this.authenticationMethod = value;
    }

}
