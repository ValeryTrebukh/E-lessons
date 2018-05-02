package elessons.lesson11.web;

import elessons.lesson11.model.Angle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "TrigonometryServlet", urlPatterns = {"/"})
public class TrigonometryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        PrintWriter pw = response.getWriter();
//        response.setContentType("text/html; charset=UTF-8");
//        pw.println("<html><head>" +
//                "<title>Functions</title>" +
//                "</head><body>");
//        pw.println("<form action=\"input\" method=\"post\">");
//        pw.println("<input type=\"text\" name=\"value\">");
//        pw.println("<input type=\"submit\" value=\"Calc\"></form>");
//        pw.println("</body></html>");

        response.sendRedirect("input.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final Angle angle = new Angle(Integer.parseInt(req.getParameter("angleValue")),
                req.getParameter("func"), Integer.parseInt(req.getParameter("prec")));

        req.setAttribute("angle", angle);

        req.getRequestDispatcher("result.jsp").forward(req, resp);

    }
}
