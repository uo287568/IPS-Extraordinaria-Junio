package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;

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
