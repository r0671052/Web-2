<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import ="domain.model.*" %>
<%@ page import ="domain.db.*"%>

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

<main>
    <section>
        <h2>Overzicht</h2>
        <table>
            <thead>
            <tr>
                <th>Schilder</th>
                <th>Naam</th>
                <th>Schatprijs</th>
                <th>Code</th>
                <th>Leeftijd</th>
                <th>Verwijder</th>
            </tr>
            </thead>

            <%
                PaintingDB paintingList = (PaintingDB) request.getAttribute("paintingList");

                for (Painting painting : paintingList.getPaintings()) {

            %>
            <tbody>
            <tr>
                <td><%=painting.getPainter() %></td>
                <td><%=painting.getName() %></td>
                <td><%=painting.getPrice() %></td>
                <td><%=painting.getCode() %></td>
                <td><%=painting.getLeeftijd()%></td>
                <td><a href="Servlet?action=delete&code=<%=painting.getCode()%>">Verwijder</a></td>

            </tr>
            </tbody>

            <%
                    }
             %>

        </table>
        <p> Momenteel is het schilderij met de grootste schatwaarde "<%=paintingList.nameMostExpensivePainting() %>",
            met als schatwaarde: <%=paintingList.mostExpensivePainting()%>.</p>
        <p>De som van alle leeftijden is gelijk aan <%=paintingList.averageAge()%>.
        (dit getal is afgerond)
        </p>
    </section>
</main>

</body>
</html>
