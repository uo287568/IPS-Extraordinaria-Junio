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
public class LocalizacionEnvioView {

	private JFrame frmTransportista;
	private JLabel lbTítulo;
	private JTextField tfNRef;
	private JPanel pnEnvio;
	private JLabel lbNRef;
	private JButton btnSalir;
	private JButton btBuscar;
	private JScrollPane pnMovimientos;
	private JTable tbMovimientos;
	private JLabel lbEstado;
	private JTextField tfEstado;
	private JLabel lbInfo;
	private JScrollPane pnInfo;
	private JTable tbInfo;
	private JLabel lbMovimientos;

	/**
	 * Create the application.
	 */
	public LocalizacionEnvioView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransportista = new JFrame();
		frmTransportista.setTitle("EnvíosTransportista");
		frmTransportista.setName("EnvíosTransportista");
		frmTransportista.setBounds(0, 0, 577, 438);
		frmTransportista.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmTransportista.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][grow][][grow][][]"));
		
		lbTítulo = new JLabel("Localización de un envío:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmTransportista.getContentPane().add(lbTítulo, "cell 0 0");
		
		pnEnvio = new JPanel();
		FlowLayout fl_pnEnvio = (FlowLayout) pnEnvio.getLayout();
		fl_pnEnvio.setAlignment(FlowLayout.LEFT);
		frmTransportista.getContentPane().add(pnEnvio, "cell 0 2,grow");
		
		lbNRef = new JLabel("Número de referencia del envío: ");
		lbNRef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnEnvio.add(lbNRef);
		
		tfNRef = new JTextField();
		pnEnvio.add(tfNRef);
		tfNRef.setColumns(10);
		
		btBuscar = new JButton("Buscar envío");
		btBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btBuscar.setBackground(Color.GREEN);
		pnEnvio.add(btBuscar);
		
		lbEstado = new JLabel("El envío se encuentra en el estado: ");
		lbEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmTransportista.getContentPane().add(lbEstado, "flowx,cell 0 3");
		
		lbInfo = new JLabel("Información general del envío:");
		lbInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmTransportista.getContentPane().add(lbInfo, "cell 0 4");
		
		pnInfo = new JScrollPane();
		frmTransportista.getContentPane().add(pnInfo, "cell 0 5,grow");
		
		tbInfo = new JTable();
		tbInfo.setDefaultEditor(Object.class, null); //readonly
		pnInfo.setViewportView(tbInfo);
		
		lbMovimientos = new JLabel("Movimientos del envío:");
		lbMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmTransportista.getContentPane().add(lbMovimientos, "cell 0 6");
		
		pnMovimientos = new JScrollPane();
		frmTransportista.getContentPane().add(pnMovimientos, "cell 0 7,grow");
		
		tbMovimientos = new JTable();
		tbMovimientos.setDefaultEditor(Object.class, null); //readonly
		pnMovimientos.setViewportView(tbMovimientos);
		
		JPanel pnSalir = new JPanel();
		FlowLayout fl_pnSalir = (FlowLayout) pnSalir.getLayout();
		fl_pnSalir.setAlignment(FlowLayout.RIGHT);
		frmTransportista.getContentPane().add(pnSalir, "cell 0 9,grow");
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnSalir.add(btnSalir);
		
		tfEstado = new JTextField();
		tfEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfEstado.setEditable(false);
		frmTransportista.getContentPane().add(tfEstado, "cell 0 3");
		tfEstado.setColumns(10);
	}
	
	public void reset() {
		this.tfNRef.setText("");
		this.getFrame().setVisible(false);
		
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmTransportista; }
	public JButton getBtSalir() { return this.btnSalir;	}	
	public JButton getBtBuscar() { return this.btBuscar;	}
	public JTextField getTfNRef() { return tfNRef;	}
	public JTextField getTfEstado() { return tfEstado;	}
	public JTable getTbInfo() { return tbInfo;	}
	public JTable getTbMovimientos() { return tbMovimientos;	}
}
