package weibo.actions;

import neteasy.examples.Init;
import neteasy.weibo.TBlog;
import neteasy.weibo.TBlogException;
import neteasy.weibo.data.Status;
import unit.UpdateStatus;

import com.opensymphony.xwork2.ActionSupport;
import com.tencent.weibo.examples.WebOAuth;

public class Update extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	private String content;

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String tenUpdate() {
		System.out.println("content = " + content);
		WebOAuth tblog = new WebOAuth();
		System.out.println("发表腾讯微博");
		try {
			tblog.update(content,"C8CC9F079F8B7164127A5DD8F9B55A70","2bf1fecd8550ac697a3f5cc9de9e3309");
			System.out.println("腾讯微博发表成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String netUpdate(){
		TBlog tblog = new Init().getTblog();
		//token.getAccesstoken()
		tblog.setOAuth2AccessToken("3a130b580b2fe7013df7297a04fcc45f");
		try {
			Status status = tblog.updateStatus(content);
			System.out.println("status:" + status.getCursorId());
		} catch (TBlogException e) {
			e.printStackTrace();
		}
		System.out.println("网易微博发表成功！");
		return SUCCESS;
	}
	//新浪微博
	public String sinUpdate(){
		System.out.println("发表新浪微博");
		UpdateStatus us = new UpdateStatus();
		//token.getAccesstoken()
		us.update("2.00__HHzCWeNSDB1f641b222300lfss", content);
		System.out.println("新浪微博发表成功！");
		return SUCCESS;
	}
}
