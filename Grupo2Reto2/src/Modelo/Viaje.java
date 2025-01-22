package Modelo;

public class Viaje {
	
	
	private String idViaje;
	private String nombre;
	private String descripcion;
	private String tipoViaje;
	private String fechas;
	private String duracion;
	private String descServicio;
	
	
	Viaje (){
		idViaje="";
		nombre="";
		descripcion="";
		tipoViaje="";
		fechas="";
		duracion="";
		descServicio="";
	}
	
	Viaje(String idViaje, String nombre, String descripcion, String tipoViaje, String fechas, String duracion, String descServicio){
		
		this.idViaje=idViaje;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.tipoViaje=tipoViaje;
		this.fechas=fechas;
		this.duracion=duracion;
		this.descServicio=descServicio;
		
		if(Integer.parseInt(duracion)<0) {
			duracion="0";
		}
	}
	
	
	
	
	public String getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(String idViaje) {
		this.idViaje = idViaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoViaej() {
		return tipoViaje;
	}
	public void setTipoViaej(String tipoViaej) {
		this.tipoViaje = tipoViaej;
	}
	public String getFechas() {
		return fechas;
	}
	public void setFechas(String fechas) {
		this.fechas = fechas;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDescServicio() {
		return descServicio;
	}
	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}

}
