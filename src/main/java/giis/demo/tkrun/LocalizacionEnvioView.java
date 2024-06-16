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

public class LocalizacionEnvioView {

	private JFrame frmLocalizacion;
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

	public LocalizacionEnvioView() {
		initialize();
	}

	private void initialize() {
		frmLocalizacion = new JFrame();
		frmLocalizacion.setTitle("LocalizaciónEnvíos");
		frmLocalizacion.setName("LocalizaciónEnvíos");
		frmLocalizacion.setBounds(0, 0, 577, 438);
		frmLocalizacion.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmLocalizacion.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][grow][][grow][][]"));
		
		lbTítulo = new JLabel("Localización de un envío:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmLocalizacion.getContentPane().add(lbTítulo, "cell 0 0");
		
		pnEnvio = new JPanel();
		FlowLayout fl_pnEnvio = (FlowLayout) pnEnvio.getLayout();
		fl_pnEnvio.setAlignment(FlowLayout.LEFT);
		frmLocalizacion.getContentPane().add(pnEnvio, "cell 0 2,grow");
		
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
		frmLocalizacion.getContentPane().add(lbEstado, "flowx,cell 0 3");
		
		lbInfo = new JLabel("Información general del envío:");
		lbInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmLocalizacion.getContentPane().add(lbInfo, "cell 0 4");
		
		pnInfo = new JScrollPane();
		frmLocalizacion.getContentPane().add(pnInfo, "cell 0 5,grow");
		
		tbInfo = new JTable();
		tbInfo.setDefaultEditor(Object.class, null); //readonly
		pnInfo.setViewportView(tbInfo);
		
		lbMovimientos = new JLabel("Movimientos del envío:");
		lbMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmLocalizacion.getContentPane().add(lbMovimientos, "cell 0 6");
		
		pnMovimientos = new JScrollPane();
		frmLocalizacion.getContentPane().add(pnMovimientos, "cell 0 7,grow");
		
		tbMovimientos = new JTable();
		tbMovimientos.setDefaultEditor(Object.class, null); //readonly
		pnMovimientos.setViewportView(tbMovimientos);
		
		JPanel pnSalir = new JPanel();
		FlowLayout fl_pnSalir = (FlowLayout) pnSalir.getLayout();
		fl_pnSalir.setAlignment(FlowLayout.RIGHT);
		frmLocalizacion.getContentPane().add(pnSalir, "cell 0 9,grow");
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnSalir.add(btnSalir);
		
		tfEstado = new JTextField();
		tfEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfEstado.setEditable(false);
		frmLocalizacion.getContentPane().add(tfEstado, "cell 0 3");
		tfEstado.setColumns(10);
	}
	
	public void reset() {
		this.tfNRef.setText("");
		this.getFrame().setVisible(false);
		
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmLocalizacion; }
	public JButton getBtSalir() { return this.btnSalir;	}	
	public JButton getBtBuscar() { return this.btBuscar;	}
	public JTextField getTfNRef() { return tfNRef;	}
	public JTextField getTfEstado() { return tfEstado;	}
	public JTable getTbInfo() { return tbInfo;	}
	public JTable getTbMovimientos() { return tbMovimientos;	}
}
