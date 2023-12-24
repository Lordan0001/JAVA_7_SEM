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
    CBean objFromReq = (CBean) request.getAttribute("atrCBean");
    CBean sessionObj = (CBean) request.getSession().getAttribute(request.getSession().getId());
%>
<h3>Attribute CBean</h3>

<div>
    <% if (objFromReq != null) { %>
        <label>value1:<%=objFromReq.getValue1()%></label>
        <br>
        <label>value2:<%=objFromReq.getValue2()%></label>
        <br>
        <label>value3:<%=objFromReq.getValue3()%></label>
    <% } else { %>
        <label>Attribute CBean is null</label>
    <% } %>
</div>

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