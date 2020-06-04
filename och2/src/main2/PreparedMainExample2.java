package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;

public class PreparedMainExample2 {
	public static void main(String[] args) throws SQLException {
		DAO dao=DAO.getInstance();
		Connection con=dao.getConnection();
		
		String sql="select eno,ename,job,salary,dname "+
				   "  from employee a, department b " + 
				   " where a.dno=b.dno" + 
				   "   and hiredate > ? " + 
				   "   and a.dno=? " + 
				   "   and a.job like ? ";//
		PreparedStatement pstmt=con.prepareStatement(sql);
		int index=0;
		pstmt.setString(++index,"87/05/05");
		pstmt.setInt(++index,20);
		pstmt.setString(++index,"CLERK");
			
		ResultSet rs = pstmt.executeQuery();
		
		//결과 출력
		while(rs.next()) {
			index=0;
			System.out.println(rs.getInt(++index)+","
		                      +rs.getString(++index)+","
		                      +rs.getString(++index)+","
		                      +rs.getInt(++index)+","
		                      +rs.getString(++index));
		}
	}
}
