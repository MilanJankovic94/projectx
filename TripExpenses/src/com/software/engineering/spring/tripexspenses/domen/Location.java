package com.software.engineering.spring.tripexspenses.domen;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LOCATIONS")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
//    , @NamedQuery(name = "Locations.findBylocId", query = "SELECT l FROM Locations l WHERE l.locId = :locId")
//    , @NamedQuery(name = "Locations.findBylocName", query = "SELECT l FROM Locations l WHERE l.locName = :locName")
//    , @NamedQuery(name = "Locations.findBylocCountry", query = "SELECT l FROM Locations l WHERE l.locCountry = :locCountry")
//    , @NamedQuery(name = "Locations.findBylocDailyAllowance", query = "SELECT l FROM Locations l WHERE l.locDailyAllowance = :locDailyAllowance")
//    , @NamedQuery(name = "Locations.findBylocDistance", query = "SELECT l FROM Locations l WHERE l.locDistance = :locDistance")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "locId")
    private Long locId;
    @Size(max = 40)
    @Column(name = "locName")
    private String locName;
    @Size(max = 40)
    @Column(name = "locCountry")
    private String locCountry;
    @Column(name = "locDailyAllowance")
    private Long locDailyAllowance;
    @Column(name = "locDistance")
    private Long locDistance;

    public Location() {
    }

    public Location(Long locId) {
        this.locId = locId;
    }

    public Long getLocId() {
        return locId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocCountry() {
        return locCountry;
    }

    public void setLocCountry(String locCountry) {
        this.locCountry = locCountry;
    }

    public Long getLocDailyAllowance() {
        return locDailyAllowance;
    }

    public void setLocDailyAllowance(Long locDailyAllowance) {
        this.locDailyAllowance = locDailyAllowance;
    }

    public Long getLocDistance() {
        return locDistance;
    }

    public void setLocDistance(Long locDistance) {
        this.locDistance = locDistance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", locCountry=" + locCountry
				+ ", locDailyAllowance=" + locDailyAllowance + ", locDistance=" + locDistance + "]";
	}

   
}
    
