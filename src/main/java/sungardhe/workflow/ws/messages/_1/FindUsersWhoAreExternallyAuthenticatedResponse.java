
package sungardhe.workflow.ws.messages._1;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for FindUsersWhoAreExternallyAuthenticatedResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="FindUsersWhoAreExternallyAuthenticatedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userPK" type="{urn:sungardhe:workflow:ws:messages:1.1}PrimaryKey" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindUsersWhoAreExternallyAuthenticatedResponse", propOrder = {
        "userPK"
})
public class FindUsersWhoAreExternallyAuthenticatedResponse {

    protected List<PrimaryKey> userPK;

    /**
     * Gets the value of the userPK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userPK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getUserPK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrimaryKey }
     * 
     * 
     */
    public List<PrimaryKey> getUserPK() {
        if (userPK == null) {
            userPK = new ArrayList<PrimaryKey>();
        }
        return this.userPK;
    }

}
