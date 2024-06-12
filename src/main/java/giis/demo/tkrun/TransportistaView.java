package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Vista de la pantalla que muestra las carreras activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde CarrerasMain) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class TransportistaView {

	private JFrame frmRegistroenvos;
	private JLabel lbTítulo;
	private JTextField tfID;
	private JPanel pnTransportista;
	private JLabel lbID;
	private JButton btnSalir;
	private JButton btBuscar;
	private JScrollPane pnTabla;
	private JTable tbPedidos;

	/**
	 * Create the application.
	 */
	public TransportistaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroenvos = new JFrame();
		frmRegistroenvos.setTitle("RegistroEnvíos");
		frmRegistroenvos.setName("RegistroEnvíos");
		frmRegistroenvos.setBounds(0, 0, 771, 422);
		frmRegistroenvos.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmRegistroenvos.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][grow][][][][]"));
		
		lbTítulo = new JLabel("Lista de pedidos de un transportista:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroenvos.getContentPane().add(lbTítulo, "cell 0 0");
		
		pnTransportista = new JPanel();
		FlowLayout fl_pnTransportista = (FlowLayout) pnTransportista.getLayout();
		fl_pnTransportista.setAlignment(FlowLayout.LEFT);
		frmRegistroenvos.getContentPane().add(pnTransportista, "cell 0 2,grow");
		
		lbID = new JLabel("ID transportista:");
		pnTransportista.add(lbID);
		
		tfID = new JTextField();
		pnTransportista.add(tfID);
		tfID.setColumns(10);
		
		btBuscar = new JButton("Buscar transportista");
		btBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btBuscar.setBackground(Color.GREEN);
		pnTransportista.add(btBuscar);
		
		pnTabla = new JScrollPane();
		frmRegistroenvos.getContentPane().add(pnTabla, "cell 0 4,grow");
		
		tbPedidos = new JTable();
		tbPedidos.setDefaultEditor(Object.class, null); //readonly
		pnTabla.setViewportView(tbPedidos);
		
		JPanel pnSalir = new JPanel();
		FlowLayout fl_pnSalir = (FlowLayout) pnSalir.getLayout();
		fl_pnSalir.setAlignment(FlowLayout.RIGHT);
		frmRegistroenvos.getContentPane().add(pnSalir, "cell 0 6,grow");
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnSalir.add(btnSalir);
	}
	
	public void reset() {
		this.tfID.setText("");
		this.getFrame().setVisible(false);
		
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmRegistroenvos; }
	public JButton getBtSalir() { return this.btnSalir;	}	
	public JButton getBtBuscar() { return this.btBuscar;	}
	public JTextField getTfID() { return tfID;	}
	public JTable getTbPedidos() { return tbPedidos;	}
}
