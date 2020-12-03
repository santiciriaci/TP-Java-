package Datos;

public class Consultas {
	/*ingresar*/
	/*PreparedStatement stmt = conn.prepareStatement("select * from usuario where usuario=? and contraseña=?");
	loguin  (ver si se puede llamar el atributo igual a la tabla)
	
	rregistrarse
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario SET usuario=?,contraseña=?,dni=?,nombre=?,apellido=?,telefono=?,mail=?,direccion=?,es_admin=?");
	registro de nuevo usuario
	
	registrar vehiculo
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO vehiculos SET dni=?,patente=?,modelo=?");
	registro de vehiculo de un usr
	
	eliminar cuenta
	PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE dni=?");
	
	
	asignar lugar
	PreparedStatement stmt = conn.prepareStatement("UPDATE lugar SET estado=? WHERE ID_lugar=?");
	cambiar estado de lugar cuando se ocupa o desocupa
	
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO ticket SET fecha_hora_inicio=?,patente=?");
	creacion de ticket con fechayhora(asignada en una variable) y la patente
	
	realizar cobro
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE patente=?");
	recupero la fecha y hora de incio del ticket
	
	PreparedStatement stmt = conn.prepareStatement("SELECT ID_tarifa,media_hora,hora FROM tarifa where ID_tarifa=(SELECT MAX(ID_tarifa) FROM tarifa");
	recupero tarifa de media hora y hora para los tickets sin aviso
	
	PreparedStatement stmt = conn.prepareStatement("UPDATE ticket SET fecha_hora_fin=?,importe=?,ID_tarifa=?");
	fin de ticket con fechayhora(asignada en una variable) y el importe pre calculado y idtarifa
	
	crear ticket (conprevio aviso)
	PreparedStatement stmt = conn.prepareStatement("SELECT ID_tarifa FROM tarifa WHERE ID_tarifa=(SELECT MAX(ID_tarifa) FROM tarifa");
	recupero tarifario actual
	
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO ticket SET patente=?,fecha_hora_inicio=?,fecha_hora_fin=?,importe=?,ID_tarifa=?");
	creo ticket a mano
	
	tarifas
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tarifa WHERE ID_tarifa=(SELECT MAX(ID_tarifa) FROM tarifa");
	tarifario actual
	
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO tarifa SET media_hora=?,hora=?,media_estadia=?,estadia_completa=?,semanal=?,mensual=?");
	actualizacion tarifa
	
	facturacion mensual cliente	
	PreparedStatement stmt = conn.prepareStatement("SELECT patente FROM vehiculo WHERE dni=?");
	recupero las patentes de ese DNI, desp ver donde se guarda o como
	
	PreparedStatement stmt = conn.prepareStatement("SELECT SUMA(importe) FROM ticket WHERE patente=? AND month(fecha_hora_inicio)=?");
	suma de los importes, necesitamos antes el mes actual, y saber como sacar el mes de fecha_hora_inicio
	
	historico servicio
	aplicar for para la cantidad de dias de ese mes
	PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(ID_ticket) FROM ticket WHERE day(fecha_hora_inicio)=?");
	sacar promedio agrupado x dia
	
	actualizar benificio
	PreparedStatement stmt = conn.prepareStatement("INSERT INTO beneficio SET porcentaje=?");
	asignar nuevo porcentaje al beneficio*/
}
