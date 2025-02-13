package Modelo;

public class Alojamiento {
	
	private String idEvento;
	private String nombreEvento;
	private String precio;
	private String nombreHotel;
	private String ciudad;
	private String fecEntrada;
	private String fecSalida;
	private String tipoHab="Doble";
	private Viaje viaje;

	public Alojamiento(){
		idEvento="";
		nombreEvento="";
		precio="";
		nombreHotel="";
		ciudad="";
		fecEntrada="";
		fecSalida="";
		tipoHab="";
		viaje = new Viaje();
	}

	
	Alojamiento(String idEvento, String nombreEvento, String precio,String nombreHotel, String ciudad,String fecEntrada,String fecSalida,String tipHab, Viaje viaje ){
		
		this.idEvento=idEvento;
		this.nombreEvento=nombreEvento;
		this.precio=precio;
		this.nombreHotel=nombreHotel;
		this.ciudad=ciudad;
		this.fecEntrada=fecEntrada;
		this.fecSalida=fecSalida;
		this.tipoHab=tipHab;
		this.viaje=viaje;

	}


	public String getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}


	public String getNombreEvento() {
		return nombreEvento;
	}


	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
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


	public Viaje getViaje() {
		return viaje;
	}


	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}


	@Override
	public String toString() {
		return "Alojamiento [idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", precio=" + precio
				+ ", nombreHotel=" + nombreHotel + ", ciudad=" + ciudad + ", fecEntrada="
				+ fecEntrada + ", fecSalida=" + fecSalida + ", tipoHab=" + tipoHab + ", viaje=" + viaje + "]";
	}
	
}
	