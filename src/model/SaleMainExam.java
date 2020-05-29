package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SaleMainExam {
	 static Dao dao=Dao.getInstance();
	 static Connection con=dao.getConnection();
	 
public static void main(String[] args) throws SQLException {
		//재고등록
		insertStock();
		//장바구니등록
		bucketProc();
		//구매
		saleProc();
	}
private static void saleProc() {
try {
	Statement stmt=con.createStatement();
	//매출등록
	stmt.executeUpdate("insert into sale values((select nvl(max(seq),0)+1 from sale),"
			         + " 'hong','mango', " + 
			"            (select qty from bucket where item='mango'), " + 
			"             sysdate)");
    //재고 처리
	 stmt.executeUpdate("update stock set "
	 		          + " qty=qty-(select qty from bucket where item='mango') "
	 		          + " where item='mango'");	
     //장바구니 비우기 
	 stmt.executeUpdate("delete from bucket");	  
	}catch(Exception e){}
}

private static void bucketProc() {
		 try {
				Statement stmt=con.createStatement();
				stmt.executeUpdate("insert into bucket values('mango',3)");
				stmt.executeUpdate("update bucket set qty=4 where item='mango'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

private static void insertStock() {
	//상품명,수량	
	  try {
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into stock values('mango',10)");
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}
}
