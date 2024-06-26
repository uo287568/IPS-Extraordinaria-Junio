package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;

public class CargaView {

	private JFrame frmCargaEnvios;
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

	public CargaView() {
		initialize();
	}

	private void initialize() {
		frmCargaEnvios = new JFrame();
		frmCargaEnvios.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCargaEnvios.setTitle("CargaEnvíos");
		frmCargaEnvios.setName("CargaEnvíos");
		frmCargaEnvios.setBounds(0, 0, 366, 231);
		frmCargaEnvios.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmCargaEnvios.getContentPane().setLayout(new MigLayout("", "[grow]", "[][10.00][][][][][16.00][]"));
		
		lbTítulo = new JLabel("Registro de carga de envíos:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmCargaEnvios.getContentPane().add(lbTítulo, "cell 0 0");
		
		lbID = new JLabel("ID del transportista: ");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCargaEnvios.getContentPane().add(lbID, "flowx,cell 0 2");
		
		lbNRef = new JLabel("Número de referencia del envío: ");
		lbNRef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCargaEnvios.getContentPane().add(lbNRef, "flowx,cell 0 3");
		
		lbUbicacion = new JLabel("Ubicación de la carga:");
		lbUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCargaEnvios.getContentPane().add(lbUbicacion, "flowx,cell 0 4");
		
		lbFecha = new JLabel("Se registrará la fecha y hora de la carga (hora actual)");
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmCargaEnvios.getContentPane().add(lbFecha, "cell 0 5");
		
		tfID = new JTextField();
		frmCargaEnvios.getContentPane().add(tfID, "cell 0 2");
		tfID.setColumns(10);
		
		tfNRef = new JTextField();
		frmCargaEnvios.getContentPane().add(tfNRef, "cell 0 3");
		tfNRef.setColumns(10);
		
		tfUbicacion = new JTextField();
		frmCargaEnvios.getContentPane().add(tfUbicacion, "cell 0 4");
		tfUbicacion.setColumns(10);
		
		JPanel pnBotones = new JPanel();
		FlowLayout fl_pnBotones = (FlowLayout) pnBotones.getLayout();
		fl_pnBotones.setAlignment(FlowLayout.RIGHT);
		frmCargaEnvios.getContentPane().add(pnBotones, "cell 0 7,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btnCancelar);
		
		btRegistro = new JButton("Registrar carga");
		btRegistro.setBackground(Color.GREEN);
		btRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btRegistro);
	}
	
	public void reset() {
		this.tfID.setText("");
		this.tfNRef.setText("");
		this.tfUbicacion.setText("");
		this.getFrame().setVisible(false);
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmCargaEnvios; }
	public JButton getBtCancelar() { return this.btnCancelar;	}
	public JButton getBtRegistrar() { return this.btRegistro;	}
	public JTextField getTfID() { return tfID;	}
	public JTextField getTfNRef() { return tfNRef;	}
	public JTextField getTfUbicacion() { return tfUbicacion;	}
}
