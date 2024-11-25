package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.repository.CategoriaOperaioRepository;

@Service
public class CategoriaOperaioService {
	
	@Autowired
	private CategoriaOperaioRepository coR;
	
	public Boolean addCategoria(CategoriaOperaio co) {
		
		coR.save(co);
		return true;
	}
	
	/*public Optional<CategoriaOperaio> ricercaCategoriaId(Long idCategoria) {
		
		Optional<CategoriaOperaio> catTrovata=this.coR.findById(idCategoria);
		return catTrovata;

	}*/
	
	public Optional<CategoriaOperaio> ricercaCategoria(CategoriaOperaio co) {
		//Optional<Operaio> opTrovato=this.or.findById(cfOperaio);
		Optional<CategoriaOperaio> catTrovata=coR.findByNomeCategoria(co.getNomeCategoria());
		return catTrovata;

	}
	
	public List<CategoriaOperaio> ElencoCategoria() {
		List<CategoriaOperaio> elencoCategorie=this.coR.findAll();
		return elencoCategorie;
	}
	
	public CategoriaOperaio ValoreIdCategoria(Long idCategoria) {

		return this.coR.findById(idCategoria).get();
	}
	
	public boolean aggiornaCategoria(CategoriaOperaio co) {
        // Qui puoi implementare la logica per aggiornare l'operatore nel database
        return coR.save(co) != null;
    }
	
}
