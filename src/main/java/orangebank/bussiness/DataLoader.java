package orangebank.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import orangebank.repository.AccountBalanceRepository;
import orangebank.entity.*;
@Component
public class DataLoader  implements ApplicationRunner {
    
    @Autowired
    AccountBalanceRepository AccountBalance;
    


    @Override
    public void run(ApplicationArguments args) throws Exception {
        AccountBalance.save(new AccountBalance("ES9820385778983000760236",55555.7));
    }

}
