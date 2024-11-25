package it.rf.gestpulizie.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="app_sede")
public class AppSede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contratto")
	private Long idContratto;
	
	@Column(name="data_contratto")
	private LocalDate dataContratto;
	
	@ManyToOne
	@JoinColumn(name="id_sede")
	private Sede nCnSede;
	
	@ManyToOne
	@JoinColumn(name="cf_cliente")
	private Cliente clAppSede;
	
	public AppSede() {}

	public AppSede(Long idContratto, LocalDate dataContratto, Sede nCnSede, Cliente clAppSede) {
		super();
		this.idContratto = idContratto;
		this.dataContratto = dataContratto;
		this.nCnSede = nCnSede;
		this.clAppSede = clAppSede;
	}

	public Long getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(Long idContratto) {
		this.idContratto = idContratto;
	}

	public LocalDate getDataContratto() {
		return dataContratto;
	}

	public void setDataContratto(LocalDate dataContratto) {
		this.dataContratto = dataContratto;
	}

	public Sede getnCnSede() {
		return nCnSede;
	}

	public void setnCnSede(Sede nCnSede) {
		this.nCnSede = nCnSede;
	}

	public Cliente getClAppSede() {
		return clAppSede;
	}

	public void setClAppSede(Cliente clAppSede) {
		this.clAppSede = clAppSede;
	}
	
}
