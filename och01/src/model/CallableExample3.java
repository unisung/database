package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLType;

public class CallableExample3 {
	public static void main(String[] args) throws SQLException {
		Dao dao=Dao.getInstance();
		Connection con=dao.getConnection();
		String sql="{call sp_salary_ename2(?,?)}" ;
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setString(1,"SCOTT");
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);  
        cstmt.execute();  
        System.out.println("이름:SCOTT, salary: " + cstmt.getInt(2)); 

	}
}
