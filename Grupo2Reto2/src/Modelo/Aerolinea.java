package Modelo;

public class Aerolinea {

	private String codigoAerolinea;
	private String descripcionAerolinea;
	private Vuelo vuelo;
	
	public Aerolinea() {
		codigoAerolinea="";
		descripcionAerolinea="";
		vuelo=new Vuelo();
		
	}
	
	public Aerolinea(String codigoAerolinea, String descripcionAerolinea, Vuelo vuelo ) {
		this.codigoAerolinea = codigoAerolinea;
		this.descripcionAerolinea= descripcionAerolinea;
		this.vuelo=vuelo;
	}

	public String getCodigoAerolinea() {
		return codigoAerolinea;
	}

	public void setCodigoAerolinea(String codigoAerolinea) {
		this.codigoAerolinea = codigoAerolinea;
	}

	public String getDescripcionAerolinea() {
		return descripcionAerolinea;
	}

	public void setDescripcionAerolinea(String descripcionAerolinea) {
		this.descripcionAerolinea = descripcionAerolinea;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	
	@Override
	public String toString() {
		return "Aerolinea [codigoAerolinea=" + codigoAerolinea + ", descripcionAerolinea=" + descripcionAerolinea
				+ ", vuelo=" + vuelo +  "]";
	}

}
