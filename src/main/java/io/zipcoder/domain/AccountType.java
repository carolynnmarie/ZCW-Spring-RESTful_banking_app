package io.zipcoder.domain;

public enum AccountType {
    SAVINGS("savings"), CHECKING("checking"), CREDIT("credit");

    private String type;

    AccountType(String type){
    this.type = type;
}

    public String getType(){
        return this.type;
}

}
