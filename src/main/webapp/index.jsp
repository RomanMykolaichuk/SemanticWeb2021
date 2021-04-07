<%-- 
    Document   : index
    Created on : 24 бер. 2021 р., 18:30:45
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
        <h1>Hello World!</h1>



        <%!int myInt = 0;%>
        <% myInt++;%>   

        <p><%=myInt%></p>


        <form action="<%=request.getContextPath()%>/servlet" method="post">
            <input type="text" name="text1"/>                
            <input type="submit" value="Ok"/>                
        </form> 


        <h2>Create resource</h2>

        <form action="<%=request.getContextPath()%>/resource" method="post">
            <input type="text" name="given" placeholder="enter given name"/> <br> 
            <input type="text" name="family" placeholder="enter family name"/> <br>
            <input type="submit" value="Ok"/>                
        </form> 


    </body>
</html>
