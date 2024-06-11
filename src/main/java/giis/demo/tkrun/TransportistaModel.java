package giis.demo.tkrun;

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

	public void crearPedido(int nref, String nE, String cE, String dE, String nR, String cR, String dR, String largo, String ancho, String alto, String peso, String precio, String coms) {
		String sql="insert into Envios (nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor,correoReceptor,direccionReceptor,largo,ancho,alto,peso,precio,instrExtra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql,nref,nE,cE,dE,nR,cR,dR,largo,ancho,alto,peso,precio,coms);
	}
	
	
	
}
