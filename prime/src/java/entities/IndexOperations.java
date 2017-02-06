/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "index_operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndexOperations.findAll", query = "SELECT i FROM IndexOperations i"),
    @NamedQuery(name = "IndexOperations.findById", query = "SELECT i FROM IndexOperations i WHERE i.id = :id"),
    @NamedQuery(name = "IndexOperations.findByDate", query = "SELECT i FROM IndexOperations i WHERE i.date = :date"),
    @NamedQuery(name = "IndexOperations.findByEntityType", query = "SELECT i FROM IndexOperations i WHERE i.entityType = :entityType"),
    @NamedQuery(name = "IndexOperations.findByOperationType", query = "SELECT i FROM IndexOperations i WHERE i.operationType = :operationType"),
    @NamedQuery(name = "IndexOperations.findByEntityId", query = "SELECT i FROM IndexOperations i WHERE i.entityId = :entityId")})
public class IndexOperations implements Serializable {

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
    @Size(min = 1, max = 3)
    @Column(name = "entity_type")
    private String entityType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "operation_type")
    private String operationType;
    @Column(name = "entity_id")
    private BigInteger entityId;

    public IndexOperations() {
    }

    public IndexOperations(Integer id) {
        this.id = id;
    }

    public IndexOperations(Integer id, Date date, String entityType, String operationType) {
        this.id = id;
        this.date = date;
        this.entityType = entityType;
        this.operationType = operationType;
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

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigInteger getEntityId() {
        return entityId;
    }

    public void setEntityId(BigInteger entityId) {
        this.entityId = entityId;
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
        if (!(object instanceof IndexOperations)) {
            return false;
        }
        IndexOperations other = (IndexOperations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.IndexOperations[ id=" + id + " ]";
    }
    
}
