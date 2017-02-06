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
import javax.persistence.Lob;
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
@Table(name = "transfer_authorizations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransferAuthorizations.findAll", query = "SELECT t FROM TransferAuthorizations t"),
    @NamedQuery(name = "TransferAuthorizations.findById", query = "SELECT t FROM TransferAuthorizations t WHERE t.id = :id"),
    @NamedQuery(name = "TransferAuthorizations.findByDate", query = "SELECT t FROM TransferAuthorizations t WHERE t.date = :date"),
    @NamedQuery(name = "TransferAuthorizations.findByAction", query = "SELECT t FROM TransferAuthorizations t WHERE t.action = :action"),
    @NamedQuery(name = "TransferAuthorizations.findByShowToMember", query = "SELECT t FROM TransferAuthorizations t WHERE t.showToMember = :showToMember")})
public class TransferAuthorizations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "action")
    private String action;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_to_member")
    private boolean showToMember;
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthorizationLevels levelId;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transfers transferId;
    @OneToMany(mappedBy = "transferAuthorizationId")
    private Collection<AmountReservations> amountReservationsCollection;

    public TransferAuthorizations() {
    }

    public TransferAuthorizations(Long id) {
        this.id = id;
    }

    public TransferAuthorizations(Long id, Date date, String action, boolean showToMember) {
        this.id = id;
        this.date = date;
        this.action = action;
        this.showToMember = showToMember;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean getShowToMember() {
        return showToMember;
    }

    public void setShowToMember(boolean showToMember) {
        this.showToMember = showToMember;
    }

    public AuthorizationLevels getLevelId() {
        return levelId;
    }

    public void setLevelId(AuthorizationLevels levelId) {
        this.levelId = levelId;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    @XmlTransient
    public Collection<AmountReservations> getAmountReservationsCollection() {
        return amountReservationsCollection;
    }

    public void setAmountReservationsCollection(Collection<AmountReservations> amountReservationsCollection) {
        this.amountReservationsCollection = amountReservationsCollection;
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
        if (!(object instanceof TransferAuthorizations)) {
            return false;
        }
        TransferAuthorizations other = (TransferAuthorizations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransferAuthorizations[ id=" + id + " ]";
    }
    
}
