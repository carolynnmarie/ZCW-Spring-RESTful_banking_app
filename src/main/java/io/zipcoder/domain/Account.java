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

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private AccountType type;

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
        return type.getType();
    }

    public void setType(AccountType type) {
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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


    public Double getNewBalance(){
        return balance + getDepositsTotal() - getWithdrawalTotal();
    }

    public Double getDepositsTotal(){
        Double d = 0.0;
        for(Deposit deposit: deposits){
            d += deposit.getAmount();
        };
        d = Math.round(d * 100d)/100d;
        return d;
    }

    public Double getWithdrawalTotal(){
        Double wTotal = 0.0;
        for(Withdrawal withdrawal: withdrawals){
            wTotal += withdrawal.getAmount();
        }
        wTotal = Math.round(wTotal * 100d)/100d;
        return wTotal;
    }

}
