package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLType;

public class CallableExample {
	public static void main(String[] args) throws SQLException {
		Dao dao=Dao.getInstance();
		Connection con=dao.getConnection();
		String sql="{call pr_emp_upSal(?)}" ;
		CallableStatement cstmt = con.prepareCall(sql);
        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);  
        cstmt.execute();  
        System.out.println("salary: " + cstmt.getInt(1)); 

	}

}
