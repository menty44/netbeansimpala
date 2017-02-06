/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "pending_members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PendingMembers.findAll", query = "SELECT p FROM PendingMembers p"),
    @NamedQuery(name = "PendingMembers.findById", query = "SELECT p FROM PendingMembers p WHERE p.id = :id"),
    @NamedQuery(name = "PendingMembers.findByCreationDate", query = "SELECT p FROM PendingMembers p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PendingMembers.findByName", query = "SELECT p FROM PendingMembers p WHERE p.name = :name"),
    @NamedQuery(name = "PendingMembers.findBySalt", query = "SELECT p FROM PendingMembers p WHERE p.salt = :salt"),
    @NamedQuery(name = "PendingMembers.findByUsername", query = "SELECT p FROM PendingMembers p WHERE p.username = :username"),
    @NamedQuery(name = "PendingMembers.findByPassword", query = "SELECT p FROM PendingMembers p WHERE p.password = :password"),
    @NamedQuery(name = "PendingMembers.findByForceChangePassword", query = "SELECT p FROM PendingMembers p WHERE p.forceChangePassword = :forceChangePassword"),
    @NamedQuery(name = "PendingMembers.findByEmail", query = "SELECT p FROM PendingMembers p WHERE p.email = :email"),
    @NamedQuery(name = "PendingMembers.findByPin", query = "SELECT p FROM PendingMembers p WHERE p.pin = :pin"),
    @NamedQuery(name = "PendingMembers.findByValidationKey", query = "SELECT p FROM PendingMembers p WHERE p.validationKey = :validationKey"),
    @NamedQuery(name = "PendingMembers.findByHideEmail", query = "SELECT p FROM PendingMembers p WHERE p.hideEmail = :hideEmail"),
    @NamedQuery(name = "PendingMembers.findByLastEmailDate", query = "SELECT p FROM PendingMembers p WHERE p.lastEmailDate = :lastEmailDate"),
    @NamedQuery(name = "PendingMembers.findByRegistrationAgreementDate", query = "SELECT p FROM PendingMembers p WHERE p.registrationAgreementDate = :registrationAgreementDate"),
    @NamedQuery(name = "PendingMembers.findByRemoteAddress", query = "SELECT p FROM PendingMembers p WHERE p.remoteAddress = :remoteAddress")})
public class PendingMembers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 32)
    @Column(name = "salt")
    private String salt;
    @Size(max = 64)
    @Column(name = "username")
    private String username;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "force_change_password")
    private boolean forceChangePassword;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 64)
    @Column(name = "pin")
    private String pin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "validation_key")
    private String validationKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hide_email")
    private boolean hideEmail;
    @Column(name = "last_email_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEmailDate;
    @Column(name = "registration_agreement_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationAgreementDate;
    @Size(max = 100)
    @Column(name = "remote_address")
    private String remoteAddress;
    @JoinColumn(name = "registration_agreement_id", referencedColumnName = "id")
    @ManyToOne
    private RegistrationAgreements registrationAgreementId;
    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    @ManyToOne
    private Members brokerId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groups groupId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(mappedBy = "pendingMemberId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public PendingMembers() {
    }

    public PendingMembers(Integer id) {
        this.id = id;
    }

    public PendingMembers(Integer id, Date creationDate, String name, boolean forceChangePassword, String email, String validationKey, boolean hideEmail) {
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.forceChangePassword = forceChangePassword;
        this.email = email;
        this.validationKey = validationKey;
        this.hideEmail = hideEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getForceChangePassword() {
        return forceChangePassword;
    }

    public void setForceChangePassword(boolean forceChangePassword) {
        this.forceChangePassword = forceChangePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getValidationKey() {
        return validationKey;
    }

    public void setValidationKey(String validationKey) {
        this.validationKey = validationKey;
    }

    public boolean getHideEmail() {
        return hideEmail;
    }

    public void setHideEmail(boolean hideEmail) {
        this.hideEmail = hideEmail;
    }

    public Date getLastEmailDate() {
        return lastEmailDate;
    }

    public void setLastEmailDate(Date lastEmailDate) {
        this.lastEmailDate = lastEmailDate;
    }

    public Date getRegistrationAgreementDate() {
        return registrationAgreementDate;
    }

    public void setRegistrationAgreementDate(Date registrationAgreementDate) {
        this.registrationAgreementDate = registrationAgreementDate;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public RegistrationAgreements getRegistrationAgreementId() {
        return registrationAgreementId;
    }

    public void setRegistrationAgreementId(RegistrationAgreements registrationAgreementId) {
        this.registrationAgreementId = registrationAgreementId;
    }

    public Members getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Members brokerId) {
        this.brokerId = brokerId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
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
        if (!(object instanceof PendingMembers)) {
            return false;
        }
        PendingMembers other = (PendingMembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PendingMembers[ id=" + id + " ]";
    }
    
}
