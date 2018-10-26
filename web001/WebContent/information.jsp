<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div>
<h1 style="text-align: center;">选课系统</h1>
</div>
<div style="text-align: center;" >
<%@include file="html/adm_menu.html"%>
</div>
<div>
  <h3 align="center">提示信息</h3>
</div>

<div>
<% 
String info = (String)request.getAttribute("info");
%>
<script type="text/javascript" language="javascript">
alert("<%=info%>");                                  //提示信息
</script>	
</div>
</html>