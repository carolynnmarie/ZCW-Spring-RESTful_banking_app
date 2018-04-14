package io.zipcoder.domain;

import javax.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private Long id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PAYEE")
    private String payee;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "CREATION_DATE")
    private String creation_date;

    @Column(name = "PAYMENT_DATE")
    private String payment_date;

    @Column(name = "RECURRING_DATE")
    private Integer recurring_date;

    @Column(name = "UPCOMING_PAYMENT_DATE")
    private String upcoming_payment_date;

    @Column(name = "PAYMENT_AMOUNT")
    private Double payment_amount;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
//    private String account_id;
    private Account account;

    public Bill() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getRecurring_date() {
        return recurring_date;
    }

    public void setRecurring_date(Integer recurring_date) {
        this.recurring_date = recurring_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

//    public String getAccount_id() {
//        return account_id;
//    }
//
//    public void setAccount_id(String account_id) {
//        this.account_id = account_id;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
