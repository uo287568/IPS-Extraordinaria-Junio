package giis.demo.tkrun;

import java.util.Random;

import javax.swing.JOptionPane;
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
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
		view.getBtRegistrar().addActionListener(e -> realizarPedido());
		view.getBtPrecio().addActionListener(e -> calcularPrecio());
	}
	
	private void calcularPrecio() {
		if(view.comprobarDimensiones()) {
			double largo = Double.parseDouble(view.getTfLargo().getText());
			double ancho = Double.parseDouble(view.getTfAncho().getText());
			double alto = Double.parseDouble(view.getTfAlto().getText());
			double peso = Double.parseDouble(view.getTfPeso().getText());
			double precioFinal = 25 + peso*2 + ((largo*ancho*alto) / 10000);
			double resultado = (double) Math.round(precioFinal * 100) / 100;
			view.getTfPrecio().setText(String.valueOf(resultado));
		}
	}

	private void realizarPedido() {
		if (view.comprobarCampos()) {
			Random rd = new Random();
			int nref = rd.nextInt(999999999);
			model.crearPedido(nref, view.getTfNombreE().getText(), view.getTfCorreoE().getText(), view.getTfDireccionE().getText(), 
					view.getTfNombreR().getText(), view.getTfCorreoR().getText(), view.getTfDireccionR().getText(), view.getTfLargo().getText(), 
					view.getTfAncho().getText(), view.getTfAlto().getText(), view.getTfPeso().getText(), view.getTfPrecio().getText(), view.getTxaComentarios().getText());
			JOptionPane.showMessageDialog(null, "REGISTRO DE PEDIDO REALIZADO CORRECTAMENTE. \nNÚMERO DE REFERENCIA DEL PEDIDO: " + nref);
			view.reset();
		}
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
	
	private void salir() {
		int eleccion=JOptionPane.showConfirmDialog(null, "¿Está segur@ de cancelar la creación del envío?");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}
}
