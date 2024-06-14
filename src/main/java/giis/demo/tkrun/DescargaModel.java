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
public class DescargaModel {

	private Database db=new Database();

	public PedidosTransportistaDisplayDTO getEnvio(int id, int nref) {
		String sql = "select * from pedidosTransportista where id=? and nref=?";
		List<PedidosTransportistaDisplayDTO> envios = db.executeQueryPojo(PedidosTransportistaDisplayDTO.class, sql, id, nref);
		if(envios.isEmpty()) {
			return null;
		}
		return envios.get(0);
	}

	public MovimientosDisplayDTO getLastMov(int id, int nref) {
		String sql = "select * from movimientos where id=? and nref=? order by fechamov desc";
		List<MovimientosDisplayDTO> movimientos = db.executeQueryPojo(MovimientosDisplayDTO.class, sql, id, nref);
		if(movimientos.isEmpty()) {
			return null;
		}
		return movimientos.get(0);
	}

	public void registrarDescarga(int id, int nref, String mov, String ubi, String fechaHoraActual) {
		String sql="insert into movimientos (id,nref,movimiento,ubicacion,fechaMov) values (?,?,?,?,?)";
		db.executeUpdate(sql,id,nref,mov,ubi,fechaHoraActual);
	}
	
	
	
}
