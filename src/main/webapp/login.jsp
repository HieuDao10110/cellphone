<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <title>Home</title>
</head>

<body>
    <div class="container">
        <div class="login-tag">
            <div>
                <p style="font-size: 30px; margin: 5px 0px 30px 0px;">ACCOUNT LOGIN</p>
            </div>
            <form action="login" method="post">
                <div class="username">
                    <p style="font-size: 12px;">USERNAME</p>
                    <input value="<%= session.getAttribute("fillUser") %>" type="text" placeholder="Enter your username" name="user" required>
                </div>
                <div class="password">
                    <p style="font-size: 12px;">PASSWORD</p>
                    <input value="<%= session.getAttribute("fillPass") %>" type="password" placeholder="Enter your password" name="pass" required>
                </div>
                <div>
                    <input type="checkbox" name="remember" id="rem1" value = "on">
                    <label for="rem1" style="font-size: 12px;">Remember?</label>
                </div>
                <p style="color:red; font-size:12px;"><%= session.getAttribute("error")%></p>
                <button class="login-buttom" type="submit">Login</button>
                <div>                    
                    <a href="home.jsp">Back to Home</a><span style="float: right;">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>
    </div>
</body>

</html>