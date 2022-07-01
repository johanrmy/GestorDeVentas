package data;
public class Planta {
	 private int id_planta;
     private String nombre;
     private String nombre_cientifico;
     private String color;
     private String lugar;
     private String tipo;
     private int precio;
	public Planta(String nombre, String nombre_cientifico, String color, String lugar, String tipo, int precio) {
		this.nombre = nombre;
		this.nombre_cientifico = nombre_cientifico;
		this.color = color;
		this.lugar = lugar;
		this.tipo = tipo;
		this.precio = precio;
	}
	public Planta() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre_cientifico() {
		return nombre_cientifico;
	}
	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId_planta() {
		return id_planta;
	}
	public void setId_planta(int id_planta) {
		this.id_planta = id_planta;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}