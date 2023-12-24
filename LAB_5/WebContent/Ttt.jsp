<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="mytaglib" prefix="taglib" %>
<html>
<head>
    <title>
        Lab5
    </title>
</head>
<body>
<taglib:dossier action="/AS_BVD5/Ttt">
    <br/><taglib:surname value="Vlad"/>
    <br/><taglib:lastname value="Vlad"/>
    <br><taglib:sex/>
    <br><taglib:submit/>
    <input type="button" value="Cancel" onclick="location.href='index.jsp';" />

</taglib:dossier>
</body>
</html>