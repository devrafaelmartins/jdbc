package aplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {		
		
		Connection conn = null;
		Statement st = null;
		
		//************TRANSAÇÕES************
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = st.executeUpdate("update seller set BaseSalary = 3530.50 where DepartmentId = 1");
			
			/*int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}*/
			
			int rows2 = st.executeUpdate("update seller set BaseSalary = 5324.8 where DepartmentId = 2");
			
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
			
			conn.commit();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
}
