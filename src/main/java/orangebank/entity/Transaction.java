package orangebank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    private String reference;
    

    private String accountiban;
    
    private Date date;
    
    private Double amount;
    
    private Double fee;
    
    private String description;

    public Transaction() {}
    
    
    public Transaction(String reference, String account_iban, Date date, Double amount, Double fee,
            String description) {
        super();
        this.reference = reference;
        this.accountiban = account_iban;
        this.date = date;
        this.amount = amount;
        this.fee = fee;
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAccount_iban() {
        return accountiban;
    }

    public void setAccount_iban(String account_iban) {
        this.accountiban = account_iban;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
