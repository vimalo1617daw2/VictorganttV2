/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import classes.XML;
import classes.Projecte;
import classes.Tasca;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Victor
 */
@WebServlet(name = "controladorTasca", urlPatterns = {"/controladorTasca"})
public class controladorTasca extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryString = request.getQueryString();
        String vista = "";
        HttpSession sessio = request.getSession();
        String usuario = (String) sessio.getAttribute("nomUsuari");

        if (queryString.contains("afegir")) {
            String nomProjecte = request.getParameter("nomProjecte");
            String nomTasca = request.getParameter("nomTasca");
            String descripcio = request.getParameter("descripcio");
            Integer durada = Integer.parseInt(request.getParameter("durada"));
            Boolean realitzada = Boolean.parseBoolean(request.getParameter("realitzada"));

            if (("".equals(request.getParameter("nomTasca"))) || ("".equals(request.getParameter("descripcio")))
                    || ("".equals(request.getParameter("durada")))) {

                vista = "error.jsp";
            } else {
                Tasca tasca1 = new Tasca(nomProjecte, nomTasca, descripcio, durada, realitzada);
                Tasca.tasques.add(tasca1);
                XML afegirItem = new XML();
                sessio.setAttribute("llistatTasques", Tasca.tasques);
                afegirItem.crearTasca(usuario + "-tasques.xml");
                request.setAttribute("tasca", tasca1);
                vista = "afegirTasca.jsp";
            }

        } else if (queryString.contains("cerrar")) {
            sessio.invalidate();
            vista = "index.jsp";
        } else if (queryString.contains("inicio")) {
            vista = "menu_index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);

    }
}
