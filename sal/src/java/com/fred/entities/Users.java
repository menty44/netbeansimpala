/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByTitle", query = "SELECT u FROM Users u WHERE u.title = :title"),
    @NamedQuery(name = "Users.findByFname", query = "SELECT u FROM Users u WHERE u.fname = :fname"),
    @NamedQuery(name = "Users.findByMname", query = "SELECT u FROM Users u WHERE u.mname = :mname"),
    @NamedQuery(name = "Users.findByLname", query = "SELECT u FROM Users u WHERE u.lname = :lname"),
    @NamedQuery(name = "Users.findByCountryofres", query = "SELECT u FROM Users u WHERE u.countryofres = :countryofres"),
    @NamedQuery(name = "Users.findByPostalcode", query = "SELECT u FROM Users u WHERE u.postalcode = :postalcode"),
    @NamedQuery(name = "Users.findByAddress1", query = "SELECT u FROM Users u WHERE u.address1 = :address1"),
    @NamedQuery(name = "Users.findByAddress2", query = "SELECT u FROM Users u WHERE u.address2 = :address2"),
    @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city"),
    @NamedQuery(name = "Users.findByGovtidpass", query = "SELECT u FROM Users u WHERE u.govtidpass = :govtidpass"),
    @NamedQuery(name = "Users.findByPhoneno", query = "SELECT u FROM Users u WHERE u.phoneno = :phoneno"),
    @NamedQuery(name = "Users.findByDob", query = "SELECT u FROM Users u WHERE u.dob = :dob"),
    @NamedQuery(name = "Users.findByNationality", query = "SELECT u FROM Users u WHERE u.nationality = :nationality"),
    @NamedQuery(name = "Users.findByMorethanthreeyrs", query = "SELECT u FROM Users u WHERE u.morethanthreeyrs = :morethanthreeyrs"),
    @NamedQuery(name = "Users.findByConvictedofcrime", query = "SELECT u FROM Users u WHERE u.convictedofcrime = :convictedofcrime"),
    @NamedQuery(name = "Users.findByRelationship", query = "SELECT u FROM Users u WHERE u.relationship = :relationship"),
    @NamedQuery(name = "Users.findByEstimatemonthlyvol", query = "SELECT u FROM Users u WHERE u.estimatemonthlyvol = :estimatemonthlyvol"),
    @NamedQuery(name = "Users.findByTradehowoften", query = "SELECT u FROM Users u WHERE u.tradehowoften = :tradehowoften"),
    @NamedQuery(name = "Users.findByPurposeoftrade", query = "SELECT u FROM Users u WHERE u.purposeoftrade = :purposeoftrade"),
    @NamedQuery(name = "Users.findBySendmoneyto", query = "SELECT u FROM Users u WHERE u.sendmoneyto = :sendmoneyto"),
    @NamedQuery(name = "Users.findByRecievepaymentfrom", query = "SELECT u FROM Users u WHERE u.recievepaymentfrom = :recievepaymentfrom"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role"),
    @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mname")
    private String mname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "countryofres")
    private String countryofres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "postalcode")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "govtidpass")
    private String govtidpass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "phoneno")
    private String phoneno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dob")
    private String dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nationality")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "morethanthreeyrs")
    private String morethanthreeyrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "convictedofcrime")
    private String convictedofcrime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "relationship")
    private String relationship;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estimatemonthlyvol")
    private String estimatemonthlyvol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tradehowoften")
    private String tradehowoften;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "purposeoftrade")
    private String purposeoftrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sendmoneyto")
    private String sendmoneyto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "recievepaymentfrom")
    private String recievepaymentfrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "created_at")
    private String createdAt;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String title, String fname, String mname, String lname, String countryofres, String postalcode, String address1, String address2, String city, String govtidpass, String phoneno, String dob, String nationality, String morethanthreeyrs, String convictedofcrime, String relationship, String estimatemonthlyvol, String tradehowoften, String purposeoftrade, String sendmoneyto, String recievepaymentfrom, String password, String email, String role, String createdAt) {
        this.id = id;
        this.title = title;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.countryofres = countryofres;
        this.postalcode = postalcode;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.govtidpass = govtidpass;
        this.phoneno = phoneno;
        this.dob = dob;
        this.nationality = nationality;
        this.morethanthreeyrs = morethanthreeyrs;
        this.convictedofcrime = convictedofcrime;
        this.relationship = relationship;
        this.estimatemonthlyvol = estimatemonthlyvol;
        this.tradehowoften = tradehowoften;
        this.purposeoftrade = purposeoftrade;
        this.sendmoneyto = sendmoneyto;
        this.recievepaymentfrom = recievepaymentfrom;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCountryofres() {
        return countryofres;
    }

    public void setCountryofres(String countryofres) {
        this.countryofres = countryofres;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGovtidpass() {
        return govtidpass;
    }

    public void setGovtidpass(String govtidpass) {
        this.govtidpass = govtidpass;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMorethanthreeyrs() {
        return morethanthreeyrs;
    }

    public void setMorethanthreeyrs(String morethanthreeyrs) {
        this.morethanthreeyrs = morethanthreeyrs;
    }

    public String getConvictedofcrime() {
        return convictedofcrime;
    }

    public void setConvictedofcrime(String convictedofcrime) {
        this.convictedofcrime = convictedofcrime;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEstimatemonthlyvol() {
        return estimatemonthlyvol;
    }

    public void setEstimatemonthlyvol(String estimatemonthlyvol) {
        this.estimatemonthlyvol = estimatemonthlyvol;
    }

    public String getTradehowoften() {
        return tradehowoften;
    }

    public void setTradehowoften(String tradehowoften) {
        this.tradehowoften = tradehowoften;
    }

    public String getPurposeoftrade() {
        return purposeoftrade;
    }

    public void setPurposeoftrade(String purposeoftrade) {
        this.purposeoftrade = purposeoftrade;
    }

    public String getSendmoneyto() {
        return sendmoneyto;
    }

    public void setSendmoneyto(String sendmoneyto) {
        this.sendmoneyto = sendmoneyto;
    }

    public String getRecievepaymentfrom() {
        return recievepaymentfrom;
    }

    public void setRecievepaymentfrom(String recievepaymentfrom) {
        this.recievepaymentfrom = recievepaymentfrom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fred.entities.Users[ id=" + id + " ]";
    }
    
}
