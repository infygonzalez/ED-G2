package Modelo;

public class Vuelo extends Evento{
	
	private String codigoVuelo;
	private String horaSalida;
	private String duracion;

	Vuelo(){
		super();
		codigoVuelo="";
		horaSalida="";
		duracion="";
	}

	Vuelo(String idEvento, String nombreEvento, String precio,String fecha, String codigoVuelo, String horaSalida,String duracion){
		
		super(idEvento,nombreEvento,precio,fecha);
		this.codigoVuelo=codigoVuelo;
		this.horaSalida=horaSalida;
		this.duracion=duracion;

	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
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
		return super.toString()+"Vuelo [codigoVuelo=" + codigoVuelo + ", horaSalida=" + horaSalida + ", duracion=" + duracion + "]";
	}


}
