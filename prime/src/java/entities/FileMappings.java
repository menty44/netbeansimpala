/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "file_mappings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileMappings.findAll", query = "SELECT f FROM FileMappings f"),
    @NamedQuery(name = "FileMappings.findById", query = "SELECT f FROM FileMappings f WHERE f.id = :id"),
    @NamedQuery(name = "FileMappings.findBySubclass", query = "SELECT f FROM FileMappings f WHERE f.subclass = :subclass"),
    @NamedQuery(name = "FileMappings.findByDateFormat", query = "SELECT f FROM FileMappings f WHERE f.dateFormat = :dateFormat"),
    @NamedQuery(name = "FileMappings.findByNumberFormat", query = "SELECT f FROM FileMappings f WHERE f.numberFormat = :numberFormat"),
    @NamedQuery(name = "FileMappings.findByDecimalPlaces", query = "SELECT f FROM FileMappings f WHERE f.decimalPlaces = :decimalPlaces"),
    @NamedQuery(name = "FileMappings.findByDecimalSeparator", query = "SELECT f FROM FileMappings f WHERE f.decimalSeparator = :decimalSeparator"),
    @NamedQuery(name = "FileMappings.findByNegativeAmountValue", query = "SELECT f FROM FileMappings f WHERE f.negativeAmountValue = :negativeAmountValue"),
    @NamedQuery(name = "FileMappings.findByClassname", query = "SELECT f FROM FileMappings f WHERE f.classname = :classname"),
    @NamedQuery(name = "FileMappings.findByStringQuote", query = "SELECT f FROM FileMappings f WHERE f.stringQuote = :stringQuote"),
    @NamedQuery(name = "FileMappings.findByColumnSeparator", query = "SELECT f FROM FileMappings f WHERE f.columnSeparator = :columnSeparator"),
    @NamedQuery(name = "FileMappings.findByHeaderLines", query = "SELECT f FROM FileMappings f WHERE f.headerLines = :headerLines")})
public class FileMappings implements Serializable {

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
    @Size(max = 20)
    @Column(name = "date_format")
    private String dateFormat;
    @Size(max = 1)
    @Column(name = "number_format")
    private String numberFormat;
    @Column(name = "decimal_places")
    private Integer decimalPlaces;
    @Column(name = "decimal_separator")
    private Character decimalSeparator;
    @Size(max = 50)
    @Column(name = "negative_amount_value")
    private String negativeAmountValue;
    @Size(max = 255)
    @Column(name = "classname")
    private String classname;
    @Column(name = "string_quote")
    private Character stringQuote;
    @Column(name = "column_separator")
    private Character columnSeparator;
    @Column(name = "header_lines")
    private Integer headerLines;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ExternalAccounts accountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileMappingId")
    private Collection<FieldMappings> fieldMappingsCollection;
    @OneToMany(mappedBy = "fileMappingId")
    private Collection<ExternalAccounts> externalAccountsCollection;

    public FileMappings() {
    }

    public FileMappings(Integer id) {
        this.id = id;
    }

    public FileMappings(Integer id, String subclass) {
        this.id = id;
        this.subclass = subclass;
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

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public Character getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(Character decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getNegativeAmountValue() {
        return negativeAmountValue;
    }

    public void setNegativeAmountValue(String negativeAmountValue) {
        this.negativeAmountValue = negativeAmountValue;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Character getStringQuote() {
        return stringQuote;
    }

    public void setStringQuote(Character stringQuote) {
        this.stringQuote = stringQuote;
    }

    public Character getColumnSeparator() {
        return columnSeparator;
    }

    public void setColumnSeparator(Character columnSeparator) {
        this.columnSeparator = columnSeparator;
    }

    public Integer getHeaderLines() {
        return headerLines;
    }

    public void setHeaderLines(Integer headerLines) {
        this.headerLines = headerLines;
    }

    public ExternalAccounts getAccountId() {
        return accountId;
    }

    public void setAccountId(ExternalAccounts accountId) {
        this.accountId = accountId;
    }

    @XmlTransient
    public Collection<FieldMappings> getFieldMappingsCollection() {
        return fieldMappingsCollection;
    }

    public void setFieldMappingsCollection(Collection<FieldMappings> fieldMappingsCollection) {
        this.fieldMappingsCollection = fieldMappingsCollection;
    }

    @XmlTransient
    public Collection<ExternalAccounts> getExternalAccountsCollection() {
        return externalAccountsCollection;
    }

    public void setExternalAccountsCollection(Collection<ExternalAccounts> externalAccountsCollection) {
        this.externalAccountsCollection = externalAccountsCollection;
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
        if (!(object instanceof FileMappings)) {
            return false;
        }
        FileMappings other = (FileMappings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FileMappings[ id=" + id + " ]";
    }
    
}
