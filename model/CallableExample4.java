package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableExample4 {
	public static void main(String[] args) throws SQLException {
		Dao dao=Dao.getInstance();
		Connection con=dao.getConnection();
		String sql="{?=call fn_hire_eno(?)}" ;
		CallableStatement cstmt = con.prepareCall(sql);
        cstmt.registerOutParameter(1, Types.DATE);
        cstmt.setInt(2,7788);
        cstmt.execute();  
        System.out.println("입사일자: " + cstmt.getDate(1)); 
	}
}
