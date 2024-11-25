package it.rf.gestpulizie.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Squadra")
public class Squadra {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSquadra;
	
	@Column
	private String nomeSquadra;
	
	@Column
	private Date dataOperativita;
	
	@Column
	private String descrizioneSquadra;
	
	@Column
	private Boolean Finta;
	
	@Column
	@OneToMany(mappedBy = "sqFormata")
	private List<eFormata> elencoEformata;
	
	@Column
	@OneToMany(mappedBy = "sqEsegue")
	private List<Esegue> elencoEsegue;
	
	@Column
	private Integer totMinutiSquadra;
	
	@Column
	private Integer minutiSquadraAccumulati;
	
	public Squadra() {}

	public Squadra(Long idSquadra, String nomeSquadra, Date dataOperativita, String descrizioneSquadra, Boolean finta,
			List<eFormata> elencoEformata, List<Esegue> elencoEsegue, Integer totMinutiSquadra,
			Integer minutiSquadraAccumulati) {
		super();
		this.idSquadra = idSquadra;
		this.nomeSquadra = nomeSquadra;
		this.dataOperativita = dataOperativita;
		this.descrizioneSquadra = descrizioneSquadra;
		Finta = finta;
		this.elencoEformata = elencoEformata;
		this.elencoEsegue = elencoEsegue;
		this.totMinutiSquadra = totMinutiSquadra;
		this.minutiSquadraAccumulati = minutiSquadraAccumulati;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public Date getDataOperativita() {
		return dataOperativita;
	}

	public void setDataOperativita(Date dataOperativita) {
		this.dataOperativita = dataOperativita;
	}

	public String getDescrizioneSquadra() {
		return descrizioneSquadra;
	}

	public void setDescrizioneSquadra(String descrizioneSquadra) {
		this.descrizioneSquadra = descrizioneSquadra;
	}

	public Boolean getFinta() {
		return Finta;
	}

	public void setFinta(Boolean finta) {
		Finta = finta;
	}

	public List<eFormata> getElencoEformata() {
		return elencoEformata;
	}

	public void setElencoEformata(List<eFormata> elencoEformata) {
		this.elencoEformata = elencoEformata;
	}

	public List<Esegue> getElencoEsegue() {
		return elencoEsegue;
	}

	public void setElencoEsegue(List<Esegue> elencoEsegue) {
		this.elencoEsegue = elencoEsegue;
	}

	public Integer getTotMinutiSquadra() {
		return totMinutiSquadra;
	}

	public void setTotMinutiSquadra(Integer totMinutiSquadra) {
		this.totMinutiSquadra = totMinutiSquadra;
	}

	public Integer getMinutiSquadraAccumulati() {
		return minutiSquadraAccumulati;
	}

	public void setMinutiSquadraAccumulati(Integer minutiSquadraAccumulati) {
		this.minutiSquadraAccumulati = minutiSquadraAccumulati;
	}

}
