package Modelo;

public class Alojamiento {


	private String nombreHotel;
	private String ciudad;
	private String precio;
	private String fecEntrada;
	private String fecSalida;
	private String tipoHab="Doble";

	Alojamiento(){
		nombreHotel="";
		ciudad="";
		precio="";
		fecEntrada="";
		fecSalida="";
		tipoHab="";
	}

	Alojamiento(String nombreHotel, String ciudad, String precio, String fecEntrada,String fecSalida,String tipHab){

		this.nombreHotel=nombreHotel;
		this.ciudad=ciudad;
		this.precio=precio;
		this.fecEntrada=fecEntrada;
		this.fecSalida=fecSalida;
		this.tipoHab=tipHab;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecEntrada() {
		return fecEntrada;
	}

	public void setFecEntrada(String fecEntrada) {
		this.fecEntrada = fecEntrada;
	}

	public String getFecSalida() {
		return fecSalida;
	}

	public void setFecSalida(String fecSalida) {
		this.fecSalida = fecSalida;
	}

	public String getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}

}