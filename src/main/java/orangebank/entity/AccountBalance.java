package orangebank.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountBalance {
    
    AccountBalance(){}
    
    @Id
    private String accountiban;
    

    

    
    private Double totalAmount;



    public AccountBalance(String accountiban, Double totalAmount) {
        super();
        this.accountiban = accountiban;
        this.totalAmount = totalAmount;
    }



    public String getAccountiban() {
        return accountiban;
    }



    public void setAccountiban(String accountiban) {
        this.accountiban = accountiban;
    }



    public Double getTotalAmount() {
        return totalAmount;
    }



    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    

    
    
    
    

}
