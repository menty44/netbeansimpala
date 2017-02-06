/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "custom_fields")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomFields.findAll", query = "SELECT c FROM CustomFields c"),
    @NamedQuery(name = "CustomFields.findById", query = "SELECT c FROM CustomFields c WHERE c.id = :id"),
    @NamedQuery(name = "CustomFields.findBySubclass", query = "SELECT c FROM CustomFields c WHERE c.subclass = :subclass"),
    @NamedQuery(name = "CustomFields.findByInternalName", query = "SELECT c FROM CustomFields c WHERE c.internalName = :internalName"),
    @NamedQuery(name = "CustomFields.findByName", query = "SELECT c FROM CustomFields c WHERE c.name = :name"),
    @NamedQuery(name = "CustomFields.findByOrderNumber", query = "SELECT c FROM CustomFields c WHERE c.orderNumber = :orderNumber"),
    @NamedQuery(name = "CustomFields.findByType", query = "SELECT c FROM CustomFields c WHERE c.type = :type"),
    @NamedQuery(name = "CustomFields.findByControl", query = "SELECT c FROM CustomFields c WHERE c.control = :control"),
    @NamedQuery(name = "CustomFields.findBySize", query = "SELECT c FROM CustomFields c WHERE c.size = :size"),
    @NamedQuery(name = "CustomFields.findByValRequired", query = "SELECT c FROM CustomFields c WHERE c.valRequired = :valRequired"),
    @NamedQuery(name = "CustomFields.findByValUnique", query = "SELECT c FROM CustomFields c WHERE c.valUnique = :valUnique"),
    @NamedQuery(name = "CustomFields.findByValMinLength", query = "SELECT c FROM CustomFields c WHERE c.valMinLength = :valMinLength"),
    @NamedQuery(name = "CustomFields.findByValMaxLength", query = "SELECT c FROM CustomFields c WHERE c.valMaxLength = :valMaxLength"),
    @NamedQuery(name = "CustomFields.findByValClass", query = "SELECT c FROM CustomFields c WHERE c.valClass = :valClass"),
    @NamedQuery(name = "CustomFields.findByAllSelectedLabel", query = "SELECT c FROM CustomFields c WHERE c.allSelectedLabel = :allSelectedLabel"),
    @NamedQuery(name = "CustomFields.findByPattern", query = "SELECT c FROM CustomFields c WHERE c.pattern = :pattern"),
    @NamedQuery(name = "CustomFields.findByMemberVisibilityAccess", query = "SELECT c FROM CustomFields c WHERE c.memberVisibilityAccess = :memberVisibilityAccess"),
    @NamedQuery(name = "CustomFields.findByMemberUpdateAccess", query = "SELECT c FROM CustomFields c WHERE c.memberUpdateAccess = :memberUpdateAccess"),
    @NamedQuery(name = "CustomFields.findByMemberSearchAccess", query = "SELECT c FROM CustomFields c WHERE c.memberSearchAccess = :memberSearchAccess"),
    @NamedQuery(name = "CustomFields.findByMemberLoanSearchAccess", query = "SELECT c FROM CustomFields c WHERE c.memberLoanSearchAccess = :memberLoanSearchAccess"),
    @NamedQuery(name = "CustomFields.findByMemberAdSearchAccess", query = "SELECT c FROM CustomFields c WHERE c.memberAdSearchAccess = :memberAdSearchAccess"),
    @NamedQuery(name = "CustomFields.findByMemberCanHide", query = "SELECT c FROM CustomFields c WHERE c.memberCanHide = :memberCanHide"),
    @NamedQuery(name = "CustomFields.findByMemberShowInPrint", query = "SELECT c FROM CustomFields c WHERE c.memberShowInPrint = :memberShowInPrint"),
    @NamedQuery(name = "CustomFields.findByMemberIndexing", query = "SELECT c FROM CustomFields c WHERE c.memberIndexing = :memberIndexing"),
    @NamedQuery(name = "CustomFields.findByOperatorVisibility", query = "SELECT c FROM CustomFields c WHERE c.operatorVisibility = :operatorVisibility"),
    @NamedQuery(name = "CustomFields.findByAdShowInSearch", query = "SELECT c FROM CustomFields c WHERE c.adShowInSearch = :adShowInSearch"),
    @NamedQuery(name = "CustomFields.findByAdIndexed", query = "SELECT c FROM CustomFields c WHERE c.adIndexed = :adIndexed"),
    @NamedQuery(name = "CustomFields.findByAdVisibility", query = "SELECT c FROM CustomFields c WHERE c.adVisibility = :adVisibility"),
    @NamedQuery(name = "CustomFields.findByPaymentEnabled", query = "SELECT c FROM CustomFields c WHERE c.paymentEnabled = :paymentEnabled"),
    @NamedQuery(name = "CustomFields.findByPaymentSearchAccess", query = "SELECT c FROM CustomFields c WHERE c.paymentSearchAccess = :paymentSearchAccess"),
    @NamedQuery(name = "CustomFields.findByPaymentListAccess", query = "SELECT c FROM CustomFields c WHERE c.paymentListAccess = :paymentListAccess"),
    @NamedQuery(name = "CustomFields.findByLoanGroupShowInSearch", query = "SELECT c FROM CustomFields c WHERE c.loanGroupShowInSearch = :loanGroupShowInSearch"),
    @NamedQuery(name = "CustomFields.findByRecordShowInSearch", query = "SELECT c FROM CustomFields c WHERE c.recordShowInSearch = :recordShowInSearch"),
    @NamedQuery(name = "CustomFields.findByRecordShowInList", query = "SELECT c FROM CustomFields c WHERE c.recordShowInList = :recordShowInList"),
    @NamedQuery(name = "CustomFields.findByRecordBrokerAccess", query = "SELECT c FROM CustomFields c WHERE c.recordBrokerAccess = :recordBrokerAccess")})
public class CustomFields implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "internal_name")
    private String internalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_number")
    private short orderNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "control")
    private String control;
    @Size(max = 1)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_required")
    private boolean valRequired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_unique")
    private boolean valUnique;
    @Column(name = "val_min_length")
    private Short valMinLength;
    @Column(name = "val_max_length")
    private Short valMaxLength;
    @Size(max = 256)
    @Column(name = "val_class")
    private String valClass;
    @Size(max = 100)
    @Column(name = "all_selected_label")
    private String allSelectedLabel;
    @Size(max = 100)
    @Column(name = "pattern")
    private String pattern;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 1)
    @Column(name = "member_visibility_access")
    private String memberVisibilityAccess;
    @Size(max = 1)
    @Column(name = "member_update_access")
    private String memberUpdateAccess;
    @Size(max = 1)
    @Column(name = "member_search_access")
    private String memberSearchAccess;
    @Size(max = 1)
    @Column(name = "member_loan_search_access")
    private String memberLoanSearchAccess;
    @Size(max = 1)
    @Column(name = "member_ad_search_access")
    private String memberAdSearchAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_can_hide")
    private boolean memberCanHide;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_show_in_print")
    private boolean memberShowInPrint;
    @Size(max = 1)
    @Column(name = "member_indexing")
    private String memberIndexing;
    @Size(max = 1)
    @Column(name = "operator_visibility")
    private String operatorVisibility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ad_show_in_search")
    private boolean adShowInSearch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ad_indexed")
    private boolean adIndexed;
    @Size(max = 1)
    @Column(name = "ad_visibility")
    private String adVisibility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_enabled")
    private boolean paymentEnabled;
    @Size(max = 1)
    @Column(name = "payment_search_access")
    private String paymentSearchAccess;
    @Size(max = 1)
    @Column(name = "payment_list_access")
    private String paymentListAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loan_group_show_in_search")
    private boolean loanGroupShowInSearch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "record_show_in_search")
    private boolean recordShowInSearch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "record_show_in_list")
    private boolean recordShowInList;
    @Size(max = 1)
    @Column(name = "record_broker_access")
    private String recordBrokerAccess;
    @JoinTable(name = "transfer_types_linked_custom_fields", joinColumns = {
        @JoinColumn(name = "field_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection;
    @ManyToMany(mappedBy = "customFieldsCollection")
    private Collection<Groups> groupsCollection;
    @OneToMany(mappedBy = "fieldId")
    private Collection<CustomFieldPossibleValues> customFieldPossibleValuesCollection;
    @OneToMany(mappedBy = "memberFieldId")
    private Collection<FieldMappings> fieldMappingsCollection;
    @OneToMany(mappedBy = "customFieldId")
    private Collection<ChannelsPrincipals> channelsPrincipalsCollection;
    @OneToMany(mappedBy = "parentId")
    private Collection<CustomFields> customFieldsCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private CustomFields parentId;
    @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes transferTypeId;
    @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")
    @ManyToOne
    private MemberRecordTypes memberRecordTypeId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(mappedBy = "fieldId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public CustomFields() {
    }

    public CustomFields(Integer id) {
        this.id = id;
    }

    public CustomFields(Integer id, String subclass, String internalName, String name, short orderNumber, String type, String control, boolean valRequired, boolean valUnique, boolean memberCanHide, boolean memberShowInPrint, boolean adShowInSearch, boolean adIndexed, boolean paymentEnabled, boolean loanGroupShowInSearch, boolean recordShowInSearch, boolean recordShowInList) {
        this.id = id;
        this.subclass = subclass;
        this.internalName = internalName;
        this.name = name;
        this.orderNumber = orderNumber;
        this.type = type;
        this.control = control;
        this.valRequired = valRequired;
        this.valUnique = valUnique;
        this.memberCanHide = memberCanHide;
        this.memberShowInPrint = memberShowInPrint;
        this.adShowInSearch = adShowInSearch;
        this.adIndexed = adIndexed;
        this.paymentEnabled = paymentEnabled;
        this.loanGroupShowInSearch = loanGroupShowInSearch;
        this.recordShowInSearch = recordShowInSearch;
        this.recordShowInList = recordShowInList;
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

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(short orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean getValRequired() {
        return valRequired;
    }

    public void setValRequired(boolean valRequired) {
        this.valRequired = valRequired;
    }

    public boolean getValUnique() {
        return valUnique;
    }

    public void setValUnique(boolean valUnique) {
        this.valUnique = valUnique;
    }

    public Short getValMinLength() {
        return valMinLength;
    }

    public void setValMinLength(Short valMinLength) {
        this.valMinLength = valMinLength;
    }

    public Short getValMaxLength() {
        return valMaxLength;
    }

    public void setValMaxLength(Short valMaxLength) {
        this.valMaxLength = valMaxLength;
    }

    public String getValClass() {
        return valClass;
    }

    public void setValClass(String valClass) {
        this.valClass = valClass;
    }

    public String getAllSelectedLabel() {
        return allSelectedLabel;
    }

    public void setAllSelectedLabel(String allSelectedLabel) {
        this.allSelectedLabel = allSelectedLabel;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMemberVisibilityAccess() {
        return memberVisibilityAccess;
    }

    public void setMemberVisibilityAccess(String memberVisibilityAccess) {
        this.memberVisibilityAccess = memberVisibilityAccess;
    }

    public String getMemberUpdateAccess() {
        return memberUpdateAccess;
    }

    public void setMemberUpdateAccess(String memberUpdateAccess) {
        this.memberUpdateAccess = memberUpdateAccess;
    }

    public String getMemberSearchAccess() {
        return memberSearchAccess;
    }

    public void setMemberSearchAccess(String memberSearchAccess) {
        this.memberSearchAccess = memberSearchAccess;
    }

    public String getMemberLoanSearchAccess() {
        return memberLoanSearchAccess;
    }

    public void setMemberLoanSearchAccess(String memberLoanSearchAccess) {
        this.memberLoanSearchAccess = memberLoanSearchAccess;
    }

    public String getMemberAdSearchAccess() {
        return memberAdSearchAccess;
    }

    public void setMemberAdSearchAccess(String memberAdSearchAccess) {
        this.memberAdSearchAccess = memberAdSearchAccess;
    }

    public boolean getMemberCanHide() {
        return memberCanHide;
    }

    public void setMemberCanHide(boolean memberCanHide) {
        this.memberCanHide = memberCanHide;
    }

    public boolean getMemberShowInPrint() {
        return memberShowInPrint;
    }

    public void setMemberShowInPrint(boolean memberShowInPrint) {
        this.memberShowInPrint = memberShowInPrint;
    }

    public String getMemberIndexing() {
        return memberIndexing;
    }

    public void setMemberIndexing(String memberIndexing) {
        this.memberIndexing = memberIndexing;
    }

    public String getOperatorVisibility() {
        return operatorVisibility;
    }

    public void setOperatorVisibility(String operatorVisibility) {
        this.operatorVisibility = operatorVisibility;
    }

    public boolean getAdShowInSearch() {
        return adShowInSearch;
    }

    public void setAdShowInSearch(boolean adShowInSearch) {
        this.adShowInSearch = adShowInSearch;
    }

    public boolean getAdIndexed() {
        return adIndexed;
    }

    public void setAdIndexed(boolean adIndexed) {
        this.adIndexed = adIndexed;
    }

    public String getAdVisibility() {
        return adVisibility;
    }

    public void setAdVisibility(String adVisibility) {
        this.adVisibility = adVisibility;
    }

    public boolean getPaymentEnabled() {
        return paymentEnabled;
    }

    public void setPaymentEnabled(boolean paymentEnabled) {
        this.paymentEnabled = paymentEnabled;
    }

    public String getPaymentSearchAccess() {
        return paymentSearchAccess;
    }

    public void setPaymentSearchAccess(String paymentSearchAccess) {
        this.paymentSearchAccess = paymentSearchAccess;
    }

    public String getPaymentListAccess() {
        return paymentListAccess;
    }

    public void setPaymentListAccess(String paymentListAccess) {
        this.paymentListAccess = paymentListAccess;
    }

    public boolean getLoanGroupShowInSearch() {
        return loanGroupShowInSearch;
    }

    public void setLoanGroupShowInSearch(boolean loanGroupShowInSearch) {
        this.loanGroupShowInSearch = loanGroupShowInSearch;
    }

    public boolean getRecordShowInSearch() {
        return recordShowInSearch;
    }

    public void setRecordShowInSearch(boolean recordShowInSearch) {
        this.recordShowInSearch = recordShowInSearch;
    }

    public boolean getRecordShowInList() {
        return recordShowInList;
    }

    public void setRecordShowInList(boolean recordShowInList) {
        this.recordShowInList = recordShowInList;
    }

    public String getRecordBrokerAccess() {
        return recordBrokerAccess;
    }

    public void setRecordBrokerAccess(String recordBrokerAccess) {
        this.recordBrokerAccess = recordBrokerAccess;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<CustomFieldPossibleValues> getCustomFieldPossibleValuesCollection() {
        return customFieldPossibleValuesCollection;
    }

    public void setCustomFieldPossibleValuesCollection(Collection<CustomFieldPossibleValues> customFieldPossibleValuesCollection) {
        this.customFieldPossibleValuesCollection = customFieldPossibleValuesCollection;
    }

    @XmlTransient
    public Collection<FieldMappings> getFieldMappingsCollection() {
        return fieldMappingsCollection;
    }

    public void setFieldMappingsCollection(Collection<FieldMappings> fieldMappingsCollection) {
        this.fieldMappingsCollection = fieldMappingsCollection;
    }

    @XmlTransient
    public Collection<ChannelsPrincipals> getChannelsPrincipalsCollection() {
        return channelsPrincipalsCollection;
    }

    public void setChannelsPrincipalsCollection(Collection<ChannelsPrincipals> channelsPrincipalsCollection) {
        this.channelsPrincipalsCollection = channelsPrincipalsCollection;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection() {
        return customFieldsCollection;
    }

    public void setCustomFieldsCollection(Collection<CustomFields> customFieldsCollection) {
        this.customFieldsCollection = customFieldsCollection;
    }

    public CustomFields getParentId() {
        return parentId;
    }

    public void setParentId(CustomFields parentId) {
        this.parentId = parentId;
    }

    public TransferTypes getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(TransferTypes transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public MemberRecordTypes getMemberRecordTypeId() {
        return memberRecordTypeId;
    }

    public void setMemberRecordTypeId(MemberRecordTypes memberRecordTypeId) {
        this.memberRecordTypeId = memberRecordTypeId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
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
        if (!(object instanceof CustomFields)) {
            return false;
        }
        CustomFields other = (CustomFields) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomFields[ id=" + id + " ]";
    }
    
}
