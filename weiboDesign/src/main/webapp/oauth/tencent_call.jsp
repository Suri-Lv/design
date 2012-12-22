<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java" import="com.tencent.weibo.api.*" %>

<jsp:useBean id="weboauth" scope="request" class="com.tencent.weibo.examples.WebOAuth" />
<%
if("1".equals(request.getParameter("opt")))
{
	String authorizationUrl = weboauth.request("http://localhost:8090/weiboDesign/oauth/tencent_callback.jsp");
	response.sendRedirect(authorizationUrl);
}
else
{
%>
<a href="tencent_call.jsp?opt=1">请点击进行腾讯OAuth认证</a>
<%}%>