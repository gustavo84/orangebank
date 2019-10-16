package orangebank.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountBalance {
    
    AccountBalance(){}
    
    @Id
    private String account_iban;
    

    
    private Double totalAmount;



    public AccountBalance(String account_iban, Double totalAmount) {
        super();
        this.account_iban = account_iban;
        this.totalAmount = totalAmount;
    }



    public String getAccount_iban() {
        return account_iban;
    }



    public void setAccount_iban(String account_iban) {
        this.account_iban = account_iban;
    }



    public Double getTotalAmount() {
        return totalAmount;
    }



    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    

    
    
    
    

}
