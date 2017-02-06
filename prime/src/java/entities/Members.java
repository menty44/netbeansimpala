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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m"),
    @NamedQuery(name = "Members.findById", query = "SELECT m FROM Members m WHERE m.id = :id"),
    @NamedQuery(name = "Members.findBySubclass", query = "SELECT m FROM Members m WHERE m.subclass = :subclass"),
    @NamedQuery(name = "Members.findByName", query = "SELECT m FROM Members m WHERE m.name = :name"),
    @NamedQuery(name = "Members.findByCreationDate", query = "SELECT m FROM Members m WHERE m.creationDate = :creationDate"),
    @NamedQuery(name = "Members.findByEmail", query = "SELECT m FROM Members m WHERE m.email = :email"),
    @NamedQuery(name = "Members.findByMemberActivationDate", query = "SELECT m FROM Members m WHERE m.memberActivationDate = :memberActivationDate"),
    @NamedQuery(name = "Members.findByHideEmail", query = "SELECT m FROM Members m WHERE m.hideEmail = :hideEmail")})
public class Members implements Serializable {

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
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "member_activation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberActivationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hide_email")
    private boolean hideEmail;
    @ManyToMany(mappedBy = "membersCollection")
    private Collection<AccountFeeLogs> accountFeeLogsCollection;
    @ManyToMany(mappedBy = "membersCollection")
    private Collection<SmsMailings> smsMailingsCollection;
    @JoinTable(name = "members_loans", joinColumns = {
        @JoinColumn(name = "member_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "loan_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Loans> loansCollection;
    @ManyToMany(mappedBy = "membersCollection")
    private Collection<LoanGroups> loanGroupsCollection;
    @ManyToMany(mappedBy = "membersCollection")
    private Collection<Channels> channelsCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<PendingEmailChanges> pendingEmailChangesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberId")
    private Collection<PendingEmailChanges> pendingEmailChangesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<UsernameChangeLogs> usernameChangeLogsCollection;
    @OneToMany(mappedBy = "brokerId")
    private Collection<DefaultBrokerCommissions> defaultBrokerCommissionsCollection;
    @OneToMany(mappedBy = "chargedMemberId")
    private Collection<SmsLogs> smsLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetMemberId")
    private Collection<SmsLogs> smsLogsCollection1;
    @OneToMany(mappedBy = "fromMemberId")
    private Collection<Invoices> invoicesCollection;
    @OneToMany(mappedBy = "toMemberId")
    private Collection<Invoices> invoicesCollection1;
    @OneToMany(mappedBy = "performedById")
    private Collection<Invoices> invoicesCollection2;
    @OneToMany(mappedBy = "sentById")
    private Collection<Invoices> invoicesCollection3;
    @OneToMany(mappedBy = "member1")
    private Collection<NotificationPreferences> notificationPreferencesCollection;
    @OneToMany(mappedBy = "cancelledById")
    private Collection<BrokerCommissionContracts> brokerCommissionContractsCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<CardLogs> cardLogsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<Images> imagesCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<GuaranteeLogs> guaranteeLogsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<ServiceClients> serviceClientsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<Alerts> alertsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "memberId")
    private MemberSmsStatus memberSmsStatus;
    @OneToMany(mappedBy = "fromMemberId")
    private Collection<Messages> messagesCollection;
    @OneToMany(mappedBy = "toMemberId")
    private Collection<Messages> messagesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<MemberPos> memberPosCollection;
    @OneToMany(mappedBy = "fromMemberId")
    private Collection<TransactionFees> transactionFeesCollection;
    @OneToMany(mappedBy = "toMemberId")
    private Collection<TransactionFees> transactionFeesCollection1;
    @OneToMany(mappedBy = "byId")
    private Collection<AccountLimitLogs> accountLimitLogsCollection;
    @OneToMany(mappedBy = "brokerId")
    private Collection<PendingMembers> pendingMembersCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<PendingMembers> pendingMembersCollection1;
    @OneToMany(mappedBy = "byId")
    private Collection<ScheduledPayments> scheduledPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<MemberRecords> memberRecordsCollection;
    @OneToMany(mappedBy = "modifiedById")
    private Collection<MemberRecords> memberRecordsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementId")
    private Collection<MemberRecords> memberRecordsCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberId")
    private Collection<RegistrationAgreementLogs> registrationAgreementLogsCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<Transfers> transfersCollection;
    @OneToMany(mappedBy = "receiverId")
    private Collection<Transfers> transfersCollection1;
    @OneToMany(mappedBy = "ownerId")
    private Collection<ImportedAds> importedAdsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerId")
    private Collection<PaymentObligations> paymentObligationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerId")
    private Collection<PaymentObligations> paymentObligationsCollection1;
    @OneToMany(mappedBy = "byId")
    private Collection<CertificationLogs> certificationLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokerId")
    private Collection<Brokerings> brokeringsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokeredId")
    private Collection<Brokerings> brokeringsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromMemberId")
    private Collection<Refs> refsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toMemberId")
    private Collection<Refs> refsCollection1;
    @OneToMany(mappedBy = "adminId")
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<PaymentObligationLogs> paymentObligationLogsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<Accounts> accountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Collection<Contacts> contactsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<Contacts> contactsCollection1;
    @OneToMany(mappedBy = "memberId")
    private Collection<Documents> documentsCollection;
    @OneToMany(mappedBy = "byId")
    private Collection<TransferAuthorizations> transferAuthorizationsCollection;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groups groupId;
    @OneToMany(mappedBy = "memberBrokerId")
    private Collection<Members> membersCollection;
    @JoinColumn(name = "member_broker_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberBrokerId;
    @OneToMany(mappedBy = "memberId")
    private Collection<Members> membersCollection1;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(mappedBy = "sellerId")
    private Collection<Guarantees> guaranteesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerId")
    private Collection<Guarantees> guaranteesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issuerId")
    private Collection<Guarantees> guaranteesCollection2;
    @OneToMany(mappedBy = "memberId")
    private Collection<CustomFields> customFieldsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromMemberId")
    private Collection<ReferenceHistory> referenceHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toMemberId")
    private Collection<ReferenceHistory> referenceHistoryCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "members")
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<Ads> adsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementId")
    private Collection<GroupHistoryLogs> groupHistoryLogsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<AdInterests> adInterestsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<AdInterests> adInterestsCollection1;
    @OneToMany(mappedBy = "byId")
    private Collection<PosLogs> posLogsCollection;
    @OneToMany(mappedBy = "assignedTo")
    private Collection<PosLogs> posLogsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<AdImports> adImportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<ExternalTransferImports> externalTransferImportsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<Cards> cardsCollection;
    @OneToMany(mappedBy = "fromMemberId")
    private Collection<Tickets> ticketsCollection;
    @OneToMany(mappedBy = "toMemberId")
    private Collection<Tickets> ticketsCollection1;
    @OneToMany(mappedBy = "member1")
    private Collection<PrintSettings> printSettingsCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<ExternalTransfers> externalTransfersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberId")
    private Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<SmsMailings> smsMailingsCollection1;
    @OneToMany(mappedBy = "memberId")
    private Collection<SmsMailings> smsMailingsCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "byId")
    private Collection<MemberImports> memberImportsCollection;
    @OneToMany(mappedBy = "fixedDestinationMemberId")
    private Collection<TransferTypes> transferTypesCollection;
    @OneToMany(mappedBy = "memberId")
    private Collection<Groups> groupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyerId")
    private Collection<Certifications> certificationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issuerId")
    private Collection<Certifications> certificationsCollection1;
    @OneToMany(mappedBy = "adminId")
    private Collection<CustomFieldValues> customFieldValuesCollection;
    @OneToMany(mappedBy = "operatorId")
    private Collection<CustomFieldValues> customFieldValuesCollection1;
    @OneToMany(mappedBy = "memberId")
    private Collection<CustomFieldValues> customFieldValuesCollection2;
    @OneToMany(mappedBy = "memberValueId")
    private Collection<CustomFieldValues> customFieldValuesCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Collection<Remarks> remarksCollection;
    @OneToMany(mappedBy = "newBrokerId")
    private Collection<Remarks> remarksCollection1;
    @OneToMany(mappedBy = "oldBrokerId")
    private Collection<Remarks> remarksCollection2;
    @OneToMany(mappedBy = "writerId")
    private Collection<Remarks> remarksCollection3;

    public Members() {
    }

    public Members(Integer id) {
        this.id = id;
    }

    public Members(Integer id, String subclass, String name, Date creationDate, boolean hideEmail) {
        this.id = id;
        this.subclass = subclass;
        this.name = name;
        this.creationDate = creationDate;
        this.hideEmail = hideEmail;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMemberActivationDate() {
        return memberActivationDate;
    }

    public void setMemberActivationDate(Date memberActivationDate) {
        this.memberActivationDate = memberActivationDate;
    }

    public boolean getHideEmail() {
        return hideEmail;
    }

    public void setHideEmail(boolean hideEmail) {
        this.hideEmail = hideEmail;
    }

    @XmlTransient
    public Collection<AccountFeeLogs> getAccountFeeLogsCollection() {
        return accountFeeLogsCollection;
    }

    public void setAccountFeeLogsCollection(Collection<AccountFeeLogs> accountFeeLogsCollection) {
        this.accountFeeLogsCollection = accountFeeLogsCollection;
    }

    @XmlTransient
    public Collection<SmsMailings> getSmsMailingsCollection() {
        return smsMailingsCollection;
    }

    public void setSmsMailingsCollection(Collection<SmsMailings> smsMailingsCollection) {
        this.smsMailingsCollection = smsMailingsCollection;
    }

    @XmlTransient
    public Collection<Loans> getLoansCollection() {
        return loansCollection;
    }

    public void setLoansCollection(Collection<Loans> loansCollection) {
        this.loansCollection = loansCollection;
    }

    @XmlTransient
    public Collection<LoanGroups> getLoanGroupsCollection() {
        return loanGroupsCollection;
    }

    public void setLoanGroupsCollection(Collection<LoanGroups> loanGroupsCollection) {
        this.loanGroupsCollection = loanGroupsCollection;
    }

    @XmlTransient
    public Collection<Channels> getChannelsCollection() {
        return channelsCollection;
    }

    public void setChannelsCollection(Collection<Channels> channelsCollection) {
        this.channelsCollection = channelsCollection;
    }

    @XmlTransient
    public Collection<PendingEmailChanges> getPendingEmailChangesCollection() {
        return pendingEmailChangesCollection;
    }

    public void setPendingEmailChangesCollection(Collection<PendingEmailChanges> pendingEmailChangesCollection) {
        this.pendingEmailChangesCollection = pendingEmailChangesCollection;
    }

    @XmlTransient
    public Collection<PendingEmailChanges> getPendingEmailChangesCollection1() {
        return pendingEmailChangesCollection1;
    }

    public void setPendingEmailChangesCollection1(Collection<PendingEmailChanges> pendingEmailChangesCollection1) {
        this.pendingEmailChangesCollection1 = pendingEmailChangesCollection1;
    }

    @XmlTransient
    public Collection<UsernameChangeLogs> getUsernameChangeLogsCollection() {
        return usernameChangeLogsCollection;
    }

    public void setUsernameChangeLogsCollection(Collection<UsernameChangeLogs> usernameChangeLogsCollection) {
        this.usernameChangeLogsCollection = usernameChangeLogsCollection;
    }

    @XmlTransient
    public Collection<DefaultBrokerCommissions> getDefaultBrokerCommissionsCollection() {
        return defaultBrokerCommissionsCollection;
    }

    public void setDefaultBrokerCommissionsCollection(Collection<DefaultBrokerCommissions> defaultBrokerCommissionsCollection) {
        this.defaultBrokerCommissionsCollection = defaultBrokerCommissionsCollection;
    }

    @XmlTransient
    public Collection<SmsLogs> getSmsLogsCollection() {
        return smsLogsCollection;
    }

    public void setSmsLogsCollection(Collection<SmsLogs> smsLogsCollection) {
        this.smsLogsCollection = smsLogsCollection;
    }

    @XmlTransient
    public Collection<SmsLogs> getSmsLogsCollection1() {
        return smsLogsCollection1;
    }

    public void setSmsLogsCollection1(Collection<SmsLogs> smsLogsCollection1) {
        this.smsLogsCollection1 = smsLogsCollection1;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection1() {
        return invoicesCollection1;
    }

    public void setInvoicesCollection1(Collection<Invoices> invoicesCollection1) {
        this.invoicesCollection1 = invoicesCollection1;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection2() {
        return invoicesCollection2;
    }

    public void setInvoicesCollection2(Collection<Invoices> invoicesCollection2) {
        this.invoicesCollection2 = invoicesCollection2;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection3() {
        return invoicesCollection3;
    }

    public void setInvoicesCollection3(Collection<Invoices> invoicesCollection3) {
        this.invoicesCollection3 = invoicesCollection3;
    }

    @XmlTransient
    public Collection<NotificationPreferences> getNotificationPreferencesCollection() {
        return notificationPreferencesCollection;
    }

    public void setNotificationPreferencesCollection(Collection<NotificationPreferences> notificationPreferencesCollection) {
        this.notificationPreferencesCollection = notificationPreferencesCollection;
    }

    @XmlTransient
    public Collection<BrokerCommissionContracts> getBrokerCommissionContractsCollection() {
        return brokerCommissionContractsCollection;
    }

    public void setBrokerCommissionContractsCollection(Collection<BrokerCommissionContracts> brokerCommissionContractsCollection) {
        this.brokerCommissionContractsCollection = brokerCommissionContractsCollection;
    }

    @XmlTransient
    public Collection<CardLogs> getCardLogsCollection() {
        return cardLogsCollection;
    }

    public void setCardLogsCollection(Collection<CardLogs> cardLogsCollection) {
        this.cardLogsCollection = cardLogsCollection;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    @XmlTransient
    public Collection<GuaranteeLogs> getGuaranteeLogsCollection() {
        return guaranteeLogsCollection;
    }

    public void setGuaranteeLogsCollection(Collection<GuaranteeLogs> guaranteeLogsCollection) {
        this.guaranteeLogsCollection = guaranteeLogsCollection;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection() {
        return serviceClientsCollection;
    }

    public void setServiceClientsCollection(Collection<ServiceClients> serviceClientsCollection) {
        this.serviceClientsCollection = serviceClientsCollection;
    }

    @XmlTransient
    public Collection<Alerts> getAlertsCollection() {
        return alertsCollection;
    }

    public void setAlertsCollection(Collection<Alerts> alertsCollection) {
        this.alertsCollection = alertsCollection;
    }

    public MemberSmsStatus getMemberSmsStatus() {
        return memberSmsStatus;
    }

    public void setMemberSmsStatus(MemberSmsStatus memberSmsStatus) {
        this.memberSmsStatus = memberSmsStatus;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection1() {
        return messagesCollection1;
    }

    public void setMessagesCollection1(Collection<Messages> messagesCollection1) {
        this.messagesCollection1 = messagesCollection1;
    }

    @XmlTransient
    public Collection<MemberPos> getMemberPosCollection() {
        return memberPosCollection;
    }

    public void setMemberPosCollection(Collection<MemberPos> memberPosCollection) {
        this.memberPosCollection = memberPosCollection;
    }

    @XmlTransient
    public Collection<TransactionFees> getTransactionFeesCollection() {
        return transactionFeesCollection;
    }

    public void setTransactionFeesCollection(Collection<TransactionFees> transactionFeesCollection) {
        this.transactionFeesCollection = transactionFeesCollection;
    }

    @XmlTransient
    public Collection<TransactionFees> getTransactionFeesCollection1() {
        return transactionFeesCollection1;
    }

    public void setTransactionFeesCollection1(Collection<TransactionFees> transactionFeesCollection1) {
        this.transactionFeesCollection1 = transactionFeesCollection1;
    }

    @XmlTransient
    public Collection<AccountLimitLogs> getAccountLimitLogsCollection() {
        return accountLimitLogsCollection;
    }

    public void setAccountLimitLogsCollection(Collection<AccountLimitLogs> accountLimitLogsCollection) {
        this.accountLimitLogsCollection = accountLimitLogsCollection;
    }

    @XmlTransient
    public Collection<PendingMembers> getPendingMembersCollection() {
        return pendingMembersCollection;
    }

    public void setPendingMembersCollection(Collection<PendingMembers> pendingMembersCollection) {
        this.pendingMembersCollection = pendingMembersCollection;
    }

    @XmlTransient
    public Collection<PendingMembers> getPendingMembersCollection1() {
        return pendingMembersCollection1;
    }

    public void setPendingMembersCollection1(Collection<PendingMembers> pendingMembersCollection1) {
        this.pendingMembersCollection1 = pendingMembersCollection1;
    }

    @XmlTransient
    public Collection<ScheduledPayments> getScheduledPaymentsCollection() {
        return scheduledPaymentsCollection;
    }

    public void setScheduledPaymentsCollection(Collection<ScheduledPayments> scheduledPaymentsCollection) {
        this.scheduledPaymentsCollection = scheduledPaymentsCollection;
    }

    @XmlTransient
    public Collection<MemberRecords> getMemberRecordsCollection() {
        return memberRecordsCollection;
    }

    public void setMemberRecordsCollection(Collection<MemberRecords> memberRecordsCollection) {
        this.memberRecordsCollection = memberRecordsCollection;
    }

    @XmlTransient
    public Collection<MemberRecords> getMemberRecordsCollection1() {
        return memberRecordsCollection1;
    }

    public void setMemberRecordsCollection1(Collection<MemberRecords> memberRecordsCollection1) {
        this.memberRecordsCollection1 = memberRecordsCollection1;
    }

    @XmlTransient
    public Collection<MemberRecords> getMemberRecordsCollection2() {
        return memberRecordsCollection2;
    }

    public void setMemberRecordsCollection2(Collection<MemberRecords> memberRecordsCollection2) {
        this.memberRecordsCollection2 = memberRecordsCollection2;
    }

    @XmlTransient
    public Collection<RegistrationAgreementLogs> getRegistrationAgreementLogsCollection() {
        return registrationAgreementLogsCollection;
    }

    public void setRegistrationAgreementLogsCollection(Collection<RegistrationAgreementLogs> registrationAgreementLogsCollection) {
        this.registrationAgreementLogsCollection = registrationAgreementLogsCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection1() {
        return transfersCollection1;
    }

    public void setTransfersCollection1(Collection<Transfers> transfersCollection1) {
        this.transfersCollection1 = transfersCollection1;
    }

    @XmlTransient
    public Collection<ImportedAds> getImportedAdsCollection() {
        return importedAdsCollection;
    }

    public void setImportedAdsCollection(Collection<ImportedAds> importedAdsCollection) {
        this.importedAdsCollection = importedAdsCollection;
    }

    @XmlTransient
    public Collection<PaymentObligations> getPaymentObligationsCollection() {
        return paymentObligationsCollection;
    }

    public void setPaymentObligationsCollection(Collection<PaymentObligations> paymentObligationsCollection) {
        this.paymentObligationsCollection = paymentObligationsCollection;
    }

    @XmlTransient
    public Collection<PaymentObligations> getPaymentObligationsCollection1() {
        return paymentObligationsCollection1;
    }

    public void setPaymentObligationsCollection1(Collection<PaymentObligations> paymentObligationsCollection1) {
        this.paymentObligationsCollection1 = paymentObligationsCollection1;
    }

    @XmlTransient
    public Collection<CertificationLogs> getCertificationLogsCollection() {
        return certificationLogsCollection;
    }

    public void setCertificationLogsCollection(Collection<CertificationLogs> certificationLogsCollection) {
        this.certificationLogsCollection = certificationLogsCollection;
    }

    @XmlTransient
    public Collection<Brokerings> getBrokeringsCollection() {
        return brokeringsCollection;
    }

    public void setBrokeringsCollection(Collection<Brokerings> brokeringsCollection) {
        this.brokeringsCollection = brokeringsCollection;
    }

    @XmlTransient
    public Collection<Brokerings> getBrokeringsCollection1() {
        return brokeringsCollection1;
    }

    public void setBrokeringsCollection1(Collection<Brokerings> brokeringsCollection1) {
        this.brokeringsCollection1 = brokeringsCollection1;
    }

    @XmlTransient
    public Collection<Refs> getRefsCollection() {
        return refsCollection;
    }

    public void setRefsCollection(Collection<Refs> refsCollection) {
        this.refsCollection = refsCollection;
    }

    @XmlTransient
    public Collection<Refs> getRefsCollection1() {
        return refsCollection1;
    }

    public void setRefsCollection1(Collection<Refs> refsCollection1) {
        this.refsCollection1 = refsCollection1;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection() {
        return adminNotificationPreferencesCollection;
    }

    public void setAdminNotificationPreferencesCollection(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection) {
        this.adminNotificationPreferencesCollection = adminNotificationPreferencesCollection;
    }

    @XmlTransient
    public Collection<PaymentObligationLogs> getPaymentObligationLogsCollection() {
        return paymentObligationLogsCollection;
    }

    public void setPaymentObligationLogsCollection(Collection<PaymentObligationLogs> paymentObligationLogsCollection) {
        this.paymentObligationLogsCollection = paymentObligationLogsCollection;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Contacts> getContactsCollection() {
        return contactsCollection;
    }

    public void setContactsCollection(Collection<Contacts> contactsCollection) {
        this.contactsCollection = contactsCollection;
    }

    @XmlTransient
    public Collection<Contacts> getContactsCollection1() {
        return contactsCollection1;
    }

    public void setContactsCollection1(Collection<Contacts> contactsCollection1) {
        this.contactsCollection1 = contactsCollection1;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection() {
        return documentsCollection;
    }

    public void setDocumentsCollection(Collection<Documents> documentsCollection) {
        this.documentsCollection = documentsCollection;
    }

    @XmlTransient
    public Collection<TransferAuthorizations> getTransferAuthorizationsCollection() {
        return transferAuthorizationsCollection;
    }

    public void setTransferAuthorizationsCollection(Collection<TransferAuthorizations> transferAuthorizationsCollection) {
        this.transferAuthorizationsCollection = transferAuthorizationsCollection;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    public Members getMemberBrokerId() {
        return memberBrokerId;
    }

    public void setMemberBrokerId(Members memberBrokerId) {
        this.memberBrokerId = memberBrokerId;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection1() {
        return membersCollection1;
    }

    public void setMembersCollection1(Collection<Members> membersCollection1) {
        this.membersCollection1 = membersCollection1;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<Guarantees> getGuaranteesCollection() {
        return guaranteesCollection;
    }

    public void setGuaranteesCollection(Collection<Guarantees> guaranteesCollection) {
        this.guaranteesCollection = guaranteesCollection;
    }

    @XmlTransient
    public Collection<Guarantees> getGuaranteesCollection1() {
        return guaranteesCollection1;
    }

    public void setGuaranteesCollection1(Collection<Guarantees> guaranteesCollection1) {
        this.guaranteesCollection1 = guaranteesCollection1;
    }

    @XmlTransient
    public Collection<Guarantees> getGuaranteesCollection2() {
        return guaranteesCollection2;
    }

    public void setGuaranteesCollection2(Collection<Guarantees> guaranteesCollection2) {
        this.guaranteesCollection2 = guaranteesCollection2;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection() {
        return customFieldsCollection;
    }

    public void setCustomFieldsCollection(Collection<CustomFields> customFieldsCollection) {
        this.customFieldsCollection = customFieldsCollection;
    }

    @XmlTransient
    public Collection<ReferenceHistory> getReferenceHistoryCollection() {
        return referenceHistoryCollection;
    }

    public void setReferenceHistoryCollection(Collection<ReferenceHistory> referenceHistoryCollection) {
        this.referenceHistoryCollection = referenceHistoryCollection;
    }

    @XmlTransient
    public Collection<ReferenceHistory> getReferenceHistoryCollection1() {
        return referenceHistoryCollection1;
    }

    public void setReferenceHistoryCollection1(Collection<ReferenceHistory> referenceHistoryCollection1) {
        this.referenceHistoryCollection1 = referenceHistoryCollection1;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<Ads> getAdsCollection() {
        return adsCollection;
    }

    public void setAdsCollection(Collection<Ads> adsCollection) {
        this.adsCollection = adsCollection;
    }

    @XmlTransient
    public Collection<GroupHistoryLogs> getGroupHistoryLogsCollection() {
        return groupHistoryLogsCollection;
    }

    public void setGroupHistoryLogsCollection(Collection<GroupHistoryLogs> groupHistoryLogsCollection) {
        this.groupHistoryLogsCollection = groupHistoryLogsCollection;
    }

    @XmlTransient
    public Collection<AdInterests> getAdInterestsCollection() {
        return adInterestsCollection;
    }

    public void setAdInterestsCollection(Collection<AdInterests> adInterestsCollection) {
        this.adInterestsCollection = adInterestsCollection;
    }

    @XmlTransient
    public Collection<AdInterests> getAdInterestsCollection1() {
        return adInterestsCollection1;
    }

    public void setAdInterestsCollection1(Collection<AdInterests> adInterestsCollection1) {
        this.adInterestsCollection1 = adInterestsCollection1;
    }

    @XmlTransient
    public Collection<PosLogs> getPosLogsCollection() {
        return posLogsCollection;
    }

    public void setPosLogsCollection(Collection<PosLogs> posLogsCollection) {
        this.posLogsCollection = posLogsCollection;
    }

    @XmlTransient
    public Collection<PosLogs> getPosLogsCollection1() {
        return posLogsCollection1;
    }

    public void setPosLogsCollection1(Collection<PosLogs> posLogsCollection1) {
        this.posLogsCollection1 = posLogsCollection1;
    }

    @XmlTransient
    public Collection<AdImports> getAdImportsCollection() {
        return adImportsCollection;
    }

    public void setAdImportsCollection(Collection<AdImports> adImportsCollection) {
        this.adImportsCollection = adImportsCollection;
    }

    @XmlTransient
    public Collection<ExternalTransferImports> getExternalTransferImportsCollection() {
        return externalTransferImportsCollection;
    }

    public void setExternalTransferImportsCollection(Collection<ExternalTransferImports> externalTransferImportsCollection) {
        this.externalTransferImportsCollection = externalTransferImportsCollection;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection1() {
        return ticketsCollection1;
    }

    public void setTicketsCollection1(Collection<Tickets> ticketsCollection1) {
        this.ticketsCollection1 = ticketsCollection1;
    }

    @XmlTransient
    public Collection<PrintSettings> getPrintSettingsCollection() {
        return printSettingsCollection;
    }

    public void setPrintSettingsCollection(Collection<PrintSettings> printSettingsCollection) {
        this.printSettingsCollection = printSettingsCollection;
    }

    @XmlTransient
    public Collection<ExternalTransfers> getExternalTransfersCollection() {
        return externalTransfersCollection;
    }

    public void setExternalTransfersCollection(Collection<ExternalTransfers> externalTransfersCollection) {
        this.externalTransfersCollection = externalTransfersCollection;
    }

    @XmlTransient
    public Collection<MemberAccountFeeLogs> getMemberAccountFeeLogsCollection() {
        return memberAccountFeeLogsCollection;
    }

    public void setMemberAccountFeeLogsCollection(Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection) {
        this.memberAccountFeeLogsCollection = memberAccountFeeLogsCollection;
    }

    @XmlTransient
    public Collection<SmsMailings> getSmsMailingsCollection1() {
        return smsMailingsCollection1;
    }

    public void setSmsMailingsCollection1(Collection<SmsMailings> smsMailingsCollection1) {
        this.smsMailingsCollection1 = smsMailingsCollection1;
    }

    @XmlTransient
    public Collection<SmsMailings> getSmsMailingsCollection2() {
        return smsMailingsCollection2;
    }

    public void setSmsMailingsCollection2(Collection<SmsMailings> smsMailingsCollection2) {
        this.smsMailingsCollection2 = smsMailingsCollection2;
    }

    @XmlTransient
    public Collection<MemberImports> getMemberImportsCollection() {
        return memberImportsCollection;
    }

    public void setMemberImportsCollection(Collection<MemberImports> memberImportsCollection) {
        this.memberImportsCollection = memberImportsCollection;
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
    public Collection<Certifications> getCertificationsCollection() {
        return certificationsCollection;
    }

    public void setCertificationsCollection(Collection<Certifications> certificationsCollection) {
        this.certificationsCollection = certificationsCollection;
    }

    @XmlTransient
    public Collection<Certifications> getCertificationsCollection1() {
        return certificationsCollection1;
    }

    public void setCertificationsCollection1(Collection<Certifications> certificationsCollection1) {
        this.certificationsCollection1 = certificationsCollection1;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection() {
        return customFieldValuesCollection;
    }

    public void setCustomFieldValuesCollection(Collection<CustomFieldValues> customFieldValuesCollection) {
        this.customFieldValuesCollection = customFieldValuesCollection;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection1() {
        return customFieldValuesCollection1;
    }

    public void setCustomFieldValuesCollection1(Collection<CustomFieldValues> customFieldValuesCollection1) {
        this.customFieldValuesCollection1 = customFieldValuesCollection1;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection2() {
        return customFieldValuesCollection2;
    }

    public void setCustomFieldValuesCollection2(Collection<CustomFieldValues> customFieldValuesCollection2) {
        this.customFieldValuesCollection2 = customFieldValuesCollection2;
    }

    @XmlTransient
    public Collection<CustomFieldValues> getCustomFieldValuesCollection3() {
        return customFieldValuesCollection3;
    }

    public void setCustomFieldValuesCollection3(Collection<CustomFieldValues> customFieldValuesCollection3) {
        this.customFieldValuesCollection3 = customFieldValuesCollection3;
    }

    @XmlTransient
    public Collection<Remarks> getRemarksCollection() {
        return remarksCollection;
    }

    public void setRemarksCollection(Collection<Remarks> remarksCollection) {
        this.remarksCollection = remarksCollection;
    }

    @XmlTransient
    public Collection<Remarks> getRemarksCollection1() {
        return remarksCollection1;
    }

    public void setRemarksCollection1(Collection<Remarks> remarksCollection1) {
        this.remarksCollection1 = remarksCollection1;
    }

    @XmlTransient
    public Collection<Remarks> getRemarksCollection2() {
        return remarksCollection2;
    }

    public void setRemarksCollection2(Collection<Remarks> remarksCollection2) {
        this.remarksCollection2 = remarksCollection2;
    }

    @XmlTransient
    public Collection<Remarks> getRemarksCollection3() {
        return remarksCollection3;
    }

    public void setRemarksCollection3(Collection<Remarks> remarksCollection3) {
        this.remarksCollection3 = remarksCollection3;
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
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Members[ id=" + id + " ]";
    }
    
}
