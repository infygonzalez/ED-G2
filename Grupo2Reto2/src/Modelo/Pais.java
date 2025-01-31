package Modelo;

public class Pais{
	
	private String codigoPais;
	private String descripPais;
	private Viaje viaje;
	
	
	public Pais() {
		codigoPais="";
		descripPais="";
		viaje = new Viaje();
	}
	
	public Pais(String codigoPais, String descripPais, Viaje viaje) {
		this.codigoPais=codigoPais;
		this.descripPais=descripPais;
		this.viaje=viaje;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getDescripPais() {
		return descripPais;
	}

	public void setDescripPais(String descripPais) {
		this.descripPais = descripPais;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	@Override
	public String toString() {
		return "Pais [codigoPais=" + codigoPais + ", descripPais=" + descripPais + ", viaje=" + viaje + "]";
	}

	
	
}

