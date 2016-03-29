package br.csi.controller.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.util.conectaBD;


public class CriarUsuario implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");
		
		System.out.println("CADASTRANDO USUARIO");
		
		String sql = "insert into usuario(login,senha) values ("+login+","+senha+")";
		
		
		
		Connection c = conectaBD.getConexao();
		/*criar adicionar user SQL no usuarioDAO*/
		try {
			
			PreparedStatement stmtPre = c.prepareStatement(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
	}

}
