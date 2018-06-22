package io.zipcoder.domain;

public enum TransactionStatus {
    PENDING("pending"), CANCELLED("cancelled"), COMPLETED("completed");

    String status;

    TransactionStatus(String status){
        this.status = status;
    }


    public String getStatus(){
        return this.status;
    }
}
