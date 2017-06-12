package controlador;

import classes.XML;
import classes.Projecte;
import classes.Tasca;
import classes.Usuari;
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
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryString = request.getQueryString();
        String vista = "";
        HttpSession sessio = request.getSession();
        String usuario = (String) sessio.getAttribute("nomUsuari");

        if (sessio.getAttribute("llistatProjectes") == null) {
            Projecte.projectes = new ArrayList<>();
            XML llegirItem = new XML();
            llegirItem.llegirProjecte(usuario + "-projectes.xml");
            sessio.setAttribute("llistatProjectes", Projecte.projectes);

        } else {
            Projecte.projectes = (ArrayList<Projecte>) sessio.getAttribute("llistatProjectes");
        }

        if (sessio.getAttribute("llistatTasques") == null) {
            Tasca.tasques = new ArrayList<>();
            XML llegirItem = new XML();
            llegirItem.llegirTasques(usuario + "-tasques.xml");
            sessio.setAttribute("llistatTasques", Tasca.tasques);

        } else {
            Tasca.tasques = (ArrayList<Tasca>) sessio.getAttribute("llistatTasques");
        }

        if (queryString.contains("afegir")) {
            String nom = request.getParameter("nProjecte");
            String descripcio = request.getParameter("descripcio");
            String diaInicial = request.getParameter("diaInicial");
            String mesInicial = request.getParameter("mesInicial");
            String anoInicial = request.getParameter("anoInicial");
            if (("".equals(nom)) || ("".equals(descripcio)) || ("".equals(request.getParameter("diaInicial")))
                    || ("".equals(request.getParameter("mesInicial"))) || ("".equals(request.getParameter("anoInicial")))
                    || ("".equals(request.getParameter("diaFinal"))) || ("".equals(request.getParameter("mesFinal")))
                    || ("".equals(request.getParameter("anoFinal")))) {

                vista = "error.jsp";
            } else {

                String fechaInicial = diaInicial + "/" + mesInicial + "/" + anoInicial;
                System.out.println(fechaInicial);
                String diaFinal = request.getParameter("diaFinal");
                String mesFinal = request.getParameter("mesFinal");
                String anoFinal = request.getParameter("anoFinal");
                String fechaFinal = diaFinal + "/" + mesFinal + "/" + anoFinal;
                System.out.println(fechaFinal);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha1;
                Date fecha2;
                try {
                    fecha1 = dateFormat.parse(fechaInicial);
                    fecha2 = dateFormat.parse(fechaFinal);
                    int dias = (int) ((fecha1.getTime() - fecha2.getTime()) / 86400000) * -1;
                    System.out.println("La diferencia en dias es:" + dias);
                    Projecte projecte1 = new Projecte(nom, descripcio, fechaInicial, fechaFinal, dias);
                    Projecte.projectes.add(projecte1);
                    XML afegirItem = new XML();
                    sessio.setAttribute("llistatProjectes", Projecte.projectes);
                    afegirItem.crearProjecte(usuario + "-projectes.xml");
                    request.setAttribute("projecte", projecte1);
                    vista = "afegirProjecte.jsp";

                } catch (ParseException ex) {
                    Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (queryString.contains("mostrar")) {
            System.out.println("Array projecte: " + Projecte.projectes);
            request.setAttribute("arrayProjecte", Projecte.projectes);
            vista = "mostrarProjecte.jsp";

        } else if (queryString.contains("cerrar")) {
            sessio.invalidate();
            vista = "index.jsp";
        } else if (queryString.contains("inicio")) {
            vista = "mostrarProjecte.jsp";
        } else if (queryString.contains("buscar")) {
            String buscar = request.getParameter("nomProjecte");
            request.setAttribute("palabraBuscar", buscar);
            vista = "mostrarProjecteBusqueda.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);

    }
}
