package it.rf.gestpulizie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface OperaioRepository extends JpaRepository<Operaio, String>{	
	@Query(
		nativeQuery = true, 
	    value="SELECT * FROM Operaio WHERE nome_operaio=:nomeOperaio AND cognome_operaio=:cognomeOperaio OR cf_operaio=:cfOperaio")
	public Optional<Operaio> findByNomeOperaioAndCognomeOperaioOrCfOperaio(String nomeOperaio, String cognomeOperaio, String cfOperaio);
	
	/*@Query(nativeQuery = true, 
		    value="SELECT * FROM operaio WHERE cf_operaio=?1 OR user_operaio=?2")
	public Optional<Operaio> findByCfOrUser(String cfOperaio, String userOperaio);*/
	
	@Query(nativeQuery = true, 
		    value="SELECT * FROM Operaio WHERE user_operaio=?1 AND pwd_operaio=?2 ")
	public Optional<Operaio> findOperaioByUserAndPwd(String userOp, String pwdOp);
	
	@Query(nativeQuery = true, 
		    value="SELECT * FROM Operaio WHERE user_operaio=?1")
	public Optional<Operaio> findUserOperaio(String userOp);
	
	@Query(nativeQuery = true, 
		    value="SELECT * FROM Operaio WHERE pwd_operaio=?1")
	public Optional<Operaio> findPwdOperaio(String pwdOp);
	
	@Query( value="SELECT operaio.* FROM (SELECT e_formata.cf_operaio FROM squadra\r\n"
    		+ "JOIN e_formata ON e_formata.id_Squadra=squadra.ID_Squadra\r\n"
    		+ "WHERE squadra.Data_operativita=?1)\r\n"
    		+ "AS partecipanti RIGHT JOIN operaio ON partecipanti.cf_operaio=operaio.cf_operaio\r\n"
    		+ "WHERE partecipanti.cf_operaio IS NULL\r\n"
    		+ "AND operaio.stato_operativita='1'\r\n"
    		+ "AND id_categoria>1", nativeQuery = true)
	public List<Operaio> findByOperaiDisponibili(Date  dataOperativita);
	
	
		
}
