<%@page import="Entity.User"%>
<%@page import="Entity.Salle"%>
<%@page import="Entity.Formation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Inscription</title>
</head>
<body>
		<%
			List<Formation> formations = (List<Formation>)request.getAttribute("formations");
			List<User> users = (List<User>) request.getAttribute("users");
		%>		
		<jsp:include page="nav.jsp"></jsp:include>
		<form class="px-5" action="/ClientWeb/inscriptions/create" method="post">		
			<div class="form-group">
			    <label class="my-2">Cne :</label>
			    <select class="form-select" aria-label="Default select example" name="cne">
				  <option selected>Choose Cne</option>
				  <%
				  	for(User u : users){
				  		out.println("<option>" + u.getCne() + "</option>");	
				  	}
				  %>
				</select>
  			</div>
			<div class="form-group">
			   <label  class="my-2">type Formation :</label>
			   <select class="form-select" aria-label="Default select example" name="type">
				  <option selected>Choose Formation</option>
				   <%
				  	for(Formation f : formations){
				  		out.println("<option>" + f.getType() + "</option>");	
				  	}
				  %>
				</select>
			 </div>
			<button type="submit" class="btn btn-primary my-2 py-2 px-5">Save</button>
		</form>
</body>
</html>