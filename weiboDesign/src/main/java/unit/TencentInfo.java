package unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.tencent.weibo.api.UserAPI;
import com.tencent.weibo.oauthv2.OAuthV2;

public class TencentInfo {

	private static OAuthV2 oAuth = new OAuthV2();
	private String format = "json";
	private String clientip = "127.0.0.1";
	private String jing = "";
	private String wei = "";
	private String syncflag = "";
	private UserAPI uAPI = new UserAPI(oAuth.getOauthVersion());// 根据oAuth配置对应的连
	private String appkey = "801158712";
	private List<Map> ui_list = new ArrayList<Map>();
	
	public TencentInfo(String openid, String accessToken) {
		oAuth.setClientId(appkey);
		oAuth.setAccessToken(accessToken);
		oAuth.setOpenid(openid);
	}

	// 获取用户的详细信息（自己的粉丝数、关注数、微博数）
	public void getUserCount() {
		String response = "";
		try {
			response = uAPI.info(oAuth, format);
			System.out.println("response:" + response);
			JSONObject jobj = JSONObject.fromObject(response);
			String data = jobj.get("data").toString();
			System.out.println("data:" + data);
			JSONObject obj = JSONObject.fromObject(data);
			// 粉丝数
			Object fansnum = obj.get("fansnum ");
			// 收听人数
			Object idolnum = obj.get("idolnum");
			// 微博数
			Object tweetnum = obj.get("tweetnum");
			//收藏数
			Object favnum = obj.get("favnum");
			// 头像url
			Object headurl = obj.get("head");
			// 用户账户名
			Object name = obj.get("name");
			// 用户昵称
			Object nick = obj.get("nick");
			Map map = new HashMap();
			map.put("fs_num", fansnum);
			ui_list.add(map);
			map.put("gz_num", idolnum);
			ui_list.add(map);
			map.put("wb_num", tweetnum);
			ui_list.add(map);
			map.put("sc_num", favnum);
			ui_list.add(map);
			map.put("tx_url", headurl);
			ui_list.add(map);
			map.put("name", name);
			ui_list.add(map);
			map.put("nick", nick);
			ui_list.add(map);
			String homeUrl = "http://t.qq.com/" + (String) name;
			map.put("home_url", homeUrl);
			ui_list.add(map); 
			System.out.println("粉丝数:" + fansnum);
			System.out.println("收听人数:" + idolnum);
			System.out.println("微博数:" + tweetnum);
			System.out.println("头像url:" + headurl);
			System.out.println("用户账户名:" + name);
			System.out.println("用户昵称:" + nick);
			System.out.println("个人主页：" + homeUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Map> getUi_list() {
		return ui_list;
	}

	public void setUi_list(List<Map> ui_list) {
		this.ui_list = ui_list;
	}

}
