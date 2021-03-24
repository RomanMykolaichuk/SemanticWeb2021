<%-- 
    Document   : result
    Created on : 24 бер. 2021 р., 18:48:02
    Author     : 38068
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Got it!</h1>
        
        <p><%= (String) request.getAttribute("servletString")%></p>
        
        <p><a href="<%=request.getContextPath()%>">Home</a></p>
    </body>
</html>
