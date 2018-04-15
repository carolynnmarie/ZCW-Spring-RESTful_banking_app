package io.zipcoder.domain;

import javax.persistence.*;

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
}
