<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/manager.css">
<title>Admin</title>
</head>
<body>
	<div class="row">
	        <div class="leftcolumn">
	            <div class="wellcome">
	                <p>Welcome <%= session.getAttribute("user") %></p>
	            </div>
	            <div>
	                <ul>
	                    <li><a href="#">Dash board</a></li>
	                    <li><a href="#">Page</a></li>
	                    <li><a href="#">Chart</a></li>
	                </ul>
	            </div>
	        </div>
	
	        <div class="rightcolumn">
	            <div class="header row">
	                <h1>1849 TEAMM</h1>
	                <a href="../logout">logout</a>
	            </div>
	            <div class="body">
	                <p>Something about this page</p>
	                <div class="content">
	                    <p>Content 1</p>
	                </div>
	                <div class="content">
	                    <p>Content 2</p>
	                </div>
	                <div class="content">
	                    <p>Content 3</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</body>
</html>