<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Web Calculator
</h1>
<form action="sum" method="post">
    <p>
        Number a: <label>
        <input type="number" name="a" required/>
    </label>
    </p>
    <p>
        Number b: <label>
        <input type="number" name="b" required/>
    </label>
    </p>
    <p>
        <input type="submit" value="a+b=?"/>
    </p>
</form>
<br/>
</body>
</html>