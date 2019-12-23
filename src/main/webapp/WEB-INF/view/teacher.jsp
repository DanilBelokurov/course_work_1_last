<%@page import="model.User"%> 
<%@page import="model.Teacher"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="model.TeacherDB"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Teacher</title>
	<script><%@include file='js/anychart-base.min.js' %></script>
	<style><%@include file='css/teacherpage.css' %></style>
	<script><%@include file='js/diagram.js' %></script>
</head>
<body>

	<div class="mark_list"><h2>Name</h2></div>
	
	<div class="group_peaker">
	
	   <% TeacherDB TDB=(TeacherDB)request.getAttribute("tdb");
	   String group = new String();
	   for(int i=0; i < TDB.getNumberGroup();i++){
	   		group = String.valueOf(TDB.getGroup(i));%>
			<form method="post"><button class="btn" name="group" value=<%=group%> type="submit"><%=group%></button></form>
		<%} %>

	</div>
	
	<div>
	
	<table id="mark_table" border ="1" width="600" align="center"> 
         <tr bgcolor=""> 
          <th><b>Student</b></th> 
          <th><b>Mark1</b></th> 
          <th><b>Mark2</b></th>
          <th><b>Mark3</b></th>
          <th><b>Mark4</b></th>
          <th><b>Mark5</b></th>
          <th><b>Mark6</b></th>
          <th><b>Mark7</b></th>
          <th><b>Mark8</b></th>
          <th><b>Mark9</b></th>
          <th><b>Mark10</b></th>         
         </tr> 
        <%ArrayList<Teacher> std = TDB.select(); 
	        for(int i=0; i < std.size();i++){%>
	            <tr> 
	                <td><%=std.get(i).getStudent()%></td> 
	                <%for(int j=0; j < 10;j++){ %>
	                	<%if(j<std.get(i).numberOfMark()){%>
	                		<td><input type="text" value="<%=std.get(i).getMark(j)%>"></td>
	                	<%} else {%>
	                		<td></td>
	                	<%}%>
	                 <%}%>
	            </tr> 
	            <%}%> 
	</table>
	
	<div class="diag_button"> <button class="btn" id="btn" onClick=" yes();"> Create diagram </button></div>
	
	</div>

	<div id="container" style="width: 500px; height: 400px;">
	
	</div>
	
	
</body>
</html>