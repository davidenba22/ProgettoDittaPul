package it.rf.gestpulizie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Servizio;

@Repository
public interface ServizioRepository extends JpaRepository<Servizio, Long>{
	
	@Query
	(value="SELECT * FROM servizio WHERE nome_servizio=?1", nativeQuery = true)
	public Optional<Servizio> findByNomeServizio(String nomeServizio);
	
	@Query
	(value="SELECT servizio.* FROM servizio JOIN comprende ON comprende.id_servizio=servizio.id_servizio AND comprende.id_lavorazione=?1 ", nativeQuery = true)
	public List<Servizio> findServizioByIdLav(Long idLav);
	
	@Query
	(value="SELECT servizio.*\r\n"
			+ "FROM servizio\r\n"
			+ "WHERE servizio.id_servizio NOT IN (\r\n"
			+ "    SELECT DISTINCT comprende.id_servizio\r\n"
			+ "    FROM comprende\r\n"
			+ "    WHERE comprende.id_lavorazione=?1 \r\n"
			+ ");",nativeQuery=true)
	public List<Servizio> elencoServiziNonScelti(Long idLav);
	
	@Query(value="SELECT SUM(servizio.prezzo_servizio) FROM comprende,servizio WHERE comprende.id_servizio=servizio.id_servizio AND comprende.id_lavorazione=?1", nativeQuery = true)
	public Double prezzoVendita(Long idLav);
	
	@Query(value="SELECT SUM(durata_servizio) FROM servizio JOIN comprende ON servizio.id_servizio=comprende.id_servizio WHERE comprende.id_lavorazione=?1",nativeQuery=true)
	public Integer totDurataServizi(Long idLavorazione);
}
