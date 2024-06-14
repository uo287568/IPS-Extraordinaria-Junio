package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import giis.demo.tkrun.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Servicio de envíos");
		frame.setBounds(0, 0, 314, 246);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);
			
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton bntEnvioADomicilio = new JButton("Registro de envíos a domicilio");
		bntEnvioADomicilio.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				EnviosController controller=new EnviosController(new EnviosModel(), new EnviosView());
				controller.initController();
			}
		});
		frame.getContentPane().add(bntEnvioADomicilio);
		
		JButton bntLocalizacion = new JButton("Localización de envíos");
		bntLocalizacion.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				LocalizacionEnvioController controller=new LocalizacionEnvioController(new LocalizacionEnvioModel(), new LocalizacionEnvioView());
				controller.initController();
			}
		});
		frame.getContentPane().add(bntLocalizacion);
		
		JButton btnEnviosTransportista = new JButton("Lista de envíos del transportista");
		btnEnviosTransportista.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				TransportistaController controller=new TransportistaController(new TransportistaModel(), new TransportistaView());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnEnviosTransportista);
		
		JButton btnCarga = new JButton("Carga de envíos");
		btnCarga.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CargaController controller=new CargaController(new CargaModel(), new CargaView());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnCarga);
		
		JButton btnDescarga = new JButton("Descarga de envíos");
		btnDescarga.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				DescargaController controller=new DescargaController(new DescargaModel(), new DescargaView());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnDescarga);
	}

	public JFrame getFrame() { return this.frame; }
	
}
