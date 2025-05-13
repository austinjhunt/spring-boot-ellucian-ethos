
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for RoleAssignment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RoleAssignment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey"/>
 *         &lt;element name="organizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleAssignment", propOrder = {
        "userPK",
        "organizationName",
        "roleName",
        "startDate",
        "endDate"
})
public class RoleAssignment {

    @XmlElement(required = true)
    protected PrimaryKey userPK;
    protected String organizationName;
    @XmlElement(required = true)
    protected String roleName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;

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
     * Gets the value of the organizationName property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *         possible object is
     *         {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *              allowed object is
     *              {@link XMLGregorianCalendar }
     * 
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *         possible object is
     *         {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *              allowed object is
     *              {@link XMLGregorianCalendar }
     * 
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
