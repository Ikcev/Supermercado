package ModeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ModeloDTO.Conexion;
import ModeloDTO.Producto;

public class ModeloProducto extends Conexion {
	public boolean insertarProducto(Producto producto) {
		String st = "INSERT INTO productos (codigo, nombre, cantidad, precio, caducidad, id_seccion) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private Producto rellenarProducto(ResultSet rs) throws SQLException {
		Producto producto = new Producto();
		producto.setId(rs.getInt("id"));
		producto.setCodigo(rs.getString("codigo"));
		producto.setNombre(rs.getString("nombre"));
		producto.setCantidad(rs.getInt("cantidad"));
		producto.setPrecio(rs.getDouble("precio"));
		producto.setCaducidad(rs.getDate("caducidad"));
		
		ModeloSeccion modeloSeccion = new ModeloSeccion();
		modeloSeccion.conectar();

		producto.setSeccion(modeloSeccion.getSeccion(rs.getInt("id_seccion")));
		
		modeloSeccion.cerrar();
		return producto;
	}
	
	public ArrayList<Producto> getAllProductos() {
		String st = "SELECT * FROM productos";
		ArrayList<Producto> productos = new ArrayList<>();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				productos.add(rellenarProducto(rs));
			}
			
			return productos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean existeCodigoDuplicado(String codigo) {
        boolean codigoDuplicado = false;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT COUNT(*) AS count FROM productos WHERE codigo = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, codigo);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                codigoDuplicado = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return codigoDuplicado;
    }

}
