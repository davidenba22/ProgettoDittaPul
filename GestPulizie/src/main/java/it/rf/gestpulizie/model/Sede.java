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
@Table(name="Sede")
public class Sede {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSede;
	
	@Column
	private String nomeSede;
	
	@Column
	private String cittaSede;
	
	@Column
	private String viaSede;
	
	
	@Column
	private String pianoSede;
	
	@Column
	@OneToMany(mappedBy = "sedeEsegue")
	private List<Esegue> elencoSedeEsegue;
	
	@Column
	@OneToMany(mappedBy = "nCnSede")
	private List<AppSede> elencoSedeApp;
	
	public Sede() {}

	public Sede(Long idSede, String nomeSede, String cittaSede, String viaSede, String pianoSede,
			List<Esegue> elencoSedeEsegue, List<AppSede> elencoSedeApp) {
		super();
		this.idSede = idSede;
		this.nomeSede = nomeSede;
		this.cittaSede = cittaSede;
		this.viaSede = viaSede;
		this.pianoSede = pianoSede;
		this.elencoSedeEsegue = elencoSedeEsegue;
		this.elencoSedeApp = elencoSedeApp;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public String getNomeSede() {
		return nomeSede;
	}

	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}

	public String getCittaSede() {
		return cittaSede;
	}

	public void setCittaSede(String cittaSede) {
		this.cittaSede = cittaSede;
	}

	public String getViaSede() {
		return viaSede;
	}

	public void setViaSede(String viaSede) {
		this.viaSede = viaSede;
	}

	public String getPianoSede() {
		return pianoSede;
	}

	public void setPianoSede(String pianoSede) {
		this.pianoSede = pianoSede;
	}

	public List<Esegue> getElencoSedeEsegue() {
		return elencoSedeEsegue;
	}

	public void setElencoSedeEsegue(List<Esegue> elencoSedeEsegue) {
		this.elencoSedeEsegue = elencoSedeEsegue;
	}

	public List<AppSede> getElencoSedeApp() {
		return elencoSedeApp;
	}

	public void setElencoSedeApp(List<AppSede> elencoSedeApp) {
		this.elencoSedeApp = elencoSedeApp;
	}

}
