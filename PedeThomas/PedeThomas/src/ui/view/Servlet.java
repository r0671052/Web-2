package ui.view;

import domain.db.PaintingDB;
import domain.model.Painting;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private PaintingDB paintingList = new PaintingDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcesRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcesRequest(request,response);
    }

    private void ProcesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "index";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        String destination = "index.jsp";

        switch(action){

            case "index":
                destination = index(request,response);
                break;

            case "overview":
                destination = overview(request,response);
                break;

            case "add":
                destination = add(request,response);
                break;

            case "delete":
                destination = delete(request,response);
                break;

            default:
                destination = index(request,response);

        }

        request.getRequestDispatcher(destination).forward(request,response);
    }

    private String index(HttpServletRequest request, HttpServletResponse response ){
        request.setAttribute("paintingList", paintingList);
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("paintingList", paintingList);
            return "overzicht.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response){

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String painter = request.getParameter("painter");
        String price = request.getParameter("price");
        String leeftijd = request.getParameter("leeftijd");

        if(code == null || code.isEmpty()|| name== null || name.isEmpty() || painter == null || painter.isEmpty()|| price==null || price.isEmpty()||leeftijd.isEmpty()||leeftijd==null) return "voegToe.jsp";
        if(Integer.parseInt(leeftijd)<0 || Integer.parseInt(leeftijd)>120){
            request.setAttribute("leeftijd", leeftijd);
            return "leeftijd.jsp";
        }
        else{
            Painting newPainting = new Painting(painter,name,Integer.parseInt(price),code, Integer.parseInt(leeftijd));

            paintingList.addPainting(newPainting);
        }
        request.setAttribute("paintingList", paintingList);

            return "overzicht.jsp";

    }

    private String delete(HttpServletRequest request,HttpServletResponse response){

        paintingList.delete(request.getParameter("code"));
        return index(request,response);
    }
}
