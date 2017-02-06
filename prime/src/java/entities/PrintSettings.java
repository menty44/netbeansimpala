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
@Table(name = "print_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrintSettings.findAll", query = "SELECT p FROM PrintSettings p"),
    @NamedQuery(name = "PrintSettings.findById", query = "SELECT p FROM PrintSettings p WHERE p.id = :id"),
    @NamedQuery(name = "PrintSettings.findByName", query = "SELECT p FROM PrintSettings p WHERE p.name = :name"),
    @NamedQuery(name = "PrintSettings.findByPrinterName", query = "SELECT p FROM PrintSettings p WHERE p.printerName = :printerName"),
    @NamedQuery(name = "PrintSettings.findByBeginDocCmd", query = "SELECT p FROM PrintSettings p WHERE p.beginDocCmd = :beginDocCmd"),
    @NamedQuery(name = "PrintSettings.findByEndDocCmd", query = "SELECT p FROM PrintSettings p WHERE p.endDocCmd = :endDocCmd"),
    @NamedQuery(name = "PrintSettings.findByPaymentMessage", query = "SELECT p FROM PrintSettings p WHERE p.paymentMessage = :paymentMessage")})
public class PrintSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "printer_name")
    private String printerName;
    @Size(max = 100)
    @Column(name = "begin_doc_cmd")
    private String beginDocCmd;
    @Size(max = 100)
    @Column(name = "end_doc_cmd")
    private String endDocCmd;
    @Size(max = 500)
    @Column(name = "payment_message")
    private String paymentMessage;
    @JoinColumn(name = "member", referencedColumnName = "id")
    @ManyToOne
    private Members member1;

    public PrintSettings() {
    }

    public PrintSettings(Integer id) {
        this.id = id;
    }

    public PrintSettings(Integer id, String name, String printerName) {
        this.id = id;
        this.name = name;
        this.printerName = printerName;
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

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getBeginDocCmd() {
        return beginDocCmd;
    }

    public void setBeginDocCmd(String beginDocCmd) {
        this.beginDocCmd = beginDocCmd;
    }

    public String getEndDocCmd() {
        return endDocCmd;
    }

    public void setEndDocCmd(String endDocCmd) {
        this.endDocCmd = endDocCmd;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public void setPaymentMessage(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }

    public Members getMember1() {
        return member1;
    }

    public void setMember1(Members member1) {
        this.member1 = member1;
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
        if (!(object instanceof PrintSettings)) {
            return false;
        }
        PrintSettings other = (PrintSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PrintSettings[ id=" + id + " ]";
    }
    
}
