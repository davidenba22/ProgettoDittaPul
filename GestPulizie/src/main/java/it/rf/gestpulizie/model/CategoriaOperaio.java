package it.rf.gestpulizie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CategoriaOperaio")
public class CategoriaOperaio {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column
	private String nomeCategoria;
	
	@Column
	private Double Stipendio;
	
	@Column
	@OneToMany(mappedBy="opCat")
	private List<Operaio> elencoOperaio;
	
	public CategoriaOperaio() {}

	public CategoriaOperaio(Long idCategoria, String nomeCategoria, Double stipendio, List<Operaio> elencoOperaio) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		Stipendio = stipendio;
		this.elencoOperaio = elencoOperaio;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Double getStipendio() {
		return Stipendio;
	}

	public void setStipendio(Double stipendio) {
		Stipendio = stipendio;
	}

	public List<Operaio> getElencoOperaio() {
		return elencoOperaio;
	}

	public void setElencoOperaio(List<Operaio> elencoOperaio) {
		this.elencoOperaio = elencoOperaio;
	}

}
