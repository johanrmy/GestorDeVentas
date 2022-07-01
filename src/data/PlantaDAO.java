	package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDAO extends DB implements CRUD{
	public String nom;
	public String nom_c;
	public String color;
	public String lugar;
	public String tipo;
	public int precio;
	public PlantaDAO(String nom, String nom_c, String color, String lugar, String tipo, int precio) {
		super();
		this.nom = nom;
		this.nom_c = nom_c;
		this.color = color;
		this.lugar = lugar;
		this.tipo = tipo;
		this.precio = precio;
	}
	public PlantaDAO() {
		
	}
	public List consulta(){
		List<Planta> lista=new ArrayList<>();
        try{
        	String sql = "select * from planta";
            PreparedStatement sen=conexion().prepareStatement(sql);
            ResultSet data=sen.executeQuery();

            while(data.next()) {
            	Planta p=new Planta();
            	p.setId_planta(data.getInt(1));
            	p.setNombre(data.getString(2));
            	p.setNombre_cientifico(data.getString(3));
            	p.setColor(data.getString(4));
            	p.setLugar(data.getString(5));
              	p.setTipo(data.getString(6));
              	p.setPrecio(data.getInt(7));
              	lista.add(p);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;	
        }
    public boolean registro(){
        try {
        	Planta p=new Planta(nom, nom_c, color, lugar, tipo,precio);
        	String sql = "INSERT INTO planta VALUES(default,?,?,?,?,?,?)";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setString(1,p.getNombre());
			ps.setString(2,p.getNombre_cientifico());
			ps.setString(3,p.getColor());
			ps.setString(4,p.getLugar());
			ps.setString(5,p.getTipo());
			ps.setInt(6, p.getPrecio());
            ps.executeUpdate();
        }catch(SQLException r3) {
            System.out.println("Error en la Inserción"+r3);
        }
        return true;
    }
    public void eliminar(int id) {
		try {
	    	String sql = "DELETE FROM planta WHERE id_planta=?";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar"+e);
		}
    }
    public List consulta(int id) {
		List<Planta> lista=new ArrayList<>();
        try{
        	String sql = "select * from planta where id_planta=?";
            PreparedStatement sen=conexion().prepareStatement(sql);
            sen.setInt(1, id);
            ResultSet data=sen.executeQuery();
            while(data.next()) {
            	Planta p=new Planta();
            	p.setId_planta(data.getInt(1));
            	p.setNombre(data.getString(2));
            	p.setNombre_cientifico(data.getString(3));
            	p.setColor(data.getString(4));
            	p.setLugar(data.getString(5));
              	p.setTipo(data.getString(6));
              	p.setPrecio(data.getInt(7));
              	lista.add(p);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;	
    }
    public void actualizacion(int id) {
			Planta p=new Planta(nom,nom_c,color,lugar,tipo,precio);
		try {
	    	String sql = "UPDATE planta SET nombre=?,nombre_cientifico=?,color=?,lugar=?,tipo=?,precio=? where id_planta=?";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setString(1,p.getNombre());
			ps.setString(2,p.getNombre_cientifico());
			ps.setString(3,p.getColor());
			ps.setString(4,p.getLugar());
			ps.setString(5,p.getTipo());
			ps.setInt(6, p.getPrecio());
			ps.setInt(7,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al actualizar id"+e);
		}
    }
}
