package it.rf.gestpulizie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.repository.AppSedeRepository;


@Service
public class AppSedeService {

	@Autowired 
	private AppSedeRepository asr;
	
	/*public Optional<AppSede> findSedeByCfCliente(String cfCliente){
		
		Optional<AppSede> sedi=asr.findClienteByCfCliente(cfCliente);
		return sedi;
	}*/
	
	public void addAppSede(AppSede contratto) {
		asr.save(contratto);
	}
}
