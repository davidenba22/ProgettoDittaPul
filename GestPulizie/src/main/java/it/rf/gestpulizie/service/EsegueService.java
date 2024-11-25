package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Esegue;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.repository.EsegueRepository;

@Service
public class EsegueService {
	
	@Autowired
	private EsegueRepository esegueR;
	
	public void addEsegue(Esegue es) {
		esegueR.save(es);
	}
	
	public void deleteEsegueByIdLav(Long idLavorazione) {
		esegueR.deleteById(idLavorazione);
	}
	
	public Optional<Esegue>ricercaById(Long idEsegue) {
		return this.esegueR.findById(idEsegue);
	}
	
	public Optional<Esegue>ricercaByIdLavInEsegue(Long idLavorazione) {
		return this.esegueR.findByIdLavInEsegue(idLavorazione);
	}
	
	public Long findSquadraByIdLavInEsegue(Long idLavorazione) {
		return this.esegueR.findSquadraByIdLavInEsegue(idLavorazione);
	}
	
}
