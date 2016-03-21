package br.csi.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.csi.model.usuario;
import br.csi.model.util.conectaBD;

public class UsuarioDao {
	
	public static void main(String args[]){
		usuario u= new usuario();
		u.setLogin("diovane");
		u.setSenha("1234");
		
		try{
			System.out.println("autenticado?"
					+ ""+new UsuarioDao().autenticado(u));
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	

	public boolean autenticado(usuario u) throws SQLException{
		boolean autenticado = false;
		Connection c = conectaBD.getConexao();
		
		Statement stmt = c.createStatement();
		
		String sql = "select * from usuario "
				+ "where login = '"+u.getLogin()+"'"
				+ "and senha='"+u.getSenha()+"';";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			long id = rs.getLong("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			autenticado = true;
		}
		
		
		
		return autenticado;
	}
	
	
}
