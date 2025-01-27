package Modelo;

public class Vuelo {
	
	private String idEvento;
	private String nombreEvento;
	private String precio;
	private String fecha;
	private String codigoVuelo;
	private String hora;
	private String duracion;
	private Vuelo vueloIda;
	private Viaje viaje;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private Aerolinea aerolinea;

	Vuelo(){
		idEvento="";
		nombreEvento="";
		precio="";
		fecha="";
		codigoVuelo="";
		hora="";
		duracion="";
		vueloIda =new Vuelo();
		viaje = new Viaje();
		aeropuertoOrigen= new Aeropuerto();
		aeropuertoDestino= new Aeropuerto();
		aerolinea = new Aerolinea(); 
		
	}

	
	Vuelo(String idEvento, String nombreEvento, String precio,String fecha, String codigoVuelo, String hora,String duracion,Vuelo vueloIda,Viaje viaje ,Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino,Aerolinea aerolinea){
		
		this.idEvento=idEvento;
		this.nombreEvento=nombreEvento;
		this.precio=precio;
		this.fecha=fecha;
		this.codigoVuelo=codigoVuelo;
		this.hora=hora;
		this.duracion=duracion;
		this.vueloIda=vueloIda;
		this.viaje=viaje;
		this.aeropuertoOrigen=aeropuertoOrigen;
		this.aeropuertoDestino=aeropuertoDestino;
		this.aerolinea=aerolinea;

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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getCodigoVuelo() {
		return codigoVuelo;
	}


	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public Vuelo getVueloIda() {
		return vueloIda;
	}


	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}


	public Viaje getViaje() {
		return viaje;
	}


	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}


	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}


	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}


	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}


	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}


	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}


	@Override
	public String toString() {
		return "Vuelo [idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", precio=" + precio + ", fecha="
				+ fecha + ", codigoVuelo=" + codigoVuelo + ", hora=" + hora + ", duracion=" + duracion + ", vueloIda="
				+ vueloIda + ", viaje=" + viaje + ", aeropuertoOrigen=" + aeropuertoOrigen + ", aeropuertoDestino="
				+ aeropuertoDestino + ", aerolinea=" + aerolinea + "]";
	}

	

}
