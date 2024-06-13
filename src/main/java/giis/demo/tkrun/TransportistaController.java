package giis.demo.tkrun;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class TransportistaController {
	private TransportistaModel model;
	private TransportistaView view;

	public TransportistaController(TransportistaModel transportistaModel, TransportistaView transportistaView) {
		this.model = transportistaModel;
		this.view = transportistaView;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	public void initController() {
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.reset()));
		view.getBtBuscar().addActionListener(e -> buscarTransportista());
	}

	private void buscarTransportista() {
		String id = view.getTfID().getText();
		if(comprobarID(id)) {
			int numID = Integer.parseInt(id);
			TransportistaDisplayDTO transportista = model.getTransportista(numID);
			if(validarTransportista(transportista,numID)) {
				getListaPedidos(numID);
			}
		}		
	}

	private void getListaPedidos(int numID) {
		List<PedidosTransportistaDisplayDTO> pedidos = model.getPedidosTransportista(numID);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(pedidos, new String[] {"nref", "nombreEmisor", "correoEmisor","direccionEmisor","direccionReceptor","fechaEntrega"});
		view.getTbPedidos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTbPedidos());
	}

	private boolean validarTransportista(TransportistaDisplayDTO transportista, int numID) {
		if (transportista==null) {
			JOptionPane.showMessageDialog(null, "No existe un transportista \ncon el ID: " + numID);
			return false;
		} else return true;
	}

	private boolean comprobarID(String id) {
		try {
			if(id.isBlank() || Integer.parseInt(id) <= 0) {
				JOptionPane.showMessageDialog(null, "Formato de ID inválido");
				return false;
			} else return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Formato de ID inválido");
			return false;
		}
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
}
