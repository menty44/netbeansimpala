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
@Table(name = "member_pos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberPos.findAll", query = "SELECT m FROM MemberPos m"),
    @NamedQuery(name = "MemberPos.findById", query = "SELECT m FROM MemberPos m WHERE m.id = :id"),
    @NamedQuery(name = "MemberPos.findByPosName", query = "SELECT m FROM MemberPos m WHERE m.posName = :posName"),
    @NamedQuery(name = "MemberPos.findByPosPin", query = "SELECT m FROM MemberPos m WHERE m.posPin = :posPin"),
    @NamedQuery(name = "MemberPos.findByDate", query = "SELECT m FROM MemberPos m WHERE m.date = :date"),
    @NamedQuery(name = "MemberPos.findByAllowMakePayment", query = "SELECT m FROM MemberPos m WHERE m.allowMakePayment = :allowMakePayment"),
    @NamedQuery(name = "MemberPos.findByMaxSchedulingPayments", query = "SELECT m FROM MemberPos m WHERE m.maxSchedulingPayments = :maxSchedulingPayments"),
    @NamedQuery(name = "MemberPos.findByNumberOfCopies", query = "SELECT m FROM MemberPos m WHERE m.numberOfCopies = :numberOfCopies"),
    @NamedQuery(name = "MemberPos.findByResultPageSize", query = "SELECT m FROM MemberPos m WHERE m.resultPageSize = :resultPageSize"),
    @NamedQuery(name = "MemberPos.findByStatus", query = "SELECT m FROM MemberPos m WHERE m.status = :status")})
public class MemberPos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 64)
    @Column(name = "pos_name")
    private String posName;
    @Size(max = 64)
    @Column(name = "pos_pin")
    private String posPin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow_make_payment")
    private boolean allowMakePayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_scheduling_payments")
    private int maxSchedulingPayments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_copies")
    private int numberOfCopies;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result_page_size")
    private int resultPageSize;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "pos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pos posId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Members ownerId;
    @OneToMany(mappedBy = "memberPosId")
    private Collection<Pos> posCollection;
    @OneToMany(mappedBy = "memberPosId")
    private Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection;

    public MemberPos() {
    }

    public MemberPos(Integer id) {
        this.id = id;
    }

    public MemberPos(Integer id, Date date, boolean allowMakePayment, int maxSchedulingPayments, int numberOfCopies, int resultPageSize, String status) {
        this.id = id;
        this.date = date;
        this.allowMakePayment = allowMakePayment;
        this.maxSchedulingPayments = maxSchedulingPayments;
        this.numberOfCopies = numberOfCopies;
        this.resultPageSize = resultPageSize;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosPin() {
        return posPin;
    }

    public void setPosPin(String posPin) {
        this.posPin = posPin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getAllowMakePayment() {
        return allowMakePayment;
    }

    public void setAllowMakePayment(boolean allowMakePayment) {
        this.allowMakePayment = allowMakePayment;
    }

    public int getMaxSchedulingPayments() {
        return maxSchedulingPayments;
    }

    public void setMaxSchedulingPayments(int maxSchedulingPayments) {
        this.maxSchedulingPayments = maxSchedulingPayments;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getResultPageSize() {
        return resultPageSize;
    }

    public void setResultPageSize(int resultPageSize) {
        this.resultPageSize = resultPageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pos getPosId() {
        return posId;
    }

    public void setPosId(Pos posId) {
        this.posId = posId;
    }

    public Members getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Members ownerId) {
        this.ownerId = ownerId;
    }

    @XmlTransient
    public Collection<Pos> getPosCollection() {
        return posCollection;
    }

    public void setPosCollection(Collection<Pos> posCollection) {
        this.posCollection = posCollection;
    }

    @XmlTransient
    public Collection<WrongCredentialAttempts> getWrongCredentialAttemptsCollection() {
        return wrongCredentialAttemptsCollection;
    }

    public void setWrongCredentialAttemptsCollection(Collection<WrongCredentialAttempts> wrongCredentialAttemptsCollection) {
        this.wrongCredentialAttemptsCollection = wrongCredentialAttemptsCollection;
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
        if (!(object instanceof MemberPos)) {
            return false;
        }
        MemberPos other = (MemberPos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberPos[ id=" + id + " ]";
    }
    
}
