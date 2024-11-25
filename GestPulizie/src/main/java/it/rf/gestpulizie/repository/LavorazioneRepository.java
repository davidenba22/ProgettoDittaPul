package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.gestpulizie.model.Lavorazione;

public interface LavorazioneRepository extends JpaRepository<Lavorazione, Long>{
	@Query(value="SELECT * FROM lavorazione WHERE lavorazione.data_prevista_esecuzione=?1", nativeQuery=true)
	public List<Lavorazione> findLavorazioneByDataEsecuzione(Date dataEsecuzione);
	
	@Query(value="SELECT * FROM lavorazione WHERE id_lavorazione=?1", nativeQuery=true)
	public Lavorazione findByIdLav(Long idLav);
}
