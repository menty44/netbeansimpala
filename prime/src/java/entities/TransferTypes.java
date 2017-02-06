/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "transfer_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransferTypes.findAll", query = "SELECT t FROM TransferTypes t"),
    @NamedQuery(name = "TransferTypes.findById", query = "SELECT t FROM TransferTypes t WHERE t.id = :id"),
    @NamedQuery(name = "TransferTypes.findByAllowedPayment", query = "SELECT t FROM TransferTypes t WHERE t.allowedPayment = :allowedPayment"),
    @NamedQuery(name = "TransferTypes.findByAllowedSelfPayment", query = "SELECT t FROM TransferTypes t WHERE t.allowedSelfPayment = :allowedSelfPayment"),
    @NamedQuery(name = "TransferTypes.findByPriority", query = "SELECT t FROM TransferTypes t WHERE t.priority = :priority"),
    @NamedQuery(name = "TransferTypes.findByConciliable", query = "SELECT t FROM TransferTypes t WHERE t.conciliable = :conciliable"),
    @NamedQuery(name = "TransferTypes.findByRequiresAuthorization", query = "SELECT t FROM TransferTypes t WHERE t.requiresAuthorization = :requiresAuthorization"),
    @NamedQuery(name = "TransferTypes.findByAllowsScheduledPayments", query = "SELECT t FROM TransferTypes t WHERE t.allowsScheduledPayments = :allowsScheduledPayments"),
    @NamedQuery(name = "TransferTypes.findByName", query = "SELECT t FROM TransferTypes t WHERE t.name = :name"),
    @NamedQuery(name = "TransferTypes.findByMaxAmountPerDay", query = "SELECT t FROM TransferTypes t WHERE t.maxAmountPerDay = :maxAmountPerDay"),
    @NamedQuery(name = "TransferTypes.findByMinAmount", query = "SELECT t FROM TransferTypes t WHERE t.minAmount = :minAmount"),
    @NamedQuery(name = "TransferTypes.findByReserveTotalOnSched", query = "SELECT t FROM TransferTypes t WHERE t.reserveTotalOnSched = :reserveTotalOnSched"),
    @NamedQuery(name = "TransferTypes.findByAllowCancelSched", query = "SELECT t FROM TransferTypes t WHERE t.allowCancelSched = :allowCancelSched"),
    @NamedQuery(name = "TransferTypes.findByAllowBlockSched", query = "SELECT t FROM TransferTypes t WHERE t.allowBlockSched = :allowBlockSched"),
    @NamedQuery(name = "TransferTypes.findByShowSchedToDest", query = "SELECT t FROM TransferTypes t WHERE t.showSchedToDest = :showSchedToDest"),
    @NamedQuery(name = "TransferTypes.findByAllowSmsNotification", query = "SELECT t FROM TransferTypes t WHERE t.allowSmsNotification = :allowSmsNotification"),
    @NamedQuery(name = "TransferTypes.findByRequiresFeedback", query = "SELECT t FROM TransferTypes t WHERE t.requiresFeedback = :requiresFeedback"),
    @NamedQuery(name = "TransferTypes.findByTransferListenerClass", query = "SELECT t FROM TransferTypes t WHERE t.transferListenerClass = :transferListenerClass"),
    @NamedQuery(name = "TransferTypes.findByFeedbackEnabledSince", query = "SELECT t FROM TransferTypes t WHERE t.feedbackEnabledSince = :feedbackEnabledSince"),
    @NamedQuery(name = "TransferTypes.findByFeedbackExpirationTimeNumber", query = "SELECT t FROM TransferTypes t WHERE t.feedbackExpirationTimeNumber = :feedbackExpirationTimeNumber"),
    @NamedQuery(name = "TransferTypes.findByFeedbackExpirationTimeField", query = "SELECT t FROM TransferTypes t WHERE t.feedbackExpirationTimeField = :feedbackExpirationTimeField"),
    @NamedQuery(name = "TransferTypes.findByFeedbackReplyExpirationTimeNumber", query = "SELECT t FROM TransferTypes t WHERE t.feedbackReplyExpirationTimeNumber = :feedbackReplyExpirationTimeNumber"),
    @NamedQuery(name = "TransferTypes.findByFeedbackReplyExpirationTimeField", query = "SELECT t FROM TransferTypes t WHERE t.feedbackReplyExpirationTimeField = :feedbackReplyExpirationTimeField"),
    @NamedQuery(name = "TransferTypes.findByDefaultFeedbackLevel", query = "SELECT t FROM TransferTypes t WHERE t.defaultFeedbackLevel = :defaultFeedbackLevel"),
    @NamedQuery(name = "TransferTypes.findByTxHierarchyVisibility", query = "SELECT t FROM TransferTypes t WHERE t.txHierarchyVisibility = :txHierarchyVisibility"),
    @NamedQuery(name = "TransferTypes.findByLoanType", query = "SELECT t FROM TransferTypes t WHERE t.loanType = :loanType"),
    @NamedQuery(name = "TransferTypes.findByLoanGrantFeeValue", query = "SELECT t FROM TransferTypes t WHERE t.loanGrantFeeValue = :loanGrantFeeValue"),
    @NamedQuery(name = "TransferTypes.findByLoanGrantFeeType", query = "SELECT t FROM TransferTypes t WHERE t.loanGrantFeeType = :loanGrantFeeType"),
    @NamedQuery(name = "TransferTypes.findByLoanMonthlyInterest", query = "SELECT t FROM TransferTypes t WHERE t.loanMonthlyInterest = :loanMonthlyInterest"),
    @NamedQuery(name = "TransferTypes.findByLoanExpirationFeeValue", query = "SELECT t FROM TransferTypes t WHERE t.loanExpirationFeeValue = :loanExpirationFeeValue"),
    @NamedQuery(name = "TransferTypes.findByLoanExpirationFeeType", query = "SELECT t FROM TransferTypes t WHERE t.loanExpirationFeeType = :loanExpirationFeeType"),
    @NamedQuery(name = "TransferTypes.findByLoanExpirationDailyInterest", query = "SELECT t FROM TransferTypes t WHERE t.loanExpirationDailyInterest = :loanExpirationDailyInterest"),
    @NamedQuery(name = "TransferTypes.findByLoanRepaymentDays", query = "SELECT t FROM TransferTypes t WHERE t.loanRepaymentDays = :loanRepaymentDays")})
public class TransferTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allowed_payment")
    private boolean allowedPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allowed_self_payment")
    private boolean allowedSelfPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priority")
    private boolean priority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conciliable")
    private boolean conciliable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requires_authorization")
    private boolean requiresAuthorization;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allows_scheduled_payments")
    private boolean allowsScheduledPayments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "confirmation_message")
    private String confirmationMessage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "max_amount_per_day")
    private BigDecimal maxAmountPerDay;
    @Column(name = "min_amount")
    private BigDecimal minAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reserve_total_on_sched")
    private boolean reserveTotalOnSched;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow_cancel_sched")
    private boolean allowCancelSched;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow_block_sched")
    private boolean allowBlockSched;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_sched_to_dest")
    private boolean showSchedToDest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow_sms_notification")
    private boolean allowSmsNotification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requires_feedback")
    private boolean requiresFeedback;
    @Size(max = 200)
    @Column(name = "transfer_listener_class")
    private String transferListenerClass;
    @Column(name = "feedback_enabled_since")
    @Temporal(TemporalType.DATE)
    private Date feedbackEnabledSince;
    @Column(name = "feedback_expiration_time_number")
    private Integer feedbackExpirationTimeNumber;
    @Column(name = "feedback_expiration_time_field")
    private Integer feedbackExpirationTimeField;
    @Column(name = "feedback_reply_expiration_time_number")
    private Integer feedbackReplyExpirationTimeNumber;
    @Column(name = "feedback_reply_expiration_time_field")
    private Integer feedbackReplyExpirationTimeField;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "default_feedback_comments")
    private String defaultFeedbackComments;
    @Column(name = "default_feedback_level")
    private Short defaultFeedbackLevel;
    @Size(max = 1)
    @Column(name = "tx_hierarchy_visibility")
    private String txHierarchyVisibility;
    @Size(max = 1)
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "loan_grant_fee_value")
    private BigDecimal loanGrantFeeValue;
    @Column(name = "loan_grant_fee_type")
    private Character loanGrantFeeType;
    @Column(name = "loan_monthly_interest")
    private BigDecimal loanMonthlyInterest;
    @Column(name = "loan_expiration_fee_value")
    private BigDecimal loanExpirationFeeValue;
    @Column(name = "loan_expiration_fee_type")
    private Character loanExpirationFeeType;
    @Column(name = "loan_expiration_daily_interest")
    private BigDecimal loanExpirationDailyInterest;
    @Column(name = "loan_repayment_days")
    private Integer loanRepaymentDays;
    @ManyToMany(mappedBy = "transferTypesCollection")
    private Collection<Groups> groupsCollection;
    @JoinTable(name = "service_clients_chargeback_payment_types", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_client_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ServiceClients> serviceClientsCollection;
    @ManyToMany(mappedBy = "transferTypesCollection")
    private Collection<Channels> channelsCollection;
    @ManyToMany(mappedBy = "transferTypesCollection1")
    private Collection<Groups> groupsCollection1;
    @JoinTable(name = "admin_preferences_new_pending_payments", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "preference_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection;
    @JoinTable(name = "admin_preferences_transfer_types", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "preference_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection1;
    @JoinTable(name = "service_clients_receive_payment_types", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_client_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ServiceClients> serviceClientsCollection1;
    @ManyToMany(mappedBy = "transferTypesCollection2")
    private Collection<Groups> groupsCollection2;
    @JoinTable(name = "transfer_types_payment_filters", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "payment_filter_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<PaymentFilters> paymentFiltersCollection;
    @ManyToMany(mappedBy = "transferTypesCollection3")
    private Collection<Groups> groupsCollection3;
    @JoinTable(name = "service_clients_do_payment_types", joinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_client_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ServiceClients> serviceClientsCollection2;
    @ManyToMany(mappedBy = "transferTypesCollection")
    private Collection<CustomFields> customFieldsCollection;
    @OneToMany(mappedBy = "creditFeeTransferTypeId")
    private Collection<GuaranteeTypes> guaranteeTypesCollection;
    @OneToMany(mappedBy = "issueFeeTransferTypeId")
    private Collection<GuaranteeTypes> guaranteeTypesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanTransferTypeId")
    private Collection<GuaranteeTypes> guaranteeTypesCollection2;
    @OneToMany(mappedBy = "forwardTransferTypeId")
    private Collection<GuaranteeTypes> guaranteeTypesCollection3;
    @OneToMany(mappedBy = "transferTypeId")
    private Collection<Invoices> invoicesCollection;
    @OneToMany(mappedBy = "transferTypeId")
    private Collection<ExternalTransferTypes> externalTransferTypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generatedTypeId")
    private Collection<TransactionFees> transactionFeesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originalTypeId")
    private Collection<TransactionFees> transactionFeesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<ScheduledPayments> scheduledPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<Transfers> transfersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<AuthorizationLevels> authorizationLevelsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferTypeId")
    private Collection<AccountFees> accountFeesCollection;
    @OneToMany(mappedBy = "initialCreditTransferTypeId")
    private Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection;
    @OneToMany(mappedBy = "transferTypeId")
    private Collection<CustomFields> customFieldsCollection1;
    @OneToMany(mappedBy = "transferTypeId")
    private Collection<Tickets> ticketsCollection;
    @OneToMany(mappedBy = "initialCreditTransferTypeId")
    private Collection<MemberImports> memberImportsCollection;
    @OneToMany(mappedBy = "initialDebitTransferTypeId")
    private Collection<MemberImports> memberImportsCollection1;
    @OneToMany(mappedBy = "loanRepaymentTypeId")
    private Collection<TransferTypes> transferTypesCollection;
    @JoinColumn(name = "loan_repayment_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes loanRepaymentTypeId;
    @OneToMany(mappedBy = "loanExpirationFeeTypeId")
    private Collection<TransferTypes> transferTypesCollection1;
    @JoinColumn(name = "loan_expiration_fee_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes loanExpirationFeeTypeId;
    @JoinColumn(name = "from_account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes fromAccountTypeId;
    @JoinColumn(name = "to_account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountTypes toAccountTypeId;
    @OneToMany(mappedBy = "loanGrantFeeTypeId")
    private Collection<TransferTypes> transferTypesCollection2;
    @JoinColumn(name = "loan_grant_fee_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes loanGrantFeeTypeId;
    @OneToMany(mappedBy = "loanExpDailyInterestTypeId")
    private Collection<TransferTypes> transferTypesCollection3;
    @JoinColumn(name = "loan_exp_daily_interest_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes loanExpDailyInterestTypeId;
    @JoinColumn(name = "fixed_destination_member_id", referencedColumnName = "id")
    @ManyToOne
    private Members fixedDestinationMemberId;
    @OneToMany(mappedBy = "loanMonthlyInterestTypeId")
    private Collection<TransferTypes> transferTypesCollection4;
    @JoinColumn(name = "loan_monthly_interest_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes loanMonthlyInterestTypeId;
    @OneToMany(mappedBy = "smsChargeTransferTypeId")
    private Collection<Groups> groupsCollection4;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferTypes")
    private Collection<OperatorGroupsMaxAmount> operatorGroupsMaxAmountCollection;

    public TransferTypes() {
    }

    public TransferTypes(Integer id) {
        this.id = id;
    }

    public TransferTypes(Integer id, boolean allowedPayment, boolean allowedSelfPayment, boolean priority, boolean conciliable, boolean requiresAuthorization, boolean allowsScheduledPayments, String name, String description, boolean reserveTotalOnSched, boolean allowCancelSched, boolean allowBlockSched, boolean showSchedToDest, boolean allowSmsNotification, boolean requiresFeedback) {
        this.id = id;
        this.allowedPayment = allowedPayment;
        this.allowedSelfPayment = allowedSelfPayment;
        this.priority = priority;
        this.conciliable = conciliable;
        this.requiresAuthorization = requiresAuthorization;
        this.allowsScheduledPayments = allowsScheduledPayments;
        this.name = name;
        this.description = description;
        this.reserveTotalOnSched = reserveTotalOnSched;
        this.allowCancelSched = allowCancelSched;
        this.allowBlockSched = allowBlockSched;
        this.showSchedToDest = showSchedToDest;
        this.allowSmsNotification = allowSmsNotification;
        this.requiresFeedback = requiresFeedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAllowedPayment() {
        return allowedPayment;
    }

    public void setAllowedPayment(boolean allowedPayment) {
        this.allowedPayment = allowedPayment;
    }

    public boolean getAllowedSelfPayment() {
        return allowedSelfPayment;
    }

    public void setAllowedSelfPayment(boolean allowedSelfPayment) {
        this.allowedSelfPayment = allowedSelfPayment;
    }

    public boolean getPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean getConciliable() {
        return conciliable;
    }

    public void setConciliable(boolean conciliable) {
        this.conciliable = conciliable;
    }

    public boolean getRequiresAuthorization() {
        return requiresAuthorization;
    }

    public void setRequiresAuthorization(boolean requiresAuthorization) {
        this.requiresAuthorization = requiresAuthorization;
    }

    public boolean getAllowsScheduledPayments() {
        return allowsScheduledPayments;
    }

    public void setAllowsScheduledPayments(boolean allowsScheduledPayments) {
        this.allowsScheduledPayments = allowsScheduledPayments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    public void setConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    public BigDecimal getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(BigDecimal maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public boolean getReserveTotalOnSched() {
        return reserveTotalOnSched;
    }

    public void setReserveTotalOnSched(boolean reserveTotalOnSched) {
        this.reserveTotalOnSched = reserveTotalOnSched;
    }

    public boolean getAllowCancelSched() {
        return allowCancelSched;
    }

    public void setAllowCancelSched(boolean allowCancelSched) {
        this.allowCancelSched = allowCancelSched;
    }

    public boolean getAllowBlockSched() {
        return allowBlockSched;
    }

    public void setAllowBlockSched(boolean allowBlockSched) {
        this.allowBlockSched = allowBlockSched;
    }

    public boolean getShowSchedToDest() {
        return showSchedToDest;
    }

    public void setShowSchedToDest(boolean showSchedToDest) {
        this.showSchedToDest = showSchedToDest;
    }

    public boolean getAllowSmsNotification() {
        return allowSmsNotification;
    }

    public void setAllowSmsNotification(boolean allowSmsNotification) {
        this.allowSmsNotification = allowSmsNotification;
    }

    public boolean getRequiresFeedback() {
        return requiresFeedback;
    }

    public void setRequiresFeedback(boolean requiresFeedback) {
        this.requiresFeedback = requiresFeedback;
    }

    public String getTransferListenerClass() {
        return transferListenerClass;
    }

    public void setTransferListenerClass(String transferListenerClass) {
        this.transferListenerClass = transferListenerClass;
    }

    public Date getFeedbackEnabledSince() {
        return feedbackEnabledSince;
    }

    public void setFeedbackEnabledSince(Date feedbackEnabledSince) {
        this.feedbackEnabledSince = feedbackEnabledSince;
    }

    public Integer getFeedbackExpirationTimeNumber() {
        return feedbackExpirationTimeNumber;
    }

    public void setFeedbackExpirationTimeNumber(Integer feedbackExpirationTimeNumber) {
        this.feedbackExpirationTimeNumber = feedbackExpirationTimeNumber;
    }

    public Integer getFeedbackExpirationTimeField() {
        return feedbackExpirationTimeField;
    }

    public void setFeedbackExpirationTimeField(Integer feedbackExpirationTimeField) {
        this.feedbackExpirationTimeField = feedbackExpirationTimeField;
    }

    public Integer getFeedbackReplyExpirationTimeNumber() {
        return feedbackReplyExpirationTimeNumber;
    }

    public void setFeedbackReplyExpirationTimeNumber(Integer feedbackReplyExpirationTimeNumber) {
        this.feedbackReplyExpirationTimeNumber = feedbackReplyExpirationTimeNumber;
    }

    public Integer getFeedbackReplyExpirationTimeField() {
        return feedbackReplyExpirationTimeField;
    }

    public void setFeedbackReplyExpirationTimeField(Integer feedbackReplyExpirationTimeField) {
        this.feedbackReplyExpirationTimeField = feedbackReplyExpirationTimeField;
    }

    public String getDefaultFeedbackComments() {
        return defaultFeedbackComments;
    }

    public void setDefaultFeedbackComments(String defaultFeedbackComments) {
        this.defaultFeedbackComments = defaultFeedbackComments;
    }

    public Short getDefaultFeedbackLevel() {
        return defaultFeedbackLevel;
    }

    public void setDefaultFeedbackLevel(Short defaultFeedbackLevel) {
        this.defaultFeedbackLevel = defaultFeedbackLevel;
    }

    public String getTxHierarchyVisibility() {
        return txHierarchyVisibility;
    }

    public void setTxHierarchyVisibility(String txHierarchyVisibility) {
        this.txHierarchyVisibility = txHierarchyVisibility;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanGrantFeeValue() {
        return loanGrantFeeValue;
    }

    public void setLoanGrantFeeValue(BigDecimal loanGrantFeeValue) {
        this.loanGrantFeeValue = loanGrantFeeValue;
    }

    public Character getLoanGrantFeeType() {
        return loanGrantFeeType;
    }

    public void setLoanGrantFeeType(Character loanGrantFeeType) {
        this.loanGrantFeeType = loanGrantFeeType;
    }

    public BigDecimal getLoanMonthlyInterest() {
        return loanMonthlyInterest;
    }

    public void setLoanMonthlyInterest(BigDecimal loanMonthlyInterest) {
        this.loanMonthlyInterest = loanMonthlyInterest;
    }

    public BigDecimal getLoanExpirationFeeValue() {
        return loanExpirationFeeValue;
    }

    public void setLoanExpirationFeeValue(BigDecimal loanExpirationFeeValue) {
        this.loanExpirationFeeValue = loanExpirationFeeValue;
    }

    public Character getLoanExpirationFeeType() {
        return loanExpirationFeeType;
    }

    public void setLoanExpirationFeeType(Character loanExpirationFeeType) {
        this.loanExpirationFeeType = loanExpirationFeeType;
    }

    public BigDecimal getLoanExpirationDailyInterest() {
        return loanExpirationDailyInterest;
    }

    public void setLoanExpirationDailyInterest(BigDecimal loanExpirationDailyInterest) {
        this.loanExpirationDailyInterest = loanExpirationDailyInterest;
    }

    public Integer getLoanRepaymentDays() {
        return loanRepaymentDays;
    }

    public void setLoanRepaymentDays(Integer loanRepaymentDays) {
        this.loanRepaymentDays = loanRepaymentDays;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection() {
        return serviceClientsCollection;
    }

    public void setServiceClientsCollection(Collection<ServiceClients> serviceClientsCollection) {
        this.serviceClientsCollection = serviceClientsCollection;
    }

    @XmlTransient
    public Collection<Channels> getChannelsCollection() {
        return channelsCollection;
    }

    public void setChannelsCollection(Collection<Channels> channelsCollection) {
        this.channelsCollection = channelsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection1() {
        return groupsCollection1;
    }

    public void setGroupsCollection1(Collection<Groups> groupsCollection1) {
        this.groupsCollection1 = groupsCollection1;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection() {
        return adminNotificationPreferencesCollection;
    }

    public void setAdminNotificationPreferencesCollection(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection) {
        this.adminNotificationPreferencesCollection = adminNotificationPreferencesCollection;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection1() {
        return adminNotificationPreferencesCollection1;
    }

    public void setAdminNotificationPreferencesCollection1(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection1) {
        this.adminNotificationPreferencesCollection1 = adminNotificationPreferencesCollection1;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection1() {
        return serviceClientsCollection1;
    }

    public void setServiceClientsCollection1(Collection<ServiceClients> serviceClientsCollection1) {
        this.serviceClientsCollection1 = serviceClientsCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<PaymentFilters> getPaymentFiltersCollection() {
        return paymentFiltersCollection;
    }

    public void setPaymentFiltersCollection(Collection<PaymentFilters> paymentFiltersCollection) {
        this.paymentFiltersCollection = paymentFiltersCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection3() {
        return groupsCollection3;
    }

    public void setGroupsCollection3(Collection<Groups> groupsCollection3) {
        this.groupsCollection3 = groupsCollection3;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection2() {
        return serviceClientsCollection2;
    }

    public void setServiceClientsCollection2(Collection<ServiceClients> serviceClientsCollection2) {
        this.serviceClientsCollection2 = serviceClientsCollection2;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection() {
        return customFieldsCollection;
    }

    public void setCustomFieldsCollection(Collection<CustomFields> customFieldsCollection) {
        this.customFieldsCollection = customFieldsCollection;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection() {
        return guaranteeTypesCollection;
    }

    public void setGuaranteeTypesCollection(Collection<GuaranteeTypes> guaranteeTypesCollection) {
        this.guaranteeTypesCollection = guaranteeTypesCollection;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection1() {
        return guaranteeTypesCollection1;
    }

    public void setGuaranteeTypesCollection1(Collection<GuaranteeTypes> guaranteeTypesCollection1) {
        this.guaranteeTypesCollection1 = guaranteeTypesCollection1;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection2() {
        return guaranteeTypesCollection2;
    }

    public void setGuaranteeTypesCollection2(Collection<GuaranteeTypes> guaranteeTypesCollection2) {
        this.guaranteeTypesCollection2 = guaranteeTypesCollection2;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection3() {
        return guaranteeTypesCollection3;
    }

    public void setGuaranteeTypesCollection3(Collection<GuaranteeTypes> guaranteeTypesCollection3) {
        this.guaranteeTypesCollection3 = guaranteeTypesCollection3;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @XmlTransient
    public Collection<ExternalTransferTypes> getExternalTransferTypesCollection() {
        return externalTransferTypesCollection;
    }

    public void setExternalTransferTypesCollection(Collection<ExternalTransferTypes> externalTransferTypesCollection) {
        this.externalTransferTypesCollection = externalTransferTypesCollection;
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
    public Collection<ScheduledPayments> getScheduledPaymentsCollection() {
        return scheduledPaymentsCollection;
    }

    public void setScheduledPaymentsCollection(Collection<ScheduledPayments> scheduledPaymentsCollection) {
        this.scheduledPaymentsCollection = scheduledPaymentsCollection;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    @XmlTransient
    public Collection<AuthorizationLevels> getAuthorizationLevelsCollection() {
        return authorizationLevelsCollection;
    }

    public void setAuthorizationLevelsCollection(Collection<AuthorizationLevels> authorizationLevelsCollection) {
        this.authorizationLevelsCollection = authorizationLevelsCollection;
    }

    @XmlTransient
    public Collection<AccountFees> getAccountFeesCollection() {
        return accountFeesCollection;
    }

    public void setAccountFeesCollection(Collection<AccountFees> accountFeesCollection) {
        this.accountFeesCollection = accountFeesCollection;
    }

    @XmlTransient
    public Collection<MemberGroupAccountSettings> getMemberGroupAccountSettingsCollection() {
        return memberGroupAccountSettingsCollection;
    }

    public void setMemberGroupAccountSettingsCollection(Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection) {
        this.memberGroupAccountSettingsCollection = memberGroupAccountSettingsCollection;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection1() {
        return customFieldsCollection1;
    }

    public void setCustomFieldsCollection1(Collection<CustomFields> customFieldsCollection1) {
        this.customFieldsCollection1 = customFieldsCollection1;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    @XmlTransient
    public Collection<MemberImports> getMemberImportsCollection() {
        return memberImportsCollection;
    }

    public void setMemberImportsCollection(Collection<MemberImports> memberImportsCollection) {
        this.memberImportsCollection = memberImportsCollection;
    }

    @XmlTransient
    public Collection<MemberImports> getMemberImportsCollection1() {
        return memberImportsCollection1;
    }

    public void setMemberImportsCollection1(Collection<MemberImports> memberImportsCollection1) {
        this.memberImportsCollection1 = memberImportsCollection1;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
    }

    public TransferTypes getLoanRepaymentTypeId() {
        return loanRepaymentTypeId;
    }

    public void setLoanRepaymentTypeId(TransferTypes loanRepaymentTypeId) {
        this.loanRepaymentTypeId = loanRepaymentTypeId;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection1() {
        return transferTypesCollection1;
    }

    public void setTransferTypesCollection1(Collection<TransferTypes> transferTypesCollection1) {
        this.transferTypesCollection1 = transferTypesCollection1;
    }

    public TransferTypes getLoanExpirationFeeTypeId() {
        return loanExpirationFeeTypeId;
    }

    public void setLoanExpirationFeeTypeId(TransferTypes loanExpirationFeeTypeId) {
        this.loanExpirationFeeTypeId = loanExpirationFeeTypeId;
    }

    public AccountTypes getFromAccountTypeId() {
        return fromAccountTypeId;
    }

    public void setFromAccountTypeId(AccountTypes fromAccountTypeId) {
        this.fromAccountTypeId = fromAccountTypeId;
    }

    public AccountTypes getToAccountTypeId() {
        return toAccountTypeId;
    }

    public void setToAccountTypeId(AccountTypes toAccountTypeId) {
        this.toAccountTypeId = toAccountTypeId;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection2() {
        return transferTypesCollection2;
    }

    public void setTransferTypesCollection2(Collection<TransferTypes> transferTypesCollection2) {
        this.transferTypesCollection2 = transferTypesCollection2;
    }

    public TransferTypes getLoanGrantFeeTypeId() {
        return loanGrantFeeTypeId;
    }

    public void setLoanGrantFeeTypeId(TransferTypes loanGrantFeeTypeId) {
        this.loanGrantFeeTypeId = loanGrantFeeTypeId;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection3() {
        return transferTypesCollection3;
    }

    public void setTransferTypesCollection3(Collection<TransferTypes> transferTypesCollection3) {
        this.transferTypesCollection3 = transferTypesCollection3;
    }

    public TransferTypes getLoanExpDailyInterestTypeId() {
        return loanExpDailyInterestTypeId;
    }

    public void setLoanExpDailyInterestTypeId(TransferTypes loanExpDailyInterestTypeId) {
        this.loanExpDailyInterestTypeId = loanExpDailyInterestTypeId;
    }

    public Members getFixedDestinationMemberId() {
        return fixedDestinationMemberId;
    }

    public void setFixedDestinationMemberId(Members fixedDestinationMemberId) {
        this.fixedDestinationMemberId = fixedDestinationMemberId;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection4() {
        return transferTypesCollection4;
    }

    public void setTransferTypesCollection4(Collection<TransferTypes> transferTypesCollection4) {
        this.transferTypesCollection4 = transferTypesCollection4;
    }

    public TransferTypes getLoanMonthlyInterestTypeId() {
        return loanMonthlyInterestTypeId;
    }

    public void setLoanMonthlyInterestTypeId(TransferTypes loanMonthlyInterestTypeId) {
        this.loanMonthlyInterestTypeId = loanMonthlyInterestTypeId;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection4() {
        return groupsCollection4;
    }

    public void setGroupsCollection4(Collection<Groups> groupsCollection4) {
        this.groupsCollection4 = groupsCollection4;
    }

    @XmlTransient
    public Collection<OperatorGroupsMaxAmount> getOperatorGroupsMaxAmountCollection() {
        return operatorGroupsMaxAmountCollection;
    }

    public void setOperatorGroupsMaxAmountCollection(Collection<OperatorGroupsMaxAmount> operatorGroupsMaxAmountCollection) {
        this.operatorGroupsMaxAmountCollection = operatorGroupsMaxAmountCollection;
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
        if (!(object instanceof TransferTypes)) {
            return false;
        }
        TransferTypes other = (TransferTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransferTypes[ id=" + id + " ]";
    }
    
}
