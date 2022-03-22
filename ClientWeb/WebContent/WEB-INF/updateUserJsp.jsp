<%@page import="Entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
		<%
			User user = (User) request.getAttribute("user");
		%>
		<jsp:include page="nav.jsp"></jsp:include>

		<form class="px-5" action="/ClientWeb/users/update" method="post">		
		
			<div class="form-group">
			    <label class="my-2">Cne :</label>
			    <input type="text" class="form-control" readonly="readonly" name="cne" value="<%= user.getCne()%>">
  			</div>
  			
			<div class="form-group">
			    <label class="my-2">Name :</label>
			    <input type="text" class="form-control" name="name" value="<%= user.getName()%>" >
  			</div>
			<div class="form-group">
			   <label  class="my-2">Email</label>
			   <input type="text" class="form-control"  name="email" value="<%= user.getEmail()%>">
			 </div>
		
			<div class="form-group">
			    <label  class="my-2">Age</label>
			    <input type="number" class="form-control"  name="age" value="<%= user.getAge()%>">
  			</div>
			
			<button type="submit" class="btn btn-primary my-2 py-2 px-5">Save</button>
			  
		</form>
</body>

</html>