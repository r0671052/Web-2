<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="domain.db.PaintingDB" %>
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

  <section>
    <h2>Mijn kunstgallerij</h2>

    <p>In deze kunstgallerij staan er een aantal van mijn favoriete kunstwerken met hun huidige schatwaarde.<br>

     <% PaintingDB paintingList = (PaintingDB) request.getAttribute("paintingList");%>
    Momenteel zijn er <%=paintingList.getTotaalAantalPaintings()%> schilderijen in de lijst.</p>
  </section>
</main>
</body>
</html>