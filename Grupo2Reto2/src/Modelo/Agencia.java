package Modelo;

import java.util.ArrayList;

public class Agencia {

	private String idAgencia;
	private String nombre;
	private String colorMarca;
	private String numeroEmpleados;
	private String logo;
	private ArrayList<Viaje>viajes;
	
	public Agencia() {
		idAgencia="";
		nombre="";
		colorMarca="";
		numeroEmpleados="";
		logo="";
		ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	}
	
	
	public Agencia(String idAgencia, String nombre, String colorMarca, String numeroEmpleados, String logo, ArrayList<Viaje> viajes) {
		
		this.idAgencia=idAgencia;
		this.nombre=nombre;
		this.colorMarca=colorMarca;
		this.numeroEmpleados=numeroEmpleados;
		this.logo=logo;
		this.viajes=viajes;
			
	}

	public String getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColorMarca() {
		return colorMarca;
	}

	public void setColorMarca(String colorMarca) {
		this.colorMarca = colorMarca;
	}

	public String getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(String numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ArrayList<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Agencia [idAgencia=" + idAgencia + ", nombre=" + nombre + ", colorMarca=" + colorMarca
				+ ", numeroEmpleados=" + numeroEmpleados + ", logo=" + logo + ", viajes=" + viajes + "]";
	}
	
	

	
}