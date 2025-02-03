package Modelo;

public class Aeropuerto {
	
	private String codigoAero;
	private String lugarAero;
	
	
	
	public Aeropuerto() {
		codigoAero="";
		lugarAero="";
		
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

	



	@Override
	public String toString() {
		return "Aeropuerto [codigoAero=" + codigoAero + ", lugarAero=" + lugarAero + "]";
	}
	
	
}
