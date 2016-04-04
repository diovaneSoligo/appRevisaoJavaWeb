package br.csi.controller.logica;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.Usuario;
import br.csi.model.dao.UsuarioDao;

public class InserirUsuarioLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println(".......... dentro de inserir InserirUsuarioLogica");
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");
		
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);

		UsuarioDao uD = new UsuarioDao();
		
		String pagina = "/index.jsp";
		
		try {
			
			boolean retorno = uD.adiciona(u);
			if(retorno){
				
				pagina = "/WEB-INF/jsp/cadastraUsuario.jsp";
				rq.setAttribute("usuarios", uD.getUsuarios());
			}else{
				rq.setAttribute("msg", "Problemas ao inserir usuário");
			}
			
		} catch (Exception e) {		
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas ao inserir usuário");
			return pagina;
		}


			return pagina;//
		
		 
	}

}
