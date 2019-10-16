package orangebank.entity;

public class SearchTransaction {
    
  
    public enum Chanel {CLIENT,INTERNAL,ATM}
    
    private String reference;
    
    private Chanel channel;
        

    public SearchTransaction() {
        super();
    }

    public SearchTransaction(String reference, Chanel channel) {
        super();
        this.reference = reference;
        this.channel = channel;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Chanel getChannel() {
        return channel;
    }

    public void setChanel(Chanel channel) {
        this.channel = channel;
    }
    
    
    


}
