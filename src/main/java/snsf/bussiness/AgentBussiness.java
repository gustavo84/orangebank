package snsf.bussiness;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import snsf.entity.SnfAgente;
import snsf.repository.AgentRepository;





@Service
public class AgentBussiness {

    @Autowired
    private AgentRepository agentsRepository;
    

	public List<SnfAgente> getAGents() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(agentsRepository.findAll());
	}


}
