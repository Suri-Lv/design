package neteasy.examples;

import neteasy.weibo.OAuthVersion;
import neteasy.weibo.TBlog;

public class Init {

	private TBlog tblog = new TBlog(OAuthVersion.V2);
	private String token = "7c6acbd37b5e1f4616e6574610e2423f";
	private String tokenSecret = "4d56c45a405d2d351f07c9e10880548a";
	
	public Init(){
		tblog.setToken(token,tokenSecret);
	}

	public TBlog getTblog() {
		return tblog;
	}

	public void setTblog(TBlog tblog) {
		this.tblog = tblog;
	}
	
}
