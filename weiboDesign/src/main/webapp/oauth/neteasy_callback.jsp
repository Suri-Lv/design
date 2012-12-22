<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="neteasy.weibo.http.*"%>
<%@ page language="java" import="neteasy.weibo.*"%>
<%@ page language="java" import="unit.*"%>

<jsp:useBean id="weboauth" scope="session"
	class="neteasy.weibo.example.OAuth2" />
<%
	String code = request.getParameter("code");
	OAuth2AccessToken token = weboauth.secondStep(code);
	//获取它的uid
	NeteasyInfo ni = new NeteasyInfo();
	String uid = ni.getUserId(token.getAccess_token());
	//封装数据
	accessToken at = new accessToken();
	at.setAccesstoken(token.getAccess_token());
	at.setFlag("N");
	at.setUsername("");
	at.setUkey(uid);
	//保存到数据库
	userData ud = new userData();
	ud.insert(at);
%>
