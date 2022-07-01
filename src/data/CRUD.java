package data;

import java.util.List;

public interface CRUD {
	public List consulta();
	public List consulta(int id);
	public boolean registro();
	public void eliminar(int id);
	public void actualizacion(int id);
}
