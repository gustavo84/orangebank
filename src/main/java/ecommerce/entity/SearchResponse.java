package ecommerce.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class SearchResponse {

    public enum Status {SETTLED,INVALID,PENDING,FUTURE;}
    


    private String transaction;
    
    private Status status;
    
    private Double amount;
    
    private Double fee;
      
    public SearchResponse(String transaction, Status status,Double amount, Double fee) {
        super();
        this.transaction = transaction;
        this.status = status;
        this.amount=amount;
        this.fee=fee;
    }
        
    
    public SearchResponse(String transaction, Status status,Double amount) {
        super();
        this.transaction = transaction;
        this.status = status;
        this.amount=amount;
    }
    
    public SearchResponse(String transaction, Status status) {
        super();
        this.transaction = transaction;
        this.status = status;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Double getFee() {
        return fee;
    }


    public void setFee(Double fee) {
        this.fee = fee;
    }
    
    
    
    
        
}
