package neteasy.examples;

import neteasy.weibo.TBlog;
import neteasy.weibo.TBlogException;
import neteasy.weibo.data.Status;

public class Account {

	public static void main(String args[]) throws TBlogException{
		System.setProperty("tblog4j.debug", "true");
		String token = "3595703bc62b4307cf8db8dae8241af5";
		TBlog tblog = new Init().getTblog();
		tblog.setOAuth2AccessToken(token);
		Status status = tblog.updateStatus("hello，hello");
		System.out.println("Status:" + status);
		System.out.println("操作成功！");
	}
}
