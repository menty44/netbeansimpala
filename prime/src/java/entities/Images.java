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
import javax.persistence.Lob;
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
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findById", query = "SELECT i FROM Images i WHERE i.id = :id"),
    @NamedQuery(name = "Images.findBySubclass", query = "SELECT i FROM Images i WHERE i.subclass = :subclass"),
    @NamedQuery(name = "Images.findByName", query = "SELECT i FROM Images i WHERE i.name = :name"),
    @NamedQuery(name = "Images.findByContentType", query = "SELECT i FROM Images i WHERE i.contentType = :contentType"),
    @NamedQuery(name = "Images.findByImageSize", query = "SELECT i FROM Images i WHERE i.imageSize = :imageSize"),
    @NamedQuery(name = "Images.findByLastModified", query = "SELECT i FROM Images i WHERE i.lastModified = :lastModified"),
    @NamedQuery(name = "Images.findByThumbnailSize", query = "SELECT i FROM Images i WHERE i.thumbnailSize = :thumbnailSize"),
    @NamedQuery(name = "Images.findByOrderNumber", query = "SELECT i FROM Images i WHERE i.orderNumber = :orderNumber"),
    @NamedQuery(name = "Images.findByCaption", query = "SELECT i FROM Images i WHERE i.caption = :caption")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "subclass")
    private String subclass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content_type")
    private String contentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "image_size")
    private int imageSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thumbnail_size")
    private int thumbnailSize;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Lob
    @Column(name = "thumbnail")
    private byte[] thumbnail;
    @Column(name = "order_number")
    private Short orderNumber;
    @Size(max = 255)
    @Column(name = "caption")
    private String caption;
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    @ManyToOne
    private Ads adId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;

    public Images() {
    }

    public Images(Integer id) {
        this.id = id;
    }

    public Images(Integer id, String subclass, String name, String contentType, int imageSize, Date lastModified, int thumbnailSize, byte[] image) {
        this.id = id;
        this.subclass = subclass;
        this.name = name;
        this.contentType = contentType;
        this.imageSize = imageSize;
        this.lastModified = lastModified;
        this.thumbnailSize = thumbnailSize;
        this.image = image;
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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getThumbnailSize() {
        return thumbnailSize;
    }

    public void setThumbnailSize(int thumbnailSize) {
        this.thumbnailSize = thumbnailSize;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Short getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Short orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Ads getAdId() {
        return adId;
    }

    public void setAdId(Ads adId) {
        this.adId = adId;
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
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Images[ id=" + id + " ]";
    }
    
}
