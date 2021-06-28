package co.edu.ufps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.ufps.dao.ConnectiontokenDAO;
import co.edu.ufps.entities.Connectiontoken;
import co.edu.ufps.entities.Typedb;
import co.edu.ufps.entities.Usuario;


/**
 * Servlet implementation class token
 */
@WebServlet("/token")
public class token extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ConnectiontokenDAO tokendao=new ConnectiontokenDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public token() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String partes[]=request.getRequestURI().split("/");
		String action=partes[3];
		try {
			switch(action) {
				case "registrar":registrarToken(request,response);
				break;

			}
		}catch(Exception e) {
			System.out.print("Ha ocurrido un error\n"+e.getMessage());
		}
	}
	protected void registrarToken(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host=request.getParameter("host");
		String userdb=request.getParameter("userdb");
		int port=Integer.parseInt(request.getParameter("port"));
		Typedb tipo=new Typedb();
		tipo.setId(request.getParameter("typedb"));
		String pass=request.getParameter("pass");
		
		Connectiontoken ct=new Connectiontoken();
		ct.setHost(host);
		ct.setUserdb(userdb);
		ct.setPort(new Short(port+""));
		ct.setTypedb(tipo);
		ct.setPass(pass);
		ct.setToken("hola123");
		HttpSession misession= request.getSession(true);
		Usuario user=(Usuario)misession.getAttribute("usuario");
		ct.setUsuario(user);
		this.tokendao.insert(ct);
		
		response.sendRedirect("../dashboard/tokens.jsp");
		
	}
}
