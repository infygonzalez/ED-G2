package Modelo;

public class Otros {
	
	private String nombre;
	private String fecha;
	private String precio;
	private String descripcion;
	
	Otros(){
		nombre="";
		fecha="";
		precio="";
		descripcion="";
}
	Otros(String nombre, String fecha, String precio, String descripcion){

		this.nombre=nombre;
		this.fecha=fecha;
		this.precio=precio;
		this.descripcion=descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Otros [nombre=" + nombre + ", fecha=" + fecha + ", precio=" + precio + ", descripcion=" + descripcion
				+ "]";
	}
	
}
