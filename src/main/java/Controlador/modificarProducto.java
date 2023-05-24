package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModeloDAO.ModeloProducto;
import ModeloDAO.ModeloSeccion;
import ModeloDTO.Producto;
import ModeloDTO.Seccion;

/**
 * Servlet implementation class modificarProducto
 */
@WebServlet("/modificarProducto")
public class modificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
			
			ModeloProducto modeloProducto = new ModeloProducto();
			modeloProducto.conectar();
			
			Producto producto = modeloProducto.getProducto(id);
			
			modeloProducto.cerrar();
			
			ModeloSeccion modeloSeccion = new ModeloSeccion();
			modeloSeccion.conectar();
			
			ArrayList<Seccion> secciones = modeloSeccion.getAllSecciones();
			
			modeloSeccion.cerrar();
			
			request.setAttribute("producto", producto);
			request.setAttribute("secciones", secciones);
			request.getRequestDispatcher("productos/modificarProducto.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String pcantidad = request.getParameter("cantidad");
		String pprecio = request.getParameter("precio");
		String caducidad = request.getParameter("caducidad");
		String pseccion = request.getParameter("id_seccion");

		Date fechaCaducidad = null;
		try {
			fechaCaducidad = new SimpleDateFormat("yyyy-MM-dd").parse(caducidad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cantidad = Integer.parseInt(pcantidad);
		double precio = Double.parseDouble(pprecio);
		
		ModeloProducto modeloProducto = new ModeloProducto();
		modeloProducto.conectar();
		
		ModeloSeccion modeloSeccion = new ModeloSeccion();
		modeloSeccion.conectar();
		
		Seccion seccion = modeloSeccion.getSeccion(Integer.parseInt(pseccion));


		if (modeloProducto.existeCodigoDuplicado(codigo)) {
			System.out.println("Error");
		} else if (precio <= 0 || cantidad <= 0) {
			System.out.println("Error");
		} else if (fechaCaducidad.before(new Date())) {
			System.out.println("Error");
		} else if (seccion == null) {
			System.out.println("Error");
		} else {


			Producto producto = new Producto();

			producto.setCodigo(codigo);
			producto.setNombre(nombre);
			producto.setCantidad(cantidad);
			producto.setPrecio(precio);
			producto.setCaducidad(fechaCaducidad);


			producto.setSeccion(seccion);

			modeloProducto.modificarProducto(producto);

			modeloProducto.cerrar();
			modeloSeccion.cerrar();
			
			request.getRequestDispatcher("mostrarProductos").forward(request, response);
		}
	}	
}
