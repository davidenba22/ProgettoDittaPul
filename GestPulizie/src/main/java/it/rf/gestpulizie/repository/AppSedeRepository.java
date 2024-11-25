package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.AppSede;

@Repository
public interface AppSedeRepository extends JpaRepository<AppSede, Long>{
	
	/*@Query( 
		    value="SELECT * FROM app_sede WHERE cf_cliente=:cfCliente", nativeQuery = true)
	public Optional<AppSede> findClienteByCfCliente(String cfCliente);*/
	
}
