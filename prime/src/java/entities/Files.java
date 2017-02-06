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
@Table(name = "files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Files.findAll", query = "SELECT f FROM Files f"),
    @NamedQuery(name = "Files.findById", query = "SELECT f FROM Files f WHERE f.id = :id"),
    @NamedQuery(name = "Files.findBySubclass", query = "SELECT f FROM Files f WHERE f.subclass = :subclass"),
    @NamedQuery(name = "Files.findByName", query = "SELECT f FROM Files f WHERE f.name = :name"),
    @NamedQuery(name = "Files.findByLastModified", query = "SELECT f FROM Files f WHERE f.lastModified = :lastModified"),
    @NamedQuery(name = "Files.findByType", query = "SELECT f FROM Files f WHERE f.type = :type")})
public class Files implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "contents")
    private String contents;
    @Size(max = 1)
    @Column(name = "type")
    private String type;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "original_contents")
    private String originalContents;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "new_contents")
    private String newContents;
    @OneToMany(mappedBy = "documentPageId")
    private Collection<Documents> documentsCollection;
    @OneToMany(mappedBy = "formPageId")
    private Collection<Documents> documentsCollection1;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups groupId;
    @JoinColumn(name = "group_filter_id", referencedColumnName = "id")
    @ManyToOne
    private GroupFilters groupFilterId;
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    @ManyToOne
    private Documents documentId;

    public Files() {
    }

    public Files(Integer id) {
        this.id = id;
    }

    public Files(Integer id, String subclass, String name, Date lastModified) {
        this.id = id;
        this.subclass = subclass;
        this.name = name;
        this.lastModified = lastModified;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalContents() {
        return originalContents;
    }

    public void setOriginalContents(String originalContents) {
        this.originalContents = originalContents;
    }

    public String getNewContents() {
        return newContents;
    }

    public void setNewContents(String newContents) {
        this.newContents = newContents;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection() {
        return documentsCollection;
    }

    public void setDocumentsCollection(Collection<Documents> documentsCollection) {
        this.documentsCollection = documentsCollection;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection1() {
        return documentsCollection1;
    }

    public void setDocumentsCollection1(Collection<Documents> documentsCollection1) {
        this.documentsCollection1 = documentsCollection1;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public GroupFilters getGroupFilterId() {
        return groupFilterId;
    }

    public void setGroupFilterId(GroupFilters groupFilterId) {
        this.groupFilterId = groupFilterId;
    }

    public Documents getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Documents documentId) {
        this.documentId = documentId;
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
        if (!(object instanceof Files)) {
            return false;
        }
        Files other = (Files) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Files[ id=" + id + " ]";
    }
    
}
