<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="domain.db.PaintingDB" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Leeftijd</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <link rel="stylesheet" media="all" href="css/style.css">
</head>

<%@include file="header.jspf"%>

<body>
<main>

    <section>
        <h2>Leeftijd</h2>

        <p>U bent <%=request.getAttribute("leeftijd")%> jaar oud, dat is geen geldige leeftijd.</p>


    </section>
</main>
</body>
</html>