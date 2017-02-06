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
@Table(name = "custom_field_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomFieldValues.findAll", query = "SELECT c FROM CustomFieldValues c"),
    @NamedQuery(name = "CustomFieldValues.findById", query = "SELECT c FROM CustomFieldValues c WHERE c.id = :id"),
    @NamedQuery(name = "CustomFieldValues.findBySubclass", query = "SELECT c FROM CustomFieldValues c WHERE c.subclass = :subclass"),
    @NamedQuery(name = "CustomFieldValues.findByStringValue", query = "SELECT c FROM CustomFieldValues c WHERE c.stringValue = :stringValue"),
    @NamedQuery(name = "CustomFieldValues.findByMemberHidden", query = "SELECT c FROM CustomFieldValues c WHERE c.memberHidden = :memberHidden")})
public class CustomFieldValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "subclass")
    private String subclass;
    @Size(max = 4000)
    @Column(name = "string_value")
    private String stringValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_hidden")
    private boolean memberHidden;
    @JoinColumn(name = "loan_group_id", referencedColumnName = "id")
    @ManyToOne
    private LoanGroups loanGroupId;
    @JoinColumn(name = "guarantee_id", referencedColumnName = "id")
    @ManyToOne
    private Guarantees guaranteeId;
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers transferId;
    @JoinColumn(name = "pending_member_id", referencedColumnName = "id")
    @ManyToOne
    private PendingMembers pendingMemberId;
    @JoinColumn(name = "member_record_id", referencedColumnName = "id")
    @ManyToOne
    private MemberRecords memberRecordId;
    @JoinColumn(name = "imported_member_record_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedMemberRecords importedMemberRecordId;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne
    private Members adminId;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne
    private Members operatorId;
    @JoinColumn(name = "imported_member_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedMembers importedMemberId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne
    private Invoices invoiceId;
    @JoinColumn(name = "imported_ad_id", referencedColumnName = "id")
    @ManyToOne
    private ImportedAds importedAdId;
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFields fieldId;
    @JoinColumn(name = "member_value_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberValueId;
    @JoinColumn(name = "scheduled_payment_id", referencedColumnName = "id")
    @ManyToOne
    private ScheduledPayments scheduledPaymentId;
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    @ManyToOne
    private Ads adId;
    @JoinColumn(name = "possible_value_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFieldPossibleValues possibleValueId;

    public CustomFieldValues() {
    }

    public CustomFieldValues(Integer id) {
        this.id = id;
    }

    public CustomFieldValues(Integer id, String subclass, boolean memberHidden) {
        this.id = id;
        this.subclass = subclass;
        this.memberHidden = memberHidden;
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

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean getMemberHidden() {
        return memberHidden;
    }

    public void setMemberHidden(boolean memberHidden) {
        this.memberHidden = memberHidden;
    }

    public LoanGroups getLoanGroupId() {
        return loanGroupId;
    }

    public void setLoanGroupId(LoanGroups loanGroupId) {
        this.loanGroupId = loanGroupId;
    }

    public Guarantees getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Guarantees guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Transfers getTransferId() {
        return transferId;
    }

    public void setTransferId(Transfers transferId) {
        this.transferId = transferId;
    }

    public PendingMembers getPendingMemberId() {
        return pendingMemberId;
    }

    public void setPendingMemberId(PendingMembers pendingMemberId) {
        this.pendingMemberId = pendingMemberId;
    }

    public MemberRecords getMemberRecordId() {
        return memberRecordId;
    }

    public void setMemberRecordId(MemberRecords memberRecordId) {
        this.memberRecordId = memberRecordId;
    }

    public ImportedMemberRecords getImportedMemberRecordId() {
        return importedMemberRecordId;
    }

    public void setImportedMemberRecordId(ImportedMemberRecords importedMemberRecordId) {
        this.importedMemberRecordId = importedMemberRecordId;
    }

    public Members getAdminId() {
        return adminId;
    }

    public void setAdminId(Members adminId) {
        this.adminId = adminId;
    }

    public Members getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Members operatorId) {
        this.operatorId = operatorId;
    }

    public ImportedMembers getImportedMemberId() {
        return importedMemberId;
    }

    public void setImportedMemberId(ImportedMembers importedMemberId) {
        this.importedMemberId = importedMemberId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    public Invoices getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoices invoiceId) {
        this.invoiceId = invoiceId;
    }

    public ImportedAds getImportedAdId() {
        return importedAdId;
    }

    public void setImportedAdId(ImportedAds importedAdId) {
        this.importedAdId = importedAdId;
    }

    public CustomFields getFieldId() {
        return fieldId;
    }

    public void setFieldId(CustomFields fieldId) {
        this.fieldId = fieldId;
    }

    public Members getMemberValueId() {
        return memberValueId;
    }

    public void setMemberValueId(Members memberValueId) {
        this.memberValueId = memberValueId;
    }

    public ScheduledPayments getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(ScheduledPayments scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }

    public Ads getAdId() {
        return adId;
    }

    public void setAdId(Ads adId) {
        this.adId = adId;
    }

    public CustomFieldPossibleValues getPossibleValueId() {
        return possibleValueId;
    }

    public void setPossibleValueId(CustomFieldPossibleValues possibleValueId) {
        this.possibleValueId = possibleValueId;
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
        if (!(object instanceof CustomFieldValues)) {
            return false;
        }
        CustomFieldValues other = (CustomFieldValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomFieldValues[ id=" + id + " ]";
    }
    
}
