package data;
import java.sql.*;
public class DB {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String db = "jdbc:mysql://localhost/pfinal";
	private String user = "root";
	private String pw = "";
	private Connection conn;
	
	public Connection conexion() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db,user,pw);
		} catch (ClassNotFoundException e1) {
			System.out.println("Eror en el driver");
		} catch (SQLException sqle1) {
			System.out.println("Error en la conexión");
		}
		return conn;
	}
	
	public void cerrar() {
		try {
			if (conexion() != null) {
				if (!conexion().isClosed()) {
			        conn.close();
				}
			}
	    } catch (SQLException sqle2) {
			System.out.println("Error al cerrar conexión");

	    }
	}
}