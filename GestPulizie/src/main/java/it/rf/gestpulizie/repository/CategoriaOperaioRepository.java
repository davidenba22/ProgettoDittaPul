package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Operaio;

@Repository
public interface CategoriaOperaioRepository extends JpaRepository<CategoriaOperaio, Long>{
	@Query(
			nativeQuery = true, 
		    value="SELECT * FROM categoria_operaio WHERE nome_categoria=:nomeCategoria")
		Optional<CategoriaOperaio> findByNomeCategoria(String nomeCategoria);
	
	/*@Query(
			nativeQuery = true, 
		    value="SELECT * FROM categoria_operaio WHERE nome_categoria=:nomeCategoria")
		Optional<Long> findByIdCategoria(Long idCategoria);*/
}
