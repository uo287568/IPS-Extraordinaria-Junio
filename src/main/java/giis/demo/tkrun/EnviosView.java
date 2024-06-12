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

public class EnviosView {

	private JFrame frmRegistroenvos;
	private JLabel lbInfoE;
	private JLabel lbTítulo;
	private JTextField tfNombreE;
	private JPanel pnEmisor;
	private JLabel lbNombreE;
	private JLabel lbCorreoE;
	private JLabel lbDireccionE;
	private JLabel lbInfoR;
	private JPanel pnReceptor;
	private JLabel lbNombreR;
	private JLabel lbCorreoR;
	private JLabel lbDireccionR;
	private JLabel lbPaquete;
	private JPanel pnPaquete;
	private JTextArea txaComentarios;
	private JTextField tfCorreoE;
	private JTextField tfDireccionE;
	private JTextField tfNombreR;
	private JTextField tfCorreoR;
	private JTextField tfDireccionR;
	private JTextField tfLargo;
	private JTextField tfAncho;
	private JTextField tfAlto;
	private JTextField tfPeso;
	private JTextField tfPrecio;
	private JButton btnCancelar;
	private JButton btRegistro;
	private JButton btPrecio;

	/**
	 * Create the application.
	 */
	public EnviosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroenvos = new JFrame();
		frmRegistroenvos.setTitle("RegistroEnvíos");
		frmRegistroenvos.setName("RegistroEnvíos");
		frmRegistroenvos.setBounds(0, 0, 703, 422);
		frmRegistroenvos.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmRegistroenvos.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][][][][grow][][][]"));
		
		lbTítulo = new JLabel("Registro de envíos a domicilio:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroenvos.getContentPane().add(lbTítulo, "cell 0 0");
		
		lbInfoE = new JLabel("Información del emisor del paquete:");
		lbInfoE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmRegistroenvos.getContentPane().add(lbInfoE, "cell 0 1");
		
		pnEmisor = new JPanel();
		frmRegistroenvos.getContentPane().add(pnEmisor, "cell 0 2,grow");
		
		lbNombreE = new JLabel("Nombre:");
		pnEmisor.add(lbNombreE);
		
		tfNombreE = new JTextField();
		pnEmisor.add(tfNombreE);
		tfNombreE.setColumns(10);
		
		lbCorreoE = new JLabel("Correo:");
		pnEmisor.add(lbCorreoE);
		
		tfCorreoE = new JTextField();
		pnEmisor.add(tfCorreoE);
		tfCorreoE.setColumns(10);
		
		lbDireccionE = new JLabel("Dirección de recogida:");
		pnEmisor.add(lbDireccionE);
		
		tfDireccionE = new JTextField();
		pnEmisor.add(tfDireccionE);
		tfDireccionE.setColumns(10);
		
		lbInfoR = new JLabel("Información del receptor del paquete:");
		lbInfoR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmRegistroenvos.getContentPane().add(lbInfoR, "cell 0 3");
		
		pnReceptor = new JPanel();
		frmRegistroenvos.getContentPane().add(pnReceptor, "cell 0 4,grow");
		
		lbNombreR = new JLabel("Nombre:");
		pnReceptor.add(lbNombreR);
		
		tfNombreR = new JTextField();
		tfNombreR.setColumns(10);
		pnReceptor.add(tfNombreR);
		
		lbCorreoR = new JLabel("Correo:");
		pnReceptor.add(lbCorreoR);
		
		tfCorreoR = new JTextField();
		tfCorreoR.setColumns(10);
		pnReceptor.add(tfCorreoR);
		
		lbDireccionR = new JLabel("Dirección de recogida:");
		pnReceptor.add(lbDireccionR);
		
		tfDireccionR = new JTextField();
		tfDireccionR.setColumns(10);
		pnReceptor.add(tfDireccionR);
		
		lbPaquete = new JLabel("Información sobre el paquete: (cm y kg)");
		lbPaquete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmRegistroenvos.getContentPane().add(lbPaquete, "cell 0 5");
		
		pnPaquete = new JPanel();
		frmRegistroenvos.getContentPane().add(pnPaquete, "cell 0 6,grow");
		
		JLabel lbLargo = new JLabel("Largo:");
		pnPaquete.add(lbLargo);
		
		tfLargo = new JTextField();
		pnPaquete.add(tfLargo);
		tfLargo.setColumns(10);
		
		JLabel lbAncho = new JLabel("Ancho:");
		pnPaquete.add(lbAncho);
		
		tfAncho = new JTextField();
		pnPaquete.add(tfAncho);
		tfAncho.setColumns(10);
		
		JLabel lbAlto = new JLabel("Alto:");
		pnPaquete.add(lbAlto);
		
		tfAlto = new JTextField();
		pnPaquete.add(tfAlto);
		tfAlto.setColumns(10);
		
		JLabel lbPeso = new JLabel("Peso:");
		pnPaquete.add(lbPeso);
		
		tfPeso = new JTextField();
		pnPaquete.add(tfPeso);
		tfPeso.setColumns(10);
		
		JLabel lbInstrucciones = new JLabel("Instrucciones extra para la recogida o envío del pedido:");
		lbInstrucciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmRegistroenvos.getContentPane().add(lbInstrucciones, "cell 0 7");
		
		txaComentarios = new JTextArea();
		frmRegistroenvos.getContentPane().add(txaComentarios, "cell 0 8,grow");
		
		JLabel lbPrecio = new JLabel("Precio final en euros (€):");
		lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmRegistroenvos.getContentPane().add(lbPrecio, "cell 0 9");
		
		JPanel pnPrecio = new JPanel();
		frmRegistroenvos.getContentPane().add(pnPrecio, "cell 0 10,grow");
		pnPrecio.setLayout(new GridLayout(0, 5, 0, 0));
		
		btPrecio = new JButton("Calcular precio: ");
		btPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnPrecio.add(btPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPrecio.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frmRegistroenvos.getContentPane().add(panel, "cell 0 11,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnCancelar);
		
		btRegistro = new JButton("Registrar envío");
		btRegistro.setBackground(Color.GREEN);
		btRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btRegistro);
	}
	
	public void reset() {
		this.tfNombreE.setText("");
		this.tfCorreoE.setText("");
		this.tfDireccionE.setText("");
		this.tfNombreR.setText("");
		this.tfCorreoR.setText("");
		this.tfDireccionR.setText("");
		this.tfLargo.setText("");
		this.tfAncho.setText("");
		this.tfAlto.setText("");
		this.tfPeso.setText("");
		this.txaComentarios.setText("");
		this.getFrame().setVisible(false);
		
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmRegistroenvos; }
	public JButton getBtCancelar() { return this.btnCancelar;	}
	public JButton getBtRegistrar() { return this.btRegistro;	}
	public JButton getBtPrecio() { return this.btPrecio;	}
	public JTextField getTfNombreE() { return tfNombreE; }
	public JTextArea getTxaComentarios() { return txaComentarios; }
	public JTextField getTfCorreoE() { return tfCorreoE; }
	public JTextField getTfDireccionE() { return tfDireccionE; }
	public JTextField getTfNombreR() { return tfNombreR; }
	public JTextField getTfCorreoR() { return tfCorreoR; }
	public JTextField getTfDireccionR() { return tfDireccionR; }
	public JTextField getTfLargo() { return tfLargo; }
	public JTextField getTfAncho() { return tfAncho; }
	public JTextField getTfAlto() { return tfAlto; }
	public JTextField getTfPeso() { return tfPeso; }
	public JTextField getTfPrecio() { return tfPrecio; }

	public boolean comprobarCampos() {
		if(this.tfNombreE.getText().isBlank() || this.tfCorreoE.getText().isBlank() || this.tfDireccionE.getText().isBlank() 
				|| this.tfNombreR.getText().isBlank() || this.tfCorreoR.getText().isBlank() || this.tfDireccionR.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
			return false;
		} else if(!comprobarPrecio()){
			return false;
		} else return comprobarDimensiones();
	}

	private boolean comprobarPrecio() {
		try {
			if(this.tfPrecio.getText().isBlank() || Double.parseDouble(this.tfPrecio.getText()) <= 0) {
					JOptionPane.showMessageDialog(null, "Precio inválido");
					return false;
				} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Precio no calculado");
			return false;
		}
	}

	public boolean comprobarDimensiones() {
		try {
			if(this.tfLargo.getText().isBlank() || Double.parseDouble(this.tfLargo.getText()) <= 0 
				|| this.tfAncho.getText().isBlank() || Double.parseDouble(this.tfAncho.getText()) <= 0
				|| this.tfAlto.getText().isBlank() || Double.parseDouble(this.tfAlto.getText()) <= 0
				|| this.tfPeso.getText().isBlank() || Double.parseDouble(this.tfPeso.getText()) <= 0) {
				JOptionPane.showMessageDialog(null, "Las dimensiones son inválidas");
				return false;
			} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Las dimensiones son inválidas");
			return false;
		}
	}	
}
