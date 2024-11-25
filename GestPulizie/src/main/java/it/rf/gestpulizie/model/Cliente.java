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
@Table(name="Cliente")
public class Cliente {

	@Column
	private String nomeCliente;
	
	@Column
	private String cognomeCliente;
	
	@Column
	@Id
	private String cfCliente;
	
	@Column
	private String userCliente;
	
	@Column
	private String pwdCliente;
	
	@Column
	@OneToMany(mappedBy = "clAppSede")
	private List<AppSede> elencoSediClienti;
	
	public Cliente() {}

	public Cliente(String nomeCliente, String cognomeCliente, String cfCliente, String userCliente, String pwdCliente,
			List<AppSede> elencoSediClienti) {
		super();
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.cfCliente = cfCliente;
		this.userCliente = userCliente;
		this.pwdCliente = pwdCliente;
		this.elencoSediClienti = elencoSediClienti;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getCfCliente() {
		return cfCliente;
	}

	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}

	public String getUserCliente() {
		return userCliente;
	}

	public void setUserCliente(String userCliente) {
		this.userCliente = userCliente;
	}

	public String getPwdCliente() {
		return pwdCliente;
	}

	public void setPwdCliente(String pwdCliente) {
		this.pwdCliente = pwdCliente;
	}

	public List<AppSede> getElencoSediClienti() {
		return elencoSediClienti;
	}

	public void setElencoSediClienti(List<AppSede> elencoSediClienti) {
		this.elencoSediClienti = elencoSediClienti;
	}

}
