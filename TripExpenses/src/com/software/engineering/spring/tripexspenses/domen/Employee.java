package com.software.engineering.spring.tripexspenses.domen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stefan.vasic
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeid", query = "SELECT e FROM Employees e WHERE e.employeeid = :employeeid")
    , @NamedQuery(name = "Employees.findByFullname", query = "SELECT e FROM Employees e WHERE e.fullname = :fullname")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findByPersidnum", query = "SELECT e FROM Employees e WHERE e.persidnum = :persidnum")
    , @NamedQuery(name = "Employees.findByPassnum", query = "SELECT e FROM Employees e WHERE e.passnum = :passnum")
    , @NamedQuery(name = "Employees.findByHaslicence", query = "SELECT e FROM Employees e WHERE e.haslicence = :haslicence")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private BigDecimal employeeid;
    @Size(max = 40)
    @Column(name = "FULLNAME")
    private String fullname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PERSIDNUM")
    private BigInteger persidnum;
    @Size(max = 15)
    @Column(name = "PASSNUM")
    private String passnum;
    @Column(name = "HASLICENCE")
    private BigInteger haslicence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesEmployeeid")
    private List<User> usersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesEmployeeid")
    private List<BusinessTrip> businesstripsList;

    public Employee() {
    }

    public Employee(BigDecimal employeeid) {
        this.employeeid = employeeid;
    }

    public BigDecimal getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(BigDecimal employeeid) {
        this.employeeid = employeeid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPersidnum() {
        return persidnum;
    }

    public void setPersidnum(BigInteger persidnum) {
        this.persidnum = persidnum;
    }

    public String getPassnum() {
        return passnum;
    }

    public void setPassnum(String passnum) {
        this.passnum = passnum;
    }

    public BigInteger getHaslicence() {
        return haslicence;
    }

    public void setHaslicence(BigInteger haslicence) {
        this.haslicence = haslicence;
    }

    @XmlTransient
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<BusinessTrip> getBusinesstripsList() {
        return businesstripsList;
    }

    public void setBusinesstripsList(List<BusinessTrip> businesstripsList) {
        this.businesstripsList = businesstripsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Employees[ employeeid=" + employeeid + " ]";
    }
    
}
