package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class ProgramCRUD {	
		
	public void program() {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("delete from department "
					+ "where Id = ?");
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		/* ***************************UPDATE************************************
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("update seller "
					+ "set BaseSalary = BaseSalary + ? "
					+ "where DepartmentId = ?");
			
			st.setDouble(1, 200.50);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}*/
		
		
		/* **********************INSERT COM PREPAREDSTATEMENT*********************
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"insert into department (Name)"
					+ " values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
						
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Rows affected: " + id);									
				}
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}*/
		
		/* **********************INSERT COM PREPAREDSTATEMENT*********************
		Connection conn = null;
		PreparedStatement st = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"insert into seller (Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "values (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, "Rafael");
			st.setString(2, "devraf@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 2331.52);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException | ParseException e) {
			throw new DbException(e.getMessage());
		}*/
		
		/* ****************CONSULTA COM STATEMENT******************
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}*/
		
	}
}
