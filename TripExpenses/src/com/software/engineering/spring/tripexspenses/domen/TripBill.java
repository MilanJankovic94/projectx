package com.software.engineering.spring.tripexspenses.domen;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stefan.vasic
 */
@Entity
@Table(name = "TRIPBILLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tripbills.findAll", query = "SELECT t FROM Tripbills t")
    , @NamedQuery(name = "Tripbills.findByTripbillid", query = "SELECT t FROM Tripbills t WHERE t.tripbillid = :tripbillid")
    , @NamedQuery(name = "Tripbills.findByTotalamount", query = "SELECT t FROM Tripbills t WHERE t.totalamount = :totalamount")})
public class TripBill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRIPBILLID")
    private BigDecimal tripbillid;
    @Column(name = "TOTALAMOUNT")
    private BigInteger totalamount;
    @JoinColumn(name = "BUSINESSTRIPS_BUSTRIPID", referencedColumnName = "BUSTRIPID")
    @ManyToOne(optional = false)
    private BusinessTrip businesstripsBustripid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripbillsTripbillid")
    private List<Bill> billsList;

    public TripBill() {
    }

    public TripBill(BigDecimal tripbillid) {
        this.tripbillid = tripbillid;
    }

    public BigDecimal getTripbillid() {
        return tripbillid;
    }

    public void setTripbillid(BigDecimal tripbillid) {
        this.tripbillid = tripbillid;
    }

    public BigInteger getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigInteger totalamount) {
        this.totalamount = totalamount;
    }

    public BusinessTrip getBusinesstripsBustripid() {
        return businesstripsBustripid;
    }

    public void setBusinesstripsBustripid(BusinessTrip businesstripsBustripid) {
        this.businesstripsBustripid = businesstripsBustripid;
    }

    @XmlTransient
    public List<Bill> getBillsList() {
        return billsList;
    }

    public void setBillsList(List<Bill> billsList) {
        this.billsList = billsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tripbillid != null ? tripbillid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TripBill)) {
            return false;
        }
        TripBill other = (TripBill) object;
        if ((this.tripbillid == null && other.tripbillid != null) || (this.tripbillid != null && !this.tripbillid.equals(other.tripbillid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Tripbills[ tripbillid=" + tripbillid + " ]";
    }
    
}
