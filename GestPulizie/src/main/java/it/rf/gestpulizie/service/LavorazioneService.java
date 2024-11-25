package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.repository.LavorazioneRepository;

@Service
public class LavorazioneService {
	
	@Autowired
	private LavorazioneRepository lavRep;
	
	public void addLavorazione(Lavorazione lav) {
		
		lavRep.save(lav);
	}
	
	public void deleteLavorazione(Long idLavorazione) {
		lavRep.deleteById(idLavorazione);
	}
	
	public Optional<Lavorazione> trovaPerIdLav(Long idLav)
	{
		return this.lavRep.findById(idLav);
	}
	
	public List<Lavorazione> findLavorazioneByDataEsecuzione(Date dataEsecuzione){
		return this.lavRep.findLavorazioneByDataEsecuzione(dataEsecuzione);
	}
	
	public Lavorazione findByIdLavNoOptional(Long idLav) {
		return this.lavRep.findByIdLav(idLav);
	}
}
