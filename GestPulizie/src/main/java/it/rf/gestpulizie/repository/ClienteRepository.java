package it.rf.gestpulizie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE nome_cliente=?1 AND cognome_cliente=?2 OR cf_cliente=?3")
	public Optional<Cliente> findByNomeClienteAndCognomeClienteOrCfCliente(String nomeCliente, String cognomeCliente, String cfCliente);

	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE nome_cliente=:nomeCliente AND cognome_cliente=:cognomeCliente")
	public Optional<Cliente> findByNomeClienteAndCognomeCliente(String nomeCliente, String cognomeCliente);
	
	@Query(nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE user_cliente=?1")
	public Optional<Cliente> findUserCliente(String userCl);
	
	@Query(nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE pwd_cliente=?1")
	public Optional<Cliente> findPwdCliente(String pwdCl);
	
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE user_cliente=?1 AND pwd_cliente=?2")
	public Optional<Cliente> findByUsernameAndPwd(String username, String pwd);
	
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Cliente WHERE cf_cliente=?1 OR user_cliente=?2")
	public Optional<Cliente> findByCfOrUser(String cfCliente, String userCliente);
	
	
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM Cliente")
	public List<Cliente> findClienti();
}
