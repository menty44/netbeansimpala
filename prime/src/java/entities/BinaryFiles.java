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
import javax.persistence.Lob;
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
@Table(name = "binary_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BinaryFiles.findAll", query = "SELECT b FROM BinaryFiles b"),
    @NamedQuery(name = "BinaryFiles.findById", query = "SELECT b FROM BinaryFiles b WHERE b.id = :id"),
    @NamedQuery(name = "BinaryFiles.findByName", query = "SELECT b FROM BinaryFiles b WHERE b.name = :name"),
    @NamedQuery(name = "BinaryFiles.findByContentType", query = "SELECT b FROM BinaryFiles b WHERE b.contentType = :contentType"),
    @NamedQuery(name = "BinaryFiles.findBySize", query = "SELECT b FROM BinaryFiles b WHERE b.size = :size"),
    @NamedQuery(name = "BinaryFiles.findByLastModified", query = "SELECT b FROM BinaryFiles b WHERE b.lastModified = :lastModified")})
public class BinaryFiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content_type")
    private String contentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private int size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "contents")
    private byte[] contents;
    @OneToMany(mappedBy = "binaryFileId")
    private Collection<Documents> documentsCollection;

    public BinaryFiles() {
    }

    public BinaryFiles(Integer id) {
        this.id = id;
    }

    public BinaryFiles(Integer id, String contentType, int size, Date lastModified, byte[] contents) {
        this.id = id;
        this.contentType = contentType;
        this.size = size;
        this.lastModified = lastModified;
        this.contents = contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection() {
        return documentsCollection;
    }

    public void setDocumentsCollection(Collection<Documents> documentsCollection) {
        this.documentsCollection = documentsCollection;
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
        if (!(object instanceof BinaryFiles)) {
            return false;
        }
        BinaryFiles other = (BinaryFiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BinaryFiles[ id=" + id + " ]";
    }
    
}
