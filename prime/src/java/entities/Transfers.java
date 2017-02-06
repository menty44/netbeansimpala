/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "transfers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfers.findAll", query = "SELECT t FROM Transfers t"),
    @NamedQuery(name = "Transfers.findById", query = "SELECT t FROM Transfers t WHERE t.id = :id"),
    @NamedQuery(name = "Transfers.findByDate", query = "SELECT t FROM Transfers t WHERE t.date = :date"),
    @NamedQuery(name = "Transfers.findByAmount", query = "SELECT t FROM Transfers t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transfers.findByEmissionDate", query = "SELECT t FROM Transfers t WHERE t.emissionDate = :emissionDate"),
    @NamedQuery(name = "Transfers.findByExpirationDate", query = "SELECT t FROM Transfers t WHERE t.expirationDate = :expirationDate"),
    @NamedQuery(name = "Transfers.findByIRate", query = "SELECT t FROM Transfers t WHERE t.iRate = :iRate"),
    @NamedQuery(name = "Transfers.findByStatus", query = "SELECT t FROM Transfers t WHERE t.status = :status"),
    @NamedQuery(name = "Transfers.findByProcessDate", query = "SELECT t FROM Transfers t WHERE t.processDate = :processDate"),
    @NamedQuery(name = "Transfers.findByFeedbackDeadline", query = "SELECT t FROM Transfers t WHERE t.feedbackDeadline = :feedbackDeadline"),
    @NamedQuery(name = "Transfers.findByTransactionNumber", query = "SELECT t FROM Transfers t WHERE t.transactionNumber = :transactionNumber"),
    @NamedQuery(name = "Transfers.findByTraceNumber", query = "SELECT t FROM Transfers t WHERE t.traceNumber = :traceNumber"),
    @NamedQuery(name = "Transfers.findByClientId", query = "SELECT t FROM Transfers t WHERE t.clientId = :clientId"),
    @NamedQuery(name = "Transfers.findByTraceData", query = "SELECT t FROM Transfers t WHERE t.traceData = :traceData")})
public class Transfers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "emission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissionDate;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "i_rate")
    private BigDecimal iRate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Column(name = "process_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Column(name = "feedback_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feedbackDeadline;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "transaction_number")
    private String transactionNumber;
    @Size(max = 100)
    @Column(name = "trace_number")
    private String traceNumber;
    @Column(name = "client_id")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "trace_data")
    private String traceData;
    @OneToMany(mappedBy = "transferId")
    private Collection<Invoices> invoicesCollection;
    @JoinColumn(name = "from_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts fromAccountId;
    @JoinColumn(name = "broker_commission_contract_id", referencedColumnName = "id")
    @ManyToOne
    private BrokerCommissionContracts brokerCommissionContractId;
    @OneToMany(mappedBy = "chargedbackById")
    private Collection<Transfers> transfersCollection;
    @JoinColumn(name = "chargedback_by_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers chargedbackById;
    @OneToMany(mappedBy = "parentId")
    private Collection<Transfers> transfersCollection1;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers parentId;
    @JoinColumn(name = "by_id", referencedColumnName = "id")
    @ManyToOne
    private Members byId;
    @JoinColumn(name = "next_authorization_level_id", referencedColumnName = "id")
    @ManyToOne
    private AuthorizationLevels nextAuthorizationLevelId;
    @JoinColumn(name = "loan_payment_id", referencedColumnName = "id")
    @ManyToOne
    private LoanPayments loanPaymentId;
    @JoinColumn(name = "transaction_fee_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionFees transactionFeeId;
    @JoinColumn(name = "external_transfer_id", referencedColumnName = "id")
    @ManyToOne
    private ExternalTransfers externalTransferId;
    @JoinColumn(name = "account_fee_log_id", referencedColumnName = "id")
    @ManyToOne
    private AccountFeeLogs accountFeeLogId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransferTypes typeId;
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    @ManyToOne
    private Members receiverId;
    @OneToMany(mappedBy = "chargebackOfId")
    private Collection<Transfers> transfersCollection2;
    @JoinColumn(name = "chargeback_of_id", referencedColumnName = "id")
    @ManyToOne
    private Transfers chargebackOfId;
    @JoinColumn(name = "scheduled_payment_id", referencedColumnName = "id")
    @ManyToOne
    private ScheduledPayments scheduledPaymentId;
    @JoinColumn(name = "fee_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionFees feeId;
    @JoinColumn(name = "to_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts toAccountId;
    @OneToMany(mappedBy = "transferId")
    private Collection<Refs> refsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferId")
    private Collection<TransferAuthorizations> transferAuthorizationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferId")
    private Collection<AccountRates> accountRatesCollection;
    @OneToMany(mappedBy = "transferId")
    private Collection<AmountReservations> amountReservationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transferId")
    private Collection<Loans> loansCollection;
    @OneToMany(mappedBy = "transferId")
    private Collection<InvoicePayments> invoicePaymentsCollection;
    @OneToMany(mappedBy = "transferId")
    private Collection<Tickets> ticketsCollection;
    @OneToMany(mappedBy = "transferId")
    private Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection;
    @OneToMany(mappedBy = "transferId")
    private Collection<CustomFieldValues> customFieldValuesCollection;

    public Transfers() {
    }

    public Transfers(Long id) {
        this.id = id;
    }

    public Transfers(Long id, Date date, BigDecimal amount, String status) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getIRate() {
        return iRate;
    }

    public void setIRate(BigDecimal iRate) {
        this.iRate = iRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Date getFeedbackDeadline() {
        return feedbackDeadline;
    }

    public void setFeedbackDeadline(Date feedbackDeadline) {
        this.feedbackDeadline = feedbackDeadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getTraceData() {
        return traceData;
    }

    public void setTraceData(String traceData) {
        this.traceData = traceData;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    public Accounts getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Accounts fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public BrokerCommissionContracts getBrokerCommissionContractId() {
        return brokerCommissionContractId;
    }

    public void setBrokerCommissionContractId(BrokerCommissionContracts brokerCommissionContractId) {
        this.brokerCommissionContractId = brokerCommissionContractId;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection() {
        return transfersCollection;
    }

    public void setTransfersCollection(Collection<Transfers> transfersCollection) {
        this.transfersCollection = transfersCollection;
    }

    public Transfers getChargedbackById() {
        return chargedbackById;
    }

    public void setChargedbackById(Transfers chargedbackById) {
        this.chargedbackById = chargedbackById;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection1() {
        return transfersCollection1;
    }

    public void setTransfersCollection1(Collection<Transfers> transfersCollection1) {
        this.transfersCollection1 = transfersCollection1;
    }

    public Transfers getParentId() {
        return parentId;
    }

    public void setParentId(Transfers parentId) {
        this.parentId = parentId;
    }

    public Members getById() {
        return byId;
    }

    public void setById(Members byId) {
        this.byId = byId;
    }

    public AuthorizationLevels getNextAuthorizationLevelId() {
        return nextAuthorizationLevelId;
    }

    public void setNextAuthorizationLevelId(AuthorizationLevels nextAuthorizationLevelId) {
        this.nextAuthorizationLevelId = nextAuthorizationLevelId;
    }

    public LoanPayments getLoanPaymentId() {
        return loanPaymentId;
    }

    public void setLoanPaymentId(LoanPayments loanPaymentId) {
        this.loanPaymentId = loanPaymentId;
    }

    public TransactionFees getTransactionFeeId() {
        return transactionFeeId;
    }

    public void setTransactionFeeId(TransactionFees transactionFeeId) {
        this.transactionFeeId = transactionFeeId;
    }

    public ExternalTransfers getExternalTransferId() {
        return externalTransferId;
    }

    public void setExternalTransferId(ExternalTransfers externalTransferId) {
        this.externalTransferId = externalTransferId;
    }

    public AccountFeeLogs getAccountFeeLogId() {
        return accountFeeLogId;
    }

    public void setAccountFeeLogId(AccountFeeLogs accountFeeLogId) {
        this.accountFeeLogId = accountFeeLogId;
    }

    public TransferTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(TransferTypes typeId) {
        this.typeId = typeId;
    }

    public Members getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Members receiverId) {
        this.receiverId = receiverId;
    }

    @XmlTransient
    public Collection<Transfers> getTransfersCollection2() {
        return transfersCollection2;
    }

    public void setTransfersCollection2(Collection<Transfers> transfersCollection2) {
        this.transfersCollection2 = transfersCollection2;
    }

    public Transfers getChargebackOfId() {
        return chargebackOfId;
    }

    public void setChargebackOfId(Transfers chargebackOfId) {
        this.chargebackOfId = chargebackOfId;
    }

    public ScheduledPayments getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(ScheduledPayments scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }

    public TransactionFees getFeeId() {
        return feeId;
    }

    public void setFeeId(TransactionFees feeId) {
        this.feeId = feeId;
    }

    public Accounts getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Accounts toAccountId) {
        this.toAccountId = toAccountId;
    }

    @XmlTransient
    public Collection<Refs> getRefsCollection() {
        return refsCollection;
    }

    public void setRefsCollection(Collection<Refs> refsCollection) {
        this.refsCollection = refsCollection;
    }

    @XmlTransient
    public Collection<TransferAuthorizations> getTransferAuthorizationsCollection() {
        return transferAuthorizationsCollection;
    }

    public void setTransferAuthorizationsCollection(Collection<TransferAuthorizations> transferAuthorizationsCollection) {
        this.transferAuthorizationsCollection = transferAuthorizationsCollection;
    }

    @XmlTransient
    public Collection<AccountRates> getAccountRatesCollection() {
        return accountRatesCollection;
    }

    public void setAccountRatesCollection(Collection<AccountRates> accountRatesCollection) {
        this.accountRatesCollection = accountRatesCollection;
    }

    @XmlTransient
    public Collection<AmountReservations> getAmountReservationsCollection() {
        return amountReservationsCollection;
    }

    public void setAmountReservationsCollection(Collection<AmountReservations> amountReservationsCollection) {
        this.amountReservationsCollection = amountReservationsCollection;
    }

    @XmlTransient
    public Collection<Loans> getLoansCollection() {
        return loansCollection;
    }

    public void setLoansCollection(Collection<Loans> loansCollection) {
        this.loansCollection = loansCollection;
    }

    @XmlTransient
    public Collection<InvoicePayments> getInvoicePaymentsCollection() {
        return invoicePaymentsCollection;
    }

    public void setInvoicePaymentsCollection(Collection<InvoicePayments> invoicePaymentsCollection) {
        this.invoicePaymentsCollection = invoicePaymentsCollection;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    @XmlTransient
    public Collection<MemberAccountFeeLogs> getMemberAccountFeeLogsCollection() {
        return memberAccountFeeLogsCollection;
    }

    public void setMemberAccountFeeLogsCollection(Collection<MemberAccountFeeLogs> memberAccountFeeLogsCollection) {
        this.memberAccountFeeLogsCollection = memberAccountFeeLogsCollection;
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
        if (!(object instanceof Transfers)) {
            return false;
        }
        Transfers other = (Transfers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transfers[ id=" + id + " ]";
    }
    
}
