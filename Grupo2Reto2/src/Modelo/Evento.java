package Modelo;

public class Evento {
	private String idEvento;
	private String nombreEvento;
	private String precio;
	private String fecha;


	public Evento() {
		idEvento="";
		nombreEvento="";
		precio="";
		fecha="";
	}
	
	public Evento(String idEvento,String nombreEvento,String precio, String fecha ) {
		this.idEvento=idEvento;
		this.nombreEvento=nombreEvento;
		this.precio=precio;
		this.fecha=fecha;
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

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", precio=" + precio + ", fecha="
				+ fecha + "]";
	}




	
}