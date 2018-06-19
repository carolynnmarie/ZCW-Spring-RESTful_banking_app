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

    @Enumerated(EnumType.STRING)
    @Column(name= "MEDIUM")
    private Medium medium;

    @Column(name= "AMOUNT")
    private Double amount;

    @Column(name= "DESCRIPTION")
    private String description;

    public Deposit(){ }

    public Deposit(Double amount){
        this.amount = amount;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
