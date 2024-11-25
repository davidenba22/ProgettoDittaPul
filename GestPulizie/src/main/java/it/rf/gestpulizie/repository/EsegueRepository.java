package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Esegue;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Squadra;

@Repository
public interface EsegueRepository extends JpaRepository<Esegue, Long>{
	
	@Query(value="SELECT * FROM esegue WHERE id_lavorazione=?1",nativeQuery=true)
	public Optional<Esegue> findByIdLavInEsegue(Long idLavorazione);
	
	@Query(value="SELECT esegue.id_squadra FROM esegue WHERE id_lavorazione=?1",nativeQuery=true)
	public Long findSquadraByIdLavInEsegue(Long idLavorazione);
}
