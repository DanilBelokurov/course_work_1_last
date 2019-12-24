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
	
	   <% TeacherDB TDB= (TeacherDB)request.getAttribute("tdb");
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
	          <%for(int j=0; j < TDB.getNumberOfDates();j++){ %>
	          	<th><b><%=TDB.getDate(j)%></b></th>   
	          <%} %>
	             
	         </tr> 
	         
	        <%ArrayList<Teacher> std = TDB.select();
	        	
	        System.out.println(std.size());
	        
	        for(int i=0; i < std.size();i++){%>
	            <tr> 
	                <td><%=std.get(i).getStudent()%></td> 
	                
	                <%for(int j=0;j<TDB.getNumberOfDates();j++){ %>
		                <%if(std.get(i).getMark().containsKey(TDB.getDate(j))) {
		                	String currentValue = std.get(i).getStudent() + String.valueOf(TDB.getDate(j));
		                    String[] tmp= currentValue.split(" ");
		       			 	currentValue = tmp[0] + "_" + tmp[1] + "_" + String.valueOf(TDB.getCurrGroup()) + "_" + tmp[2] + "_" + String.valueOf(j);%>
	       			 
		                	<td>
		                		<form method="post">
		                			<input type="text" placeholder=<%=std.get(i).getMark().get(TDB.getDate(j))%> name="newMark1" value=""/>
		                			<button hidden="true" type="submit" name="currValue1" value=<%=currentValue%> >ok</button>
		                		</form>
		                	</td>
	                 
	                 	<%}else{
	                	 
			                 String currentValue = std.get(i).getStudent() + String.valueOf(TDB.getDate(j));
			                 String[] tmp = currentValue.split(" ");
			    			 currentValue = tmp[0] + "_" + tmp[1] + "_5711_" + tmp[2] + "_" + String.valueOf(j);%>
	                	 
		                	 <td>
		                	 	<form method="post">
		                	 		<input type="text" placeholder="" name="newMark" value=""/>
		                	 		<button hidden="true" type="submit" name="currValue" value= <%=currentValue%> >ok</button>
		                	 	</form>
		                	 </td>
	                	 <%}%>
	           		<%}%>
	            </tr>
	            
		       <%}%> 
		</table>
		
		<div class="diag_button"> <button class="btn" id="btn" onClick="diagForTeacher();"> Create diagram </button></div>
	
	</div>

	<div id="container" style="width: 500px; height: 400px;"></div>
	
</body>
</html>