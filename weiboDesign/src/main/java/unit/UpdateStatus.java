package unit;

import weibo4j.Statuses;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class UpdateStatus {

	public void update(String access_token,String status){
		Statuses sm = new Statuses();
		sm.client.setToken(access_token);
		Status sta;
		try {
			sta = sm.createStatus(status);
			Log.logInfo(sta.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
