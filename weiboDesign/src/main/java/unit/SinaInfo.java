package unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class SinaInfo {

	private List<Map> ui_list = new ArrayList<Map>();

	// 批量获取用户的粉丝数、关注数、微博数
	public void getUserCount(String uid, String token) {
		Users user = new Users();
		user.client.setToken(token);
		try {
			User ui_data = user.showUserById(uid);
			int followers_count = ui_data.getFollowersCount();
			int friends_count = ui_data.getFriendsCount();
			int statuses_count = ui_data.getStatusesCount();
			int favourites_count = ui_data.getFavouritesCount();
			String headurl = ui_data.getProfileImageUrl();
			String name = ui_data.getName();
			String nick = ui_data.getScreenName();
			String homeurl = "http://weibo.com/" + ui_data.getProfileUrl();
			Map map = new HashMap();
			map.put("fs_num", followers_count);
			ui_list.add(map);
			map.put("gz_num", friends_count);
			ui_list.add(map);
			map.put("wb_num", statuses_count);
			ui_list.add(map);
			map.put("tx_url", headurl);
			ui_list.add(map);
			map.put("name", name);
			ui_list.add(map);
			map.put("nick", nick);
			ui_list.add(map);
			map.put("home_url", homeurl);
			ui_list.add(map);
			System.out.println("用户个性化域名:" + homeurl);
			System.out.println("头像：" + headurl);
			System.out.println("关注：" + friends_count);
			System.out.println("粉丝：" + followers_count);
			System.out.println("微博：" + statuses_count);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得关注用户的最新微博
	public void getStatusesLists(String access_token) {
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			StatusWapper status = tm.getFriendsTimeline();
			System.out
					.println("发布者头像 \t\t昵称\t内容\t\t转发\t评论\t发布时间\t微博来源\t图片缩略url");
			for (Status s : status.getStatuses()) {
				// Log.logInfo(s.toString());
				User user = s.getUser();
				System.out.println(user.getProfileImageUrl() + "\t"
						+ user.getScreenName() + "\t" + s.getText() + "\t\t"
						+ s.getRepostsCount() + "\t" + s.getCommentsCount()
						+ "\t" + s.getSource() + "\t" + s.getThumbnailPic());
			}
			System.out.println(status.getNextCursor());
			System.out.println(status.getPreviousCursor());
			System.out.println(status.getTotalNumber());
			System.out.println(status.getHasvisible());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

	public List<Map> getUi_list() {
		return ui_list;
	}

	public void setUi_list(List<Map> ui_list) {
		this.ui_list = ui_list;
	}

	public static void main(String args[]) {
		SinaInfo si = new SinaInfo();
		String uid = "2832943642";
		String accesstoken = "2.00__HHzCWeNSDB2a35a2d7a10e2jVo";
		// si.getUserCount(uid, accesstoken);
		si.getStatusesLists(accesstoken);
	}
}
