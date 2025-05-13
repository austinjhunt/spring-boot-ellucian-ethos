
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for AddRoleAssignmentForUserResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AddRoleAssignmentForUserResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assignmentPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddRoleAssignmentForUserResponse", propOrder = {
        "assignmentPK"
})
public class AddRoleAssignmentForUserResponse {

    @XmlElement(required = true)
    protected PrimaryKey assignmentPK;

    /**
     * Gets the value of the assignmentPK property.
     * 
     * @return
     *         possible object is
     *         {@link PrimaryKey }
     * 
     */
    public PrimaryKey getAssignmentPK() {
        return assignmentPK;
    }

    /**
     * Sets the value of the assignmentPK property.
     * 
     * @param value
     *              allowed object is
     *              {@link PrimaryKey }
     * 
     */
    public void setAssignmentPK(PrimaryKey value) {
        this.assignmentPK = value;
    }

}
