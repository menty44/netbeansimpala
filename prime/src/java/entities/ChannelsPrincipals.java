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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "channels_principals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChannelsPrincipals.findAll", query = "SELECT c FROM ChannelsPrincipals c"),
    @NamedQuery(name = "ChannelsPrincipals.findById", query = "SELECT c FROM ChannelsPrincipals c WHERE c.id = :id"),
    @NamedQuery(name = "ChannelsPrincipals.findByPrincipal", query = "SELECT c FROM ChannelsPrincipals c WHERE c.principal = :principal"),
    @NamedQuery(name = "ChannelsPrincipals.findByIsDefault", query = "SELECT c FROM ChannelsPrincipals c WHERE c.isDefault = :isDefault")})
public class ChannelsPrincipals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "principal")
    private String principal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_default")
    private boolean isDefault;
    @JoinColumn(name = "custom_field_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFields customFieldId;
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channels channelId;

    public ChannelsPrincipals() {
    }

    public ChannelsPrincipals(Integer id) {
        this.id = id;
    }

    public ChannelsPrincipals(Integer id, String principal, boolean isDefault) {
        this.id = id;
        this.principal = principal;
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public CustomFields getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(CustomFields customFieldId) {
        this.customFieldId = customFieldId;
    }

    public Channels getChannelId() {
        return channelId;
    }

    public void setChannelId(Channels channelId) {
        this.channelId = channelId;
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
        if (!(object instanceof ChannelsPrincipals)) {
            return false;
        }
        ChannelsPrincipals other = (ChannelsPrincipals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChannelsPrincipals[ id=" + id + " ]";
    }
    
}
