<%@page import="Entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Inscription</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">

</head>

<body>
	<%
		List<User> users = (List<User>)request.getAttribute("users");
	
		
	%>
		
	<jsp:include page="nav.jsp"></jsp:include>
	
	
	<div class ="p-4">
		<div class="px-10 mb-4 d-flex items-center justify-content-between">	
			<form class="d-flex items-center gap-4" action="/ClientWeb/users" method="post">
			    <input class="form-control mr-sm-2" 
			    style="display: inline-block!important;width: 160%!important" 
			    placeHolder="Cne : "
			    name="cne">
			    <button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			
			<a href ="/ClientWeb/users/create" class="btn btn-success">Create User</a>
		</div>
		
		<table class="table table-striped">
			<caption>List of Users</caption>
		
			<thead>
		    	<tr>
			    	<th scope="col">CNE</th>
			      	<th scope="col">NAME</th>
					<th scope="col">EMIAL</th>
					<th scope="col">Age</th>
		    	</tr>
	  		</thead>
	  		
	  		<tbody>
	  			<%
	  				for(User item : users){
	  					out.println("<tr>");
	  					
	  					out.println("<td>" + item.getCne()+ "</td>");
	  					out.println("<td>" + item.getName() + "</td>");
	  					out.println("<td>" + item.getEmail()+ "</td>");
	  					
	  					out.println("<td>" + item.getAge() + "</td>");
	  					
	  					out.println("<td><a href='/ClientWeb/users/update?cne="+item.getCne() 
	  					+"' class='btn btn-success'>update</a></td>");
	  				
	  					out.println("<td><form method='post' action='/ClientWeb/users/operation'>"
	  							+"<input  type='hidden'  name ='cne' value ='"+item.getCne() + "' />"
	  					+"<input type='submit' value='delete' class ='btn btn-danger'/></form></td>");
	  					
	  					out.println("</tr>");
	  				}
	  			%>
	  		</tbody>
		</table>
	</div>	
	



<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>