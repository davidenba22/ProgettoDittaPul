package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.repository.SquadraRepository;

@Service
public class SquadraService {
	
	@Autowired
	private SquadraRepository sqRep;
	
	public boolean addSquadra(Squadra s, String nomeSquadra) {
		Optional<Squadra> squadraTrovata=sqRep.findByNomeSquadra(nomeSquadra);
		
		if(squadraTrovata.isPresent()) {
			return false;
		}
		else {
			if(s.getFinta() == null) {
				s.setFinta(false);
			}
			
			sqRep.save(s);
			return true;
		}
	}
	
	public void saveSquadra(Squadra s) {
		sqRep.save(s);
	}
	
	public Optional<Squadra> ricercaSquadraById(Long idSquadra) {
		
		Optional<Squadra> sqTrv=this.sqRep.findById(idSquadra);
		return sqTrv;
	}
	
	public Optional<Squadra> ricercaSquadraByNomeSquadra(String nomeSquadra) {
		
		Optional<Squadra> sqTrv=this.sqRep.findByNomeSquadra(nomeSquadra);
		return sqTrv;
	}
	
	public Squadra findSqFinta() {
		Squadra trv=sqRep.findSqFinta();
		return trv;
	}
	
	public List<Squadra> elencoSquadre(){
		return this.sqRep.findAll();
	}
	
	public List<Squadra> findSquadraByDataEsecuzione(Date dataEsec){
		return this.sqRep.findSquadraByDataEsecuzione(dataEsec);
	}
	
	public Optional<Squadra> findSquadraByNomeSquadraAndDataEsecuzione(String nomeSquadra, Date dataEsec){
		return this.sqRep.findSquadraByNomeSquadraAndDataEsecuzione(nomeSquadra, dataEsec);
	}
}
