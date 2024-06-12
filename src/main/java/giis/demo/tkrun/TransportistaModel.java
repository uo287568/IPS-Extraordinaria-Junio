package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;
/**
 * Acceso a los datos de carreras e inscripciones, 
 * utilizado como modelo para el ejemplo de swing y para las pruebas unitarias y de interfaz de usuario.
 * 
 * <br/>En los metodos de este ejemplo toda la logica de negocio se realiza mediante una unica query sql por lo que siempre
 * se utilizan los metodos de utilidad en la clase Database que usan apache commons-dbutils y controlan la conexion. 
 * En caso de que en un mismo metodo se realicen diferentes queries se deberia controlar la conexion desde esta clase 
 * (ver como ejemplo la implementacion en Database).
 * 
 * <br/>Si utilizase algún otro framework para manejar la persistencia, la funcionalidad proporcionada por esta clase sería la asignada
 * a los Servicios, Repositorios y DAOs.
 */
public class TransportistaModel {

	private Database db=new Database();

	public TransportistaDisplayDTO getTransportista(int id) {
		String sql = "select * from transportistas where id=?";
		List<TransportistaDisplayDTO> transportistas = db.executeQueryPojo(TransportistaDisplayDTO.class, sql, id);
		if(transportistas.isEmpty()) {
			return null;
		}
		return transportistas.get(0);
	}

	public List<PedidosTransportistaDisplayDTO> getPedidosTransportista(int numID) {
		String sql = "select * from pedidosTransportista where id=? order by fechaEntrega";
		List<PedidosTransportistaDisplayDTO> pedidos = db.executeQueryPojo(PedidosTransportistaDisplayDTO.class, sql, numID);
		return pedidos;
	}
	
	
	
}
