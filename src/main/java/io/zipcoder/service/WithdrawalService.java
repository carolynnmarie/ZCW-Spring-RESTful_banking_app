package io.zipcoder.service;

import io.zipcoder.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {


    WithdrawalRepository withdrawalRepository;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository) {
        this.withdrawalRepository = withdrawalRepository;
    }
}
