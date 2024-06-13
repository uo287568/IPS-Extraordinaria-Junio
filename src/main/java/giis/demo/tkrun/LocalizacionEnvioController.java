package giis.demo.tkrun;

import giis.demo.util.SwingUtil;

public class LocalizacionEnvioController {
	private LocalizacionEnvioModel model;
	private LocalizacionEnvioView view;

	public LocalizacionEnvioController(LocalizacionEnvioModel localizacionEnvioModel, LocalizacionEnvioView localizacionEnvioView) {
		this.model = localizacionEnvioModel;
		this.view = localizacionEnvioView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.reset()));
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
