<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.ServletContext" %>
<%@ page import="mypackage.CBean" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<%
    CBean ob = (CBean) pageContext.getServletContext().getAttribute("atrCBean");
%>
<%=ob.getValue1()%>
<%=ob.getValue2()%>
<%=ob.getValue3()%>
</body>
</html>