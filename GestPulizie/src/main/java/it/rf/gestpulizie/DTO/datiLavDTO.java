package it.rf.gestpulizie.DTO;

import java.sql.Date;

public class datiLavDTO {

	private Long idLavorazione;
	private String nomeSede;
	private String cittaSede;
	private String viaSede;
	private String pianoSede;
	private Date dataPrevistaEsecuzione;
	
	public datiLavDTO () {}

	public datiLavDTO(Long idLavorazione, String nomeSede, String cittaSede, String viaSede, String pianoSede,
			Date dataPrevistaEsecuzione) {
		super();
		this.idLavorazione = idLavorazione;
		this.nomeSede = nomeSede;
		this.cittaSede = cittaSede;
		this.viaSede = viaSede;
		this.pianoSede = pianoSede;
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
	}

	public datiLavDTO(Long idLavorazione, String nomeSede, String cittaSede, String viaSede, String pianoSede) {
		super();
		this.idLavorazione = idLavorazione;
		this.nomeSede = nomeSede;
		this.cittaSede = cittaSede;
		this.viaSede = viaSede;
		this.pianoSede = pianoSede;
	}

	public Long getIdLavorazione() {
		return idLavorazione;
	}

	public void setIdLavorazione(Long idLavorazione) {
		this.idLavorazione = idLavorazione;
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

	public Date getDataPrevistaEsecuzione() {
		return dataPrevistaEsecuzione;
	}

	public void setDataPrevistaEsecuzione(Date dataPrevistaEsecuzione) {
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
	}
	
}
