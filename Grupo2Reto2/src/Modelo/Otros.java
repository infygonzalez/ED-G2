package Modelo;

public class Otros {
	
	private String idEvento;
	private String nombreEvento;
	private String precio;
	private String fecha;
	private String nombre;
	private String descripcion;
	private Viaje viaje;
	Otros(){
		idEvento="";
		nombreEvento="";
		precio="";
		fecha="";
		nombre="";
		descripcion="";
		viaje= new Viaje();
		
}
	
	Otros(String idEvento, String nombreEvento, String precio,String fecha,String nombre, String descripcion,Viaje viaje){
		this.idEvento=idEvento;
		this.nombreEvento=nombreEvento;
		this.precio=precio;
		this.fecha=fecha;
		this.nombre=nombre;
		this.descripcion=descripcion;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	public Viaje getViaje() {
		return viaje;
	}
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	@Override
	public String toString() {
		return "Otros [idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", precio=" + precio + ", fecha="
				+ fecha + ", nombre=" + nombre + ", descripcion=" + descripcion + ", viaje=" + viaje + "]";
	}
	
	
	
}