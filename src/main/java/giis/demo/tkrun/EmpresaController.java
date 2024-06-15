package giis.demo.tkrun;

import javax.swing.JOptionPane;
import giis.demo.util.SwingUtil;

public class EmpresaController {
	private EmpresaModel model;
	private EmpresaView view;

	public EmpresaController(EmpresaModel empresaModel, EmpresaView empresaView) {
		this.model = empresaModel;
		this.view = empresaView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
		view.getBtRegistrar().addActionListener(e -> registrarEnvios());
	}

	private void registrarEnvios() {
		if (view.comprobarCampos()) {
			model.crearPedidos(view.getTfNombreE().getText());
			view.reset();
		}
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
	
	private void salir() {
		int eleccion=JOptionPane.showConfirmDialog(null, "¿Está segur@ de cancelar la creación de envíos?");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}
}
