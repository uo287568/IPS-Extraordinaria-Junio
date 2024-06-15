package giis.demo.tkrun;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import giis.demo.util.Database;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserEmpresa;

public class EmpresaModel {

	private Database db=new Database();
	
	public void crearPedidos(String nEmpresa) {
		String sql="insert into Envios (nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor,correoReceptor,direccionReceptor,largo,ancho,alto,peso,precio,instrExtra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<EnvioEntity> envios = cargarEnvios("src/main/java/files/" + nEmpresa + ".csv");
		Random rd = new Random();
		for (EnvioEntity envio: envios) {
			envio.setNref(rd.nextInt(999999999));
			db.executeUpdate(sql,envio.getNref(),envio.getNombreEmisor(),envio.getCorreoEmisor(),envio.getDireccionEmisor(),
					envio.getNombreReceptor(),envio.getCorreoReceptor(),envio.getDireccionReceptor(),envio.getLargo(),envio.getAncho(),
					envio.getAlto(),envio.getPeso(),envio.getPrecio(),envio.getInstrExtra());
		}
		JOptionPane.showMessageDialog(null, "SE HAN REGISTRADO CORRECTAMENTE " + envios.size() + " ENVÍOS");
	}

	private List<EnvioEntity> cargarEnvios(String ruta) {
		return new ParserEmpresa().parseLines(new FileUtil().readLines(ruta));
	}
	
}
