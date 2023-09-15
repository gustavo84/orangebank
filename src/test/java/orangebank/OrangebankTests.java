/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package orangebank;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ecommerce.bussiness.OrangebankBussiness;
import ecommerce.entity.Price;
import ecommerce.repository.TransactionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrangebankTests {

    @Autowired
    private OrangebankBussiness business;
    
    @Autowired
    private TransactionRepository transactionRep;

    @Test
    public void createTransactionTest() throws Exception {
        try {
            business.createTransaction(new Price("a", "a", new Date(), 31324.2, 22.3, ""));;
            fail("expected exception was not occured.");
        }catch(Exception e) {
            
        }
        business.createTransaction(new Price("aa01", "ES9820385778983000760236", new Date(), 31324.2, 22.3, ""));
        assertTrue(transactionRep.existsById("aa01"));
        
        
    }

  

}


