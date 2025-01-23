package Modelo;

import java.util.ArrayList;

public class Viaje {
	
	
	private String idViaje;
	private String nombreViaje;
	private String descripcion;
	private String tipoViaje;
	private String fechas;
	private String duracion;
	private String descServicio;
	private Agencia agencia;
	private Pais pais;
	private ArrayList<Evento> evento;
	

	
	
	Viaje (){
		idViaje="";
		nombreViaje="";
		descripcion="";
		tipoViaje="";
		fechas="";
		duracion="";
		descServicio="";
		agencia = new Agencia();
		pais=new Pais();
		ArrayList<Evento> evento = new ArrayList<Evento>();
	}
	
	Viaje(String idViaje, String nombreViaje, String descripcion, String tipoViaje, String fechas, String duracion, String descServicio, Agencia agencia, Pais pais, ArrayList<Evento> evento){
		
		this.idViaje=idViaje;
		this.nombreViaje=nombreViaje;
		this.descripcion=descripcion;
		this.tipoViaje=tipoViaje;
		this.fechas=fechas;
		this.duracion=duracion;
		this.descServicio=descServicio;
		this.agencia= agencia;
		this.pais=pais;
		this.evento=evento;
		
	}

	public String getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(String idViaje) {
		this.idViaje = idViaje;
	}

	public String getNombreViaje() {
		return nombreViaje;
	}

	public void setNombreViaje(String nombreViaje) {
		this.nombreViaje = nombreViaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoViaje() {
		return tipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
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

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", nombreViaje=" + nombreViaje + ", descripcion=" + descripcion
				+ ", tipoViaje=" + tipoViaje + ", fechas=" + fechas + ", duracion=" + duracion + ", descServicio="
				+ descServicio + ", agencia=" + agencia + "]";
	}

	
	
	
}
	