package Modelo;

import java.util.ArrayList;

public class Viaje {
	
	
	private String idViaje;
	private String nombreViaje;
	private String descripcion;
	private String tipoViaje;
	private String fechaIda;
	private String fechaVuelta;
	private String duracion;
	private String descServicio;
	private Agencia agencia;
	private Pais pais;
	private ArrayList<Alojamiento> alojamiento;
	private ArrayList<Vuelo> vuelo;
	private ArrayList<Otros> otros;
	

	
	
	Viaje (){
		idViaje="";
		nombreViaje="";
		descripcion="";
		tipoViaje="";
		fechaIda="";
		fechaVuelta="";
		duracion="";
		descServicio="";
		agencia = new Agencia();
		pais=new Pais();
		ArrayList<Alojamiento> alojamiento = new ArrayList<Alojamiento>();
		ArrayList<Vuelo> vuelo = new ArrayList<Vuelo>();
		ArrayList<Otros> otros = new ArrayList<Otros>();
	}
	
	
	Viaje(String idViaje, String nombreViaje, String descripcion, String tipoViaje, String fechaIda,String fechaVuelta, String duracion, String descServicio, Agencia agencia, Pais pais, ArrayList<Alojamiento> alojamiento, ArrayList<Vuelo> vuelo, ArrayList<Otros> otros){
		
		this.idViaje=idViaje;
		this.nombreViaje=nombreViaje;
		this.descripcion=descripcion;
		this.tipoViaje=tipoViaje;
		this.fechaIda=fechaIda;
		this.fechaVuelta=fechaVuelta;
		this.duracion=duracion;
		this.descServicio=descServicio;
		this.agencia= agencia;
		this.pais=pais;
		this.alojamiento=alojamiento;
		this.vuelo=vuelo;
		this.otros=otros;
		
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


	public String getFechaIda() {
		return fechaIda;
	}


	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}


	public String getFechaVuelta() {
		return fechaVuelta;
	}


	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
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


	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public ArrayList<Alojamiento> getAlojamiento() {
		return alojamiento;
	}


	public void setAlojamiento(ArrayList<Alojamiento> alojamiento) {
		this.alojamiento = alojamiento;
	}


	public ArrayList<Vuelo> getVuelo() {
		return vuelo;
	}


	public void setVuelo(ArrayList<Vuelo> vuelo) {
		this.vuelo = vuelo;
	}


	public ArrayList<Otros> getOtros() {
		return otros;
	}


	public void setOtros(ArrayList<Otros> otros) {
		this.otros = otros;
	}


	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", nombreViaje=" + nombreViaje + ", descripcion=" + descripcion
				+ ", tipoViaje=" + tipoViaje + ", fechaIda=" + fechaIda + ", fechaVuelta=" + fechaVuelta + ", duracion="
				+ duracion + ", descServicio=" + descServicio + ", agencia=" + agencia + ", pais=" + pais
				+ ", alojamiento=" + alojamiento + ", vuelo=" + vuelo + ", otros=" + otros + "]";
	}


}
	