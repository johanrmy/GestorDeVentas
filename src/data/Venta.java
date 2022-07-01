package data;

public class Venta {
	private int id_venta;
	private int id_empleado;
	private int id_planta;
	private String comprador;
	private String dni;
	private int precio;
	private int cantidad;
	private Double igv;
	private Double total;
	public Venta(int id_empleado, int id_planta, String comprador, String dni, int precio, int cantidad,
			Double igv, Double total) {
		super();
		this.id_empleado = id_empleado;
		this.id_planta = id_planta;
		this.comprador = comprador;
		this.dni = dni;
		this.precio = precio;
		this.cantidad = cantidad;
		this.igv = igv;
		this.total = total;
	}
	public Venta() {
		
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public int getId_planta() {
		return id_planta;
	}
	public void setId_planta(int id_planta) {
		this.id_planta = id_planta;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getIgv() {
		return igv;
	}
	public void setIgv(Double igv) {
		this.igv = igv;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
