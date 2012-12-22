package unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private String username = "scott";
	private String pwd = "tiger";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private Connection conn;
	
	public DAO(){
		try {
			//加载驱动
			Class.forName(driver);
			//建立数据连接对象
			conn = DriverManager.getConnection(url,username,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得数据库操作对象

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
