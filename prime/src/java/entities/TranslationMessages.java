/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "translation_messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TranslationMessages.findAll", query = "SELECT t FROM TranslationMessages t"),
    @NamedQuery(name = "TranslationMessages.findById", query = "SELECT t FROM TranslationMessages t WHERE t.id = :id"),
    @NamedQuery(name = "TranslationMessages.findByMsgKey", query = "SELECT t FROM TranslationMessages t WHERE t.msgKey = :msgKey")})
public class TranslationMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "msg_key")
    private String msgKey;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "value")
    private String value;

    public TranslationMessages() {
    }

    public TranslationMessages(Integer id) {
        this.id = id;
    }

    public TranslationMessages(Integer id, String msgKey) {
        this.id = id;
        this.msgKey = msgKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof TranslationMessages)) {
            return false;
        }
        TranslationMessages other = (TranslationMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TranslationMessages[ id=" + id + " ]";
    }
    
}