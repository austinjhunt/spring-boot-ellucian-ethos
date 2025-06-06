
package sungardhe.workflow.ws.messages._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for NameParameterValuePair complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="NameParameterValuePair">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="stringValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="booleanValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="dateValue" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *           &lt;element name="numericValue" type="{urn:sungardhe:workflow:ws:messages:1.1}NumericValue"/>
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
@XmlType(name = "NameParameterValuePair", propOrder = {
        "name",
        "stringValue",
        "booleanValue",
        "dateValue",
        "numericValue"
})
public class NameParameterValuePair {

    @XmlElement(required = true)
    protected String name;
    protected String stringValue;
    protected Boolean booleanValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValue;
    protected String numericValue;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the stringValue property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Sets the value of the stringValue property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    /**
     * Gets the value of the booleanValue property.
     * 
     * @return
     *         possible object is
     *         {@link Boolean }
     * 
     */
    public Boolean isBooleanValue() {
        return booleanValue;
    }

    /**
     * Sets the value of the booleanValue property.
     * 
     * @param value
     *              allowed object is
     *              {@link Boolean }
     * 
     */
    public void setBooleanValue(Boolean value) {
        this.booleanValue = value;
    }

    /**
     * Gets the value of the dateValue property.
     * 
     * @return
     *         possible object is
     *         {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getDateValue() {
        return dateValue;
    }

    /**
     * Sets the value of the dateValue property.
     * 
     * @param value
     *              allowed object is
     *              {@link XMLGregorianCalendar }
     * 
     */
    public void setDateValue(XMLGregorianCalendar value) {
        this.dateValue = value;
    }

    /**
     * Gets the value of the numericValue property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getNumericValue() {
        return numericValue;
    }

    /**
     * Sets the value of the numericValue property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setNumericValue(String value) {
        this.numericValue = value;
    }

}
