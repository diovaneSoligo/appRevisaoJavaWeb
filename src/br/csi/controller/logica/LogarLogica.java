package br.csi.controller.logica;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.usuario;
import br.csi.model.dao.UsuarioDao;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		
		System.out.println("dentro do executa no logar logica");
		
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");
		
		usuario u = new usuario();
		
		u.setLogin(login);
		u.setSenha(senha);
		
		UsuarioDao uD = new UsuarioDao();
		
		String pagina="index.jsp";
		
		try {
			boolean retorno = uD.autenticado(u);
			
			if(retorno){
				
				
				pagina="/WEB-INF/jsp/principal.jsp";
				rq.setAttribute("usuario", u);
				
			}else{
				rq.setAttribute("msg", "Rpoblemas a logar"); 
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			rq.setAttribute("msg", "Rpoblemas a logar");
			
			return pagina;
		}
		
		return pagina;
	}

}
