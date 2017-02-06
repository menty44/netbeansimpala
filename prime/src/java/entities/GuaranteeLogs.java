/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "guarantee_logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuaranteeLogs.findAll", query = "SELECT g FROM GuaranteeLogs g"),
    @NamedQuery(name = "GuaranteeLogs.findById", query = "SELECT g FROM GuaranteeLogs g WHERE g.id = :id"),
    @NamedQuery(name = "GuaranteeLogs.findByDate", query = "SELECT g FROM GuaranteeLogs g WHERE g.date = :date"),
    @NamedQuery(name = "GuaranteeLogs.findByStatus", query = "SELECT g FROM GuaranteeLogs g WHERE g.status = :status")})
public class GuaranteeLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "guarantee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Guarantees guaranteeId;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;

    public GuaranteeLogs() {
    }

    public GuaranteeLogs(Integer id) {
        this.id = id;
    }

    public GuaranteeLogs(Integer id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guarantees getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Guarantees guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
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
        if (!(object instanceof GuaranteeLogs)) {
            return false;
        }
        GuaranteeLogs other = (GuaranteeLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GuaranteeLogs[ id=" + id + " ]";
    }
    
}
