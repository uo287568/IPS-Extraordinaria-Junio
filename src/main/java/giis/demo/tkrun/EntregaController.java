package giis.demo.tkrun;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class EntregaController {
	private EntregaModel model;
	private EntregaView view;

	public EntregaController(EntregaModel entregaModel, EntregaView entregaView) {
		this.model = entregaModel;
		this.view = entregaView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
		view.getBtRegistrar().addActionListener(e -> realizarEntrega());
		view.getBtInfo().addActionListener(e -> verInfo());
	}
	
	private void verInfo() {
		String nref = view.getTfNRef().getText();
		if(comprobarNRef(nref)) {
			int nrefnum = Integer.parseInt(nref);
			EnvioDisplayDTO envio = model.getEnvio(nrefnum);
			if(validarEnvio(envio,nrefnum)) {
				List<EnvioDisplayDTO> pedidos = new ArrayList<>();
				pedidos.add(envio);
				TableModel tmodel = SwingUtil.getTableModelFromPojos(pedidos, new String[] {"nombreReceptor", "correoReceptor","direccionReceptor"});
				view.getTbInfo().setModel(tmodel);
				SwingUtil.autoAdjustColumns(view.getTbInfo());
			}
		}	
	}

	private boolean validarEnvio(EnvioDisplayDTO envio, int nrefnum) {
		if (envio==null) {
			JOptionPane.showMessageDialog(null, "No existe un envio \ncon el NRef: " + nrefnum);
			return false;
		} else return true;
	}

	private boolean comprobarNRef(String nref) {
		try {
			if(nref.isBlank() || Integer.parseInt(nref) <= 0) {
				JOptionPane.showMessageDialog(null, "Formato de NRef inválido");
				return false;
			} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato de NRef inválido");
			return false;
		}
	}

	private void realizarEntrega() {
		if (comprobarCampos()) {
			int id = Integer.parseInt(view.getTfID().getText());
			int nref = Integer.parseInt(view.getTfNRef().getText());
			if (comprobarEnvio(id, nref)) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        LocalDateTime now = LocalDateTime.now();
		        String fechaHoraActual = dtf.format(now);
				model.registrarEntrega(id, nref, "Entrega", view.getTfUbicacion().getText(), fechaHoraActual);
				JOptionPane.showMessageDialog(null, "REGISTRO DE ENTREGA REALIZADO CORRECTAMENTE");
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
					JOptionPane.showMessageDialog(null, "No puede haber un movimiento de entrega seguido de uno de descarga. \nEl último movimiento debe ser de carga");
					return false;
				} else if (!envio.getDireccionReceptor().equals(view.getTfUbicacion().getText())) {
					JOptionPane.showMessageDialog(null, "La ubicación de la entrega no coincide con la de la entrega asignada");
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "El envío aún no ha sido recogido");
				return false;
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
		int eleccion=JOptionPane.showConfirmDialog(null, "¿Está segur@ de cancelar la entrega del envío?");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
