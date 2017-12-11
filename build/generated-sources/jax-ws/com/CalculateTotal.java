
package com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateTotal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateTotal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claims" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="membersSize" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateTotal", propOrder = {
    "claims",
    "membersSize"
})
public class CalculateTotal {

    protected double claims;
    protected int membersSize;

    /**
     * Gets the value of the claims property.
     * 
     */
    public double getClaims() {
        return claims;
    }

    /**
     * Sets the value of the claims property.
     * 
     */
    public void setClaims(double value) {
        this.claims = value;
    }

    /**
     * Gets the value of the membersSize property.
     * 
     */
    public int getMembersSize() {
        return membersSize;
    }

    /**
     * Sets the value of the membersSize property.
     * 
     */
    public void setMembersSize(int value) {
        this.membersSize = value;
    }

}
