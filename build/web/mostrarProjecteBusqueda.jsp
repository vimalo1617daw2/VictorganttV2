<%-- 
    Document   : mostrarProjecteBusqueda
    Created on : 12-jun-2017, 1:44:05
    Author     : victor
--%>


<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <li ><a href="vistaAfegir.jsp">Afegir projectes i tasques</a></li>
                        <li><a href="vistaDiagrama.jsp">Veure diagrama de Gantt</a></li>
                        <form action="controlador">
                            <button name="cerrar" type="submit" value="cerrar">Tancar sessió</button>
                        </form>

                    </ul><br>
                </div>
                <div>
                    <h4><small>Diagrama de Gantt</small></h4>
                    <table>
                        <tr>
                            <th>LLEGENDA</th>
                        </tr>
                        <tr>
                            <td style="color: green;">Realitzada</td>
                        </tr>
                        <tr>
                            <td style="color: crimson;">Pendent</td>
                        </tr>
                    </table>
                    <br>   <br>
                    <c:forEach items="${llistatProjectes}" var="projecte">
                        <c:if test="${projecte.nomProjecte==palabraBuscar}">
                            <table>
                                <tr>
                                    <th>Nom projecte</th>
                                    <th>Descripcio</th>
                                    <th>Data inicial</th>
                                    <th>Data final</th>
                                    <th>Dies</th>
                                </tr>
                                <tr>
                                    <td>${projecte.nomProjecte}</td>
                                    <td>${projecte.descripcio}</td>
                                    <td>${projecte.fechaInicial}</td>
                                    <td>${projecte.fechaFinal}</td>
                                    <td>${projecte.dias}</td>
                                </tr>

                            </table>
                                <ct:taulaDiagrama/>
                        </c:if>    
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>