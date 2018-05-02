<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    <%--<jsp:useBean id="angle" scope="request" type="elessons.lesson11.model.Angle"/>--%>
    <%--RESULT: <jsp:getProperty name="angle" property="result"/>--%>
    RESULT:<fmt:formatNumber type="number" pattern = "${angle.pattern}" value = "${angle.result}" />
</body>
</html>