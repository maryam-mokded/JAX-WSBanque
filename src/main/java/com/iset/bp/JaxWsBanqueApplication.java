package com.iset.bp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.iset.bp.dao.CompteRepository;
import com.iset.bp.entities.Compte;


@SpringBootApplication
public class JaxWsBanqueApplication implements CommandLineRunner{

	@Autowired
	private CompteRepository CptRep;
	public static void main(String[] args) {
		SpringApplication.run(JaxWsBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Compte compte1 = new Compte(1, 1000.00, new Date());
		Compte compte2 = new Compte(2, 2000.00, new Date());
		Compte compte3 = new Compte(3, 3000.00, new Date());

		CptRep.save(compte1);
		CptRep.save(compte2);
		CptRep.save(compte3);
	
	}

}
