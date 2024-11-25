package it.rf.gestpulizie.model;


import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Operaio {
	
	@Column
	private String nomeOperaio;
	
	@Column
	private String cognomeOperaio;
	
	@Id
	@Column
	private String cfOperaio;
	
	@Column
	private String userOperaio;
	
	@Column
	private String pwdOperaio;
	
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private CategoriaOperaio opCat;
	
	@Column
	private Boolean statoOperativita;
	
	@Column
	@OneToMany(mappedBy = "opF")
	private List<eFormata> elencoEformata;
	
	public Operaio() {}

	public Operaio(String nomeOperaio, String cognomeOperaio, String cfOperaio, String userOperaio, String pwdOperaio,
			CategoriaOperaio opCat, Boolean statoOperativita, List<eFormata> elencoEformata) {
		super();
		this.nomeOperaio = nomeOperaio;
		this.cognomeOperaio = cognomeOperaio;
		this.cfOperaio = cfOperaio;
		this.userOperaio = userOperaio;
		this.pwdOperaio = pwdOperaio;
		this.opCat = opCat;
		this.statoOperativita = statoOperativita;
		this.elencoEformata = elencoEformata;
	}

	public String getNomeOperaio() {
		return nomeOperaio;
	}

	public void setNomeOperaio(String nomeOperaio) {
		this.nomeOperaio = nomeOperaio;
	}

	public String getCognomeOperaio() {
		return cognomeOperaio;
	}

	public void setCognomeOperaio(String cognomeOperaio) {
		this.cognomeOperaio = cognomeOperaio;
	}

	public String getCfOperaio() {
		return cfOperaio;
	}

	public void setCfOperaio(String cfOperaio) {
		this.cfOperaio = cfOperaio;
	}

	public String getUserOperaio() {
		return userOperaio;
	}

	public void setUserOperaio(String userOperaio) {
		this.userOperaio = userOperaio;
	}

	public String getPwdOperaio() {
		return pwdOperaio;
	}

	public void setPwdOperaio(String pwdOperaio) {
		this.pwdOperaio = pwdOperaio;
	}

	public CategoriaOperaio getOpCat() {
		return opCat;
	}

	public void setOpCat(CategoriaOperaio opCat) {
		this.opCat = opCat;
	}

	public Boolean getStatoOperativita() {
		return statoOperativita;
	}

	public void setStatoOperativita(Boolean statoOperativita) {
		this.statoOperativita = statoOperativita;
	}

	public List<eFormata> getElencoEformata() {
		return elencoEformata;
	}

	public void setElencoEformata(List<eFormata> elencoEformata) {
		this.elencoEformata = elencoEformata;
	}

}
