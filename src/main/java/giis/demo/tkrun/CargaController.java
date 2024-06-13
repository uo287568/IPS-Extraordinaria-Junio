package giis.demo.tkrun;

import giis.demo.util.SwingUtil;

public class CargaController {
	private CargaModel model;
	private CargaView view;

	public CargaController(CargaModel cargaModel, CargaView cargaView) {
		this.model = cargaModel;
		this.view = cargaView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.reset()));
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
