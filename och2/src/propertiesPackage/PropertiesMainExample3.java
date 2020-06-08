package propertiesPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PropertiesMainExample3 {
	public static void main(String[] args) throws SQLException {
		ProDAO dao = ProDAO.getInstance();
		Connection c = dao.getConnection();
		String sql="select dno, dname, loc from dept where dno=?";
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setInt(1,10);
		
		ResultSet rs=pstmt.executeQuery();
		//헤드부분제외 하고 데이타 부분만 출력 
		//메타데이타 출력 rs.getMetaData()
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("칼럼수:"+rsmd.getColumnCount());
        for(int i=1;i<=rsmd.getColumnCount();i++) {
        	System.out.print(rsmd.getColumnName(i)+"\t");
        }
        System.out.println("\n--------------------------");
		rs.next();
		System.out.println(rs.getInt(1)+","
		                  +rs.getString(2)+","+rs.getString(3));
	}
}
