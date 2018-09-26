package text;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class mysql1 {
	private final static String DETABASE_DRIVER = "com.mysql.jdbc.MysqlIO";
	private static final String URL = "jdbc:mysql://localhost:3306/gc";
	private static final String USER = "root";
	private static final String PASSWORD = "kk123456";
	public static void main(String[] args) throws Exception {
		Class.forName(DETABASE_DRIVER);
		Connection con = null;
		con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println(con);
		Statement sta = (Statement) con.createStatement();
		String sql = "select id,title,content from book";
		ResultSet rs = sta.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			System.out.println(id + "、" + title + "、"  + content);
		}
		con.close();
	}
}
