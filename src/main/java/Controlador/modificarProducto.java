package Controlador;

import java.io.IOException;
import java.util.ArrayList;

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
		request.getRequestDispatcher("productos/modificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
