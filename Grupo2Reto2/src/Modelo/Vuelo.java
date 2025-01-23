package Modelo;

public class Vuelo {

	private String codigoVuelo;
	private String precio;
	private String fecSalida;
	private String horaSalida;
	private String duracion;

	Vuelo(){
		codigoVuelo="";
		precio="";
		fecSalida="";
		horaSalida="";
		duracion="";
	}

	Vuelo(String codigoVuelo, String precio, String fecSalida, String horaSalida,String duracion){

		this.codigoVuelo=codigoVuelo;
		this.precio=precio;
		this.fecSalida=fecSalida;
		this.horaSalida=horaSalida;
		this.duracion=duracion;

	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecSalida() {
		return fecSalida;
	}

	public void setFecSalida(String fecSalida) {
		this.fecSalida = fecSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Vuelo [codigoVuelo=" + codigoVuelo + ", precio=" + precio + ", fecSalida=" + fecSalida + ", horaSalida="
				+ horaSalida + ", duracion=" + duracion + "]";
	}
	
}
