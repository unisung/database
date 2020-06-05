package main3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DAO;
public class PreparedCallExample3 {
	public static void main(String[] args) throws SQLException {
		DAO dao=DAO.getInstance();
		Connection con=dao.getConnection();
		//프로시져
		String sql="{call sp_salary_ename2(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
        //값 바인딩 처리
		//out모드 바인딩처리
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		//in모드 바이딩처리
		cstmt.setString(1, "SMITH");
		//실행
		cstmt.execute();
		//결과 출력
		System.out.println(cstmt.getInt(2));
	}
}
