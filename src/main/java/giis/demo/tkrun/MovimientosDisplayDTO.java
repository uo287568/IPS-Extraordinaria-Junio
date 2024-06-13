package giis.demo.tkrun;

public class MovimientosDisplayDTO {
	private int id;
	private int nref;
	private String movimiento;
	private String ubicacion;
	private String fechaMov;
	public MovimientosDisplayDTO() {}
	public MovimientosDisplayDTO(int id, int nref, String movimiento, String ubicacion, String fechaMov) {
		super();
		this.id = id;
		this.nref = nref;
		this.movimiento = movimiento;
		this.ubicacion = ubicacion;
		this.fechaMov = fechaMov;
	}
	public int getId() {
		return id;
	}
	public int getNref() {
		return nref;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public String getFechaMov() {
		return fechaMov;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public void setFechaMov(String fechaMov) {
		this.fechaMov = fechaMov;
	}
	
}
