package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * Vista de la pantalla que muestra las carreras activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde CarrerasMain) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class EnviosView {

	private JFrame frame;
	private JTextField tfNombreE;
	private JTextField tfCorreoE;
	private JTextField textField;
	private JTextField tfNombreR;
	private JTextField tfCorreoR;
	private JTextField tfDireccionR;
	private JTextField tfLargo;
	private JTextField tfAncho;
	private JTextField tfAlto;
	private JTextField tfPeso;
	private JTextField tfPrecio;

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
		frame = new JFrame();
		frame.setTitle("Carreras");
		frame.setName("Carreras");
		frame.setBounds(0, 0, 595, 422);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][][][][grow][][][]"));
		
		final JLabel lbInfoE;
		
		JLabel lbTítulo = new JLabel("Registro de envíos a domicilio:");
		lbTítulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lbTítulo, "cell 0 0");
		
				lbInfoE = new JLabel("Información del emisor del paquete:");
				lbInfoE.setFont(new Font("Tahoma", Font.PLAIN, 13));
				frame.getContentPane().add(lbInfoE, "cell 0 1");
		
		JPanel pnEmisor = new JPanel();
		frame.getContentPane().add(pnEmisor, "cell 0 2,grow");
		
		JLabel lbNombreE = new JLabel("Nombre:");
		pnEmisor.add(lbNombreE);
		
		tfNombreE = new JTextField();
		pnEmisor.add(tfNombreE);
		tfNombreE.setColumns(10);
		
		JLabel lbCorreoE = new JLabel("Correo:");
		pnEmisor.add(lbCorreoE);
		
		tfCorreoE = new JTextField();
		pnEmisor.add(tfCorreoE);
		tfCorreoE.setColumns(10);
		
		JLabel lbDireccionE = new JLabel("Dirección de recogida:");
		pnEmisor.add(lbDireccionE);
		
		textField = new JTextField();
		pnEmisor.add(textField);
		textField.setColumns(10);
		
		JLabel lbInfoR = new JLabel("Información del receptor del paquete:");
		lbInfoR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lbInfoR, "cell 0 3");
		
		JPanel pnReceptor = new JPanel();
		frame.getContentPane().add(pnReceptor, "cell 0 4,grow");
		
		JLabel lbNombreR = new JLabel("Nombre:");
		pnReceptor.add(lbNombreR);
		
		tfNombreR = new JTextField();
		tfNombreR.setColumns(10);
		pnReceptor.add(tfNombreR);
		
		JLabel lbCorreoR = new JLabel("Correo:");
		pnReceptor.add(lbCorreoR);
		
		tfCorreoR = new JTextField();
		tfCorreoR.setColumns(10);
		pnReceptor.add(tfCorreoR);
		
		JLabel lbDireccionR = new JLabel("Dirección de recogida:");
		pnReceptor.add(lbDireccionR);
		
		tfDireccionR = new JTextField();
		tfDireccionR.setColumns(10);
		pnReceptor.add(tfDireccionR);
		
		JLabel lbPaquete = new JLabel("Información sobre el paquete: (cm y kg)");
		lbPaquete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lbPaquete, "cell 0 5");
		
		JPanel pnPaquete = new JPanel();
		frame.getContentPane().add(pnPaquete, "cell 0 6,grow");
		
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
		frame.getContentPane().add(lbInstrucciones, "cell 0 7");
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, "cell 0 8,grow");
		
		JLabel lbPrecio = new JLabel("Precio final en euros (€):");
		lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lbPrecio, "cell 0 9");
		
		JPanel pnPrecio = new JPanel();
		frame.getContentPane().add(pnPrecio, "cell 0 10,grow");
		pnPrecio.setLayout(new GridLayout(0, 5, 0, 0));
		
		tfPrecio = new JTextField();
		pnPrecio.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel, "cell 0 11,grow");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btnCancelar);
		
		JButton btLimpiar = new JButton("Limpiar");
		btLimpiar.setBackground(Color.LIGHT_GRAY);
		btLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btLimpiar);
		
		JButton btRegistro = new JButton("Registrar envío");
		btRegistro.setBackground(Color.GREEN);
		btRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(btRegistro);
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	
}
