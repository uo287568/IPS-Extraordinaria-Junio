package giis.demo.tkrun;
/**
 * Cada una de las filas que muestran al usuario las carreras y su estado
 * IMPORTANTE: Cuando se usan los componentes de Apache Commons DbUtils debe
 * mantenerse de forma estricta el convenio de capitalización de Java:
 *  - Capitalizar todas las palabras que forman un identificador 
 *    excepto la primera letra de nombres de métodos y variables.
 *  - No utilizar subrayados
 * Seguir tambien estos mismos criterios en los nombres de tablas y campos de la BD
 */
public class EnvioDisplayDTO {
	private String nref;
	private String nombreEmisor;
	private String correoEmisor;
	private String direccionEmisor;
	private String nombreReceptor;
	private String correoReceptor;
	private String direccionReceptor;
	private Double largo;
	private Double ancho;
	private Double alto;
	private Double peso;
	private Double precio;
	private String instrExtra;
	public EnvioDisplayDTO() {}
	public EnvioDisplayDTO(String nref, String nombreEmisor, String correoEmisor, String direccionEmisor,
			String nombreReceptor, String correoReceptor, String direccionReceptor, Double largo, Double ancho,
			Double alto, Double peso, Double precio, String instrExtra) {
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
	public String getNref() {
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
	public Double getLargo() {
		return largo;
	}
	public Double getAncho() {
		return ancho;
	}
	public Double getAlto() {
		return alto;
	}
	public Double getPeso() {
		return peso;
	}
	public Double getPrecio() {
		return precio;
	}
	public String getInstrExtra() {
		return instrExtra;
	}
	public void setNref(String nref) {
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
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public void setInstrExtra(String instrExtra) {
		this.instrExtra = instrExtra;
	}
}
