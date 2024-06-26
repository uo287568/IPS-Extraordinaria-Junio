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

public class TransportistaView {

	private JFrame frmTransportista;
	private JLabel lbTítulo;
	private JTextField tfID;
	private JPanel pnTransportista;
	private JLabel lbID;
	private JButton btnSalir;
	private JButton btBuscar;
	private JScrollPane pnTabla;
	private JTable tbPedidos;

	public TransportistaView() {
		initialize();
	}

	private void initialize() {
		frmTransportista = new JFrame();
		frmTransportista.setTitle("EnvíosTransportista");
		frmTransportista.setName("EnvíosTransportista");
		frmTransportista.setBounds(0, 0, 771, 321);
		frmTransportista.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmTransportista.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][grow][][][][]"));
		
		lbTítulo = new JLabel("Lista de pedidos de un transportista:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmTransportista.getContentPane().add(lbTítulo, "cell 0 0");
		
		pnTransportista = new JPanel();
		FlowLayout fl_pnTransportista = (FlowLayout) pnTransportista.getLayout();
		fl_pnTransportista.setAlignment(FlowLayout.LEFT);
		frmTransportista.getContentPane().add(pnTransportista, "cell 0 2,grow");
		
		lbID = new JLabel("ID transportista:");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnTransportista.add(lbID);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnTransportista.add(tfID);
		tfID.setColumns(10);
		
		btBuscar = new JButton("Buscar transportista");
		btBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btBuscar.setBackground(Color.GREEN);
		pnTransportista.add(btBuscar);
		
		pnTabla = new JScrollPane();
		frmTransportista.getContentPane().add(pnTabla, "cell 0 4,grow");
		
		tbPedidos = new JTable();
		tbPedidos.setDefaultEditor(Object.class, null); //readonly
		pnTabla.setViewportView(tbPedidos);
		
		JPanel pnSalir = new JPanel();
		FlowLayout fl_pnSalir = (FlowLayout) pnSalir.getLayout();
		fl_pnSalir.setAlignment(FlowLayout.RIGHT);
		frmTransportista.getContentPane().add(pnSalir, "cell 0 6,grow");
		
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
	public JFrame getFrame() { return this.frmTransportista; }
	public JButton getBtSalir() { return this.btnSalir;	}	
	public JButton getBtBuscar() { return this.btBuscar;	}
	public JTextField getTfID() { return tfID;	}
	public JTable getTbPedidos() { return tbPedidos;	}
}
