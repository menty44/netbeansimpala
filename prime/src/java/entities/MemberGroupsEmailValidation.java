/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "member_groups_email_validation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberGroupsEmailValidation.findAll", query = "SELECT m FROM MemberGroupsEmailValidation m"),
    @NamedQuery(name = "MemberGroupsEmailValidation.findByGroupId", query = "SELECT m FROM MemberGroupsEmailValidation m WHERE m.memberGroupsEmailValidationPK.groupId = :groupId"),
    @NamedQuery(name = "MemberGroupsEmailValidation.findByType", query = "SELECT m FROM MemberGroupsEmailValidation m WHERE m.memberGroupsEmailValidationPK.type = :type")})
public class MemberGroupsEmailValidation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemberGroupsEmailValidationPK memberGroupsEmailValidationPK;
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Groups groups;

    public MemberGroupsEmailValidation() {
    }

    public MemberGroupsEmailValidation(MemberGroupsEmailValidationPK memberGroupsEmailValidationPK) {
        this.memberGroupsEmailValidationPK = memberGroupsEmailValidationPK;
    }

    public MemberGroupsEmailValidation(int groupId, String type) {
        this.memberGroupsEmailValidationPK = new MemberGroupsEmailValidationPK(groupId, type);
    }

    public MemberGroupsEmailValidationPK getMemberGroupsEmailValidationPK() {
        return memberGroupsEmailValidationPK;
    }

    public void setMemberGroupsEmailValidationPK(MemberGroupsEmailValidationPK memberGroupsEmailValidationPK) {
        this.memberGroupsEmailValidationPK = memberGroupsEmailValidationPK;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberGroupsEmailValidationPK != null ? memberGroupsEmailValidationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberGroupsEmailValidation)) {
            return false;
        }
        MemberGroupsEmailValidation other = (MemberGroupsEmailValidation) object;
        if ((this.memberGroupsEmailValidationPK == null && other.memberGroupsEmailValidationPK != null) || (this.memberGroupsEmailValidationPK != null && !this.memberGroupsEmailValidationPK.equals(other.memberGroupsEmailValidationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MemberGroupsEmailValidation[ memberGroupsEmailValidationPK=" + memberGroupsEmailValidationPK + " ]";
    }
    
}
