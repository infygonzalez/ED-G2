package Modelo;

public class Otros {
	
	private String idEvento;
	private String nombreEvento;
	private String precio;
	private String fecha;
	private String descripcion;
	private Viaje viaje;
	public Otros(){
		idEvento="";
		nombreEvento="";
		precio="";
		fecha="";
		descripcion="";
		viaje= new Viaje();
		
}
	
	Otros(String idEvento, String nombreEvento, String precio,String fecha, String descripcion,Viaje viaje){
		this.idEvento=idEvento;
		this.nombreEvento=nombreEvento;
		this.precio=precio;
		this.fecha=fecha;
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
				+ fecha + ", descripcion=" + descripcion + ", viaje=" + viaje + "]";
	}

	
}