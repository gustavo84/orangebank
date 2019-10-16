package orangebank.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import orangebank.bussiness.OrangebankBussiness;
import orangebank.entity.SearchResponse;
import orangebank.entity.SearchTransaction;
import orangebank.entity.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrangebankController {

    @Autowired
    private OrangebankBussiness orangebankBussiness;
    
    @RequestMapping(method = RequestMethod.POST,value="/accounts/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {

        try {
            orangebankBussiness.createTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    
    @RequestMapping(method = RequestMethod.POST,value="/accounts/searches")
    public ResponseEntity<?>  searchTransactions(@RequestBody SearchTransaction searchTransaction) {
        
        try {
            SearchResponse searchresponse = orangebankBussiness.searchTransactions(searchTransaction);
            return new ResponseEntity<>(searchresponse,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        

    }
}
