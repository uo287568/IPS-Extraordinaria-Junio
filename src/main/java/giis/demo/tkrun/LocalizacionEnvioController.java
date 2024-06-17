package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		view.getBtBuscar().addActionListener(e -> buscarEnvio());
	}

	private void buscarEnvio() {
		String nref = view.getTfNRef().getText();
		if(comprobarNRef(nref)) {
			limpiar();
			int nrefNum = Integer.parseInt(nref);
			EnvioDisplayDTO envio = model.getEnvio(nrefNum);
			if(comprobarEnvio(envio, nrefNum)) {
				mostrarInfo(envio);
				mostrarMovimientos(nrefNum);
			}
		}
	}

	private void limpiar() {
		DefaultTableModel model1 = (DefaultTableModel) view.getTbInfo().getModel();
        model1.setRowCount(0);
		DefaultTableModel model2 = (DefaultTableModel) view.getTbMovimientos().getModel();
        model2.setRowCount(0);
	}

	private void mostrarMovimientos(int nrefNum) {
		List<MovimientosDisplayDTO> movimientos = model.getMovimientos(nrefNum);
		if(movimientos.size() > 0) {
			TableModel tmodel = SwingUtil.getTableModelFromPojos(movimientos, new String[] {"movimiento", "ubicacion","fechaMov"});
			view.getTbMovimientos().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTbMovimientos());
			if (movimientos.get(0).getMovimiento().equals("Entrega")) {
				view.getTfEstado().setText("ENTREGADO");
			} else {
				view.getTfEstado().setText("EN CAMINO");
			}
		}
	}

	private void mostrarInfo(EnvioDisplayDTO envio) {
		List<EnvioDisplayDTO> envios = new ArrayList<>();
		envios.add(envio);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(envios, new String[] {"nref", "nombreEmisor", "correoEmisor","direccionEmisor","direccionReceptor"});
		view.getTbInfo().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTbInfo());
		view.getTfEstado().setText("REGISTRADO");
	}

	private boolean comprobarEnvio(EnvioDisplayDTO envio, int nrefNum) {
		if (envio==null) {
			JOptionPane.showMessageDialog(null, "No existe un envío con el \nnúmero de referencia: " + nrefNum);
			return false;
		} else return true;
	}

	private boolean comprobarNRef(String nref) {
		try {
			if(nref.isBlank() || Integer.parseInt(nref) <= 0) {
				JOptionPane.showMessageDialog(null, "Formato de número de referencia inválido");
				return false;
			} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato de Número de referencia inválido");
			return false;
		}
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
