package it.rf.gestpulizie.model;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="eFormata")
public class eFormata {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAssociazioneOperatore;
	
	@Column
	private LocalDate dataCreazione;
	
	@Column
	private Boolean responsabileSquadra;
	
	@ManyToOne
	@JoinColumn(name="cfOperaio")
	private Operaio opF;
	
	@ManyToOne
	@JoinColumn(name="idSquadra")
	private Squadra sqFormata;

	public eFormata() {}

	public eFormata(Long idAssociazioneOperatore, LocalDate dataCreazione, Boolean responsabileSquadra, Operaio opF,
			Squadra sqFormata) {
		super();
		this.idAssociazioneOperatore = idAssociazioneOperatore;
		this.dataCreazione = dataCreazione;
		this.responsabileSquadra = responsabileSquadra;
		this.opF = opF;
		this.sqFormata = sqFormata;
	}

	public Long getIdAssociazioneOperatore() {
		return idAssociazioneOperatore;
	}

	public void setIdAssociazioneOperatore(Long idAssociazioneOperatore) {
		this.idAssociazioneOperatore = idAssociazioneOperatore;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Boolean getResponsabileSquadra() {
		return responsabileSquadra;
	}

	public void setResponsabileSquadra(Boolean responsabileSquadra) {
		this.responsabileSquadra = responsabileSquadra;
	}

	public Operaio getOpF() {
		return opF;
	}

	public void setOpF(Operaio opF) {
		this.opF = opF;
	}

	public Squadra getSqFormata() {
		return sqFormata;
	}

	public void setSqFormata(Squadra sqFormata) {
		this.sqFormata = sqFormata;
	}

}
