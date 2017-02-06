/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "imported_members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportedMembers.findAll", query = "SELECT i FROM ImportedMembers i"),
    @NamedQuery(name = "ImportedMembers.findById", query = "SELECT i FROM ImportedMembers i WHERE i.id = :id"),
    @NamedQuery(name = "ImportedMembers.findByStatus", query = "SELECT i FROM ImportedMembers i WHERE i.status = :status"),
    @NamedQuery(name = "ImportedMembers.findByLineNumber", query = "SELECT i FROM ImportedMembers i WHERE i.lineNumber = :lineNumber"),
    @NamedQuery(name = "ImportedMembers.findByErrorArgument1", query = "SELECT i FROM ImportedMembers i WHERE i.errorArgument1 = :errorArgument1"),
    @NamedQuery(name = "ImportedMembers.findByErrorArgument2", query = "SELECT i FROM ImportedMembers i WHERE i.errorArgument2 = :errorArgument2"),
    @NamedQuery(name = "ImportedMembers.findByName", query = "SELECT i FROM ImportedMembers i WHERE i.name = :name"),
    @NamedQuery(name = "ImportedMembers.findBySalt", query = "SELECT i FROM ImportedMembers i WHERE i.salt = :salt"),
    @NamedQuery(name = "ImportedMembers.findByUsername", query = "SELECT i FROM ImportedMembers i WHERE i.username = :username"),
    @NamedQuery(name = "ImportedMembers.findByPassword", query = "SELECT i FROM ImportedMembers i WHERE i.password = :password"),
    @NamedQuery(name = "ImportedMembers.findByEmail", query = "SELECT i FROM ImportedMembers i WHERE i.email = :email"),
    @NamedQuery(name = "ImportedMembers.findByCreationDate", query = "SELECT i FROM ImportedMembers i WHERE i.creationDate = :creationDate"),
    @NamedQuery(name = "ImportedMembers.findByCreditLimit", query = "SELECT i FROM ImportedMembers i WHERE i.creditLimit = :creditLimit"),
    @NamedQuery(name = "ImportedMembers.findByUpperCreditLimit", query = "SELECT i FROM ImportedMembers i WHERE i.upperCreditLimit = :upperCreditLimit"),
    @NamedQuery(name = "ImportedMembers.findByInitialBalance", query = "SELECT i FROM ImportedMembers i WHERE i.initialBalance = :initialBalance")})
public class ImportedMembers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Column(name = "line_number")
    private Integer lineNumber;
    @Size(max = 200)
    @Column(name = "error_argument1")
    private String errorArgument1;
    @Size(max = 200)
    @Column(name = "error_argument2")
    private String errorArgument2;
    @Size(max = 100)
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "upper_credit_limit")
    private BigDecimal upperCreditLimit;
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    @JoinColumn(name = "import_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MemberImports importId;
    @OneToMany(mappedBy = "importedMemberId")
    private Collection<ImportedMemberRecords> importedMemberRecordsCollection;
    @OneToMany(mappedBy = "importedMemberId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public ImportedMembers() {
    }

    public ImportedMembers(Integer id) {
        this.id = id;
    }

    public ImportedMembers(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getErrorArgument1() {
        return errorArgument1;
    }

    public void setErrorArgument1(String errorArgument1) {
        this.errorArgument1 = errorArgument1;
    }

    public String getErrorArgument2() {
        return errorArgument2;
    }

    public void setErrorArgument2(String errorArgument2) {
        this.errorArgument2 = errorArgument2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getUpperCreditLimit() {
        return upperCreditLimit;
    }

    public void setUpperCreditLimit(BigDecimal upperCreditLimit) {
        this.upperCreditLimit = upperCreditLimit;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public MemberImports getImportId() {
        return importId;
    }

    public void setImportId(MemberImports importId) {
        this.importId = importId;
    }

    @XmlTransient
    public Collection<ImportedMemberRecords> getImportedMemberRecordsCollection() {
        return importedMemberRecordsCollection;
    }

    public void setImportedMemberRecordsCollection(Collection<ImportedMemberRecords> importedMemberRecordsCollection) {
        this.importedMemberRecordsCollection = importedMemberRecordsCollection;
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
        if (!(object instanceof ImportedMembers)) {
            return false;
        }
        ImportedMembers other = (ImportedMembers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ImportedMembers[ id=" + id + " ]";
    }
    
}
