<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "m_IBRtCXne64If1zjscq";//애플리케이션 클라이언트 아이디값"; 
    String redirectURI = URLEncoder.encode("http://localhost:8080/project3/main.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
 <table style="margin: auto; margin-top: 50px;">
 <tr>
 	<td>
 	<a href="<%=apiURL%>"><span>네이버 아이디로 로그인 합니다</span></a>
 	</td>
 	</tr>
 <%-- <tr><td><a href="<%=apiURL%>"><img height="100" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a></td></tr>
 <tr><td><a href="#"><img height="100" alt ="카카오" src=""/></a></td></tr>
 <tr><td><a href="#"><img height="100" alt = "구글" src=""/></a></td></tr>
  --%></table>
  
  
  </body>
</html>