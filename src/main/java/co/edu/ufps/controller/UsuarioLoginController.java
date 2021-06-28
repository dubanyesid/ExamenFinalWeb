package co.edu.ufps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.UsuarioDAO;
import co.edu.ufps.entities.Usuario;

/**
 * Servlet implementation class UsuarioLoginController
 */
@WebServlet({ "/UsuarioLoginController", "/Usuario" })
public class UsuarioLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLoginController() {
        super();
        usuarioDao = new UsuarioDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("UsuarioLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		Usuario u = usuarioDao.findByField("usuario", usuario);
		if (u != null) {
			if (u.getUsuario().equals(usuario) && u.getPass().equals(pass) && u.getState() == 1) {
				request.getSession().setAttribute("user", u);
				request.setAttribute("usuario",u);
				RequestDispatcher dispatcher = request.getRequestDispatcher("logueado.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("UsuarioLogin.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.print("null");
			RequestDispatcher dispatcher = request.getRequestDispatcher("UsuarioLogin.jsp");
			dispatcher.forward(request, response);
		}
	}
}

