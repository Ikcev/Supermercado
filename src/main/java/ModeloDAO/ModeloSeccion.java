package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ModeloDTO.Conexion;
import ModeloDTO.Seccion;

public class ModeloSeccion extends Conexion {
	public boolean insertarSeccion(Seccion seccion) {
		String st = "INSERT INTO secciones (nombre) values (?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, seccion.getNombre());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Seccion getSeccion(int id) {
		String st = "SELECT * FROM secciones WHERE id=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Seccion seccion = rellenarSeccion(rs);
			
			return seccion;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Seccion rellenarSeccion(ResultSet rs) throws SQLException {
		Seccion seccion = new Seccion();
		
		seccion.setId(rs.getInt("id"));
		seccion.setNombre(rs.getString("nombre"));
		
		return seccion;
	}
	
	public ArrayList<Seccion> getAllSecciones() {
		String st = "SELECT * FROM secciones";
		ArrayList<Seccion> secciones = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				secciones.add(rellenarSeccion(rs));
			}
			
			return secciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
