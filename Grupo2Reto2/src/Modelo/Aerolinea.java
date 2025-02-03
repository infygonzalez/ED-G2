package Modelo;

public class Aerolinea {

	private String codigoAerolinea;
	private String descripcionAerolinea;
	
	public Aerolinea() {
		codigoAerolinea="";
		descripcionAerolinea="";
		
	}
	
	public Aerolinea(String codigoAerolinea, String descripcionAerolinea) {
		this.codigoAerolinea = codigoAerolinea;
		this.descripcionAerolinea= descripcionAerolinea;
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


	
	@Override
	public String toString() {
		return "Aerolinea [codigoAerolinea=" + codigoAerolinea + ", descripcionAerolinea=" + descripcionAerolinea
		+ "]";
	}

}
