package Modelo;

import java.util.ArrayList;

public class Agencia {

	private String nombre;
	private String colorMarca;
	private String numeroEmpleados;
	private String tipoAgencia;
	private String logo;
	private String clave;
	

	private ArrayList<Viaje>viajes;
	
	public Agencia() {
		nombre="";
		colorMarca="";
		numeroEmpleados="";
		tipoAgencia="";
		logo="";
		clave="";
		ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	}
	
	
	public Agencia(String nombre, String colorMarca, String numeroEmpleados, String tipoAgencia,String logo, String clave,ArrayList<Viaje> viajes) {
		
		this.nombre=nombre;
		this.colorMarca=colorMarca;
		this.numeroEmpleados=numeroEmpleados;
		this.tipoAgencia=tipoAgencia;
		this.logo=logo;
		this.clave=clave;
		this.viajes=viajes;
			
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


	public String getTipoAgencia() {
		return tipoAgencia;
	}


	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public ArrayList<Viaje> getViajes() {
		return viajes;
	}


	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}


	@Override
	public String toString() {
		return "Agencia [nombre=" + nombre + ", colorMarca=" + colorMarca
				+ ", numeroEmpleados=" + numeroEmpleados + ", tipoAgencia=" + tipoAgencia + ", logo=" + logo
				+ ", clave=" + clave + ", viajes=" + viajes + "]";
	}

	
}