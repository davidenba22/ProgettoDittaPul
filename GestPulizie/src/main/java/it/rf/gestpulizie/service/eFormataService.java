package it.rf.gestpulizie.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.model.eFormata;
import it.rf.gestpulizie.repository.eFormataRepository;

@Service
public class eFormataService {
	
	
	@Autowired
	private eFormataRepository efr;
	
	public Boolean addeFormata(eFormata ef) {
		
		efr.save(ef);
		return true;
	}
	
	public Boolean setResponsabile(Boolean Resp, Long idScelto, String []cfOperaio) {
		
		efr.setResponsabile(Resp, idScelto, cfOperaio);
		return true;
	}
	
	public LocalDate ricercaDataCreazioneSquadra(Long squadraDaMod){
		
		LocalDate dataTrv=efr.findDataCreazione(squadraDaMod);
		
		return dataTrv;
	}
	
	public Squadra ricercaSquadraOperaioByCf(Operaio cfOperaio) {
		
		return this.efr.findSquadraByCfOperaio(cfOperaio);
	}
	
	public eFormata findCfOperaioInEformata(String cfOperaio) {
		
		return this.efr.findCfOperaioInEformata(cfOperaio);
	}
	
	public Integer countCfOperaioByIdSquadra(Long idSquadra) {
		return this.efr.countCfOperaioByIdSquadra(idSquadra);
	}
}
