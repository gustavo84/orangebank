package orangebank.entity;

public class SearchResponse {

    public enum Status {SETTLED,INVALID,PENDING;}
    
    private Status status;
}
