package it.rf.gestpulizie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Servizio")
public class Servizio {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServizio;
	
	@Column
	private String nomeServizio;
	
	@Column
	private String descrizioneServizio;
	
	@Column
	private Double prezzoServizio;
	
	@Column
	@OneToMany(mappedBy = "servComprende")
	private List<Comprende> elencoComprende;
	
	@Column
	private Integer durataServizio;
	
	public Servizio () {}

	public Servizio(Long idServizio, String nomeServizio, String descrizioneServizio, Double prezzoServizio,
			List<Comprende> elencoComprende, Integer durataServizio) {
		super();
		this.idServizio = idServizio;
		this.nomeServizio = nomeServizio;
		this.descrizioneServizio = descrizioneServizio;
		this.prezzoServizio = prezzoServizio;
		this.elencoComprende = elencoComprende;
		this.durataServizio = durataServizio;
	}

	public Long getIdServizio() {
		return idServizio;
	}

	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}

	public Double getPrezzoServizio() {
		return prezzoServizio;
	}

	public void setPrezzoServizio(Double prezzoServizio) {
		this.prezzoServizio = prezzoServizio;
	}

	public List<Comprende> getElencoComprende() {
		return elencoComprende;
	}

	public void setElencoComprende(List<Comprende> elencoComprende) {
		this.elencoComprende = elencoComprende;
	}

	public Integer getDurataServizio() {
		return durataServizio;
	}

	public void setDurataServizio(Integer durataServizio) {
		this.durataServizio = durataServizio;
	}

}
