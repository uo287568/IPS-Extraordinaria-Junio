package giis.demo.tkrun;

import giis.demo.util.Database;

public class EnviosModel {

	private Database db=new Database();

	public void crearPedido(int nref, String nE, String cE, String dE, String nR, String cR, String dR, String largo, String ancho, String alto, String peso, String precio, String coms) {
		String sql="insert into Envios (nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor,correoReceptor,direccionReceptor,largo,ancho,alto,peso,precio,instrExtra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql,nref,nE,cE,dE,nR,cR,dR,largo,ancho,alto,peso,precio,coms);
	}
	
	
	
}
