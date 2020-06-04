package main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAO;

public class SQL5MainExample {
	public static void main(String[] args) throws SQLException {
		//1.db연결객체 생성
		  DAO dao = DAO.getInstance();	
		//2.db연결맺기
		  Connection con=dao.getConnection();
		//3.쿼리객체 생성
		  int dno=60;
	      String sql="delete from dept where dno=?";
		  PreparedStatement stmt = con.prepareStatement(sql);
		//바인딩 처리
		  stmt.setInt(1, dno);
		//4.쿼리 실행 및 결과 받기
         System.out.println("쿼리문:"+sql);
	//executeUpdate()메소드 - 실행 후 db에 반영된 행수(건수)를 리턴하는 함수
	 int result = stmt.executeUpdate();
	 if(result>0) 
		 System.out.println("삭제완료");
	 else
		 System.out.println("삭제실패");
	 
		//자원해제-생성된 역순으로 해제
		stmt.close();
		con.close();
	}
}
