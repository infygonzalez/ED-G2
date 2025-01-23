package Modelo;

public class Otros extends Evento{
	
	private String nombre;
	private String descripcion;
	
	Otros(){
		super();
		nombre="";
		descripcion="";
}
	Otros(String idEvento, String nombreEvento, String precio,String fecha,String nombre, String descripcion){
		
		super(idEvento,nombreEvento,precio,fecha);
		this.nombre=nombre;
		this.descripcion=descripcion;
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
	@Override
	public String toString() {
		return super.toString()+"Otros [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
