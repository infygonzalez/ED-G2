package Modelo;

public class SQLQuerys {

	
	//INSERT
		public static final String INSERT_NUEVA_AGENCIA = "insert into agencia(nombre,colorMarca,numeroEmpleados,tipoAgencia,logo,clave) VALUES('";
		public static final String INSERT_NUEVO_VIAJE = "insert into viajes(nombre,descripcion,tipoViaje,fechaIda,fechaVuelta,duracion,descripcionServicio,idAgencia,codigoPais) VALUES('";
		public static final String INSERT_NUEVO_VUELO = "insert into vuelo(codigoVuelo,precio,fecSalida,horaSalida,vueloDuracion,codigoAeropuertoOrigen,codigoAeropuertoDestino,codigoAerolinea,idViajes) VALUES('";
		public static final String INSERT_NUEVO_VUELO_VUELTA = "insert into vuelo(codigoVuelo,precio,fecSalida,horaSalida,vueloDuracion,codigoAeropuertoOrigen,codigoAeropuertoDestino,codigoAerolinea,vueloIda,idViajes) VALUES('";
		public static final String INSERT_NUEVO_ALOJAMIENTO = "insert into alojamiento(nombreHotel,ciudad,precio,fecSalida,tipoHab,idViajes) VALUES('";
		public static final String INSERT_NUEVO_OTROS = "insert into otros(nombre,descripcion,precio,fecSalida,idViajes) VALUES('";
		public static final String SEPARATOR = "', '";
		public static final String ENDBLOCK = "')";
	
	//SELECTS
		public static final String SELECT_USUARIO_CLAVE = "SELECT * FROM agencia WHERE nombre = ? AND clave = ?";
		public static final String SELECT_TODOS_VIAJES = "SELECT * FROM viajes WHERE idAgencia = ?";
		public static final String SELECT_TODOS_VUELOS = "SELECT * FROM vuelo where idViajes = ?";
		public static final String SELECT_TODOS_ALOJAMIENTO = "SELECT * FROM alojamiento where idViajes = ?";
		public static final String SELECT_TODOS_OTROS = "SELECT * FROM otros where idViajes = ?";
		public static final String SELECT_TODOS_PAISES = "SELECT * FROM pais";
		public static final String SELECT_TODAS_AEROLINEAS = "SELECT * FROM aerolinea";
		public static final String SELECT_TODAS_AEROPUERTOS = "SELECT * FROM aeropuerto";
		public static final String SELECT_MAXIMO_ID_EVENTO = "SELECT max(idEvento) FROM vuelo";
		
		
	//DELETES
		public static final String DELETE_VIAJE = "DELETE FROM viajes WHERE idViajes = ?";
		public static final String DELETE_EVENTO_VUELO = "DELETE FROM vuelo WHERE idEvento = ?";
		public static final String DELETE_EVENTO_ALOJAMIENTO = "DELETE FROM alojamiento WHERE idEvento = ?";
		public static final String DELETE_EVENTO_OTROS = "DELETE FROM otros WHERE idEvento = ?";
		
		
	
	
}
