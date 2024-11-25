package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.DTO.datiLavDTO;
import it.rf.gestpulizie.DTO.serviziDiLavDTO;
import it.rf.gestpulizie.model.Comprende;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Operaio;

@Repository
public interface ComprendeRepository extends JpaRepository<Comprende, Long>{
	
	@Query(value="SELECT DISTINCT new it.rf.gestpulizie.DTO.datiLavDTO(lav.idLavorazione, sed.nomeSede, sed.cittaSede, sed.viaSede, sed.pianoSede) "
            + "FROM Servizio serv "
            + "JOIN serv.elencoComprende com "
            + "JOIN com.lavComprende lav "
            + "JOIN lav.elencoEsegue es "
            + "JOIN es.sedeEsegue sed "
            + "JOIN es.sqEsegue sq "
            + "JOIN sq.elencoEformata ef "
            + "WHERE lav.dataPrevistaEsecuzione=?1 AND ef.opF=?2")
	
	public List<datiLavDTO> elencoInterventiVarieSedi(Date dataDaRic, Operaio op);
	
	@Query(value="SELECT DISTINCT new it.rf.gestpulizie.DTO.datiLavDTO(lav.idLavorazione, sed.nomeSede, sed.cittaSede, sed.viaSede, sed.pianoSede) "
            + "FROM Servizio serv "
            + "JOIN serv.elencoComprende com "
            + "JOIN com.lavComprende lav "
            + "JOIN lav.elencoEsegue es "
            + "JOIN es.sedeEsegue sed "
            + "JOIN es.sqEsegue sq "
            + "JOIN sq.elencoEformata ef "
            + "WHERE lav.dataPrevistaEsecuzione=?1")
	
	public List<datiLavDTO> elencoInterventiVarieSedi(Date dataDaRic);
	
	@Query(value="SELECT DISTINCT new it.rf.gestpulizie.DTO.datiLavDTO(lav.idLavorazione, sed.nomeSede, sed.cittaSede, sed.viaSede, sed.pianoSede, lav.dataPrevistaEsecuzione) "
            + "FROM Servizio serv "
            + "JOIN serv.elencoComprende com "
            + "JOIN com.lavComprende lav "
            + "JOIN lav.elencoEsegue es "
            + "JOIN es.sedeEsegue sed "
            + "JOIN es.sqEsegue sq "
            + "JOIN sq.elencoEformata ef "
            + "WHERE ef.opF=?3 "
            + "AND lav.dataPrevistaEsecuzione BETWEEN ?1 AND ?2 AND es.dataLavoroEseguito is not null")
	
	public List<datiLavDTO> elencoInterventiPeriodoDiTempo(Date dataInizioPeriodo, Date dataFinePeriodo, Operaio cfOp);
	
	@Query(value="SELECT new it.rf.gestpulizie.DTO.serviziDiLavDTO( "
			 + "serv.nomeServizio, com.idComprende) "
             + "FROM Servizio serv "
             + "JOIN serv.elencoComprende com "
             + "JOIN com.lavComprende lav "
             + "JOIN lav.elencoEsegue es "
             + "JOIN es.sedeEsegue sed "
             + "JOIN es.sqEsegue sq "
             + "JOIN sq.elencoEformata ef "
             + "WHERE lav.idLavorazione=?1 AND ef.opF=?2 AND com.fineEsecuzioneServizio=false")
	
	public List<serviziDiLavDTO> elencoServiziSingolaLavorazione(Long idLav, Operaio op);
	
	@Query(value="UPDATE comprende SET fine_esecuzione_servizio='1' WHERE comprende.id_comprende=?1",nativeQuery=true)
	public void spuntaServizio(Long idComprende);
	
	@Query(value="SELECT * FROM comprende WHERE id_lavorazione=?1",nativeQuery=true)
	public List<Comprende> serviziSceltiPerIntervento(Long idLavorazione);
	
	@Query(value="SELECT * FROM comprende WHERE id_servizio=?1",nativeQuery=true)
	public Long findIdServizioDaEliminare(Long servScelto);
	
}
