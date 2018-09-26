package text;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class mysql2 {
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.MysqlDefs";
	private static final String DRIVER = "jdbc:mysql://localhost:3306/gc";
	private static final String USER = "root";
	private static final String PASSWORD = "kk123456";
	public static void main(String[] args) throws Exception {
		Class.forName(DATABASE_DRIVER);
		Connection con = null;
		String Name = "book1";
		con = (Connection) DriverManager.getConnection(DRIVER, USER, PASSWORD);
		System.out.println(con);
		String str = "hello";
		String sql = "select id,title,content from book1";
		String update = "update book1 set content=? where id = 3";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(update);
		pst.setString(1,"hello");
		int x = pst.executeUpdate();
		System.out.println(x);
        ResultSet rs = pst.executeQuery(sql); 
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String title = rs.getString("title");
        	String content = rs.getString("content");
        	System.out.println(id + "、"+ title + "、" + content);
        }
	}
}
