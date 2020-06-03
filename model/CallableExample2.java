package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLType;

public class CallableExample2 {
	public static void main(String[] args) throws SQLException {
		Dao dao=Dao.getInstance();
		Connection con=dao.getConnection();
		String sql="{?=call fn_salary_ename(?)}" ;
		CallableStatement cstmt = con.prepareCall(sql);
        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cstmt.setString(2,"SCOTT" );
        cstmt.execute();  
        System.out.println("salary: " + cstmt.getInt(1)); 

	}

}
