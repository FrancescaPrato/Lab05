package it.polito.tdp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class paroleDAO {

	public paroleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean cercaParola(String s) {
		
		boolean trovata= false;
		String parola="";
		final String sql = "SELECT * FROM parola WHERE nome=? ";
		
		try { 

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
 
				parola=rs.getString("nome");
				if(parola.compareTo(s)==0)
					trovata=true;
			}
			
		

			conn.close();


		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
		
		return trovata;
	}

}
