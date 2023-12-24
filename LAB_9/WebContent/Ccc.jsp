<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.ServletContext" %>
<%@ page import="mypackage.CBean" %>
<html>
<head>
    <title>
    </title>
</head>
<body>
<h3>Value2 param: <%=request.getParameter("value2")%></h3>
<%
    CBean sessionObj = (CBean) request.getSession().getAttribute(request.getSession().getId());
%>

<h3>Session CBean</h3>

<div>
    <% if (sessionObj != null) { %>
        <label>value1:<%=sessionObj.getValue1()%></label>
        <br>
        <label>value2:<%=sessionObj.getValue2()%></label>
        <br>
        <label>value3:<%=sessionObj.getValue3()%></label>
    <% } else { %>
        <label>Session CBean is null</label>
    <% } %>
</div>
</body>
</html>