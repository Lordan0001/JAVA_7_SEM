<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.ServletContext" %>
<html>
<head>
</head>
<body>

<%=pageContext.getServletContext().getInitParameter("URL1")%><br/>
<%=pageContext.getServletContext().getInitParameter("URL2")%>
<h1>REMOTE</h1>
<form method="post" action="http://192.168.68.128:8080/AS_BVD7/Ccc">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>POST</button>
</form>
<%--<h1>LOCAL</h1>
<form method="post" action="http://localhost:8082/AS_BVD7/Ccc">
    <input type="text" name="value1" placeholder="value1"/><br>
    <input type="text" name="value2" placeholder="value2"/><br>
    <input type="text" name="value3" placeholder="value3"/><br>
    <input type="text" name="cbean" placeholder="cbean"/><br>
    <button>POST</button>
</form>--%>

<a href="http://192.168.68.128:8080/AS_BVD7/first_task.html">Remote page</a>

<a href="http://192.168.68.128:8080/AS_BVD7/Local?urln=1">Param 1</a>
<a href="http://192.168.68.128:8080/AS_BVD7/Local?urln=2">Param 2</a>

<a href="http://192.168.68.128:8080/AS_BVD7/Ccc">Ccc</a>

</body>
</html>
