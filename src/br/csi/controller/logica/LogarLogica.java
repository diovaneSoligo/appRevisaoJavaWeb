package br.csi.controller.logica;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.Usuario;
import br.csi.model.dao.UsuarioDao;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
System.out.println("... dentro do excuta no LogarLogica");	

	
	String login = rq.getParameter("login");
	String senha = rq.getParameter("senha");
	System.out.println("login:"+login);	
	System.out.println("senha:"+senha);	
	
	
	Usuario u = new Usuario();
	u.setLogin(login);
	u.setSenha(senha);

	System.out.println("Cria o uD de usuarioDAO");	
	UsuarioDao uD = new UsuarioDao();
	
	String pagina = "/index.jsp";
	
	try {
		
		boolean retorno = uD.autenticado(u);
		if(retorno){
			System.out.println("Manda para principal");	
			pagina = "/WEB-INF/jsp/principal.jsp";
			rq.setAttribute("usuario", u);
			rq.setAttribute("usuarios", uD.getUsuarios());
		}else{
			rq.setAttribute("msg", "Problemas ao logar");
		}
		
	} catch (SQLException e) {		
		e.printStackTrace();
		rq.setAttribute("msg", "Problemas ao logar");
		return pagina;
	}


		return pagina;//
	}

	
	
	
}
