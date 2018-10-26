<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<div id="add_course">
    <form action="UpdateCourse" method="Post" >
        <h3 align="center">修改课程信息</h3>
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
            <tr>
                <td style="width:20%"><input style="width:80%" type="text" name="course" value="${course.courseName }"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="course_id" value="${course.courseId}"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="teacher" value="${course.teacher }"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="classroom" value="${course.classRoom }"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="lesson" value="${course.lesson }"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="credit" value="${course.credit }"></td>
                <td style="width:10%"><input style="width:80%" type="text" name="max_num" value="${course.maxNum }"></td>
                <td style="width:10%"><input style="width:80%" type="submit" value="修改" ></td>
            </tr>
        </table>
        <br/>
    </form>     
</div>
</div>
</body>

<%
String errorInfo = (String)request.getAttribute("adderror");         // 获取错误属性
if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
alert("<%=errorInfo%>");                                            //弹出错误信息
                         
</script>	
<%
}
%>

<%
String Info = (String)request.getAttribute("info");         // 获取消息
if(Info == "修改成功！") {
%>
<script type="text/javascript" language="javascript">
alert("<%=Info%>");                                            //弹出消息
window.location= 'FindCourse' ;                           
</script>	
<%
}
%>
</html>