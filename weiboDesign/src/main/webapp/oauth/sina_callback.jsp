<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="weibo4j.http.AccessToken,unit.*"%>
<jsp:useBean id="oauth" scope="request" class="weibo4j.Oauth" />
<%
	String code = request.getParameter("code");
	AccessToken accessToken = oauth.getAccessTokenByCode(code);
	String access_token = accessToken.getAccessToken();
	//获得uid
	String uid = accessToken.getUid();
	//封转数据
	accessToken token = new accessToken();
	token.setFlag("S");
	token.setAccesstoken(access_token);
	token.setUsername("");
	token.setUkey(uid);
	//将数据保存到数据库
	userData ud = new userData();
	boolean flag = ud.insert(token);
	System.out.println("token flag :" + flag);
%>