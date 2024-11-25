package it.rf.gestpulizie.service;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.eFormata;
import it.rf.gestpulizie.repository.OperaioRepository;

@Service
public class OperaioService {
	
	@Autowired
	private OperaioRepository or;
	
	public Boolean addOperaio(Operaio o) {
		or.save(o);
		return true;
	}
	
	public boolean inserisciOperaio(Operaio m, String cfOperaio) {
		
		Optional<Operaio> opTrovato=this.or.findById(cfOperaio);
		
		if(opTrovato.isPresent()) {
			return false;
		}
		else {
			or.save(m);
			return true;
		}
	}
	
	public List<Operaio> elencoOperai(){
		return this.or.findAll();
	}
	
	/*public boolean inserisciOperaio(Operaio op, String cfOperaio, String userOperaio) {
		
		Optional<Operaio> clienteTrovato=this.or.findByCfOrUser(cfOperaio, userOperaio);
		
		if(clienteTrovato.isPresent()) {
			return false;
		}
		else {
			or.save(op);
			return true;
		}
	}*/
	
	public Optional<Operaio> ricercaOperaioCf(String cfOperaio) {
		//Optional<Operaio> opTrovato=this.or.findById(cfOperaio);
		Optional<Operaio> opTrovato=or.findById(cfOperaio);
		return opTrovato;

	}
	
	public Optional<Operaio> ricercaOperaio(String cfOperaio, String nomeOperaio, String cognomeOperaio) {
		//Optional<Operaio> opTrovato=this.or.findById(cfOperaio);
		Optional<Operaio> opTrovato=or.findByNomeOperaioAndCognomeOperaioOrCfOperaio(nomeOperaio, cognomeOperaio, cfOperaio);
		return opTrovato;

	}
	
	public Optional<Operaio> ricercaOperaioByUserAndPwd(String username, String pwd) {
		
		return this.or.findOperaioByUserAndPwd(username, pwd);
	}
	
	public Optional<Operaio> findUserOperaio(String username) {
		
		return this.or.findUserOperaio(username);
	}
	
	public Optional<Operaio> findPwdOperaio(String password) {
		
		return this.or.findPwdOperaio(password);
	}

	public Boolean eliminaOperaio(String cfOperaio) {
        Optional<Operaio> opTrovato = or.findById(cfOperaio);
        
        if (opTrovato.isPresent()) {
            or.delete(opTrovato.get());
            return true;
        } 
        else {
            return false;
        }
		
    }
	
	public boolean aggiornaOperaio(Operaio op) {
        // Qui puoi implementare la logica per aggiornare l'operatore nel database
        return or.existsById(op.getCfOperaio()) && or.save(op) != null;
    }
	
	public List<Operaio> operaiDisp(Date dataOperativita){
		
		List<Operaio> elencoDisponibili=this.or.findByOperaiDisponibili(dataOperativita);
		
		return elencoDisponibili;
	}
	
	/*public Boolean creaSquadra(eFormata ef, Boolean responsabile, String cfOperaio) {
		
		ef.setResponsabileSquadra(responsabile);
		
		for(Operaio opScelti : cfOperaio) {
			ef.setOpF(opScelti);
		}
		
		return true;
	}*/

}
