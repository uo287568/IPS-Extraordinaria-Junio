package giis.demo.tkrun;

public class PedidosTransportistaDisplayDTO {
	private int id;
	private int nref;
	private String nombreEmisor;
	private String correoEmisor;
	private String direccionEmisor;
	private String direccionReceptor;
	private String fechaEntrega;
	public PedidosTransportistaDisplayDTO() {}
	public PedidosTransportistaDisplayDTO(int id, int nref, String nombreEmisor, String correoEmisor,
			String direccionEmisor, String direccionReceptor, String fechaEntrega) {
		super();
		this.id = id;
		this.nref = nref;
		this.nombreEmisor = nombreEmisor;
		this.correoEmisor = correoEmisor;
		this.direccionEmisor = direccionEmisor;
		this.direccionReceptor = direccionReceptor;
		this.fechaEntrega = fechaEntrega;
	}
	public int getId() {
		return id;
	}
	public int getNref() {
		return nref;
	}
	public String getNombreEmisor() {
		return nombreEmisor;
	}
	public String getCorreoEmisor() {
		return correoEmisor;
	}
	public String getDireccionEmisor() {
		return direccionEmisor;
	}
	public String getDireccionReceptor() {
		return direccionReceptor;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}
	public void setCorreoEmisor(String correoEmisor) {
		this.correoEmisor = correoEmisor;
	}
	public void setDireccionEmisor(String direccionEmisor) {
		this.direccionEmisor = direccionEmisor;
	}
	public void setDireccionReceptor(String direccionReceptor) {
		this.direccionReceptor = direccionReceptor;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
}
