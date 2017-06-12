<%-- 
    Document   : modificarProjecte
    Created on : 10-jun-2017, 1:43:39
    Author     : victor
--%>


<%@page import="classes.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Diagrama de Gantt</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>

        <div>
            <div>
                <div>
                    <h4>Diagrama de Gantt</h4>
                    <p>Usuari: ${nomUsuari}</p>
                    <ul>
                        <li><a href="controlador?mostrar">Veure projectes i tasques</a></li>
                        <li><a href="modificarProjecte.jsp">Modificar projectes i tasques</a></li>
                        <li><a href="vistaAfegir.jsp">Afegir projectes i tasques</a></li>
                        <li><a href="vistaDiagrama.jsp">Veure diagrama de Gantt</a></li>
                        <form action="controlador" class="form-inline">
                            <button name="cerrar" type="submit" value="cerrar">Tancar sessió</button>
                        </form>

                    </ul><br>
                </div>
                <div>
                    <h4><small>Modificar projectes i tasques</small></h4>
                     <ct:taulaModificar/>          
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>