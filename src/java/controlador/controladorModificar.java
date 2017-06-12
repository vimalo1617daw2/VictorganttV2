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
@WebServlet(name = "controladorModificar", urlPatterns = {"/controladorModificar"})
public class controladorModificar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryString = request.getQueryString();
        String vista = "";
        HttpSession sessio = request.getSession();
        String usuario = (String) sessio.getAttribute("nomUsuari");

        if (queryString.contains("modificarProjecte")) {
            String nomProjecte = request.getParameter("nomProjecte");
            String descripcio = request.getParameter("descripcioProjecte");
            String dataInicial = request.getParameter("dataInicial");
            String dataFinal = request.getParameter("dataFinal");
            Integer dias = Integer.parseInt(request.getParameter("dies"));

            if (("".equals(request.getParameter("nomProjecte"))) || ("".equals(request.getParameter("descripcioProjecte")))
                    || ("".equals(request.getParameter("dataInicial"))) || "".equals(request.getParameter("dataFinal"))) {

                vista = "error.jsp";
            } else {

                for (int z = 0; z < Projecte.projectes.size(); z++) {
                    if (nomProjecte.equals(Projecte.projectes.get(z).getNomProjecte())) {

                        Projecte.projectes.remove(z);
                        Projecte projecte1 = new Projecte(nomProjecte, descripcio, dataInicial, dataFinal, dias);
                        Projecte.projectes.add(projecte1);
                        XML llegirItem = new XML();
                        llegirItem.crearProjecte(usuario + "-projectes.xml");

                        vista = "modificarProjecte.jsp";
                    }
                }
            }

        } else if (queryString.contains("cerrar")) {
            sessio.invalidate();
            vista = "index.jsp";
        } else if (queryString.contains("inicio")) {
            vista = "menu_index.jsp";
        } else if (queryString.contains("eliminarTasca")) {
            String tasca = request.getParameter("nomTasca");
            System.out.println("entra eliminar");

            for (int z = 0; z < Tasca.tasques.size(); z++) {
                System.out.println(Tasca.tasques.get(z));
                if (tasca.equals(Tasca.tasques.get(z).getNomTasca())) {
                    System.out.println("entra if");

                    Tasca.tasques.remove(z);
                    XML llegirItem = new XML();
                    llegirItem.crearTasca(usuario + "-tasques.xml");
                    vista = "modificarProjecte.jsp";
                }
            }
        } else if (queryString.contains("eliminarProjecte")) {
            System.out.println("entra");
            String projecte = request.getParameter("nomProjecte");
            System.out.println(request.getParameter("nomProjecte"));

            for (int z = 0; z < Projecte.projectes.size(); z++) {

                System.out.println("entra for");
                if (projecte.equals(Projecte.projectes.get(z).getNomProjecte())) {
                    for (int a = 0; a < Tasca.tasques.size(); a++) {
                        if (projecte.equals(Tasca.tasques.get(z).getNomProjecte())) {
                            Tasca.tasques.remove(a);
                            XML llegirItem2 = new XML();
                            llegirItem2.crearTasca(usuario + "-tasques.xml");
                        }
                        System.out.println("entra if eliminar");
                        Projecte.projectes.remove(z);

                        XML llegirItem = new XML();
                        llegirItem.crearProjecte(usuario + "-projectes.xml");

                        vista = "modificarProjecte.jsp";
                    }
                }
            }
        } else if (queryString.contains("modificarTasca")) {
            String nomProjecte = request.getParameter("nomProjecte");
            String descripcio = request.getParameter("descripcioTasca");
            String nomTasca = request.getParameter("nomTasca");
            Integer duradaTasca = Integer.parseInt(request.getParameter("duradaTasca"));
            Boolean realitzada = Boolean.parseBoolean(request.getParameter("realitzadaTasca"));

            if (("".equals(request.getParameter("nomProjecte"))) || ("".equals(request.getParameter("descripcioTasca")))
                    || ("".equals(request.getParameter("nomTasca"))) || "".equals(request.getParameter("duradaTasca")) || "".equals(request.getParameter("dies"))) {

                vista = "error.jsp";
            } else {

                for (int z = 0; z < Tasca.tasques.size(); z++) {
                    System.out.println("entra for");
                    if (nomTasca.equals(Tasca.tasques.get(z).getNomTasca())) {
                        System.out.println("entra if");
                        Tasca.tasques.remove(z);
                        Tasca tasca1 = new Tasca(nomProjecte, nomTasca, descripcio, duradaTasca, realitzada);
                        Tasca.tasques.add(tasca1);
                        XML llegirItem = new XML();
                        llegirItem.crearTasca(usuario + "-tasques.xml");

                        vista = "modificarProjecte.jsp";
                    }
                }
            }

        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);

    }
}
