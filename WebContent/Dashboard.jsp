<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.project.virtusa.login.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<link
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		<style >body {background-color: #e6fff3;}</style>
		
</head>
 
    <body> 
    <%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if (session.getAttribute("username") == null)
			response.sendRedirect("ApplicationLogin.jsp");
	%>
	<a href = "./Display1?mimeType=upf">hgg</a>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bank</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
       <li><form action="search.jsp" ><button type="submit" class="btn btn-link navbar-btn navbar-link">Search</button></form></li>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./Display1?mimeType=upf">Display</a>
      </li>
    </ul>
     <li class="nav-item">
       <li><form action="Logout" ><button type="submit" class="btn btn-link navbar-btn navbar-link">Logout</button></form></li>
      </li>
  </div>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
       <div class="container col-lg-6">
			<h1 class="text-center">To upload the transaction details as csv file </h1>
			<div class="card">
				<div class="card-body">
          			 <form action="Dashboard" method="post" enctype="multipart/form-data">
        		   <div class="form-group">
             		  <label for="file">Csv File:</label> <input type="file" name="file" />
         	     </div>
                <input type="submit" value="upload" class="btn btn-success" />
            </form>       
        </div>
       </div>
       </div>
    </body>
</html>

