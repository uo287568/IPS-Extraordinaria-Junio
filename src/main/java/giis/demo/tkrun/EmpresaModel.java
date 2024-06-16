package giis.demo.tkrun;

import java.util.ArrayList;
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
		List<EnvioEntity> envios = cargarEnvios("src/main/java/files/" + nEmpresa + ".csv", nEmpresa);
		if (envios.size() > 0) {
			Random rd = new Random();
			List<Integer> nrefs = new ArrayList<>();
			for (EnvioEntity envio: envios) {
				int rand = rd.nextInt(999999999);
				envio.setNref(rand);
				nrefs.add(rand);
				db.executeUpdate(sql,envio.getNref(),envio.getNombreEmisor(),envio.getCorreoEmisor(),envio.getDireccionEmisor(),
						envio.getNombreReceptor(),envio.getCorreoReceptor(),envio.getDireccionReceptor(),envio.getLargo(),envio.getAncho(),
						envio.getAlto(),envio.getPeso(),envio.getPrecio(),envio.getInstrExtra());
			}
			JOptionPane.showMessageDialog(null, "SE HAN REGISTRADO CORRECTAMENTE " + envios.size() + " ENVÍOS\nNúmeros de referencia: " + nrefs.toString());			
		}
	}

	private List<EnvioEntity> cargarEnvios(String ruta, String nEmpresa) {
		try {
			return new ParserEmpresa().parseLines(new FileUtil().readLines(ruta));
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo para el \nregistro de envíos de la empresa: " + nEmpresa);
		}
		return new ArrayList<>();
	}
	
}
