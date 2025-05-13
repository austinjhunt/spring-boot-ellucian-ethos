
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for AddRoleAssignmentForUserRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AddRoleAssignmentForUserRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{urn:sungardhe:workflow:ws:messages:1.1}Authentication"/>
 *         &lt;element name="roleAssignment" type="{urn:sungardhe:workflow:ws:messages:1.1}RoleAssignment"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddRoleAssignmentForUserRequest", propOrder = {
        "authentication",
        "roleAssignment"
})
public class AddRoleAssignmentForUserRequest {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected RoleAssignment roleAssignment;

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
     * Gets the value of the roleAssignment property.
     * 
     * @return
     *         possible object is
     *         {@link RoleAssignment }
     * 
     */
    public RoleAssignment getRoleAssignment() {
        return roleAssignment;
    }

    /**
     * Sets the value of the roleAssignment property.
     * 
     * @param value
     *              allowed object is
     *              {@link RoleAssignment }
     * 
     */
    public void setRoleAssignment(RoleAssignment value) {
        this.roleAssignment = value;
    }

}
