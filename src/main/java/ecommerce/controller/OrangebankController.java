package ecommerce.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bussiness.OrangebankBussiness;
import ecommerce.entity.AccountBalance;
import ecommerce.entity.SearchResponse;
import ecommerce.entity.SearchTransaction;
import ecommerce.entity.Price;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrangebankController {
    
    public enum OrderBy {ASC,DESC}
    
    @Autowired
    private OrangebankBussiness orangebankBussiness;
    
    @RequestMapping(method = RequestMethod.POST,value="/accounts/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody Price transaction) {

        try {
            orangebankBussiness.createTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    
    @RequestMapping(method = RequestMethod.POST,value="/accounts/transactions/searches")
    public ResponseEntity<?>  searchTransactions(@RequestBody SearchTransaction searchTransaction) {
        
        try {
            SearchResponse searchresponse = orangebankBussiness.searchTransactions(searchTransaction);
            return new ResponseEntity<>(searchresponse,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        

    }
    
    
    @RequestMapping(method = RequestMethod.GET,value="/accounts/account/searches")
    public ResponseEntity<?>  searchTransactionByAccountIban(@RequestParam String accountIban,@RequestParam(defaultValue ="ASC") OrderBy order) {
            List<Price> listAccount = orangebankBussiness.searchTransactionByAccountIban(accountIban,order);
            return new ResponseEntity<>(listAccount,HttpStatus.OK);
    }
}
