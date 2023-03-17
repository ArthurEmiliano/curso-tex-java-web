package br.com.motos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.motos.modelo.Usuario;
import br.com.motos.util.JdbcFactory;

public class UsuarioDao {

	public Usuario verifica(String login, String senha) {
		Usuario usuario = null;
		
		try {
			Connection conn = JdbcFactory.getConnection();
			String sql = "select * from usuarios where login = ? and senha = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("login")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
}
