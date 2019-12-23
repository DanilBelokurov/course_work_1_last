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
	 <style><%@include file='css/userpage.css'%></style>
</head>

<body>

	<!-- Вывод имени ученика -->
	<div class="student_name">
		<I> <% 
			String name = ((User)request.getAttribute("user")).getName(); 
			out.println(name);
		%></I>
	</div>

	<!-- Отрисовка таблицы ведомости  -->
	<div id="marks_table">
		<table border ="1" width="500" align="center"> 
         <tr > 
          <th><b>Subject</b></th> 
          <th colspan="10"><b>Mark</b></th> 
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
	</div>
	
	<a href="logout">Logout</a>
</body>
</html>