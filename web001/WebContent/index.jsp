<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<form action="Login" name="login">
    <p>userId:<input type="text" name="userid"></p>
    <p>password:<input type="password" name="password"></p>
    <select name="usertype">     
    <option value="0">-请选择-</option>     
    <option value="1">管理员</option>     
    <option value="2">教师</option>  
    <option value="3">学生</option> 
    </select>  
    <input type="submit" value="登陆">
</form>
</body>
</html>
