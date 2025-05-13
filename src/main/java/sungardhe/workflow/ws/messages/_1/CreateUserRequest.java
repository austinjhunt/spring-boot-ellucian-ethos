
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateUserRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CreateUserRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="attributes" type="{urn:sungardhe:workflow:ws:messages:1.1}UserAttributes"/>
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
@XmlType(name = "CreateUserRequest", propOrder = {
        "authentication",
        "attributes",
        "authenticationMethod"
})
public class CreateUserRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected UserAttributes attributes;
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
