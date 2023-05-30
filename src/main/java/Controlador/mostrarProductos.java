package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModeloDAO.ModeloProducto;
import ModeloDTO.Producto;

/**
 * Servlet implementation class mostrarProductos
 */
@WebServlet("/mostrarProductos")
public class mostrarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mostrarProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String busca = request.getParameter("buscador");
		ModeloProducto modeloProducto = new ModeloProducto();
		modeloProducto.conectar();
		
		ArrayList<Producto> productos = modeloProducto.getAllProductos();
		
		
		if(busca != null){
			ArrayList<Producto> resultados = new ArrayList<>();
		    for (Producto producto : productos) {
		        if (producto.getNombre().contains(busca) || producto.getCodigo().contains(busca)) {
		            resultados.add(producto);
		        }
		    }
		    request.setAttribute("resultados", resultados);
		    request.getRequestDispatcher("productos/verResultados.jsp").forward(request, response);
		}else {
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("productos/verProductos.jsp").forward(request, response);
		}
		modeloProducto.cerrar();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
