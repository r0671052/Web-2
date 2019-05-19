
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <link rel="stylesheet" media="all" href="css/style.css">
</head>

<%@include file="header.jspf"%>

<body>
<main>
<form action="Servlet?action=add" method="post" >
    Painter:<br>
    <input type="text" name="painter"><br>
    Name:<br>
    <input type="text" name="name"><br>
    Code:<br>
    <input type="text" name="code"><br>
    Price:<br>
    <input type="number" name="price" min="0"><br><br>
    <input type="Submit" value="Send">


</form>
</main>
</body>
<footer>

</footer>
</html>
