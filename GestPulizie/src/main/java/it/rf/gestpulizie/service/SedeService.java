package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Sede;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.repository.SedeRepository;

@Service
public class SedeService {
	
	@Autowired 
	private SedeRepository sr;
	
	public Boolean addSede(Sede s) {
		sr.save(s);
		return true;
	}
	
	public List<Sede> findSedeByCfCliente(String cfCliente){
		
		List<Sede> sedi=sr.findClienteByCfCliente(cfCliente);
		return sedi;
	}
	
	public List<Sede> findSedeByCfClienteOrNomeAndCognomeCliente(String cfCliente, String nomeCliente, String cognomeCliente){
		
		List<Sede> sedi=sr.findSedeByCfClienteOrNomeAndCognomeCliente(cfCliente, nomeCliente, cognomeCliente);
		return sedi;
	}
	
	public Sede findByIdSede(Long idSede){
		
		Sede trv=sr.findIdSede(idSede);
		return trv;
	}
	
	public Optional<Sede> ricercaById(Long idSede) {
		return this.sr.findById(idSede);
	}
	
	public List<Sede> findByNomeSedeAndCittaSede(String nomeSede, String cittaSede) {
		return this.sr.findByNomeSedeAndCittaSede(nomeSede, cittaSede);
	}
	
	public Optional<Sede> findByNomeSedeAndCittaOptional(String nomeSede, String cittaSede) {
		return this.sr.findByNomeSedeAndCittaOptional(nomeSede, cittaSede);
	}
	
	public List<Sede> elencoSedi(){
		return this.sr.findAll();
	}
	
	public boolean updateSede(Sede s) {
        return sr.save(s) != null;
    }
	
	public Boolean deleteSede(Long idSede) {
		Optional<Sede> sedeTrv=sr.findById(idSede);
        
        if (sedeTrv.isPresent()) {
        	sr.delete(sedeTrv.get());
            return true;
        } 
        else {
            return false;
        }
	}
}
