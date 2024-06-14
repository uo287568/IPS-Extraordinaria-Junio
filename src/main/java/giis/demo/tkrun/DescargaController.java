package giis.demo.tkrun;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class DescargaController {
	private DescargaModel model;
	private DescargaView view;

	public DescargaController(DescargaModel descargaModel, DescargaView descargaView) {
		this.model = descargaModel;
		this.view = descargaView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
		view.getBtRegistrar().addActionListener(e -> realizarDescarga());
	}
	
	private void realizarDescarga() {
		if (comprobarCampos()) {
			int id = Integer.parseInt(view.getTfID().getText());
			int nref = Integer.parseInt(view.getTfNRef().getText());
			if (comprobarEnvio(id, nref)) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        LocalDateTime now = LocalDateTime.now();
		        String fechaHoraActual = dtf.format(now);
				model.registrarDescarga(id, nref, "Descarga", view.getTfUbicacion().getText(), fechaHoraActual);
				JOptionPane.showMessageDialog(null, "REGISTRO DE DESCARGA REALIZADO CORRECTAMENTE");
				view.reset();
			}
		}
	}

	private boolean comprobarEnvio(int id, int nref) {
		PedidosTransportistaDisplayDTO envio = model.getEnvio(id, nref);
		if (envio==null) {
			JOptionPane.showMessageDialog(null, "No existe un pedido con el número: " + nref + "\nasignado al repartidor con ID: " + id);
			return false;
		} else {
			MovimientosDisplayDTO movimiento = model.getLastMov(id, nref);
			if (movimiento != null) {
				if (movimiento.getMovimiento().equals("Descarga")) {
					JOptionPane.showMessageDialog(null, "No puede haber un movimiento de descarga seguido de otro de descarga. \nEl último movimiento debe ser de carga");
					return false;
				} else if (movimiento.getUbicacion().equals(view.getTfUbicacion().getText())) {
					JOptionPane.showMessageDialog(null, "La ubicación de la descarga coincide con la de la última carga");
					return false;
				}
			}
			return true;
		}
	}

	private boolean comprobarCampos() {
		try {
			if(view.getTfID().getText().isBlank() || view.getTfNRef().getText().isBlank() || view.getTfUbicacion().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Rellena todos los campos");
				return false;
			} else if(Integer.parseInt(view.getTfID().getText()) <= 0 || Integer.parseInt(view.getTfNRef().getText()) <= 0) {
				JOptionPane.showMessageDialog(null, "Formato de ID o Número de referencia inválido");
				return false;
			} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato de ID o Número de referencia inválido");
			return false;
		}
	}

	private void salir() {
		int eleccion=JOptionPane.showConfirmDialog(null, "¿Está segur@ de cancelar la descarga del envío?");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
