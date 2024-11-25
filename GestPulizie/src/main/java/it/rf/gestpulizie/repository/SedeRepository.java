package it.rf.gestpulizie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Sede;

public interface SedeRepository extends JpaRepository<Sede, Long>{
	
	@Query( nativeQuery = true, 
		    value="SELECT app_sede.data_contratto, sede.*, cliente.nome_cliente, cliente.cognome_cliente \r\n"
		    		+ "FROM sede\r\n"
		    		+ "RIGHT JOIN app_sede ON sede.id_sede=app_sede.id_sede\r\n"
		    		+ "RIGHT JOIN cliente ON cliente.cf_cliente=app_sede.cf_cliente\r\n"
		    		+ "WHERE app_sede.cf_cliente=?1 \r\n"
		    		+ "AND app_sede.data_contratto=(SELECT MAX(app_sede.data_contratto)\r\n"
		    		+ "                             FROM app_sede \r\n"
		    		+ "                             WHERE app_sede.id_sede=sede.id_sede);")
	public List<Sede> findClienteByCfCliente(String cfCliente);
	
	@Query( nativeQuery = true, 
		    value="SELECT app_sede.data_contratto, sede.*, cliente.nome_cliente, cliente.cognome_cliente \r\n"
		    		+ "FROM sede\r\n"
		    		+ "RIGHT JOIN app_sede ON sede.id_sede=app_sede.id_sede\r\n"
		    		+ "RIGHT JOIN cliente ON cliente.cf_cliente=app_sede.cf_cliente\r\n"
		    		+ "WHERE (app_sede.cf_cliente=?1 \r\n"
		    		+ "OR (cliente.nome_cliente=?2 AND cliente.cognome_cliente=?3 ))\r\n"
		    		+ "AND app_sede.data_contratto=(SELECT MAX(app_sede.data_contratto)\r\n"
		    		+ "                             FROM app_sede \r\n"
		    		+ "                             WHERE app_sede.id_sede=sede.id_sede)")
	public List<Sede> findSedeByCfClienteOrNomeAndCognomeCliente(String cfCliente, String nomeCliente, String cognomeCliente);
	
	@Query( nativeQuery = true, 
		    value="SELECT * FROM sede WHERE id_sede=:idSede")
	public Sede findIdSede(Long idSede);
	
	@Query( nativeQuery = true, 
		    value="SELECT * FROM sede WHERE nome_sede=?1 AND citta_sede=?2")
	public List<Sede> findByNomeSedeAndCittaSede(String nomeSede, String cittaSede);
	
	@Query( nativeQuery = true, 
		    value="SELECT * FROM sede WHERE nome_sede=?1 AND citta_sede=?2")
	public Optional<Sede> findByNomeSedeAndCittaOptional(String nomeSede, String cittaSede);
	
}
