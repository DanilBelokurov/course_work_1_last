<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import=" model.User"%>
<%@ page import=" model.Student"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="RU">
	<title>Student page</title>
		<script><%@include file='js/anychart-base.min.js' %></script>
		<style><%@include file='css/teacherpage.css' %></style>
		<script><%@include file='js/diagram.js' %></script>
</head>

<body>

	<!-- Вывод имени ученика -->
	<div class="student_name">
		<h2> <% 
			String name = ((User)request.getAttribute("user")).getName(); 
			out.println(name);
		%></h2>
	</div>

	<!-- Отрисовка таблицы ведомости  -->
	<div id="marks_table">
		<table border ="1" width="500" align="center"> 
         <tr > 
          <th><b>Subject</b></th> 
          <th colspan="10"><b>Marks</b></th> 
         </tr> 
        <%ArrayList<Student> std = (ArrayList<Student>)request.getAttribute("students"); 
        for(int i=0; i<std.size();i++){%>
            <tr> 
                <td><%=std.get(i).getSubject()%></td> 
                <%for(int j=0; j<std.get(i).getMark().size();j++) {%>
                	<td><%=std.get(i).getMark().get(j).toString()%></td> 
                <%} %>
            </tr> 
            <%}%> 
        </table>
        
        <div class="diag_button"> <button class="btn" id="btn" onClick="diagForStudent();"> Create diagram </button></div>
	</div>
	
	
	<div id="container" style="width: 500px; height: 400px;">
	
<!-- 	<a href="logout">Logout</a> -->
</body>
</html>