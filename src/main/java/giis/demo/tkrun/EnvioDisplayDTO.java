package giis.demo.tkrun;

public class EnvioDisplayDTO {
	private int nref;
	private String nombreEmisor;
	private String correoEmisor;
	private String direccionEmisor;
	private String nombreReceptor;
	private String correoReceptor;
	private String direccionReceptor;
	private double largo;
	private double ancho;
	private double alto;
	private double peso;
	private double precio;
	private String instrExtra;
	public EnvioDisplayDTO() {}
	public EnvioDisplayDTO(int nref, String nombreEmisor, String correoEmisor, String direccionEmisor,
			String nombreReceptor, String correoReceptor, String direccionReceptor, double largo, double ancho,
			double alto, double peso, double precio, String instrExtra) {
		super();
		this.nref = nref;
		this.nombreEmisor = nombreEmisor;
		this.correoEmisor = correoEmisor;
		this.direccionEmisor = direccionEmisor;
		this.nombreReceptor = nombreReceptor;
		this.correoReceptor = correoReceptor;
		this.direccionReceptor = direccionReceptor;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.peso = peso;
		this.precio = precio;
		this.instrExtra = instrExtra;
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
	public String getNombreReceptor() {
		return nombreReceptor;
	}
	public String getCorreoReceptor() {
		return correoReceptor;
	}
	public String getDireccionReceptor() {
		return direccionReceptor;
	}
	public double getLargo() {
		return largo;
	}
	public double getAncho() {
		return ancho;
	}
	public double getAlto() {
		return alto;
	}
	public double getPeso() {
		return peso;
	}
	public double getPrecio() {
		return precio;
	}
	public String getInstrExtra() {
		return instrExtra;
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
	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}
	public void setCorreoReceptor(String correoReceptor) {
		this.correoReceptor = correoReceptor;
	}
	public void setDireccionReceptor(String direccionReceptor) {
		this.direccionReceptor = direccionReceptor;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setInstrExtra(String instrExtra) {
		this.instrExtra = instrExtra;
	}
}
