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
public class LocalizacionEnvioModel {

	private Database db=new Database();

	public EnvioDisplayDTO getEnvio(int nrefNum) {
		String sql = "select * from envios where nref=?";
		List<EnvioDisplayDTO> envios = db.executeQueryPojo(EnvioDisplayDTO.class, sql, nrefNum);
		if(envios.isEmpty()) {
			return null;
		}
		return envios.get(0);
	}

	public List<MovimientosDisplayDTO> getMovimientos(int nrefNum) {
		String sql = "select * from movimientos where nref=? order by fechaMov desc";
		List<MovimientosDisplayDTO> movimientos = db.executeQueryPojo(MovimientosDisplayDTO.class, sql, nrefNum);
		return movimientos;
	}
	
	
	
}
