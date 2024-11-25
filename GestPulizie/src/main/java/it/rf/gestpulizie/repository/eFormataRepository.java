package it.rf.gestpulizie.repository;

import java.sql.Date;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.model.eFormata;

public interface eFormataRepository extends JpaRepository<eFormata, Long>{
	
	@Query( value="UPDATE e_formata SET Responsabile_squadra='1' WHERE cf_operaio=:cfOperaio AND id_squadra=:idSquadra AND responsabile_squadra=:responsabileSquadra"
		    , nativeQuery = true)
	void setResponsabile(Boolean responsabileSquadra, Long idSquadra, String []cfOperaio);
	
	@Query( value="SELECT DISTINCT data_creazione FROM e_formata WHERE id_squadra=:squadraDaMod"
		    , nativeQuery = true)
	public LocalDate findDataCreazione(Long squadraDaMod);
	
	@Query( value="SELECT * FROM e_formata WHERE cf_operaio=?1;"
		    , nativeQuery = true)
	public Squadra findSquadraByCfOperaio(Operaio cfOperaio);
	
	@Query( value="SELECT * FROM e_formata WHERE cf_operaio=?1;"
		    , nativeQuery = true)
	public eFormata findCfOperaioInEformata(String cfOperaio);
	
	@Query( value="SELECT COUNT(e_formata.cf_operaio) FROM e_formata WHERE e_formata.id_squadra=?1"
		    , nativeQuery = true)
	public Integer countCfOperaioByIdSquadra(Long idSquadra);
	
}
