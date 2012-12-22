<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="neteasy.weibo.*"%>
<%@ page language="java" import="neteasy.weibo.http.*"%>
<jsp:useBean id="weboauth" scope="session" class="neteasy.weibo.example.OAuth2" />
<%
	//第一步，请求token
	String url = weboauth.firstStep();
	response.sendRedirect(url);
%>