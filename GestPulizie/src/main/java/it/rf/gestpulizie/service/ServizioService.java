package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.repository.ServizioRepository;

@Service
public class ServizioService {
	
	@Autowired 
	private ServizioRepository ServRep;
	
	public Boolean addServizio(Servizio serv) {
		ServRep.save(serv);
		return true;
	}
	
	public Boolean deleteServizio(Long idServizio) {
		Optional<Servizio> servizioTrv=ServRep.findById(idServizio);
        
        if (servizioTrv.isPresent()) {
        	ServRep.delete(servizioTrv.get());
            return true;
        } 
        else {
            return false;
        }
	}
	
	public Optional<Servizio> findByNomeServizio(String nomeServizio){
		return this.ServRep.findByNomeServizio(nomeServizio);
	}
	
	public List<Servizio> elencoServizi(){
		
		return this.ServRep.findAll();
	}
	
	public List<Servizio> elencoServiziNonScelti(Long idLavorazione){
		return this.ServRep.elencoServiziNonScelti(idLavorazione);
	}
	
	public Optional<Servizio> trovaServizioPerId(Long idServizio) {
		
		return this.ServRep.findById(idServizio);
	}
	
	public Double prezzoVendita(Long idLav) {
		return this.ServRep.prezzoVendita(idLav);
	}
	
	public List<Servizio> findServizioById(Long idLav){
		return this.ServRep.findServizioByIdLav(idLav);
	}
	
	public boolean updateServizio(Servizio serv) {
        // Qui puoi implementare la logica per aggiornare l'operatore nel database
        return ServRep.save(serv) != null;
    }
	
	public Integer totDurataServizi(Long idLavorazione) {
		return this.ServRep.totDurataServizi(idLavorazione);
	}
}
