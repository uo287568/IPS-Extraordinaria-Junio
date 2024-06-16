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

public class EntregaView {

	private JFrame frmEntrega;
	private JLabel lbTítulo;
	private JButton btnCancelar;
	private JButton btRegistro;
	private JLabel lbID;
	private JTextField tfID;
	private JLabel lbNRef;
	private JTextField tfNRef;
	private JLabel lbUbicacion;
	private JTextField tfUbicacion;
	private JLabel lbFecha;
	private JButton btInfo;
	private JScrollPane spInfo;
	private JTable tbInfo;

	/**
	 * Create the application.
	 */
	public EntregaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEntrega = new JFrame();
		frmEntrega.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmEntrega.setTitle("Entrega");
		frmEntrega.setName("Entrega");
		frmEntrega.setBounds(0, 0, 419, 267);
		frmEntrega.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmEntrega.getContentPane().setLayout(new MigLayout("", "[grow]", "[][10.00][][][grow][][][16.00][]"));
		
		lbTítulo = new JLabel("Entrega en destino:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmEntrega.getContentPane().add(lbTítulo, "cell 0 0");
		
		lbID = new JLabel("ID del transportista: ");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmEntrega.getContentPane().add(lbID, "flowx,cell 0 2");
		
		lbNRef = new JLabel("Número de referencia del envío: ");
		lbNRef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmEntrega.getContentPane().add(lbNRef, "flowx,cell 0 3");
		
		spInfo = new JScrollPane();
		frmEntrega.getContentPane().add(spInfo, "cell 0 4,grow");
		
		tbInfo = new JTable();
		tbInfo.setDefaultEditor(Object.class, null); //readonly
		spInfo.setViewportView(tbInfo);
		
		lbUbicacion = new JLabel("Ubicación de destino:");
		lbUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmEntrega.getContentPane().add(lbUbicacion, "flowx,cell 0 5");
		
		lbFecha = new JLabel("Se registrará la fecha y hora de destino (hora actual)");
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmEntrega.getContentPane().add(lbFecha, "cell 0 6");
		
		tfID = new JTextField();
		frmEntrega.getContentPane().add(tfID, "cell 0 2");
		tfID.setColumns(10);
		
		tfNRef = new JTextField();
		frmEntrega.getContentPane().add(tfNRef, "cell 0 3");
		tfNRef.setColumns(10);
		
		tfUbicacion = new JTextField();
		frmEntrega.getContentPane().add(tfUbicacion, "cell 0 5");
		tfUbicacion.setColumns(10);
		
		JPanel pnBotones = new JPanel();
		FlowLayout fl_pnBotones = (FlowLayout) pnBotones.getLayout();
		fl_pnBotones.setAlignment(FlowLayout.RIGHT);
		frmEntrega.getContentPane().add(pnBotones, "cell 0 8,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btnCancelar);
		
		btRegistro = new JButton("Registrar entrega");
		btRegistro.setBackground(Color.GREEN);
		btRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btRegistro);
		
		btInfo = new JButton("Ver Info");
		frmEntrega.getContentPane().add(btInfo, "cell 0 3");
	}
	
	public void reset() {
		this.tfID.setText("");
		this.tfNRef.setText("");
		this.tfUbicacion.setText("");
		this.getFrame().setVisible(false);
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmEntrega; }
	public JButton getBtCancelar() { return this.btnCancelar;	}
	public JButton getBtRegistrar() { return this.btRegistro;	}
	public JButton getBtInfo() { return this.btInfo;	}
	public JTextField getTfID() { return tfID;	}
	public JTextField getTfNRef() { return tfNRef;	}
	public JTextField getTfUbicacion() { return tfUbicacion;	}
	public JTable getTbInfo() { return tbInfo;	}
}
