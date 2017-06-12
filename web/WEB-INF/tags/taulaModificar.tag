<%-- 
    Document   : taulaModificar
    Created on : 11-jun-2017, 13:08:18
    Author     : victor
--%>

<%@tag description="taula fitxer modificarProjecte" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Projecte -->
<c:forEach items="${llistatProjectes}" var="projecte">
    <table>
        <th>Nom projecte</th>
        <th>Descripcio</th>
        <th>Data d'inici</th>
        <th>Data final</th>
        <th>Dies</th>
        <th>Modificar</th>
        <th>Eliminar</th>
        <tr>
        <form action="controladorModificar">
            <td><input  type="text" name="nomProjecte" value=${projecte.nomProjecte} readonly></td>
            <td><input   type="text" name="descripcioProjecte" value="${projecte.descripcio}"></td>
            <td><input   type="text" name="dataInicial" value="${projecte.fechaInicial}"></td>
            <td><input   type="text" name="dataFinal" value="${projecte.fechaFinal}"></td>
            <td><input   min="1" max="31" type="number" name="dies" value="${projecte.dias}"></td>
            <!--Modifica -->
            <td><button  name="modificarProjecte" type="submit"  value="modificar"><span  aria-hidden="true"></span></button></td>
            <!--Elimina -->
            <td><button  name="eliminarProjecte" type="submit"  value="eliminar"><span  aria-hidden="true"></span></button></td>
        </form> 
    </tr>
    <!--Tasques del Projecte -->
    <c:forEach items="${llistatTasques}" var="projecte2">
        <!--Comprueba que la tasca pertenece al projecto -->
        <c:if test="${projecte.nomProjecte==projecte2.nomProjecte}">
            <th>Nom tasca</th>
            <th>Descripcio</th>
            <th>Durada dies</th>
            <th>Realitzada</th>
            <th>Modificar</th>
            <th>Eliminar</th>
            <tr>
            <form action="controladorModificar">
                <input type="hidden" name="nomProjecte" value="${projecte2.nomProjecte}" readonly>
                <td><input  type="text" name="nomTasca" value="${projecte2.nomTasca}" readonly></td>
                <td><input type="text" name="descripcioTasca" value="${projecte2.descripcio}"></td>
                <td> <input type="number" min="1" max="${projecte.dias}" name="duradaTasca" id="duradaTasca" value="${projecte2.durada}"></td>
                <td><select name="realitzadaTasca">
                        <c:if test="${projecte2.realitzada==false}">
                            <option value="true">Si</option>
                            <option value="false">No</option>
                        </c:if>
                        <c:if test="${projecte2.realitzada==true}">
                            <option value="true">Si</option>
                            <option value="false">No</option>

                        </c:if>
                    </select></td>
                <td><button  name="modificarTasca" type="submit"  value="modificar"><span aria-hidden="true"></span></button></td>
                <td><button  name="eliminarTasca" type="submit" value="eliminar"><span aria-hidden="true"></span></button></td>
            </form>  
        </tr>
    </c:if>
</c:forEach>

</c:forEach>