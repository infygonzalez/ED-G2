package Modelo;

public class Aeropuerto {
	
	private String codigoAero;
	private String lugarAero;
	private Vuelo vuelo;
	
	
	
	public Aeropuerto() {
		codigoAero="";
		lugarAero="";
		vuelo = new Vuelo();
		
	}



	public String getCodigoAero() {
		return codigoAero;
	}



	public void setCodigoAero(String codigoAero) {
		this.codigoAero = codigoAero;
	}



	public String getLugarAero() {
		return lugarAero;
	}



	public void setLugarAero(String lugarAero) {
		this.lugarAero = lugarAero;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}



	@Override
	public String toString() {
		return "Aeropuerto [codigoAero=" + codigoAero + ", lugarAero=" + lugarAero + ", vuelo=" + vuelo + "]";
	}
	
	
}
