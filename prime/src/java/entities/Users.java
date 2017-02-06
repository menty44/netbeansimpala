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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findBySubclass", query = "SELECT u FROM Users u WHERE u.subclass = :subclass"),
    @NamedQuery(name = "Users.findBySalt", query = "SELECT u FROM Users u WHERE u.salt = :salt"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByTransactionPassword", query = "SELECT u FROM Users u WHERE u.transactionPassword = :transactionPassword"),
    @NamedQuery(name = "Users.findByTransactionPasswordStatus", query = "SELECT u FROM Users u WHERE u.transactionPasswordStatus = :transactionPasswordStatus"),
    @NamedQuery(name = "Users.findByLastLogin", query = "SELECT u FROM Users u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "Users.findByPasswordDate", query = "SELECT u FROM Users u WHERE u.passwordDate = :passwordDate"),
    @NamedQuery(name = "Users.findByPasswordBlockedUntil", query = "SELECT u FROM Users u WHERE u.passwordBlockedUntil = :passwordBlockedUntil"),
    @NamedQuery(name = "Users.findByPin", query = "SELECT u FROM Users u WHERE u.pin = :pin"),
    @NamedQuery(name = "Users.findByPinBlockedUntil", query = "SELECT u FROM Users u WHERE u.pinBlockedUntil = :pinBlockedUntil")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Size(max = 32)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    private String username;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 64)
    @Column(name = "transaction_password")
    private String transactionPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "transaction_password_status")
    private String transactionPasswordStatus;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "password_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordDate;
    @Column(name = "password_blocked_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordBlockedUntil;
    @Size(max = 64)
    @Column(name = "pin")
    private String pin;
    @Column(name = "pin_blocked_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pinBlockedUntil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UsernameChangeLogs> usernameChangeLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<LoginHistory> loginHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Sessions> sessionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<PermissionDenieds> permissionDeniedsCollection;
    @OneToMany(mappedBy = "loggedUserId")
    private Collection<ErrorLogEntries> errorLogEntriesCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<PasswordHistory> passwordHistoryCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Members members;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String subclass, String username, String transactionPasswordStatus) {
        this.id = id;
        this.subclass = subclass;
        this.username = username;
        this.transactionPasswordStatus = transactionPasswordStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
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

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    public String getTransactionPasswordStatus() {
        return transactionPasswordStatus;
    }

    public void setTransactionPasswordStatus(String transactionPasswordStatus) {
        this.transactionPasswordStatus = transactionPasswordStatus;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getPasswordDate() {
        return passwordDate;
    }

    public void setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
    }

    public Date getPasswordBlockedUntil() {
        return passwordBlockedUntil;
    }

    public void setPasswordBlockedUntil(Date passwordBlockedUntil) {
        this.passwordBlockedUntil = passwordBlockedUntil;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getPinBlockedUntil() {
        return pinBlockedUntil;
    }

    public void setPinBlockedUntil(Date pinBlockedUntil) {
        this.pinBlockedUntil = pinBlockedUntil;
    }

    @XmlTransient
    public Collection<UsernameChangeLogs> getUsernameChangeLogsCollection() {
        return usernameChangeLogsCollection;
    }

    public void setUsernameChangeLogsCollection(Collection<UsernameChangeLogs> usernameChangeLogsCollection) {
        this.usernameChangeLogsCollection = usernameChangeLogsCollection;
    }

    @XmlTransient
    public Collection<LoginHistory> getLoginHistoryCollection() {
        return loginHistoryCollection;
    }

    public void setLoginHistoryCollection(Collection<LoginHistory> loginHistoryCollection) {
        this.loginHistoryCollection = loginHistoryCollection;
    }

    @XmlTransient
    public Collection<Sessions> getSessionsCollection() {
        return sessionsCollection;
    }

    public void setSessionsCollection(Collection<Sessions> sessionsCollection) {
        this.sessionsCollection = sessionsCollection;
    }

    @XmlTransient
    public Collection<PermissionDenieds> getPermissionDeniedsCollection() {
        return permissionDeniedsCollection;
    }

    public void setPermissionDeniedsCollection(Collection<PermissionDenieds> permissionDeniedsCollection) {
        this.permissionDeniedsCollection = permissionDeniedsCollection;
    }

    @XmlTransient
    public Collection<ErrorLogEntries> getErrorLogEntriesCollection() {
        return errorLogEntriesCollection;
    }

    public void setErrorLogEntriesCollection(Collection<ErrorLogEntries> errorLogEntriesCollection) {
        this.errorLogEntriesCollection = errorLogEntriesCollection;
    }

    @XmlTransient
    public Collection<WrongCredentialAttempts> getWrongCredentialAttemptsCollection() {
        return wrongCredentialAttemptsCollection;
    }

    public void setWrongCredentialAttemptsCollection(Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection) {
        this.wrongCredentialAttemptsCollection = wrongCredentialAttemptsCollection;
    }

    @XmlTransient
    public Collection<PasswordHistory> getPasswordHistoryCollection() {
        return passwordHistoryCollection;
    }

    public void setPasswordHistoryCollection(Collection<PasswordHistory> passwordHistoryCollection) {
        this.passwordHistoryCollection = passwordHistoryCollection;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
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
        return "entities.Users[ id=" + id + " ]";
    }
    
}
