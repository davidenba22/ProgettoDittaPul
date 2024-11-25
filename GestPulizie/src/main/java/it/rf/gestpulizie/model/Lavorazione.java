package it.rf.gestpulizie.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Lavorazione")
public class Lavorazione {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLavorazione;
	
	@Column
	private LocalDate dataPrenotazioneLavorazione;
	
	@Column
	private Date dataPrevistaEsecuzione;
	
	@Column
	private String descrizioneLavorazione;
	
	@Column
	@OneToMany(mappedBy = "lvEsegue", cascade=CascadeType.ALL)
	private List<Esegue> elencoEsegue;
	
	@Column
	@OneToMany(mappedBy = "lavComprende")
	private List<Comprende> elencoComprende;
	
	@Column
	private Double prezzoTotale;
	
	@Column
	private Double Acconto;
	
	public Lavorazione() {}

	public Lavorazione(Long idLavorazione, LocalDate dataPrenotazioneLavorazione, Date dataPrevistaEsecuzione,
			String descrizioneLavorazione, List<Esegue> elencoEsegue, List<Comprende> elencoComprende,
			Double prezzoTotale, Double acconto) {
		super();
		this.idLavorazione = idLavorazione;
		this.dataPrenotazioneLavorazione = dataPrenotazioneLavorazione;
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
		this.descrizioneLavorazione = descrizioneLavorazione;
		this.elencoEsegue = elencoEsegue;
		this.elencoComprende = elencoComprende;
		this.prezzoTotale = prezzoTotale;
		Acconto = acconto;
	}

	public Long getIdLavorazione() {
		return idLavorazione;
	}

	public void setIdLavorazione(Long idLavorazione) {
		this.idLavorazione = idLavorazione;
	}

	public LocalDate getDataPrenotazioneLavorazione() {
		return dataPrenotazioneLavorazione;
	}

	public void setDataPrenotazioneLavorazione(LocalDate dataPrenotazioneLavorazione) {
		this.dataPrenotazioneLavorazione = dataPrenotazioneLavorazione;
	}

	public Date getDataPrevistaEsecuzione() {
		return dataPrevistaEsecuzione;
	}

	public void setDataPrevistaEsecuzione(Date dataPrevistaEsecuzione) {
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
	}

	public String getDescrizioneLavorazione() {
		return descrizioneLavorazione;
	}

	public void setDescrizioneLavorazione(String descrizioneLavorazione) {
		this.descrizioneLavorazione = descrizioneLavorazione;
	}

	public List<Esegue> getElencoEsegue() {
		return elencoEsegue;
	}

	public void setElencoEsegue(List<Esegue> elencoEsegue) {
		this.elencoEsegue = elencoEsegue;
	}

	public List<Comprende> getElencoComprende() {
		return elencoComprende;
	}

	public void setElencoComprende(List<Comprende> elencoComprende) {
		this.elencoComprende = elencoComprende;
	}

	public Double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(Double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public Double getAcconto() {
		return Acconto;
	}

	public void setAcconto(Double acconto) {
		Acconto = acconto;
	}

}
