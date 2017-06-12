<%-- 
    Document   : vistaAfegir
    Created on : 10-Jun-2017, 1:38:51
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <button name="cerrar" type="submit"  value="cerrar">Tancar sessió</button>
                        </form>

                    </ul><br>
                </div>
                <div>
                    <h4><small>Afegir projecte</small></h4>
                    <form action="controlador">
                        <div>
                            <label>Nom projecte:</label>
                            <input type="text" name="nProjecte" id="nomProjecte" placeholder="Nom del projecte">
                        </div>
                        <div>
                            <label>Descripció:</label>
                            <input type="text" id="descripcioProjecte" placeholder="Descripcio">
                        </div>
                        <div>
                            <label>Fecha inicio:</label>
                            <ct:date dia="diaInicial" mes="mesInicial" any="anoInicial"/>
                        </div>
                        <div>
                            <label>Fecha final:</label>
                            <ct:date dia="diaFinal" mes="mesFinal" any="anoFinal"/>
                        </div>
                        <button name="op"  type="submit" value="afegir">Afegir projecte</button>
                    </form>
                         <hr />
                </div>
                        
                <div>
                    <c:forEach items="${llistatProjectes}" var="projecte">
                        <form action="controladorTasca">
                            <h4><small>Afegir tasca projecte ${projecte.nomProjecte}</small></h4>
                            <div>
                                <label>Nom projecte:</label>
          
                                    <input size="5" type="text" name="nomProjecte" id="nomTasca" value="${projecte.nomProjecte}" readonly>
                            </div>
                            <div>
                                <label>Nom tasca:</label>
                                <input type="text" name="nomTasca" id="nomTasca" placeholder="Examen,exercicis..">
                            </div>
                            <div>
                                <label>Descripció:</label>
                                <input type="text"name="descripcio" id="descripcioTasca" placeholder="Descripcio">
                            </div>
                            <div>

                                <label>Durada:</label>
                                <input type="number" min="1" max="${projecte.dias}" name="durada" id="duradaTasca" placeholder="Dies">

                            </div>
                            <div>
                                <label>Realitzada:</label>
                                <select name="realitzada">
                                    <option value="false">No</option>
                                    <option value="true">Si</option>

                                </select>
                            </div>
                            <button name="op" type="submit" value="afegir">Afegir tasca</button>
                        </form>
                                <hr />
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>