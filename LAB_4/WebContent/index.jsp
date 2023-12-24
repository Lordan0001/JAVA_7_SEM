<%@ page language="java"
 contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="lab4.DateConverter" %>
<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<!%@ page import="org.apache.commons.lang3.time.DateUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<!-- .......................................... -->
<head>
<meta http-equiv="Content-Type"
content="text/html; charset=ISO-8859-1">
<%--<title>IS&amp;T-2009</title>--%>
    <title>LAB_4</title>
<%!
    String name = null;
    DateConverter r = new DateConverter();
    Integer n = r.GetHOUR();

    protected String Salutation(Integer h)
    {
        String rc = "Good ";
        if ((h > 0) && (h <= 5))
        rc += "night";
        else if ((h > 5) && (h <= 12))
        rc += "morning";
        else if ((h > 12) && (h <= 17))
        rc += "afternoon";
        else
        rc += "evening";
        return rc;
    }
    protected String GetJsp(Integer h)
    {
        if ((h > 0) && (h <= 5))
        name = "night";
        else if ((h > 5) && (h <= 12))
        name = "morning";
        else if ((h > 12) && (h <= 17))
        name = "afternoon";
        else
        name = "evening";
        return name;
    }
%>
</head>
<body>
    <%=Salutation(n)%>
    <%
    if(request.getParameter("time")!=null)
    {
    %>
        <%
        if(GetJsp(n)=="morning")
        {
        %>
            <%--<%@ include file="morning.jsp" %>--%>
<%--    <p>This is after the include.</p>--%>
    <jsp:include page="morning.jsp" />
<%--    <jsp:forward page="morning.jsp" />--%>

        <%
        }
        %>
        <%
        if(GetJsp(n)=="afternoon")
        {
        %>
<%--
            <%@ include file="afternoon.jsp" %>
--%>
            <jsp:include page="afternoon.jsp" />
<%--            <jsp:forward page="afternoon.jsp" />--%>
        <%
        }
        %>
        <%
        if(GetJsp(n)=="night")
        {
        %>
<%--
            <%@ include file="night.jsp" %>
--%>
            <jsp:include page="night.jsp" />
<%--            <jsp:forward page="night.jsp" />--%>
        <%
        }
        %>
        <%
        if(GetJsp(n)=="evening")
        {
        %>
<%--
            <%@ include file="evening.jsp" %>
--%>
            <jsp:include page="evening.jsp" />
<%--            <jsp:forward page="evening.jsp" />--%>
        <%
        }
        %>
    <%
    }
    %>
        <%=n%>
        <%GetJsp(n);%>
        <%request.getParameter("time");%>
        <%Date dateNow = new Date();%>
        <%SimpleDateFormat yy = new SimpleDateFormat("dd/MM/yyyy"); %>

        <table>

            <% for (int i=0; i < 7; i++) {
                Date dateNext = new Date(new Date().getTime() + 60*60*24*1000*i);
                Calendar c = Calendar.getInstance();
                c.setTime(dateNext);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                %>
                <tr>
                    <td><% out.print(yy.format(dateNext)); %></td>
                    <td><% out.print(dayOfWeek); %></td>
                </tr>
            <% } %>

        </table>



<form action="#" method="post">
    <label>TASK 5</label><br />
        <input hidden="hidden" type="text" name="time" value="<%= GetJsp(n) %>"/><br /> <br />
    <input type="submit" value="PRESS"/>
</form>

    <label>TASK 7</label>
    <jsp:include page="/Afternoon" />
<%-- <jsp:include page="Afternoon"></jsp:include> --%>

<%-- <jsp:include page="Jjj"></jsp:include> --%>
<form action="Jjj" method="GET">
    <input type="submit" name="press" value="GET (Jjj)">
</form>

<form action="Jjj" method="POST">
    <input type="submit" name="press" value="POST (Jjj)">
</form>