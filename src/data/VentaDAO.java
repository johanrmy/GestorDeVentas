package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO extends DB implements CRUD {
	public int id_e;
	public int id_p;
	public String com;
	public String dni;
	public int pre;
	public int can;
	public Double igv;
	public Double tot;
	public VentaDAO(int id_e, int id_p, String com, String dni, int pre, int can, Double igv, Double tot) {
		this.id_e = id_e;
		this.id_p = id_p;
		this.com = com;
		this.dni = dni;
		this.pre = pre;
		this.can = can;
		this.igv = igv;
		this.tot = tot;
	}
	public VentaDAO() {
		
	}
	public List consulta() {
		List<Venta> lista=new ArrayList<>();
        try{
        	String sql = "select * from venta";
            PreparedStatement sen=conexion().prepareStatement(sql);
            ResultSet data=sen.executeQuery();
            while(data.next()) {
            	Venta v=new Venta();
            	v.setId_venta(data.getInt(1));
            	v.setId_empleado(data.getInt(2));
            	v.setId_planta(data.getInt(3));;
            	v.setComprador(data.getString(4));
            	v.setDni(data.getString(5));
            	v.setPrecio(data.getInt(6));
              	v.setCantidad(data.getInt(7));
              	v.setIgv(data.getDouble(8));
              	v.setTotal(data.getDouble(9));
              	lista.add(v);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;	
	}
	public List consulta(int id) {
		List<Venta> lista=new ArrayList<>();
        try{
        	String sql = "select * from venta where id_venta=?";
            PreparedStatement sen=conexion().prepareStatement(sql);
            sen.setInt(1, id);
            ResultSet data=sen.executeQuery();
            while(data.next()) {
            	Venta v=new Venta();
            	v.setId_venta(data.getInt(1));
            	v.setId_empleado(data.getInt(2));
            	v.setId_planta(data.getInt(3));;
            	v.setComprador(data.getString(4));
            	v.setDni(data.getString(5));
            	v.setPrecio(data.getInt(6));
              	v.setCantidad(data.getInt(7));
              	v.setIgv(data.getDouble(8));
              	v.setTotal(data.getDouble(9));
              	lista.add(v);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;
	}
	public boolean registro() {
        try {
        	Venta v=new Venta(id_e,id_p,com,dni,pre,can,igv,tot);
        	String sql = "INSERT INTO venta VALUES(default,?,?,?,?,(select precio from planta where id_planta=?),?,?,?)";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setInt(1,v.getId_empleado());
			ps.setInt(2,v.getId_planta());
			ps.setString(3,v.getComprador());
			ps.setString(4,v.getDni());
			ps.setInt(5,v.getPrecio());
			ps.setInt(6,v.getCantidad());
			ps.setDouble(7,v.getIgv());
			ps.setDouble(8,v.getTotal());
            ps.executeUpdate();
        }catch(SQLException r3) {
            System.out.println("Error en la Inserción"+r3);
        }
        return true;
	}
	public void eliminar(int id) {
		try {
	    	String sql = "DELETE FROM venta WHERE id_venta=?";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar"+e);
		}
	}
	public void actualizacion(int id) {
    	Venta v=new Venta(id_e,id_p,com,dni,pre,can,igv,tot);
		try {
	    	String sql = "UPDATE venta SET id_planta=?,comprador=?,dni=?,cantidad=?,igv=?,total=? WHERE id_venta=?";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setInt(1,v.getId_planta());
			ps.setString(2,v.getComprador());
			ps.setString(3,v.getDni());
			ps.setInt(4,v.getCantidad());
			ps.setDouble(5,v.getIgv());
			ps.setDouble(6,v.getTotal());
			ps.setInt(7,id);
			ps.executeUpdate();
		} catch (SQLException er) {
			System.out.println("Error al actualizar id"+er);
			}
	}
	
	
}
