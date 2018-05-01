package io.zipcoder.domain;

import javax.persistence.*;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "DEPOSIT_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name= "TYPE")
    private TransactionType type;

    @Column(name= "TRANSACTION_DATE")
    private String transaction_date;

    @Enumerated(EnumType.STRING)
    @Column(name= "STATUS")
    private TransactionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "ACCOUNT_ID")
    private Account account;

    @Column(name = "PAYER_ACCOUNT_ID")
    private Long payer_id;

    @Enumerated(EnumType.STRING)
    @Column(name= "MEDIUM")
    private Medium medium;

    @Column(name= "AMOUNT")
    private Double amount;

    @Column(name= "DESCRIPTION")
    private String description;


//    public Deposit(Long id, TransactionType type, String transaction_date, TransactionStatus status,
//                   Account account, Medium medium, Double amount, String description) {
//
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }
    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        payer_id = account.getId();
        this.payer_id = payer_id;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", account_id=" + account.getId() +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
