<%-- 
    Document   : afegirProjecte
    Created on : 10-jun-2017, 0:39:48
    Author     : victor
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <form action="controlador">
                            <button name="cerrar" type="submit" value="cerrar">Tancar sessió</button>
                        </form>

                    </ul><br>
                </div>
                <div>
                    <h4><small>Projecte afegit</small></h4>
                    <table>
                        <th>Nom projecte</th>
                        <th>Descripcio</th>
                        <th>Data d'inici</th>
                        <th>Data final</th>
                        <tr>
                            <td>${projecte.nomProjecte}</td>
                            <td>${projecte.descripcio}</td>
                            <td>${projecte.fechaInicial}</td>
                            <td>${projecte.fechaFinal}</td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>