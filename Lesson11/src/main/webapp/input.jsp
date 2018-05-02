<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Functions</title>
</head>
<body>
<form action="input" method="post">
    <select name="func">
        <option value="cos">cosine</option>
        <option value="sin">sinus</option>
        <option value="tan">tangent</option>
    </select>
    <input type="text" name="angleValue" style="width: 50px">
    <input type="text" name="prec" style="width: 50px">
    <input type="submit" value="calc">
</form>
</body>
</html>
