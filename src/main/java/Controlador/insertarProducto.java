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
 * Servlet implementation class insertarProducto
 */
@WebServlet("/insertarProducto")
public class insertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ModeloProducto modeloProducto = new ModeloProducto();
		ModeloSeccion modeloSeccion = new ModeloSeccion();

		modeloSeccion.conectar();
		modeloProducto.conectar();

		ArrayList<Producto> productos = modeloProducto.getAllProductos();
		ArrayList<Seccion> secciones = modeloSeccion.getAllSecciones();

		modeloSeccion.cerrar();
		modeloProducto.cerrar();

		request.setAttribute("secciones", secciones);
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("productos/insertarProductos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String pcantidad = request.getParameter("cantidad");
		String pprecio = request.getParameter("precio");
		String caducidad = request.getParameter("caducidad");
		String pseccion = request.getParameter("id_seccion");

		System.out.println(caducidad);

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

			modeloProducto.insertarProducto(producto);

			modeloProducto.cerrar();
			modeloSeccion.cerrar();
			
			request.getRequestDispatcher("mostrarProductos").forward(request, response);
		}
	}

}

