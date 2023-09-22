package snsf.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import snsf.bussiness.AgentBussiness;
import snsf.entity.SnfAgente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class AgentController {
   
    @Autowired
    private AgentBussiness orangebankBussiness;

    
    
    
    @RequestMapping(method = RequestMethod.GET,value="/agents")
    public ResponseEntity<?>  searchTransactionByAccountIban() {
            List<SnfAgente> listAccount = orangebankBussiness.getAGents();
            return new ResponseEntity<>(listAccount,HttpStatus.OK);
    }
}
