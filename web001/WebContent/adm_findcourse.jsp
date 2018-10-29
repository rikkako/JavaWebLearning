<%@ page language="java" import="java.util.*,model.Course" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h1 style="text-align: center;">选课系统</h1>
</div>
<div style="text-align: center;" >
<%@include file="html/adm_menu.html"%>
<div id="add_user">
        <h3 align="center">课程列表</h3>
        <table border="1" width="70%" align="center">         
            <tr>          
                <th>课程</th>        
                <th>课程ID</th>          
                <th>任课老师</th>
                <th>上课地点</th>          
                <th>课时</th>         
                <th>学分</th>
                <th>最大人数</th>
                <th>操作</th>
            </tr>
            <%-- <c:forEach>标签，需要下载jstl标签库jar包 jstl-1.2,
            然后添加<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
            
            class="btn btn-danger" class="btn btn-info"
            
            --%>
            <c:forEach items="${courseList}" var="course">
            <tr>
            <td style="width:20%">${course.courseName}</td>
            <td style="width:10%">${course.courseId}</td>
            <td style="width:10%">${course.teacher}</td>
            <td style="width:10%">${course.classRoom}</td>
            <td style="width:10%">${course.lesson}</td>
            <td style="width:10%">${course.credit}</td>
            <td style="width:10%">${course.maxNum}</td>
            <td><a href="EditPage?id=${course.courseId}" >修改</a>
            <a href="DeleteCourse?id=${course.courseId}" >删除</a></td>
            </tr>
            </c:forEach>     
        </table>
        <br/>   
</div>
</div>

<%
String Info = (String)request.getAttribute("info");         // 获取消息
if(Info == "删除成功！") {
%>
<script type="text/javascript" language="javascript">
alert("<%=Info%>");                                            //弹出消息
window.location= 'FindCourse' ;                           
</script>	
<%
}
%>

<%if(Info == "现在还没有课程，请添加课程") {
%>
<script type="text/javascript" language="javascript">
alert("<%=Info%>");                                            //弹出消息
window.location= 'adm_addcourse.jsp' ;                           
</script>
<% 
}
%>

<%
if(Info == "修改成功！") {
%>
<script type="text/javascript" language="javascript">
alert("<%=Info%>");                                            //弹出消息
window.location= 'FindCourse' ;                           
</script>	
<%
}
%>
</body>
</html>