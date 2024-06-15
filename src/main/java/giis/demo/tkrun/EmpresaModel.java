package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserEmpresa;

public class EmpresaModel {

	private Database db=new Database();

	public void crearPedido(int nref, String nE, String cE, String dE, String nR, String cR, String dR, String largo, String ancho, String alto, String peso, String precio, String coms) {
		String sql="insert into Envios (nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor,correoReceptor,direccionReceptor,largo,ancho,alto,peso,precio,instrExtra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql,nref,nE,cE,dE,nR,cR,dR,largo,ancho,alto,peso,precio,coms);
	}
	
	public void crearPedidos(String nEmpresa) {
		String sql="insert into Envios (nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor,correoReceptor,direccionReceptor,largo,ancho,alto,peso,precio,instrExtra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<EnvioEntity> envios = cargarEnvios("src/main/java/files/" + nEmpresa + ".csv");
		for (EnvioEntity envio: envios) {
			db.executeUpdate(sql,envio.getNref(),envio.getNombreEmisor(),envio.getCorreoEmisor(),envio.getDireccionEmisor(),
					envio.getNombreReceptor(),envio.getCorreoReceptor(),envio.getDireccionReceptor(),envio.getLargo(),envio.getAncho(),
					envio.getAlto(),envio.getPeso(),envio.getPrecio(),envio.getInstrExtra());
		}
	}

	private List<EnvioEntity> cargarEnvios(String ruta) {
		return new ParserEmpresa().parseLines(new FileUtil().readLines(ruta));
	}
	
}
