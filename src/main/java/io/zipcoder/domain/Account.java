package io.zipcoder.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name ="ACCOUNT_ID")
    private Long id;

    @Column(name = "ACCOUNT_TYPE")
    private String type;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "REWARDS")
    private Integer rewards;

    @Column(name="BALANCE")
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPOSIT_ID")
    private LinkedHashSet<Deposit> deposits;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "WITHDRAWAL_ID")
    private LinkedHashSet<Withdrawal> withdrawals;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Double getBalance() {
        return balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }

    public LinkedHashSet<Deposit> getDeposits() {
        return deposits;
    }
    public void setDeposits(LinkedHashSet<Deposit> deposits) {
        this.deposits = deposits;
    }

    public LinkedHashSet<Withdrawal> getWithdrawals() {
        return withdrawals;
    }
    public void setWithdrawals(LinkedHashSet<Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }


}
