package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Squadra;

@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Long>{
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Squadra WHERE nome_squadra=:nomeSquadra")
		public Optional<Squadra> findByNomeSquadra(String nomeSquadra);
	
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Squadra WHERE id_squadra='1'")
		public Squadra findSqFinta();
	
	@Query(value="SELECT * FROM squadra WHERE data_operativita=?1", nativeQuery=true)
	public List<Squadra> findSquadraByDataEsecuzione(Date dataEsec);
	
	@Query( value="SELECT * FROM squadra WHERE data_operativita=?2 AND nome_squadra=?1", nativeQuery = true)
		public Optional<Squadra> findSquadraByNomeSquadraAndDataEsecuzione(String nomeSquadra, Date dataOperativita);
}
