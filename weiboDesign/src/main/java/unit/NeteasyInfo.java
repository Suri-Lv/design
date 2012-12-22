package unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import neteasy.examples.Init;
import neteasy.weibo.TBlog;
import neteasy.weibo.TBlogException;
import neteasy.weibo.data.User;

public class NeteasyInfo {

	private List<Map> ui_list = new ArrayList<Map>();
	//获取uid
	public String getUserId(String accesstoken){
		String uid = "";
		TBlog tblog = new Init().getTblog();
		tblog.setOAuth2AccessToken(accesstoken);
		try {
			User user = tblog.showUser();
			Map map = new HashMap();
			uid = Long.valueOf(user.getId()).toString();
			//粉丝数
			int fs_num = user.getFollowersCount();
			map.put("fs_num", fs_num);
			ui_list.add(map);
			//关注数
			int gz_num = user.getFriendsCount();
			map.put("gz_num", gz_num);
			ui_list.add(map);
			//微博数
			int wb_num = user.getStatusesCount();
			map.put("wb_num", wb_num);
			ui_list.add(map);
			//收藏数
			int sc_num = user.getFavouritesCount();
			map.put("sc_num", sc_num);
			ui_list.add(map);
			//用户头像
			String imageurl = user.getProfileImageURL();
			map.put("tx_url", imageurl);
			ui_list.add(map);
			//用户名
			String name = user.getName();
			map.put("name", name);
			ui_list.add(map);
			//用户昵称
			String nick = user.getName();
			map.put("nick", nick);
			ui_list.add(map);
			//微博主页
			String homeUrl = "http://t.163.com/" + user.getScreenName();
			map.put("home_url", homeUrl);
			ui_list.add(map);
			System.out.println("uid:" + uid);
			System.out.println("name:" + name + ", nick:" + nick);
		} catch (TBlogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
	}
	
	public List<Map> getUi_list() {
		return ui_list;
	}

	public void setUi_list(List<Map> ui_list) {
		this.ui_list = ui_list;
	}

	public static void main(String args[]){
		
		String accesstoken = "7de43a093cd0a38c938a1fb2f66d0442";
		NeteasyInfo ni = new NeteasyInfo();
		ni.getUserId(accesstoken);
	}
}
