package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;

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
