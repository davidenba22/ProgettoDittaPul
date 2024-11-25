package it.rf.gestpulizie.model;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Comprende")
public class Comprende {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComprende;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="idLavorazione")
	private Lavorazione lavComprende;
	
	@Column
	private String noteComprende;
	
	@Column
	private LocalDate dataAssociazioneComprende;
	
	@Column
	private Boolean fineEsecuzioneServizio;
	
	@ManyToOne
	@JoinColumn(name="idServizio")
	private Servizio servComprende;
	
	public Comprende() {}

	public Comprende(Long idComprende, Lavorazione lavComprende, String noteComprende, LocalDate dataAssociazioneComprende,
			Boolean fineEsecuzioneServizio, Servizio servComprende) {
		super();
		this.idComprende = idComprende;
		this.lavComprende = lavComprende;
		this.noteComprende = noteComprende;
		this.dataAssociazioneComprende = dataAssociazioneComprende;
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
		this.servComprende = servComprende;
	}

	public Long getIdComprende() {
		return idComprende;
	}

	public void setIdComprende(Long idComprende) {
		this.idComprende = idComprende;
	}

	public Lavorazione getLavComprende() {
		return lavComprende;
	}

	public void setLavComprende(Lavorazione lavComprende) {
		this.lavComprende = lavComprende;
	}

	public String getNoteComprende() {
		return noteComprende;
	}

	public void setNoteComprende(String noteComprende) {
		this.noteComprende = noteComprende;
	}

	public LocalDate getDataAssociazioneComprende() {
		return dataAssociazioneComprende;
	}

	public void setDataAssociazioneComprende(LocalDate dataAssociazioneComprende) {
		this.dataAssociazioneComprende = dataAssociazioneComprende;
	}

	public Boolean getFineEsecuzioneServizio() {
		return fineEsecuzioneServizio;
	}

	public void setFineEsecuzioneServizio(Boolean fineEsecuzioneServizio) {
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
	}

	public Servizio getServComprende() {
		return servComprende;
	}

	public void setServComprende(Servizio servComprende) {
		this.servComprende = servComprende;
	}
	
}
