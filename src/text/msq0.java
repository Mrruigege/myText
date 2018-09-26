package text;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class msq0 {
	private final static String DETABASE_DRIVER = "com.mysql.jdbc.MysqlIO";
	private static final String URL = "jdbc:mysql://localhost:3306/gc";
	private static final String USER = "root";
	private static final String PASSWORD = "kk123456";
	public static void main(String[] args) throws Exception{
		Class.forName(DETABASE_DRIVER);
		Connection con = null;
		con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println(con);
		Statement statement = (Statement) con.createStatement();
		String sql = "select * from book1";
		String sql1 = "update book1 set id = 2 where title = 'y'";
		String sql2 = "delete from book1 where id = 1";
		int count = statement.executeUpdate(sql1);
		statement.executeUpdate(sql2);
		ResultSet rs = statement.executeQuery(sql);
		String id = null;
		String title = null;
		String content = null;
		while(rs.next()) {
			id = rs.getString("id");
			title = rs.getString("title");
			content = rs.getString("content");
			System.out.println(id + "\t" + title + "\t" + content);
		}
		rs.close();
		con.close();
	}
}
