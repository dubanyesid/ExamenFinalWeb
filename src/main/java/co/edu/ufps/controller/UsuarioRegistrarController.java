package co.edu.ufps.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.RolDAO;
import co.edu.ufps.dao.UsuarioDAO;

import java.io.IOException;
import java.util.List;
import co.edu.ufps.entities.Usuario;
import co.edu.ufps.entities.Rol;
import co.edu.ufps.util.*;

/**
 * Servlet implementation class UsuarioRegistrarController
 */
@WebServlet({ "/UsuarioRegistrarController", "/UsuarioRegistrar" })
public class UsuarioRegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolDAO rolDao;
	private UsuarioDAO usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioRegistrarController() {
        super();
        rolDao = new RolDAO();
        usuarioDao = new UsuarioDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Rol> roles = rolDao.list();
		request.setAttribute("roles",roles);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UsuarioRegistrar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
        Rol rol = rolDao.find(Integer.parseInt(role));
        short state = Short.parseShort(request.getParameter("state"));
        Usuario u = new Usuario();
        u.setUsuario(usuario);
        u.setEmail(email);
        u.setPass(pass);
        u.setRol(rol);
        u.setState(state);
        EnviarEmail ee = new EnviarEmail();
        ee.enviarEmail(email, "Registro exitoso sistema reportes",  "http://localhost:8086"+request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/Registro?registro=Se ha registrado verifique su correo electronico");
        usuarioDao.insert(u);
		doGet(request, response);
	}

}