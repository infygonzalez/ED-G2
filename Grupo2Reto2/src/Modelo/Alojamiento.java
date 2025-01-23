package Modelo;

public class Alojamiento extends Evento{
	
	private String nombreHotel;
	private String ciudad;
	private String fecSalida;
	private String tipoHab="Doble";

	Alojamiento(){
		super();
		nombreHotel="";
		ciudad="";
		fecSalida="";
		tipoHab="";
	}

	Alojamiento(String idEvento, String nombreEvento, String precio,String fecha,String nombreHotel, String ciudad,String fecSalida,String tipHab ){
		
		super(idEvento,nombreEvento,precio,fecha);
		this.nombreHotel=nombreHotel;
		this.ciudad=ciudad;
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

	@Override
	public String toString() {
		return super.toString()+"Alojamiento [nombreHotel=" + nombreHotel + ", ciudad=" + ciudad + ", fecSalida=" + fecSalida
				+ ", tipoHab=" + tipoHab + "]";
	}


}