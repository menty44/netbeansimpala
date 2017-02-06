/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id = :id"),
    @NamedQuery(name = "Groups.findBySubclass", query = "SELECT g FROM Groups g WHERE g.subclass = :subclass"),
    @NamedQuery(name = "Groups.findByStatus", query = "SELECT g FROM Groups g WHERE g.status = :status"),
    @NamedQuery(name = "Groups.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name"),
    @NamedQuery(name = "Groups.findByMaxPasswordTries", query = "SELECT g FROM Groups g WHERE g.maxPasswordTries = :maxPasswordTries"),
    @NamedQuery(name = "Groups.findByMinPasswordLength", query = "SELECT g FROM Groups g WHERE g.minPasswordLength = :minPasswordLength"),
    @NamedQuery(name = "Groups.findByMaxPasswordLength", query = "SELECT g FROM Groups g WHERE g.maxPasswordLength = :maxPasswordLength"),
    @NamedQuery(name = "Groups.findByPasswordPolicy", query = "SELECT g FROM Groups g WHERE g.passwordPolicy = :passwordPolicy"),
    @NamedQuery(name = "Groups.findByDeactivationNumber", query = "SELECT g FROM Groups g WHERE g.deactivationNumber = :deactivationNumber"),
    @NamedQuery(name = "Groups.findByDeactivationField", query = "SELECT g FROM Groups g WHERE g.deactivationField = :deactivationField"),
    @NamedQuery(name = "Groups.findByPasswordExpirationNumber", query = "SELECT g FROM Groups g WHERE g.passwordExpirationNumber = :passwordExpirationNumber"),
    @NamedQuery(name = "Groups.findByPasswordExpirationField", query = "SELECT g FROM Groups g WHERE g.passwordExpirationField = :passwordExpirationField"),
    @NamedQuery(name = "Groups.findByTransactionPassword", query = "SELECT g FROM Groups g WHERE g.transactionPassword = :transactionPassword"),
    @NamedQuery(name = "Groups.findByTransactionPasswordLength", query = "SELECT g FROM Groups g WHERE g.transactionPasswordLength = :transactionPasswordLength"),
    @NamedQuery(name = "Groups.findByMaxTpTries", query = "SELECT g FROM Groups g WHERE g.maxTpTries = :maxTpTries"),
    @NamedQuery(name = "Groups.findByHideCurrencyOnPmt", query = "SELECT g FROM Groups g WHERE g.hideCurrencyOnPmt = :hideCurrencyOnPmt"),
    @NamedQuery(name = "Groups.findByRootUrl", query = "SELECT g FROM Groups g WHERE g.rootUrl = :rootUrl"),
    @NamedQuery(name = "Groups.findByLoginPageName", query = "SELECT g FROM Groups g WHERE g.loginPageName = :loginPageName"),
    @NamedQuery(name = "Groups.findByContainerUrl", query = "SELECT g FROM Groups g WHERE g.containerUrl = :containerUrl"),
    @NamedQuery(name = "Groups.findBySmsChargeAmount", query = "SELECT g FROM Groups g WHERE g.smsChargeAmount = :smsChargeAmount"),
    @NamedQuery(name = "Groups.findBySmsFreeCount", query = "SELECT g FROM Groups g WHERE g.smsFreeCount = :smsFreeCount"),
    @NamedQuery(name = "Groups.findBySmsAdditionalChargedCount", query = "SELECT g FROM Groups g WHERE g.smsAdditionalChargedCount = :smsAdditionalChargedCount"),
    @NamedQuery(name = "Groups.findBySmsAdditionalChargedPeriodNumber", query = "SELECT g FROM Groups g WHERE g.smsAdditionalChargedPeriodNumber = :smsAdditionalChargedPeriodNumber"),
    @NamedQuery(name = "Groups.findBySmsAdditionalChargedPeriodField", query = "SELECT g FROM Groups g WHERE g.smsAdditionalChargedPeriodField = :smsAdditionalChargedPeriodField"),
    @NamedQuery(name = "Groups.findBySmsShowFreeThreshold", query = "SELECT g FROM Groups g WHERE g.smsShowFreeThreshold = :smsShowFreeThreshold"),
    @NamedQuery(name = "Groups.findBySmsContextClassName", query = "SELECT g FROM Groups g WHERE g.smsContextClassName = :smsContextClassName"),
    @NamedQuery(name = "Groups.findByMemberMaxImagesPerMember", query = "SELECT g FROM Groups g WHERE g.memberMaxImagesPerMember = :memberMaxImagesPerMember"),
    @NamedQuery(name = "Groups.findByMemberMaxAdsPerMember", query = "SELECT g FROM Groups g WHERE g.memberMaxAdsPerMember = :memberMaxAdsPerMember"),
    @NamedQuery(name = "Groups.findByMemberMaxAdDescriptionSize", query = "SELECT g FROM Groups g WHERE g.memberMaxAdDescriptionSize = :memberMaxAdDescriptionSize"),
    @NamedQuery(name = "Groups.findByMemberMaxAdImagesPerMember", query = "SELECT g FROM Groups g WHERE g.memberMaxAdImagesPerMember = :memberMaxAdImagesPerMember"),
    @NamedQuery(name = "Groups.findByMemberDefaultAdPublicationNumber", query = "SELECT g FROM Groups g WHERE g.memberDefaultAdPublicationNumber = :memberDefaultAdPublicationNumber"),
    @NamedQuery(name = "Groups.findByMemberDefaultAdPublicationField", query = "SELECT g FROM Groups g WHERE g.memberDefaultAdPublicationField = :memberDefaultAdPublicationField"),
    @NamedQuery(name = "Groups.findByMemberMaxAdPublicationNumber", query = "SELECT g FROM Groups g WHERE g.memberMaxAdPublicationNumber = :memberMaxAdPublicationNumber"),
    @NamedQuery(name = "Groups.findByMemberMaxAdPublicationField", query = "SELECT g FROM Groups g WHERE g.memberMaxAdPublicationField = :memberMaxAdPublicationField"),
    @NamedQuery(name = "Groups.findByMemberEnablePermanentAds", query = "SELECT g FROM Groups g WHERE g.memberEnablePermanentAds = :memberEnablePermanentAds"),
    @NamedQuery(name = "Groups.findByMemberShowPoswebPmtDsc", query = "SELECT g FROM Groups g WHERE g.memberShowPoswebPmtDsc = :memberShowPoswebPmtDsc"),
    @NamedQuery(name = "Groups.findByMemberExternalAdPublication", query = "SELECT g FROM Groups g WHERE g.memberExternalAdPublication = :memberExternalAdPublication"),
    @NamedQuery(name = "Groups.findByMemberSendPasswordByEmail", query = "SELECT g FROM Groups g WHERE g.memberSendPasswordByEmail = :memberSendPasswordByEmail"),
    @NamedQuery(name = "Groups.findByMemberViewLoansByGroup", query = "SELECT g FROM Groups g WHERE g.memberViewLoansByGroup = :memberViewLoansByGroup"),
    @NamedQuery(name = "Groups.findByMemberRepayLoanByGroup", query = "SELECT g FROM Groups g WHERE g.memberRepayLoanByGroup = :memberRepayLoanByGroup"),
    @NamedQuery(name = "Groups.findByMemberMaxSchedulingPayments", query = "SELECT g FROM Groups g WHERE g.memberMaxSchedulingPayments = :memberMaxSchedulingPayments"),
    @NamedQuery(name = "Groups.findByMemberMaxSchedulingPeriodNumber", query = "SELECT g FROM Groups g WHERE g.memberMaxSchedulingPeriodNumber = :memberMaxSchedulingPeriodNumber"),
    @NamedQuery(name = "Groups.findByMemberMaxSchedulingPeriodField", query = "SELECT g FROM Groups g WHERE g.memberMaxSchedulingPeriodField = :memberMaxSchedulingPeriodField"),
    @NamedQuery(name = "Groups.findByMinPinLength", query = "SELECT g FROM Groups g WHERE g.minPinLength = :minPinLength"),
    @NamedQuery(name = "Groups.findByMaxPinLength", query = "SELECT g FROM Groups g WHERE g.maxPinLength = :maxPinLength"),
    @NamedQuery(name = "Groups.findByMemberMaxPinTries", query = "SELECT g FROM Groups g WHERE g.memberMaxPinTries = :memberMaxPinTries"),
    @NamedQuery(name = "Groups.findByMemberPinBlockNumber", query = "SELECT g FROM Groups g WHERE g.memberPinBlockNumber = :memberPinBlockNumber"),
    @NamedQuery(name = "Groups.findByMemberPinBlockField", query = "SELECT g FROM Groups g WHERE g.memberPinBlockField = :memberPinBlockField"),
    @NamedQuery(name = "Groups.findByMemberExpireNumber", query = "SELECT g FROM Groups g WHERE g.memberExpireNumber = :memberExpireNumber"),
    @NamedQuery(name = "Groups.findByMemberExpireField", query = "SELECT g FROM Groups g WHERE g.memberExpireField = :memberExpireField"),
    @NamedQuery(name = "Groups.findByMemberMaxPosSchedulingPayments", query = "SELECT g FROM Groups g WHERE g.memberMaxPosSchedulingPayments = :memberMaxPosSchedulingPayments"),
    @NamedQuery(name = "Groups.findByMemberNumberOfCopies", query = "SELECT g FROM Groups g WHERE g.memberNumberOfCopies = :memberNumberOfCopies"),
    @NamedQuery(name = "Groups.findByMemberResultPageSize", query = "SELECT g FROM Groups g WHERE g.memberResultPageSize = :memberResultPageSize"),
    @NamedQuery(name = "Groups.findByMemberAllowMakePayment", query = "SELECT g FROM Groups g WHERE g.memberAllowMakePayment = :memberAllowMakePayment"),
    @NamedQuery(name = "Groups.findByMemberActive", query = "SELECT g FROM Groups g WHERE g.memberActive = :memberActive"),
    @NamedQuery(name = "Groups.findByInitialGroupShow", query = "SELECT g FROM Groups g WHERE g.initialGroupShow = :initialGroupShow"),
    @NamedQuery(name = "Groups.findByInitialGroup", query = "SELECT g FROM Groups g WHERE g.initialGroup = :initialGroup"),
    @NamedQuery(name = "Groups.findByMemberDefaultAllowChargingSms", query = "SELECT g FROM Groups g WHERE g.memberDefaultAllowChargingSms = :memberDefaultAllowChargingSms"),
    @NamedQuery(name = "Groups.findByMemberDefaultAcceptFreeMailing", query = "SELECT g FROM Groups g WHERE g.memberDefaultAcceptFreeMailing = :memberDefaultAcceptFreeMailing"),
    @NamedQuery(name = "Groups.findByMemberDefaultAcceptPaidMailing", query = "SELECT g FROM Groups g WHERE g.memberDefaultAcceptPaidMailing = :memberDefaultAcceptPaidMailing")})
public class Groups implements Serializable {

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
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "max_password_tries")
    private Integer maxPasswordTries;
    @Column(name = "min_password_length")
    private Integer minPasswordLength;
    @Column(name = "max_password_length")
    private Integer maxPasswordLength;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "password_policy")
    private String passwordPolicy;
    @Column(name = "deactivation_number")
    private Integer deactivationNumber;
    @Column(name = "deactivation_field")
    private Integer deactivationField;
    @Column(name = "password_expiration_number")
    private Integer passwordExpirationNumber;
    @Column(name = "password_expiration_field")
    private Integer passwordExpirationField;
    @Size(max = 1)
    @Column(name = "transaction_password")
    private String transactionPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_password_length")
    private int transactionPasswordLength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_tp_tries")
    private int maxTpTries;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hide_currency_on_pmt")
    private boolean hideCurrencyOnPmt;
    @Size(max = 100)
    @Column(name = "root_url")
    private String rootUrl;
    @Size(max = 20)
    @Column(name = "login_page_name")
    private String loginPageName;
    @Size(max = 100)
    @Column(name = "container_url")
    private String containerUrl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sms_charge_amount")
    private BigDecimal smsChargeAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sms_free_count")
    private int smsFreeCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sms_additional_charged_count")
    private int smsAdditionalChargedCount;
    @Column(name = "sms_additional_charged_period_number")
    private Integer smsAdditionalChargedPeriodNumber;
    @Column(name = "sms_additional_charged_period_field")
    private Integer smsAdditionalChargedPeriodField;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sms_show_free_threshold")
    private int smsShowFreeThreshold;
    @Size(max = 255)
    @Column(name = "sms_context_class_name")
    private String smsContextClassName;
    @Column(name = "member_max_images_per_member")
    private Integer memberMaxImagesPerMember;
    @Column(name = "member_max_ads_per_member")
    private Integer memberMaxAdsPerMember;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_max_ad_description_size")
    private int memberMaxAdDescriptionSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_max_ad_images_per_member")
    private int memberMaxAdImagesPerMember;
    @Column(name = "member_default_ad_publication_number")
    private Integer memberDefaultAdPublicationNumber;
    @Column(name = "member_default_ad_publication_field")
    private Integer memberDefaultAdPublicationField;
    @Column(name = "member_max_ad_publication_number")
    private Integer memberMaxAdPublicationNumber;
    @Column(name = "member_max_ad_publication_field")
    private Integer memberMaxAdPublicationField;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_enable_permanent_ads")
    private boolean memberEnablePermanentAds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_show_posweb_pmt_dsc")
    private boolean memberShowPoswebPmtDsc;
    @Size(max = 1)
    @Column(name = "member_external_ad_publication")
    private String memberExternalAdPublication;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_send_password_by_email")
    private boolean memberSendPasswordByEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_view_loans_by_group")
    private boolean memberViewLoansByGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_repay_loan_by_group")
    private boolean memberRepayLoanByGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_max_scheduling_payments")
    private int memberMaxSchedulingPayments;
    @Column(name = "member_max_scheduling_period_number")
    private Integer memberMaxSchedulingPeriodNumber;
    @Column(name = "member_max_scheduling_period_field")
    private Integer memberMaxSchedulingPeriodField;
    @Column(name = "min_pin_length")
    private Integer minPinLength;
    @Column(name = "max_pin_length")
    private Integer maxPinLength;
    @Column(name = "member_max_pin_tries")
    private Integer memberMaxPinTries;
    @Column(name = "member_pin_block_number")
    private Integer memberPinBlockNumber;
    @Column(name = "member_pin_block_field")
    private Integer memberPinBlockField;
    @Column(name = "member_expire_number")
    private Integer memberExpireNumber;
    @Column(name = "member_expire_field")
    private Integer memberExpireField;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_max_pos_scheduling_payments")
    private int memberMaxPosSchedulingPayments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_number_of_copies")
    private int memberNumberOfCopies;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_result_page_size")
    private int memberResultPageSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_allow_make_payment")
    private boolean memberAllowMakePayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_active")
    private boolean memberActive;
    @Size(max = 100)
    @Column(name = "initial_group_show")
    private String initialGroupShow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "initial_group")
    private boolean initialGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_default_allow_charging_sms")
    private boolean memberDefaultAllowChargingSms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_default_accept_free_mailing")
    private boolean memberDefaultAcceptFreeMailing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_default_accept_paid_mailing")
    private boolean memberDefaultAcceptPaidMailing;
    @JoinTable(name = "groups_conversion_simulation_transfer_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection;
    @JoinTable(name = "admin_groups_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection;
    @JoinTable(name = "groups_account_fees", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "account_fee_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AccountFees> accountFeesCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<Channels> channelsCollection;
    @JoinTable(name = "broker_groups_transaction_fees", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transaction_fee_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransactionFees> transactionFeesCollection;
    @JoinTable(name = "admin_groups_admin_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection1;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<GroupFilters> groupFiltersCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<AccountTypes> accountTypesCollection;
    @JoinTable(name = "broker_conversion_simulation_transfer_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection1;
    @JoinTable(name = "broker_groups_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection2;
    @ManyToMany(mappedBy = "groupsCollection1")
    private Collection<Channels> channelsCollection1;
    @JoinTable(name = "admin_groups_create_admin_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection3;
    @ManyToMany(mappedBy = "groupsCollection1")
    private Collection<AccountTypes> accountTypesCollection1;
    @JoinTable(name = "broker_groups_modify_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection4;
    @JoinTable(name = "admin_groups_modify_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection5;
    @JoinTable(name = "group_view_ads_permissions", joinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "related_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<Groups> groupsCollection1;
    @JoinTable(name = "groups_from_transaction_fees", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transaction_fee_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransactionFees> transactionFeesCollection1;
    @JoinTable(name = "admin_view_connected_users_of", joinColumns = {
        @JoinColumn(name = "viewed_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "viewer_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection2;
    @ManyToMany(mappedBy = "groupsCollection2")
    private Collection<Groups> groupsCollection3;
    @JoinTable(name = "group_broker_account_information_permissions", joinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "account_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AccountTypes> accountTypesCollection2;
    @ManyToMany(mappedBy = "groupsCollection3")
    private Collection<AccountTypes> accountTypesCollection3;
    @JoinTable(name = "groups_documents", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "document_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Documents> documentsCollection;
    @JoinTable(name = "groups_payment_filters", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "payment_filter_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<PaymentFilters> paymentFiltersCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<MessageCategories> messageCategoriesCollection;
    @JoinTable(name = "broker_groups_create_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection6;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<Messages> messagesCollection;
    @JoinTable(name = "broker_groups_delete_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection7;
    @JoinTable(name = "admin_groups_modify_admin_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection8;
    @JoinTable(name = "admin_manages_member_groups", joinColumns = {
        @JoinColumn(name = "manager_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "managed_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection4;
    @ManyToMany(mappedBy = "groupsCollection4")
    private Collection<Groups> groupsCollection5;
    @JoinTable(name = "admin_group_authorization_level", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "authorization_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AuthorizationLevels> authorizationLevelsCollection;
    @JoinTable(name = "admin_groups_create_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection9;
    @JoinTable(name = "service_clients_manage_groups", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_client_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<ServiceClients> serviceClientsCollection;
    @JoinTable(name = "group_issue_certification_to", joinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "related_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection6;
    @ManyToMany(mappedBy = "groupsCollection6")
    private Collection<Groups> groupsCollection7;
    @JoinTable(name = "groups_to_transaction_fees", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transaction_fee_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransactionFees> transactionFeesCollection2;
    @JoinTable(name = "group_view_profile_permissions", joinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "related_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection8;
    @ManyToMany(mappedBy = "groupsCollection8")
    private Collection<Groups> groupsCollection9;
    @JoinTable(name = "broker_groups_documents", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "document_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Documents> documentsCollection1;
    @JoinTable(name = "admin_groups_delete_admin_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection10;
    @JoinTable(name = "groups_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection11;
    @JoinTable(name = "groups_transfer_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection2;
    @JoinTable(name = "groups_chargeback_transfer_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "transfer_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<TransferTypes> transferTypesCollection3;
    @ManyToMany(mappedBy = "groupsCollection2")
    private Collection<Channels> channelsCollection2;
    @JoinTable(name = "broker_groups_possible_initial_groups", joinColumns = {
        @JoinColumn(name = "possible_initial_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection10;
    @ManyToMany(mappedBy = "groupsCollection10")
    private Collection<Groups> groupsCollection11;
    @JoinTable(name = "group_guarantee_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "guarantee_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<GuaranteeTypes> guaranteeTypesCollection;
    @JoinTable(name = "admin_groups_delete_member_record_types", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "member_record_type_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<MemberRecordTypes> memberRecordTypesCollection12;
    @JoinTable(name = "group_buy_with_payment_obligations_from", joinColumns = {
        @JoinColumn(name = "owner_group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "related_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Groups> groupsCollection12;
    @ManyToMany(mappedBy = "groupsCollection12")
    private Collection<Groups> groupsCollection13;
    @JoinTable(name = "admin_groups_custom_fields", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "custom_field_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<CustomFields> customFieldsCollection;
    @JoinTable(name = "admin_preferences_new_members", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "preference_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection;
    @ManyToMany(mappedBy = "groupsCollection")
    private Collection<SmsMailings> smsMailingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private Collection<Permissions> permissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<PendingMembers> pendingMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<Members> membersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private Collection<MemberGroupsEmailValidation> memberGroupsEmailValidationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<GroupHistoryLogs> groupHistoryLogsCollection;
    @OneToMany(mappedBy = "groupId")
    private Collection<Files> filesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<MemberImports> memberImportsCollection;
    @JoinColumn(name = "registration_agreement_id", referencedColumnName = "id")
    @ManyToOne
    private RegistrationAgreements registrationAgreementId;
    @OneToMany(mappedBy = "memberExpireGroupId")
    private Collection<Groups> groupsCollection14;
    @JoinColumn(name = "member_expire_group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups memberExpireGroupId;
    @JoinColumn(name = "card_type_id", referencedColumnName = "id")
    @ManyToOne
    private CardTypes cardTypeId;
    @JoinColumn(name = "sms_charge_transfer_type_id", referencedColumnName = "id")
    @ManyToOne
    private TransferTypes smsChargeTransferTypeId;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne
    private Members memberId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private Collection<OperatorGroupsMaxAmount> operatorGroupsMaxAmountCollection;
    @OneToMany(mappedBy = "oldGroupId")
    private Collection<Remarks> remarksCollection;
    @OneToMany(mappedBy = "newGroupId")
    private Collection<Remarks> remarksCollection1;

    public Groups() {
    }

    public Groups(Integer id) {
        this.id = id;
    }

    public Groups(Integer id, String subclass, String status, String name, String passwordPolicy, int transactionPasswordLength, int maxTpTries, boolean hideCurrencyOnPmt, int smsFreeCount, int smsAdditionalChargedCount, int smsShowFreeThreshold, int memberMaxAdDescriptionSize, int memberMaxAdImagesPerMember, boolean memberEnablePermanentAds, boolean memberShowPoswebPmtDsc, boolean memberSendPasswordByEmail, boolean memberViewLoansByGroup, boolean memberRepayLoanByGroup, int memberMaxSchedulingPayments, int memberMaxPosSchedulingPayments, int memberNumberOfCopies, int memberResultPageSize, boolean memberAllowMakePayment, boolean memberActive, boolean initialGroup, boolean memberDefaultAllowChargingSms, boolean memberDefaultAcceptFreeMailing, boolean memberDefaultAcceptPaidMailing) {
        this.id = id;
        this.subclass = subclass;
        this.status = status;
        this.name = name;
        this.passwordPolicy = passwordPolicy;
        this.transactionPasswordLength = transactionPasswordLength;
        this.maxTpTries = maxTpTries;
        this.hideCurrencyOnPmt = hideCurrencyOnPmt;
        this.smsFreeCount = smsFreeCount;
        this.smsAdditionalChargedCount = smsAdditionalChargedCount;
        this.smsShowFreeThreshold = smsShowFreeThreshold;
        this.memberMaxAdDescriptionSize = memberMaxAdDescriptionSize;
        this.memberMaxAdImagesPerMember = memberMaxAdImagesPerMember;
        this.memberEnablePermanentAds = memberEnablePermanentAds;
        this.memberShowPoswebPmtDsc = memberShowPoswebPmtDsc;
        this.memberSendPasswordByEmail = memberSendPasswordByEmail;
        this.memberViewLoansByGroup = memberViewLoansByGroup;
        this.memberRepayLoanByGroup = memberRepayLoanByGroup;
        this.memberMaxSchedulingPayments = memberMaxSchedulingPayments;
        this.memberMaxPosSchedulingPayments = memberMaxPosSchedulingPayments;
        this.memberNumberOfCopies = memberNumberOfCopies;
        this.memberResultPageSize = memberResultPageSize;
        this.memberAllowMakePayment = memberAllowMakePayment;
        this.memberActive = memberActive;
        this.initialGroup = initialGroup;
        this.memberDefaultAllowChargingSms = memberDefaultAllowChargingSms;
        this.memberDefaultAcceptFreeMailing = memberDefaultAcceptFreeMailing;
        this.memberDefaultAcceptPaidMailing = memberDefaultAcceptPaidMailing;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getMaxPasswordTries() {
        return maxPasswordTries;
    }

    public void setMaxPasswordTries(Integer maxPasswordTries) {
        this.maxPasswordTries = maxPasswordTries;
    }

    public Integer getMinPasswordLength() {
        return minPasswordLength;
    }

    public void setMinPasswordLength(Integer minPasswordLength) {
        this.minPasswordLength = minPasswordLength;
    }

    public Integer getMaxPasswordLength() {
        return maxPasswordLength;
    }

    public void setMaxPasswordLength(Integer maxPasswordLength) {
        this.maxPasswordLength = maxPasswordLength;
    }

    public String getPasswordPolicy() {
        return passwordPolicy;
    }

    public void setPasswordPolicy(String passwordPolicy) {
        this.passwordPolicy = passwordPolicy;
    }

    public Integer getDeactivationNumber() {
        return deactivationNumber;
    }

    public void setDeactivationNumber(Integer deactivationNumber) {
        this.deactivationNumber = deactivationNumber;
    }

    public Integer getDeactivationField() {
        return deactivationField;
    }

    public void setDeactivationField(Integer deactivationField) {
        this.deactivationField = deactivationField;
    }

    public Integer getPasswordExpirationNumber() {
        return passwordExpirationNumber;
    }

    public void setPasswordExpirationNumber(Integer passwordExpirationNumber) {
        this.passwordExpirationNumber = passwordExpirationNumber;
    }

    public Integer getPasswordExpirationField() {
        return passwordExpirationField;
    }

    public void setPasswordExpirationField(Integer passwordExpirationField) {
        this.passwordExpirationField = passwordExpirationField;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    public int getTransactionPasswordLength() {
        return transactionPasswordLength;
    }

    public void setTransactionPasswordLength(int transactionPasswordLength) {
        this.transactionPasswordLength = transactionPasswordLength;
    }

    public int getMaxTpTries() {
        return maxTpTries;
    }

    public void setMaxTpTries(int maxTpTries) {
        this.maxTpTries = maxTpTries;
    }

    public boolean getHideCurrencyOnPmt() {
        return hideCurrencyOnPmt;
    }

    public void setHideCurrencyOnPmt(boolean hideCurrencyOnPmt) {
        this.hideCurrencyOnPmt = hideCurrencyOnPmt;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getLoginPageName() {
        return loginPageName;
    }

    public void setLoginPageName(String loginPageName) {
        this.loginPageName = loginPageName;
    }

    public String getContainerUrl() {
        return containerUrl;
    }

    public void setContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
    }

    public BigDecimal getSmsChargeAmount() {
        return smsChargeAmount;
    }

    public void setSmsChargeAmount(BigDecimal smsChargeAmount) {
        this.smsChargeAmount = smsChargeAmount;
    }

    public int getSmsFreeCount() {
        return smsFreeCount;
    }

    public void setSmsFreeCount(int smsFreeCount) {
        this.smsFreeCount = smsFreeCount;
    }

    public int getSmsAdditionalChargedCount() {
        return smsAdditionalChargedCount;
    }

    public void setSmsAdditionalChargedCount(int smsAdditionalChargedCount) {
        this.smsAdditionalChargedCount = smsAdditionalChargedCount;
    }

    public Integer getSmsAdditionalChargedPeriodNumber() {
        return smsAdditionalChargedPeriodNumber;
    }

    public void setSmsAdditionalChargedPeriodNumber(Integer smsAdditionalChargedPeriodNumber) {
        this.smsAdditionalChargedPeriodNumber = smsAdditionalChargedPeriodNumber;
    }

    public Integer getSmsAdditionalChargedPeriodField() {
        return smsAdditionalChargedPeriodField;
    }

    public void setSmsAdditionalChargedPeriodField(Integer smsAdditionalChargedPeriodField) {
        this.smsAdditionalChargedPeriodField = smsAdditionalChargedPeriodField;
    }

    public int getSmsShowFreeThreshold() {
        return smsShowFreeThreshold;
    }

    public void setSmsShowFreeThreshold(int smsShowFreeThreshold) {
        this.smsShowFreeThreshold = smsShowFreeThreshold;
    }

    public String getSmsContextClassName() {
        return smsContextClassName;
    }

    public void setSmsContextClassName(String smsContextClassName) {
        this.smsContextClassName = smsContextClassName;
    }

    public Integer getMemberMaxImagesPerMember() {
        return memberMaxImagesPerMember;
    }

    public void setMemberMaxImagesPerMember(Integer memberMaxImagesPerMember) {
        this.memberMaxImagesPerMember = memberMaxImagesPerMember;
    }

    public Integer getMemberMaxAdsPerMember() {
        return memberMaxAdsPerMember;
    }

    public void setMemberMaxAdsPerMember(Integer memberMaxAdsPerMember) {
        this.memberMaxAdsPerMember = memberMaxAdsPerMember;
    }

    public int getMemberMaxAdDescriptionSize() {
        return memberMaxAdDescriptionSize;
    }

    public void setMemberMaxAdDescriptionSize(int memberMaxAdDescriptionSize) {
        this.memberMaxAdDescriptionSize = memberMaxAdDescriptionSize;
    }

    public int getMemberMaxAdImagesPerMember() {
        return memberMaxAdImagesPerMember;
    }

    public void setMemberMaxAdImagesPerMember(int memberMaxAdImagesPerMember) {
        this.memberMaxAdImagesPerMember = memberMaxAdImagesPerMember;
    }

    public Integer getMemberDefaultAdPublicationNumber() {
        return memberDefaultAdPublicationNumber;
    }

    public void setMemberDefaultAdPublicationNumber(Integer memberDefaultAdPublicationNumber) {
        this.memberDefaultAdPublicationNumber = memberDefaultAdPublicationNumber;
    }

    public Integer getMemberDefaultAdPublicationField() {
        return memberDefaultAdPublicationField;
    }

    public void setMemberDefaultAdPublicationField(Integer memberDefaultAdPublicationField) {
        this.memberDefaultAdPublicationField = memberDefaultAdPublicationField;
    }

    public Integer getMemberMaxAdPublicationNumber() {
        return memberMaxAdPublicationNumber;
    }

    public void setMemberMaxAdPublicationNumber(Integer memberMaxAdPublicationNumber) {
        this.memberMaxAdPublicationNumber = memberMaxAdPublicationNumber;
    }

    public Integer getMemberMaxAdPublicationField() {
        return memberMaxAdPublicationField;
    }

    public void setMemberMaxAdPublicationField(Integer memberMaxAdPublicationField) {
        this.memberMaxAdPublicationField = memberMaxAdPublicationField;
    }

    public boolean getMemberEnablePermanentAds() {
        return memberEnablePermanentAds;
    }

    public void setMemberEnablePermanentAds(boolean memberEnablePermanentAds) {
        this.memberEnablePermanentAds = memberEnablePermanentAds;
    }

    public boolean getMemberShowPoswebPmtDsc() {
        return memberShowPoswebPmtDsc;
    }

    public void setMemberShowPoswebPmtDsc(boolean memberShowPoswebPmtDsc) {
        this.memberShowPoswebPmtDsc = memberShowPoswebPmtDsc;
    }

    public String getMemberExternalAdPublication() {
        return memberExternalAdPublication;
    }

    public void setMemberExternalAdPublication(String memberExternalAdPublication) {
        this.memberExternalAdPublication = memberExternalAdPublication;
    }

    public boolean getMemberSendPasswordByEmail() {
        return memberSendPasswordByEmail;
    }

    public void setMemberSendPasswordByEmail(boolean memberSendPasswordByEmail) {
        this.memberSendPasswordByEmail = memberSendPasswordByEmail;
    }

    public boolean getMemberViewLoansByGroup() {
        return memberViewLoansByGroup;
    }

    public void setMemberViewLoansByGroup(boolean memberViewLoansByGroup) {
        this.memberViewLoansByGroup = memberViewLoansByGroup;
    }

    public boolean getMemberRepayLoanByGroup() {
        return memberRepayLoanByGroup;
    }

    public void setMemberRepayLoanByGroup(boolean memberRepayLoanByGroup) {
        this.memberRepayLoanByGroup = memberRepayLoanByGroup;
    }

    public int getMemberMaxSchedulingPayments() {
        return memberMaxSchedulingPayments;
    }

    public void setMemberMaxSchedulingPayments(int memberMaxSchedulingPayments) {
        this.memberMaxSchedulingPayments = memberMaxSchedulingPayments;
    }

    public Integer getMemberMaxSchedulingPeriodNumber() {
        return memberMaxSchedulingPeriodNumber;
    }

    public void setMemberMaxSchedulingPeriodNumber(Integer memberMaxSchedulingPeriodNumber) {
        this.memberMaxSchedulingPeriodNumber = memberMaxSchedulingPeriodNumber;
    }

    public Integer getMemberMaxSchedulingPeriodField() {
        return memberMaxSchedulingPeriodField;
    }

    public void setMemberMaxSchedulingPeriodField(Integer memberMaxSchedulingPeriodField) {
        this.memberMaxSchedulingPeriodField = memberMaxSchedulingPeriodField;
    }

    public Integer getMinPinLength() {
        return minPinLength;
    }

    public void setMinPinLength(Integer minPinLength) {
        this.minPinLength = minPinLength;
    }

    public Integer getMaxPinLength() {
        return maxPinLength;
    }

    public void setMaxPinLength(Integer maxPinLength) {
        this.maxPinLength = maxPinLength;
    }

    public Integer getMemberMaxPinTries() {
        return memberMaxPinTries;
    }

    public void setMemberMaxPinTries(Integer memberMaxPinTries) {
        this.memberMaxPinTries = memberMaxPinTries;
    }

    public Integer getMemberPinBlockNumber() {
        return memberPinBlockNumber;
    }

    public void setMemberPinBlockNumber(Integer memberPinBlockNumber) {
        this.memberPinBlockNumber = memberPinBlockNumber;
    }

    public Integer getMemberPinBlockField() {
        return memberPinBlockField;
    }

    public void setMemberPinBlockField(Integer memberPinBlockField) {
        this.memberPinBlockField = memberPinBlockField;
    }

    public Integer getMemberExpireNumber() {
        return memberExpireNumber;
    }

    public void setMemberExpireNumber(Integer memberExpireNumber) {
        this.memberExpireNumber = memberExpireNumber;
    }

    public Integer getMemberExpireField() {
        return memberExpireField;
    }

    public void setMemberExpireField(Integer memberExpireField) {
        this.memberExpireField = memberExpireField;
    }

    public int getMemberMaxPosSchedulingPayments() {
        return memberMaxPosSchedulingPayments;
    }

    public void setMemberMaxPosSchedulingPayments(int memberMaxPosSchedulingPayments) {
        this.memberMaxPosSchedulingPayments = memberMaxPosSchedulingPayments;
    }

    public int getMemberNumberOfCopies() {
        return memberNumberOfCopies;
    }

    public void setMemberNumberOfCopies(int memberNumberOfCopies) {
        this.memberNumberOfCopies = memberNumberOfCopies;
    }

    public int getMemberResultPageSize() {
        return memberResultPageSize;
    }

    public void setMemberResultPageSize(int memberResultPageSize) {
        this.memberResultPageSize = memberResultPageSize;
    }

    public boolean getMemberAllowMakePayment() {
        return memberAllowMakePayment;
    }

    public void setMemberAllowMakePayment(boolean memberAllowMakePayment) {
        this.memberAllowMakePayment = memberAllowMakePayment;
    }

    public boolean getMemberActive() {
        return memberActive;
    }

    public void setMemberActive(boolean memberActive) {
        this.memberActive = memberActive;
    }

    public String getInitialGroupShow() {
        return initialGroupShow;
    }

    public void setInitialGroupShow(String initialGroupShow) {
        this.initialGroupShow = initialGroupShow;
    }

    public boolean getInitialGroup() {
        return initialGroup;
    }

    public void setInitialGroup(boolean initialGroup) {
        this.initialGroup = initialGroup;
    }

    public boolean getMemberDefaultAllowChargingSms() {
        return memberDefaultAllowChargingSms;
    }

    public void setMemberDefaultAllowChargingSms(boolean memberDefaultAllowChargingSms) {
        this.memberDefaultAllowChargingSms = memberDefaultAllowChargingSms;
    }

    public boolean getMemberDefaultAcceptFreeMailing() {
        return memberDefaultAcceptFreeMailing;
    }

    public void setMemberDefaultAcceptFreeMailing(boolean memberDefaultAcceptFreeMailing) {
        this.memberDefaultAcceptFreeMailing = memberDefaultAcceptFreeMailing;
    }

    public boolean getMemberDefaultAcceptPaidMailing() {
        return memberDefaultAcceptPaidMailing;
    }

    public void setMemberDefaultAcceptPaidMailing(boolean memberDefaultAcceptPaidMailing) {
        this.memberDefaultAcceptPaidMailing = memberDefaultAcceptPaidMailing;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection() {
        return transferTypesCollection;
    }

    public void setTransferTypesCollection(Collection<TransferTypes> transferTypesCollection) {
        this.transferTypesCollection = transferTypesCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection() {
        return memberRecordTypesCollection;
    }

    public void setMemberRecordTypesCollection(Collection<MemberRecordTypes> memberRecordTypesCollection) {
        this.memberRecordTypesCollection = memberRecordTypesCollection;
    }

    @XmlTransient
    public Collection<AccountFees> getAccountFeesCollection() {
        return accountFeesCollection;
    }

    public void setAccountFeesCollection(Collection<AccountFees> accountFeesCollection) {
        this.accountFeesCollection = accountFeesCollection;
    }

    @XmlTransient
    public Collection<Channels> getChannelsCollection() {
        return channelsCollection;
    }

    public void setChannelsCollection(Collection<Channels> channelsCollection) {
        this.channelsCollection = channelsCollection;
    }

    @XmlTransient
    public Collection<TransactionFees> getTransactionFeesCollection() {
        return transactionFeesCollection;
    }

    public void setTransactionFeesCollection(Collection<TransactionFees> transactionFeesCollection) {
        this.transactionFeesCollection = transactionFeesCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection1() {
        return memberRecordTypesCollection1;
    }

    public void setMemberRecordTypesCollection1(Collection<MemberRecordTypes> memberRecordTypesCollection1) {
        this.memberRecordTypesCollection1 = memberRecordTypesCollection1;
    }

    @XmlTransient
    public Collection<GroupFilters> getGroupFiltersCollection() {
        return groupFiltersCollection;
    }

    public void setGroupFiltersCollection(Collection<GroupFilters> groupFiltersCollection) {
        this.groupFiltersCollection = groupFiltersCollection;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection() {
        return accountTypesCollection;
    }

    public void setAccountTypesCollection(Collection<AccountTypes> accountTypesCollection) {
        this.accountTypesCollection = accountTypesCollection;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection1() {
        return transferTypesCollection1;
    }

    public void setTransferTypesCollection1(Collection<TransferTypes> transferTypesCollection1) {
        this.transferTypesCollection1 = transferTypesCollection1;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection2() {
        return memberRecordTypesCollection2;
    }

    public void setMemberRecordTypesCollection2(Collection<MemberRecordTypes> memberRecordTypesCollection2) {
        this.memberRecordTypesCollection2 = memberRecordTypesCollection2;
    }

    @XmlTransient
    public Collection<Channels> getChannelsCollection1() {
        return channelsCollection1;
    }

    public void setChannelsCollection1(Collection<Channels> channelsCollection1) {
        this.channelsCollection1 = channelsCollection1;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection3() {
        return memberRecordTypesCollection3;
    }

    public void setMemberRecordTypesCollection3(Collection<MemberRecordTypes> memberRecordTypesCollection3) {
        this.memberRecordTypesCollection3 = memberRecordTypesCollection3;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection1() {
        return accountTypesCollection1;
    }

    public void setAccountTypesCollection1(Collection<AccountTypes> accountTypesCollection1) {
        this.accountTypesCollection1 = accountTypesCollection1;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection4() {
        return memberRecordTypesCollection4;
    }

    public void setMemberRecordTypesCollection4(Collection<MemberRecordTypes> memberRecordTypesCollection4) {
        this.memberRecordTypesCollection4 = memberRecordTypesCollection4;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection5() {
        return memberRecordTypesCollection5;
    }

    public void setMemberRecordTypesCollection5(Collection<MemberRecordTypes> memberRecordTypesCollection5) {
        this.memberRecordTypesCollection5 = memberRecordTypesCollection5;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection1() {
        return groupsCollection1;
    }

    public void setGroupsCollection1(Collection<Groups> groupsCollection1) {
        this.groupsCollection1 = groupsCollection1;
    }

    @XmlTransient
    public Collection<TransactionFees> getTransactionFeesCollection1() {
        return transactionFeesCollection1;
    }

    public void setTransactionFeesCollection1(Collection<TransactionFees> transactionFeesCollection1) {
        this.transactionFeesCollection1 = transactionFeesCollection1;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection2() {
        return groupsCollection2;
    }

    public void setGroupsCollection2(Collection<Groups> groupsCollection2) {
        this.groupsCollection2 = groupsCollection2;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection3() {
        return groupsCollection3;
    }

    public void setGroupsCollection3(Collection<Groups> groupsCollection3) {
        this.groupsCollection3 = groupsCollection3;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection2() {
        return accountTypesCollection2;
    }

    public void setAccountTypesCollection2(Collection<AccountTypes> accountTypesCollection2) {
        this.accountTypesCollection2 = accountTypesCollection2;
    }

    @XmlTransient
    public Collection<AccountTypes> getAccountTypesCollection3() {
        return accountTypesCollection3;
    }

    public void setAccountTypesCollection3(Collection<AccountTypes> accountTypesCollection3) {
        this.accountTypesCollection3 = accountTypesCollection3;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection() {
        return documentsCollection;
    }

    public void setDocumentsCollection(Collection<Documents> documentsCollection) {
        this.documentsCollection = documentsCollection;
    }

    @XmlTransient
    public Collection<PaymentFilters> getPaymentFiltersCollection() {
        return paymentFiltersCollection;
    }

    public void setPaymentFiltersCollection(Collection<PaymentFilters> paymentFiltersCollection) {
        this.paymentFiltersCollection = paymentFiltersCollection;
    }

    @XmlTransient
    public Collection<MessageCategories> getMessageCategoriesCollection() {
        return messageCategoriesCollection;
    }

    public void setMessageCategoriesCollection(Collection<MessageCategories> messageCategoriesCollection) {
        this.messageCategoriesCollection = messageCategoriesCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection6() {
        return memberRecordTypesCollection6;
    }

    public void setMemberRecordTypesCollection6(Collection<MemberRecordTypes> memberRecordTypesCollection6) {
        this.memberRecordTypesCollection6 = memberRecordTypesCollection6;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection7() {
        return memberRecordTypesCollection7;
    }

    public void setMemberRecordTypesCollection7(Collection<MemberRecordTypes> memberRecordTypesCollection7) {
        this.memberRecordTypesCollection7 = memberRecordTypesCollection7;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection8() {
        return memberRecordTypesCollection8;
    }

    public void setMemberRecordTypesCollection8(Collection<MemberRecordTypes> memberRecordTypesCollection8) {
        this.memberRecordTypesCollection8 = memberRecordTypesCollection8;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection4() {
        return groupsCollection4;
    }

    public void setGroupsCollection4(Collection<Groups> groupsCollection4) {
        this.groupsCollection4 = groupsCollection4;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection5() {
        return groupsCollection5;
    }

    public void setGroupsCollection5(Collection<Groups> groupsCollection5) {
        this.groupsCollection5 = groupsCollection5;
    }

    @XmlTransient
    public Collection<AuthorizationLevels> getAuthorizationLevelsCollection() {
        return authorizationLevelsCollection;
    }

    public void setAuthorizationLevelsCollection(Collection<AuthorizationLevels> authorizationLevelsCollection) {
        this.authorizationLevelsCollection = authorizationLevelsCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection9() {
        return memberRecordTypesCollection9;
    }

    public void setMemberRecordTypesCollection9(Collection<MemberRecordTypes> memberRecordTypesCollection9) {
        this.memberRecordTypesCollection9 = memberRecordTypesCollection9;
    }

    @XmlTransient
    public Collection<ServiceClients> getServiceClientsCollection() {
        return serviceClientsCollection;
    }

    public void setServiceClientsCollection(Collection<ServiceClients> serviceClientsCollection) {
        this.serviceClientsCollection = serviceClientsCollection;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection6() {
        return groupsCollection6;
    }

    public void setGroupsCollection6(Collection<Groups> groupsCollection6) {
        this.groupsCollection6 = groupsCollection6;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection7() {
        return groupsCollection7;
    }

    public void setGroupsCollection7(Collection<Groups> groupsCollection7) {
        this.groupsCollection7 = groupsCollection7;
    }

    @XmlTransient
    public Collection<TransactionFees> getTransactionFeesCollection2() {
        return transactionFeesCollection2;
    }

    public void setTransactionFeesCollection2(Collection<TransactionFees> transactionFeesCollection2) {
        this.transactionFeesCollection2 = transactionFeesCollection2;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection8() {
        return groupsCollection8;
    }

    public void setGroupsCollection8(Collection<Groups> groupsCollection8) {
        this.groupsCollection8 = groupsCollection8;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection9() {
        return groupsCollection9;
    }

    public void setGroupsCollection9(Collection<Groups> groupsCollection9) {
        this.groupsCollection9 = groupsCollection9;
    }

    @XmlTransient
    public Collection<Documents> getDocumentsCollection1() {
        return documentsCollection1;
    }

    public void setDocumentsCollection1(Collection<Documents> documentsCollection1) {
        this.documentsCollection1 = documentsCollection1;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection10() {
        return memberRecordTypesCollection10;
    }

    public void setMemberRecordTypesCollection10(Collection<MemberRecordTypes> memberRecordTypesCollection10) {
        this.memberRecordTypesCollection10 = memberRecordTypesCollection10;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection11() {
        return memberRecordTypesCollection11;
    }

    public void setMemberRecordTypesCollection11(Collection<MemberRecordTypes> memberRecordTypesCollection11) {
        this.memberRecordTypesCollection11 = memberRecordTypesCollection11;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection2() {
        return transferTypesCollection2;
    }

    public void setTransferTypesCollection2(Collection<TransferTypes> transferTypesCollection2) {
        this.transferTypesCollection2 = transferTypesCollection2;
    }

    @XmlTransient
    public Collection<TransferTypes> getTransferTypesCollection3() {
        return transferTypesCollection3;
    }

    public void setTransferTypesCollection3(Collection<TransferTypes> transferTypesCollection3) {
        this.transferTypesCollection3 = transferTypesCollection3;
    }

    @XmlTransient
    public Collection<Channels> getChannelsCollection2() {
        return channelsCollection2;
    }

    public void setChannelsCollection2(Collection<Channels> channelsCollection2) {
        this.channelsCollection2 = channelsCollection2;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection10() {
        return groupsCollection10;
    }

    public void setGroupsCollection10(Collection<Groups> groupsCollection10) {
        this.groupsCollection10 = groupsCollection10;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection11() {
        return groupsCollection11;
    }

    public void setGroupsCollection11(Collection<Groups> groupsCollection11) {
        this.groupsCollection11 = groupsCollection11;
    }

    @XmlTransient
    public Collection<GuaranteeTypes> getGuaranteeTypesCollection() {
        return guaranteeTypesCollection;
    }

    public void setGuaranteeTypesCollection(Collection<GuaranteeTypes> guaranteeTypesCollection) {
        this.guaranteeTypesCollection = guaranteeTypesCollection;
    }

    @XmlTransient
    public Collection<MemberRecordTypes> getMemberRecordTypesCollection12() {
        return memberRecordTypesCollection12;
    }

    public void setMemberRecordTypesCollection12(Collection<MemberRecordTypes> memberRecordTypesCollection12) {
        this.memberRecordTypesCollection12 = memberRecordTypesCollection12;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection12() {
        return groupsCollection12;
    }

    public void setGroupsCollection12(Collection<Groups> groupsCollection12) {
        this.groupsCollection12 = groupsCollection12;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection13() {
        return groupsCollection13;
    }

    public void setGroupsCollection13(Collection<Groups> groupsCollection13) {
        this.groupsCollection13 = groupsCollection13;
    }

    @XmlTransient
    public Collection<CustomFields> getCustomFieldsCollection() {
        return customFieldsCollection;
    }

    public void setCustomFieldsCollection(Collection<CustomFields> customFieldsCollection) {
        this.customFieldsCollection = customFieldsCollection;
    }

    @XmlTransient
    public Collection<AdminNotificationPreferences> getAdminNotificationPreferencesCollection() {
        return adminNotificationPreferencesCollection;
    }

    public void setAdminNotificationPreferencesCollection(Collection<AdminNotificationPreferences> adminNotificationPreferencesCollection) {
        this.adminNotificationPreferencesCollection = adminNotificationPreferencesCollection;
    }

    @XmlTransient
    public Collection<SmsMailings> getSmsMailingsCollection() {
        return smsMailingsCollection;
    }

    public void setSmsMailingsCollection(Collection<SmsMailings> smsMailingsCollection) {
        this.smsMailingsCollection = smsMailingsCollection;
    }

    @XmlTransient
    public Collection<Permissions> getPermissionsCollection() {
        return permissionsCollection;
    }

    public void setPermissionsCollection(Collection<Permissions> permissionsCollection) {
        this.permissionsCollection = permissionsCollection;
    }

    @XmlTransient
    public Collection<PendingMembers> getPendingMembersCollection() {
        return pendingMembersCollection;
    }

    public void setPendingMembersCollection(Collection<PendingMembers> pendingMembersCollection) {
        this.pendingMembersCollection = pendingMembersCollection;
    }

    @XmlTransient
    public Collection<MemberGroupAccountSettings> getMemberGroupAccountSettingsCollection() {
        return memberGroupAccountSettingsCollection;
    }

    public void setMemberGroupAccountSettingsCollection(Collection<MemberGroupAccountSettings> memberGroupAccountSettingsCollection) {
        this.memberGroupAccountSettingsCollection = memberGroupAccountSettingsCollection;
    }

    @XmlTransient
    public Collection<Members> getMembersCollection() {
        return membersCollection;
    }

    public void setMembersCollection(Collection<Members> membersCollection) {
        this.membersCollection = membersCollection;
    }

    @XmlTransient
    public Collection<MemberGroupsEmailValidation> getMemberGroupsEmailValidationCollection() {
        return memberGroupsEmailValidationCollection;
    }

    public void setMemberGroupsEmailValidationCollection(Collection<MemberGroupsEmailValidation> memberGroupsEmailValidationCollection) {
        this.memberGroupsEmailValidationCollection = memberGroupsEmailValidationCollection;
    }

    @XmlTransient
    public Collection<GroupHistoryLogs> getGroupHistoryLogsCollection() {
        return groupHistoryLogsCollection;
    }

    public void setGroupHistoryLogsCollection(Collection<GroupHistoryLogs> groupHistoryLogsCollection) {
        this.groupHistoryLogsCollection = groupHistoryLogsCollection;
    }

    @XmlTransient
    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
    }

    @XmlTransient
    public Collection<MemberImports> getMemberImportsCollection() {
        return memberImportsCollection;
    }

    public void setMemberImportsCollection(Collection<MemberImports> memberImportsCollection) {
        this.memberImportsCollection = memberImportsCollection;
    }

    public RegistrationAgreements getRegistrationAgreementId() {
        return registrationAgreementId;
    }

    public void setRegistrationAgreementId(RegistrationAgreements registrationAgreementId) {
        this.registrationAgreementId = registrationAgreementId;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection14() {
        return groupsCollection14;
    }

    public void setGroupsCollection14(Collection<Groups> groupsCollection14) {
        this.groupsCollection14 = groupsCollection14;
    }

    public Groups getMemberExpireGroupId() {
        return memberExpireGroupId;
    }

    public void setMemberExpireGroupId(Groups memberExpireGroupId) {
        this.memberExpireGroupId = memberExpireGroupId;
    }

    public CardTypes getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(CardTypes cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public TransferTypes getSmsChargeTransferTypeId() {
        return smsChargeTransferTypeId;
    }

    public void setSmsChargeTransferTypeId(TransferTypes smsChargeTransferTypeId) {
        this.smsChargeTransferTypeId = smsChargeTransferTypeId;
    }

    public Members getMemberId() {
        return memberId;
    }

    public void setMemberId(Members memberId) {
        this.memberId = memberId;
    }

    @XmlTransient
    public Collection<OperatorGroupsMaxAmount> getOperatorGroupsMaxAmountCollection() {
        return operatorGroupsMaxAmountCollection;
    }

    public void setOperatorGroupsMaxAmountCollection(Collection<OperatorGroupsMaxAmount> operatorGroupsMaxAmountCollection) {
        this.operatorGroupsMaxAmountCollection = operatorGroupsMaxAmountCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Groups[ id=" + id + " ]";
    }
    
}
