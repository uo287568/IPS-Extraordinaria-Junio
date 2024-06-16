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
import java.awt.Color;

public class EmpresaView {

	private JFrame frmRegistroEmpresa;
	private JLabel lbTítulo;
	private JTextField tfNombre;
	private JPanel pnEmisor;
	private JLabel lbNombre;
	private JButton btnCancelar;
	private JButton btRegistro;

	public EmpresaView() {
		initialize();
	}

	private void initialize() {
		frmRegistroEmpresa = new JFrame();
		frmRegistroEmpresa.setTitle("RegistroEmpresa");
		frmRegistroEmpresa.setName("RegistroEmpresa");
		frmRegistroEmpresa.setBounds(0, 0, 301, 155);
		frmRegistroEmpresa.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmRegistroEmpresa.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][]"));
		
		lbTítulo = new JLabel("Registro de envíos de empresa:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroEmpresa.getContentPane().add(lbTítulo, "cell 0 0");
		
		pnEmisor = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnEmisor.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmRegistroEmpresa.getContentPane().add(pnEmisor, "cell 0 2,grow");
		
		lbNombre = new JLabel("Nombre de la empresa:");
		lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnEmisor.add(lbNombre);
		
		tfNombre = new JTextField();
		pnEmisor.add(tfNombre);
		tfNombre.setColumns(10);
		
		JPanel pnBotones = new JPanel();
		FlowLayout fl_pnBotones = (FlowLayout) pnBotones.getLayout();
		fl_pnBotones.setAlignment(FlowLayout.RIGHT);
		frmRegistroEmpresa.getContentPane().add(pnBotones, "cell 0 3,grow");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btnCancelar);
		
		btRegistro = new JButton("Registrar envíos");
		btRegistro.setBackground(Color.GREEN);
		btRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnBotones.add(btRegistro);
	}
	
	public void reset() {
		this.tfNombre.setText("");
		this.getFrame().setVisible(false);
		
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmRegistroEmpresa; }
	public JButton getBtCancelar() { return this.btnCancelar;	}
	public JButton getBtRegistrar() { return this.btRegistro;	}
	public JTextField getTfNombreE() { return tfNombre; }

	public boolean comprobarCampos() {
		if(this.tfNombre.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Rellena con el nombre de la empresa");
			return false;
		}
		return true;
	}
}
