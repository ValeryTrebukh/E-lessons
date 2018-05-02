<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Functions</title>
</head>
<body>
<form action="calc" method="post">
    <select name="func" style="width: 90px">
        <c:forEach items="${functions}" var="funct">
            <jsp:useBean id="funct" type="elessons.lesson11.web.TrigonometryServlet.MathFunctions"/>
            <option value="${funct}">${funct.type}</option>
        </c:forEach>
    </select>
    <input type="text" name="angleValue" placeholder="angle" style="width: 60px">
    <select name="atype">
        <option value="rad">radian</option>
        <option value="deg">degree</option>
    </select>
    <br>
    <div style="display: inline-block; width: 90px">Precision: </div>
    <input type="text" name="prec" style="width: 60px">
    <br><br>
    <input type="submit" value="calc" style="width: 120px">
</form>
</body>
</html>
