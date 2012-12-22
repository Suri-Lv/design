<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="com.tencent.weibo.oauthv2.*"%>
<%@ page language="java" import="unit.*"%>
<jsp:useBean id="weboauth" scope="request"
	class="com.tencent.weibo.examples.WebOAuth" />
<%
	String code = request.getParameter("code");
	String openid = request.getParameter("openid");
	String openkey = request.getParameter("openkey");
	if (code != null) {
		//换取accessToken
		OAuthV2 oauth = weboauth.requstAccessToken(code, openid,
				openkey);
		System.out.println("accessToken:" + oauth.getAccessToken());
		//获取uid
		String name = oauth.getName();
		//封装数据
		accessToken at = new accessToken();
		at.setFlag("T");
		at.setAccesstoken(oauth.getAccessToken());
		at.setOpenid(openid);
		at.setUsername("");
		at.setUkey(name);
		//保存到数据库
		userData ud = new userData();
		ud.insert(at);
	} else {
		out.println("request token session error");
	}
%>
