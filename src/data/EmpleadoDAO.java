package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO extends DB implements CRUD {
	public String ape;
	public String nom;
	public String dni;
	public String fecha_na;
	public String dir;
	public String telf;
	public String puesto;
	public int sueldo;
	
	public EmpleadoDAO(String ape, String nom, String dni, String fecha_na, String dir, String telf, String puesto,
			int sueldo) {
		super();
		this.ape = ape;
		this.nom = nom;
		this.dni = dni;
		this.fecha_na = fecha_na;
		this.dir = dir;
		this.telf = telf;
		this.puesto = puesto;
		this.sueldo = sueldo;
	}
	public EmpleadoDAO() {

	}
	public List consulta() {
		List<Empleado> lista=new ArrayList<>();
        try{
        	String sql = "select * from empleado";
            PreparedStatement sen=conexion().prepareStatement(sql);
            ResultSet data=sen.executeQuery();

            while(data.next()) {
            	Empleado e=new Empleado();
            	e.setId_empleado(data.getInt(1));
            	e.setApellidos(data.getString(2));
            	e.setNombres(data.getString(3));
            	e.setDni(data.getString(4));
            	e.setFecha_nacimiento(data.getString(5));
            	e.setDireccion(data.getString(6));
              	e.setTelefono(data.getString(7));
              	e.setPuesto(data.getString(8));
              	e.setSueldo(data.getInt(9));
              	lista.add(e);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;	
	}
	public List consulta(int id) {
		List<Empleado> lista=new ArrayList<>();
        try{
        	String sql = "select * from empleado where id_empleado=?";
            PreparedStatement sen=conexion().prepareStatement(sql);
            sen.setInt(1, id);
            ResultSet data=sen.executeQuery();
            while(data.next()) {
            	Empleado e=new Empleado();
            	e.setId_empleado(data.getInt(1));
            	e.setApellidos(data.getString(2));
            	e.setNombres(data.getString(3));
            	e.setDni(data.getString(4));
            	e.setFecha_nacimiento(data.getString(5));
            	e.setDireccion(data.getString(6));
              	e.setTelefono(data.getString(7));
              	e.setPuesto(data.getString(8));
              	e.setSueldo(data.getInt(9));
              	lista.add(e);
            }
        }catch(SQLException r2) {
            System.out.println("Error en la consulta"+r2);
        	}
		return lista;
	}
	public boolean registro() {
        try {
        	Empleado e=new Empleado(ape,nom,dni,fecha_na,dir,telf,puesto,sueldo);
        	String sql = "INSERT INTO empleado VALUES(default,?,?,?,?,?,?,?,?)";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setString(1,e.getApellidos());
			ps.setString(2,e.getNombres());
			ps.setString(3,e.getDni());
			ps.setString(4,e.getFecha_nacimiento());
			ps.setString(5,e.getDireccion());
			ps.setString(6,e.getTelefono());
			ps.setString(7,e.getPuesto());
			ps.setInt(8,e.getSueldo());
            ps.executeUpdate();
        }catch(SQLException r3) {
            System.out.println("Error en la Inserción"+r3);
        }
        return true;
	}
	public void eliminar(int id) {
		try {
	    	String sql = "DELETE FROM empleado WHERE id_empleado=?";
			PreparedStatement ps;
			ps = conexion().prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar"+e);
		}
	}
	public void actualizacion(int id) {
		Empleado e=new Empleado(ape,nom,dni,fecha_na,dir,telf,puesto,sueldo);
	try {
    	String sql = "UPDATE empleado SET apellidos=?,nombres=?,direccion=?,telefono=?,puesto=?,sueldo=? "
    			+ "where id_empleado=?";
		PreparedStatement ps;
		ps = conexion().prepareStatement(sql);
		ps.setString(1,e.getApellidos());
		ps.setString(2,e.getNombres());
		ps.setString(3,e.getDireccion());
		ps.setString(4,e.getTelefono());
		ps.setString(5,e.getPuesto());
		ps.setInt(6,e.getSueldo());
		ps.setInt(7, id);
		ps.executeUpdate();
	} catch (SQLException er) {
		System.out.println("Error al actualizar id"+er);
		}
	}
}
