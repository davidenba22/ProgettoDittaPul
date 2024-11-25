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
@Table(name="Esegue")
public class Esegue {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsecuzione;
	
	@ManyToOne
	@JoinColumn(name="idSquadra")
	private Squadra sqEsegue;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="idLavorazione")
	private Lavorazione lvEsegue;
	
	@ManyToOne
	@JoinColumn(name="idSede")
	private Sede sedeEsegue;
	
	@Column
	private LocalDate dataLavoroEseguito;
	
	@Column
	private String noteEsecuzione;
	
	@Column
	private Boolean completato;
	
	public Esegue() {}

	public Esegue(Long idEsecuzione, Squadra sqEsegue, Lavorazione lvEsegue, Sede sedeEsegue, LocalDate dataLavoroEseguito,
			String noteEsecuzione, Double acconto, Boolean completato) {
		super();
		this.idEsecuzione = idEsecuzione;
		this.sqEsegue = sqEsegue;
		this.lvEsegue = lvEsegue;
		this.sedeEsegue = sedeEsegue;
		this.dataLavoroEseguito = dataLavoroEseguito;
		this.noteEsecuzione = noteEsecuzione;
		this.completato = completato;
	}

	public Long getIdEsecuzione() {
		return idEsecuzione;
	}

	public void setIdEsecuzione(Long idEsecuzione) {
		this.idEsecuzione = idEsecuzione;
	}

	public Squadra getSqEsegue() {
		return sqEsegue;
	}

	public void setSqEsegue(Squadra sqEsegue) {
		this.sqEsegue = sqEsegue;
	}

	public Lavorazione getLvEsegue() {
		return lvEsegue;
	}

	public void setLvEsegue(Lavorazione lvEsegue) {
		this.lvEsegue = lvEsegue;
	}

	public Sede getSedeEsegue() {
		return sedeEsegue;
	}

	public void setSedeEsegue(Sede sedeEsegue) {
		this.sedeEsegue = sedeEsegue;
	}

	public LocalDate getDataLavoroEseguito() {
		return dataLavoroEseguito;
	}

	public void setDataLavoroEseguito(LocalDate dataLavoroEseguito) {
		this.dataLavoroEseguito = dataLavoroEseguito;
	}

	public String getNoteEsecuzione() {
		return noteEsecuzione;
	}

	public void setNoteEsecuzione(String noteEsecuzione) {
		this.noteEsecuzione = noteEsecuzione;
	}

	public Boolean getCompletato() {
		return completato;
	}

	public void setCompletato(Boolean completato) {
		this.completato = completato;
	}
	
}
