package br.com.motos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.motos.modelo.Moto;
import br.com.motos.util.JdbcFactory;

public class MotoDao {
	
	public void cadastra(Moto moto) {
		
		try {
			Connection conn = JdbcFactory.getConnection();
			
			String sql = "insert into motos (marca, modelo, ano) values (?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, moto.getMarca());
			st.setString(2, moto.getModelo());
			st.setInt(3, moto.getAno());
			
			st.execute();
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Moto> lista() {
		
		List<Moto> motos = new ArrayList();
		
		try {
			Connection conn = JdbcFactory.getConnection();
			String sql = "select * from motos";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Moto moto = new Moto(
						rs.getInt("id"),
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getInt("ano")
						);
				motos.add(moto);
			}
			
			st.close();
            rs.close();
            conn.close();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return motos;
	}
	
	public Moto buscaPor(Integer idMoto) {
		Moto moto = null;
		
		try {
			Connection conn = JdbcFactory.getConnection();
			String sql = "select * from motos where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idMoto);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				
				moto = new Moto(idMoto, marca, modelo, ano);
			}
			
			st.close();
            rs.close();
            conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return moto;
	}

	public void deleta(Integer id) {
		
		try {
		
			Connection conn = JdbcFactory.getConnection();
			String sql = "delete from motos where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
            ps.close();
            conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualiza(Moto moto) {
		
		try {

            Connection conn = JdbcFactory.getConnection();
            String sql = "update motos set marca = ?, modelo = ?, ano = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, moto.getMarca());
            ps.setString(2, moto.getModelo());
            ps.setInt(3, moto.getAno());
            ps.setInt(4, moto.getId());
            
            ps.execute();
            
            ps.close();
            conn.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
