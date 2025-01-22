package Modelo;

public class Agencia {

	private String idAgencia;
	private String nombre;
	private String colorMarca;
	private String numeroEmpleados;
	private String logo;
	
	
	public Agencia() {
		idAgencia="";
		nombre="";
		colorMarca="";
		numeroEmpleados="";
		logo="";
	}
	
	public Agencia(String idAgencia, String nombre, String colorMarca, String numeroEmpleados, String logo) {
		
		this.idAgencia=idAgencia;
		this.nombre=nombre;
		this.colorMarca=colorMarca;
		this.numeroEmpleados=numeroEmpleados;
		this.logo=logo;
		
		if(Integer.parseInt(numeroEmpleados)<0) {
			this.numeroEmpleados="0";
		}
		
		
		
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
	public void setNumeroEmpleados(String numeroEmpleado) {
		this.numeroEmpleados = numeroEmpleado;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	
	
}
