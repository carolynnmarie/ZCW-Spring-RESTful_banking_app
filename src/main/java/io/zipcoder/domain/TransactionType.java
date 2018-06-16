package io.zipcoder.domain;

public enum TransactionType {
    P2P("p2p"), DEPOSIT("deposit"), WITHDRAWAL("withdrawal");

    String type;

    TransactionType(String type){
        this.type = type;
    }
}
