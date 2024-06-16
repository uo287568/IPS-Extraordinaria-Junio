package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;

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
