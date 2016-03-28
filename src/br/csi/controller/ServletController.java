package br.csi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.usuario;
import br.csi.model.dao.UsuarioDao;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		
		RequestDispatcher dispatcher;
		
		if(opcao.equals("logar")){
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			usuario u = new usuario();
			
			u.setLogin(login);
			u.setSenha(senha);
			
			UsuarioDao uD = new UsuarioDao();
			
			
			
			try{
				boolean retorno = uD.autenticado(u);
				if(retorno){
					String pagina="/WEB-INF/jsp/principal.jsp";
					request.setAttribute("usuario", u);
					
					dispatcher=getServletContext().getRequestDispatcher(pagina);
					
					dispatcher.forward(request, response);
				}else{
					String pagina="/index.jsp";
					request.setAttribute("msg", "ERRO AO LOGAR!!!!");
					
					dispatcher=getServletContext().getRequestDispatcher(pagina);
					
					dispatcher.forward(request, response);
				}
				
				
			}catch(SQLException e){
				
				e.printStackTrace();
				
				String pagina="/index.jsp";
				
				dispatcher=getServletContext().getRequestDispatcher(pagina);
				
				dispatcher.forward(request, response);
			}
			
		}else 
			if(opcao.equals("paginacadastro")){
				
				String pagina="/WEB-INF/jsp/cadastro.jsp";
				
				dispatcher=getServletContext().getRequestDispatcher(pagina);
				
				dispatcher.forward(request, response);
				
			}else
				if(opcao.equals("cadastroUsuario")){
					
					
					
					
				}
		
		
		
		
		
		
		
		
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
		doGet(request, response);
	}

}
