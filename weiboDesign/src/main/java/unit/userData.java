package unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class userData {
	
	private PreparedStatement pstm;
	private ResultSet rs;
	private Connection conn = new DAO().getConn();
	//增加记录
	public boolean insert(accessToken token){
		boolean flag = false;
		String sql = "insert into wb_oauth values(?,?,?,?,?)";
		System.out.println("flag:" + token.getFlag());
		System.out.println("openid:" + token.getOpenid());
		System.out.println("accessToken:" + token.getAccesstoken());
		System.out.println("username:" + token.getUsername());
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, token.getFlag());
			pstm.setString(2, token.getOpenid());
			pstm.setString(3, token.getAccesstoken());
			pstm.setString(4, token.getUsername());
			pstm.setString(5, token.getUkey());
			int ret = pstm.executeUpdate();
			if(ret!=0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//查找记录
	public accessToken search(String flag){
		accessToken token = null;
		String sql = "select * from wb_user where flag = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, flag);
			rs = pstm.executeQuery();
			while(rs.next()){
				token.setFlag(rs.getString(1));
				token.setOpenid(rs.getString(2));
				token.setAccesstoken(rs.getString(3));
				token.setUsername(rs.getString(4));
				token.setUkey(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return token;
	}
	//获得用户绑定的微博账号列表
	public List<accessToken> getAccessTokenList(String username){
		List<accessToken> list = new ArrayList();
		String sql = "select * from wb_oauth where username = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while(rs.next()){
				accessToken temp = new accessToken();
				temp.setFlag(rs.getString(1));
				temp.setOpenid(rs.getString(2));
				temp.setAccesstoken(rs.getString(3));
				temp.setUsername(rs.getString(4));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
