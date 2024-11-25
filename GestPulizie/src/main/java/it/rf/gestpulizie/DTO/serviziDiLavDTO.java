package it.rf.gestpulizie.DTO;

public class serviziDiLavDTO {
	
	private String nomeServizio;
	private Long idComprende;
	
	public serviziDiLavDTO() {}

	public serviziDiLavDTO(String nomeServizio, Long idComprende) {
		super();
		this.nomeServizio = nomeServizio;
		this.idComprende = idComprende;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public Long getIdComprende() {
		return idComprende;
	}

	public void setIdComprende(Long idComprende) {
		this.idComprende = idComprende;
	}

}
