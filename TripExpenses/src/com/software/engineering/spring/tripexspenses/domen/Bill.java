package com.software.engineering.spring.tripexspenses.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "BILLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b")
    , @NamedQuery(name = "Bills.findByBillid", query = "SELECT b FROM Bills b WHERE b.billid = :billid")
    , @NamedQuery(name = "Bills.findByBillitem", query = "SELECT b FROM Bills b WHERE b.billitem = :billitem")
    , @NamedQuery(name = "Bills.findByPrice", query = "SELECT b FROM Bills b WHERE b.price = :price")
    , @NamedQuery(name = "Bills.findByBilldate", query = "SELECT b FROM Bills b WHERE b.billdate = :billdate")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BILLID")
    private BigDecimal billid;
    @Size(max = 40)
    @Column(name = "BILLITEM")
    private String billitem;
    @Column(name = "PRICE")
    private BigInteger price;
    @Column(name = "BILLDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billdate;
    @JoinColumn(name = "TRIPBILLS_TRIPBILLID", referencedColumnName = "TRIPBILLID")
    @ManyToOne(optional = false)
    private TripBill tripbillsTripbillid;

    public Bill() {
    }

    public Bill(BigDecimal billid) {
        this.billid = billid;
    }

    public BigDecimal getBillid() {
        return billid;
    }

    public void setBillid(BigDecimal billid) {
        this.billid = billid;
    }

    public String getBillitem() {
        return billitem;
    }

    public void setBillitem(String billitem) {
        this.billitem = billitem;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public TripBill getTripbillsTripbillid() {
        return tripbillsTripbillid;
    }

    public void setTripbillsTripbillid(TripBill tripbillsTripbillid) {
        this.tripbillsTripbillid = tripbillsTripbillid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billid != null ? billid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billid == null && other.billid != null) || (this.billid != null && !this.billid.equals(other.billid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Bills[ billid=" + billid + " ]";
    }
    
}
