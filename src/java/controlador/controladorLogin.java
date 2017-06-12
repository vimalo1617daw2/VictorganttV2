/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import classes.XML;
import classes.Usuari;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "controladorLogin", urlPatterns = {"/controladorLogin"})
public class controladorLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryString = request.getQueryString();
        String vista = "";

        HttpSession sessio = request.getSession();
        //si no contiene usuarios creo el arrayList, si existe le añado el array
//        

        if (sessio.getAttribute("llistatUsuaris") == null) {
            Usuari.llistatUsuaris = new ArrayList<>();
            XML llegirItem = new XML();
            llegirItem.llegirUsuari();
        } else {
            Usuari.llistatUsuaris = (ArrayList<Usuari>) sessio.getAttribute("llistatUsuaris");
        }

//         System.out.println("sessio usuaris: "+sessio.getAttribute("llistatUsuaris"));
        if (queryString.contains("registrar")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Usuari usuari1 = new Usuari(username, password);
            Usuari.llistatUsuaris.add(usuari1);
            System.out.println(Usuari.llistatUsuaris);
            sessio.setAttribute("llistatUsuaris", Usuari.llistatUsuaris);
            XML afegirItem = new XML();
            afegirItem.crearUsuari();
            request.setAttribute("resposta", "Usuari registra't Inicia sessió");
            vista = "index.jsp";

        } else if (queryString.contains("iniciar")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            for (int z = 0; z < Usuari.llistatUsuaris.size(); z++) {
                if (Usuari.llistatUsuaris.get(z).getUsername().equals(username) && Usuari.llistatUsuaris.get(z).getPassword().equals(password)) {
                    System.out.println("sessio: " + username);
                    sessio.setAttribute("nomUsuari", username);
                    vista = "controlador?mostrar";
                    break;
                } else {
                    vista = "errorLogin.jsp";
                }
            }

        } else if (queryString.contains("inicio")) {
            vista = "index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);

    }

}
