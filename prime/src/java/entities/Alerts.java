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
@Table(name = "alerts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerts.findAll", query = "SELECT a FROM Alerts a"),
    @NamedQuery(name = "Alerts.findById", query = "SELECT a FROM Alerts a WHERE a.id = :id"),
    @NamedQuery(name = "Alerts.findBySubclass", query = "SELECT a FROM Alerts a WHERE a.subclass = :subclass"),
    @NamedQuery(name = "Alerts.findByRemoved", query = "SELECT a FROM Alerts a WHERE a.removed = :removed"),
    @NamedQuery(name = "Alerts.findByMsgKey", query = "SELECT a FROM Alerts a WHERE a.msgKey = :msgKey"),
    @NamedQuery(name = "Alerts.findByArg0", query = "SELECT a FROM Alerts a WHERE a.arg0 = :arg0"),
    @NamedQuery(name = "Alerts.findByArg1", query = "SELECT a FROM Alerts a WHERE a.arg1 = :arg1"),
    @NamedQuery(name = "Alerts.findByArg2", query = "SELECT a FROM Alerts a WHERE a.arg2 = :arg2"),
    @NamedQuery(name = "Alerts.findByArg3", query = "SELECT a FROM Alerts a WHERE a.arg3 = :arg3"),
    @NamedQuery(name = "Alerts.findByArg4", query = "SELECT a FROM Alerts a WHERE a.arg4 = :arg4"),
    @NamedQuery(name = "Alerts.findByDate", query = "SELECT a FROM Alerts a WHERE a.date = :date")})
public class Alerts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "removed")
    private boolean removed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "msg_key")
    private String msgKey;
    @Size(max = 255)
    @Column(name = "arg0")
    private String arg0;
    @Size(max = 255)
    @Column(name = "arg1")
    private String arg1;
    @Size(max = 255)
    @Column(name = "arg2")
    private String arg2;
    @Size(max = 255)
    @Column(name = "arg3")
    private String arg3;
    @Size(max = 255)
    @Column(name = "arg4")
    private String arg4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;

    public Alerts() {
    }

    public Alerts(Integer id) {
        this.id = id;
    }

    public Alerts(Integer id, String subclass, boolean removed, String msgKey, Date date) {
        this.id = id;
        this.subclass = subclass;
        this.removed = removed;
        this.msgKey = msgKey;
        this.date = date;
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

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getArg4() {
        return arg4;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
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
        if (!(object instanceof Alerts)) {
            return false;
        }
        Alerts other = (Alerts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alerts[ id=" + id + " ]";
    }
    
}
