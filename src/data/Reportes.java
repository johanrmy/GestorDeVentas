package data;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes extends DB{
	public void reporte1(String reporte, String consulta) {
		try {
			Connection conn = conexion();
			String sql = consulta;
			String ruta = "src/reportes/"+reporte+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			JRDesignQuery jrdq=new JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr=JasperCompileManager.compileReport(jd);
			JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
			JasperViewer.viewReport(jp,false);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al generar reporte");
		}
	}
	public void reporte2(String reporte, String consulta, String columna,String condicion) {
		try {
			Connection conn = conexion();
			String sql = consulta;
			String ruta = "src/reportes/"+reporte+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			Map<String,Object> map=new HashMap<String,Object>();
			map.clear();
			map.put(columna, condicion);
			JRDesignQuery jrdq=new JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr=JasperCompileManager.compileReport(jd);
			JasperPrint jp=JasperFillManager.fillReport(jr, map,conn);
			JasperViewer.viewReport(jp,false);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al generar reporte");
		}
	}
	public void reporte3(String reporte, String consulta, int codigo) {
		try {
			Connection conn = conexion();
			String sql = consulta;
			String ruta = "src/reportes/"+reporte+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			Map<String,Object> map=new HashMap<String,Object>();
			map.clear();
			map.put("id_planta", codigo);
			JRDesignQuery jrdq=new JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr=JasperCompileManager.compileReport(jd);
			JasperPrint jp=JasperFillManager.fillReport(jr, map,conn);
			JasperViewer.viewReport(jp,false);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al generar reporte");
		}
	}
}