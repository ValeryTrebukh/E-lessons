<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    cos(${angle}) = <fmt:formatNumber type="number" pattern = "${pattern}" value = "${result}" /> <br>
    <a href="calc">back</a>
</body>
</html>