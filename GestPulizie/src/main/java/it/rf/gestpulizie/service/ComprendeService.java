package it.rf.gestpulizie.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.DTO.datiLavDTO;
import it.rf.gestpulizie.DTO.serviziDiLavDTO;
import it.rf.gestpulizie.model.Comprende;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.repository.ComprendeRepository;

@Service
public class ComprendeService {
	@Autowired
	private ComprendeRepository comRep;
	
	public void salvaComprende(Comprende com) {
		comRep.save(com);
	}
	
	public void deleteComprendeByIdLav(Long idLavorazione) {
		comRep.deleteById(idLavorazione);
	}
	
	public Optional<Comprende> findById(Long idComprende){
		return this.comRep.findById(idComprende);
	}
	
	public List<datiLavDTO> elencoInterventiVarieSedi(Date dataDaRic, Operaio op){
		return this.comRep.elencoInterventiVarieSedi(dataDaRic, op);
	}
	
	public List<datiLavDTO> elencoInterventiVarieSedi(Date dataDaRic){
		return this.comRep.elencoInterventiVarieSedi(dataDaRic);
	}
	
	public List<datiLavDTO> elencoInterventiPeriodoDiTempo(Date dataInizioPeriodo, Date dataFinePeriodo, Operaio cfOp){
		return this.comRep.elencoInterventiPeriodoDiTempo(dataInizioPeriodo, dataFinePeriodo, cfOp);
	}
	
	public List<serviziDiLavDTO> elencoServiziSingolaLavorazione(Long idLav, Operaio op){
		return this.comRep.elencoServiziSingolaLavorazione(idLav, op);
	}
	
	public Boolean spuntaServizio(Long idComprende) {
		
		this.comRep.spuntaServizio(idComprende);
		
		return true;
	}
	
	public List<Comprende> serviziSceltiPerIntervento(Long idLavorazione){
		return this.comRep.serviziSceltiPerIntervento(idLavorazione);
	}
	
	public Long findIdServizioDaEliminare(Long servScelto) {
		return this.comRep.findIdServizioDaEliminare(servScelto);
	}
	
	public void deleteServizio(Long servScelto) {
		comRep.deleteById(servScelto);
	}
	
	/*public boolean spuntaServizio(Comprende c) {
		
		return this.comRep.save(c) != null;
	
	}*/
}
