<%-- 
    Document   : taulaMostrar
    Created on : 11-jun-2017, 00:18:13
    Author     : victor
--%>

<%@tag description="taula fitxer mostrar projecte" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${llistatProjectes}" var="projecte">
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
        <c:forEach items="${llistatTasques}" var="projecte2">
            <c:if test="${projecte.nomProjecte==projecte2.nomProjecte}">
                <th>Nom tasca</th>
                <th>Descripcio</th>
                <th>Durada dies</th>
                <th>Realitzada</th>
                <tr>
                    <td>${projecte2.nomTasca}</td>
                    <td>${projecte2.descripcio}</td>
                    <td>${projecte2.durada}</td>
                    <c:if test="${projecte2.realitzada==true}">
                        <td>Si</td>
                    </c:if>
                    <c:if test="${projecte2.realitzada==false}">
                        <td>No</td>
                    </c:if>
                </tr>
            </c:if>
        </c:forEach>

    </c:forEach>