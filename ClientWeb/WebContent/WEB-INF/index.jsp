
<%@page import="Model.InscriptionInfo"%>
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
		List<InscriptionInfo> infos = (List<InscriptionInfo>) request.getAttribute("inscriptions");
		
	%>
		
	<jsp:include page="nav.jsp"></jsp:include>
	<div class ="p-4">
		<div class="px-10 mb-4 d-flex items-center justify-content-between">	
			<form class="d-flex items-center gap-4" action="/ClientWeb/inscriptions" method="post">
			    <input class="form-control mr-sm-2" 
			    style="display: inline-block!important;width: 160%!important" 
			    placeHolder="Cne : "
			    name="cne">
			    <button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			
			<a href ="/ClientWeb/inscriptions/create" class="btn btn-success">Create Inscription</a>
		</div>
		
		<table class="table table-striped">
			<caption>List of inscriptions</caption>
		
			<thead>
		    	<tr>
				   	<th scope="col">ID</th>
			    	<th scope="col">CNE</th>
			      	<th scope="col">NAME</th>
					<th scope="col">ETAT</th>
					<th scope="col">NUMERO SALLE</th>
				    <th scope="col">TYPE</th>
			      	<th scope="col">PRIX</th>
		    	</tr>
	  		</thead>
	  		
	  		<tbody>
	  			<%
	  				for(InscriptionInfo item : infos){
	  					out.println("<tr>");
	  					
	  					out.println("<td>" + item.getId() + "</td>");
	  					out.println("<td>" + item.getCne() + "</td>");
	  					out.println("<td>" + item.getName() + "</td>");
	  					
	  					String etat ;
	  					if(item.getEtat()){
	  						etat = "Active";
	  					} else etat ="Désactive";
	  					
	  					out.println("<td>" +etat+ "</td>");
	  					
	  					
	  					out.println("<td>" + item.getNumSalle() + "</td>");
	  					out.println("<td>" + item.getType() + "</td>");
	  					out.println("<td>" + item.getPrix() + "</td>");
	  					
	  					out.println("<td>");
	  					
	  					Boolean etatDiff = !item.getEtat();
	  					
	  					if(item.getEtat() == true){
	  						out.println("<a class ='btn btn-danger' href ='/ClientWeb/inscriptions/oprations?id=" + item.getId() + "'>Désactive</a>");
	  					}else{
	  						out.println("<a class ='btn btn-success' href ='/ClientWeb/inscriptions/oprations?id=" + item.getId()+ "'>Activer</a>");
	  					}
	  					
	  					out.println("</td>");
	  					
	  					out.println("<td><form method='post' action='/ClientWeb/inscriptions/oprations'>"
	  							+"<input  type='hidden'  name ='id' value ='"+item.getId() + "' />"
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