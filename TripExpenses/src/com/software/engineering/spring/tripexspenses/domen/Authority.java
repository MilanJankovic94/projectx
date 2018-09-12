//package com.software.engineering.spring.tripexspenses.domen;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author stefan.vasic
// */
//@Entity
//@Table(name = "AUTHORITIES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Authorities.findAll", query = "SELECT a FROM Authorities a")
//    , @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authority = :authority")
//    , @NamedQuery(name = "Authorities.findByUsersUsername", query = "SELECT a FROM Authorities a WHERE a.usersUsername = :usersUsername")})
//public class Authority implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Size(max = 20)
//    @Column(name = "AUTHORITY")
//    private String authority;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
//    @Column(name = "USERS_USERNAME")
//    private String userUsername;
//    @JoinColumn(name = "USERS_USERNAME", referencedColumnName = "USERNAME", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private User user;
//
//    public Authority() {
//    }
//
//    public Authority(String usersUsername) {
//        this.userUsername = usersUsername;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    public String getUserUsername() {
//        return userUsername;
//    }
//
//    public void setUserUsername(String userUsername) {
//        this.userUsername = userUsername;
//    }
//
//    public User getUsers() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (userUsername != null ? userUsername.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Authority)) {
//            return false;
//        }
//        Authority other = (Authority) object;
//        if ((this.userUsername == null && other.userUsername != null) || (this.userUsername != null && !this.userUsername.equals(other.userUsername))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "domen.Authorities[ usersUsername=" + userUsername + " ]";
//    }
//    
//}