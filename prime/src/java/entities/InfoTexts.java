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
import javax.persistence.Lob;
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
@Table(name = "info_texts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoTexts.findAll", query = "SELECT i FROM InfoTexts i"),
    @NamedQuery(name = "InfoTexts.findById", query = "SELECT i FROM InfoTexts i WHERE i.id = :id"),
    @NamedQuery(name = "InfoTexts.findBySubject", query = "SELECT i FROM InfoTexts i WHERE i.subject = :subject"),
    @NamedQuery(name = "InfoTexts.findByEnabled", query = "SELECT i FROM InfoTexts i WHERE i.enabled = :enabled"),
    @NamedQuery(name = "InfoTexts.findByBeginDate", query = "SELECT i FROM InfoTexts i WHERE i.beginDate = :beginDate"),
    @NamedQuery(name = "InfoTexts.findByEndDate", query = "SELECT i FROM InfoTexts i WHERE i.endDate = :endDate")})
public class InfoTexts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "subject")
    private String subject;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public InfoTexts() {
    }

    public InfoTexts(Integer id) {
        this.id = id;
    }

    public InfoTexts(Integer id, String subject, boolean enabled) {
        this.id = id;
        this.subject = subject;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        if (!(object instanceof InfoTexts)) {
            return false;
        }
        InfoTexts other = (InfoTexts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InfoTexts[ id=" + id + " ]";
    }
    
}
