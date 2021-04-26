<%-- 
    Document   : signUp.jsp
    Created on : Oct 28, 2020, 10:59:19 AM
    Author     : tamda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Sign Up</h1>
        <form action = "DispatchServlet">
            Username*: <input type="text" name="txtUsername" value=""/><br/><br/>
            Password*:   <input type="password" name="txtPassword" value=""/><br/><br/>
            Confirm password*: <input type="password" name="txtConfirmPassword" value=""/><br/><br/>
            Fullname*: <input type="text" name="txtFullname" value=""/><br/><br/>
            <input type="submit" value="Sign up"/>
        </form>
    </body>
</html>
