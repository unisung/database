package ext;


import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class RowSetSample {

	public static void main(String[] args) throws SQLException {
		 CachedRowSet jdbcRs=new CachedRowSetImpl();
		 jdbcRs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 jdbcRs.setUsername("hr");
		 jdbcRs.setPassword("hr");
		 jdbcRs.setCommand("select eno,ename from employee");
		 jdbcRs.execute();
		 while(jdbcRs.next()) {
		 System.out.println(jdbcRs.getInt(1)+","+jdbcRs.getString(2));
		 }
	}
}
