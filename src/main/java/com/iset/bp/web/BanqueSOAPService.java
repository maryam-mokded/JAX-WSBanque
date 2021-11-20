package com.iset.bp.web;

import java.util.ArrayList;
import java.util.Optional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.iset.bp.dao.CompteRepository;
import com.iset.bp.entities.Compte;

@Component
@WebService
public class BanqueSOAPService {
	
	@Autowired
	private CompteRepository CptRep;
	
	@WebMethod(operationName = "conversionToDT")
	public double conversion(@WebParam(name="montant") double mt ) {
		return mt*3;
	}
	
	 @WebMethod(operationName = "listComptes")
	public ArrayList<Compte> listComptes(){
		ArrayList<Compte> comptes = (ArrayList<Compte>) CptRep.findAll();
		return comptes;
	}
	
	 public Compte getCompte(@WebParam(name="code")long code) {
	
		 Optional<Compte> cpt=CptRep.findById(code);
			if (cpt.isPresent()) { 
				return cpt.get();
			}else throw new RuntimeException("Compte introuvable");

	}
	 
	 public Compte Addcompte(Compte compte){
	    	Optional<Compte> cpt=CptRep.findById(compte.getCode());
			if (cpt.isPresent() == false) { 
				return CptRep.save(compte);
			}else throw new RuntimeException("Ce compte déjà existe");
		
		}
	 
	 
	 
	 
	 public void deletCompte(@WebParam(name = "code")long cd) {
			Optional<Compte> cpt=CptRep.findById(cd);
			if (cpt.isPresent()) { 
				CptRep.deleteById(cd);
		    }else throw new RuntimeException("Compte introuvable on ne peut pas le supprimer");
		}
	 
	 public Compte EditCompte(Compte comptemodif){
			
		
			CptRep.save(comptemodif);

			return comptemodif;
	}
	 
	 

}
