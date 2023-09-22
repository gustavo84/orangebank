package orangebank.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import orangebank.bussiness.OrangebankBussiness;


import orangebank.entity.SnfAgente;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class OrangebankController {
   
    @Autowired
    private OrangebankBussiness orangebankBussiness;

    
    
    
    @RequestMapping(method = RequestMethod.GET,value="/agents")
    public ResponseEntity<?>  searchTransactionByAccountIban() {
            List<SnfAgente> listAccount = orangebankBussiness.getAGents();
            return new ResponseEntity<>(listAccount,HttpStatus.OK);
    }
}
