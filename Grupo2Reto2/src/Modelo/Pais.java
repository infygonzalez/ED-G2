package Modelo;

public class Pais{
	private String codigoPais;
	private String descripPais;
	
	
	public Pais() {
		codigoPais="";
		descripPais="";
	}
	
	public Pais(String codigoPais, String descripPais) {
		this.codigoPais=codigoPais;
		this.descripPais=descripPais;
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

	@Override
	public String toString() {
		return "Pais [codigoPais=" + codigoPais + ", descripPais=" + descripPais + "]";
	}
	
}

