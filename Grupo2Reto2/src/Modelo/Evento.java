package Modelo;

public class Evento {
	private String idEvento;
	private String tipoEvento;


	public Evento() {
		idEvento="";
		tipoEvento="";
	}
	
	public Evento(String idEvento,String tipoEvento ) {
		this.idEvento=idEvento;
		this.tipoEvento=tipoEvento;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", tipoEvento=" + tipoEvento + "]";
	}
	
}