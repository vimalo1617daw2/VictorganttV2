<%-- 
    Document   : taulaDiagrama
    Created on : 11-jun-2017, 13:55:12
    Author     : victor
--%>

<%@tag description="Tabla de la vista diagrama" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- c== Basico --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%-- fmt== formato para fechas --%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- fn== function --%>


<table>

    <!-- modifica la vista en el momento actual --> 

    <c:set var="now" value="<%=new java.util.Date()%>" />

    <!-- Te permite modificar el formato de la fecha --> 
    <th>Data actual: <fmt:formatDate type="date" value="${now}" /></th>
    <!-- 23-Sep-2010 -->
</tr>
<tr>

    <th>Dias:</th>
    <!-- c: forEach begin: inicial, end: final,var -->
    <c:forEach begin="1" end="31" var="dia">
        <!-- var -->
        <th>${dia}</th>
        </c:forEach>
</tr>

<!-- Proyecto -->
<c:forEach items="${llistatProjectes}" var="projecte">
    <c:set var="dateInicial" value="${fn:split(projecte.fechaInicial, '/')}" />
    <c:set var="dateFinal" value="${fn:split(projecte.fechaFinal, '/')}" />
    <tr>
        <td style="font-weight: bold; color: black;">${projecte.nomProjecte}</td>

        <!-- Para cada dia te mira si la fecha inicial y el dia son menores o igual que el final
               para modificarte el fondo -->
        <c:forEach begin="1" end="31" var="dia">
            <c:choose>
                <c:when test="${dia>=dateInicial[0]&&dia<=dateFinal[0]}">
                    <td style="background-color: blue;"></td>
                </c:when>
                <c:otherwise>
                    <td style="background-color: white;"></td>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </tr>

    <!-- Tasques -->
    <c:forEach items="${llistatTasques}" var="projecte2">
        <tr>
            <c:if test="${projecte.nomProjecte==projecte2.nomProjecte}">
                <td>${projecte2.nomProjecte}.${projecte2.nomTasca}</td>
                <c:forEach begin="1" end="31" var="dia">
                    <c:choose>
                        <c:when test="${dia>=dateInicial[0]&&dia<=dateInicial[0]+projecte2.durada-1}">
                            <c:if test="${projecte2.realitzada==true}">
                                <td style="background-color: green;"></td>
                            </c:if>
                            <c:if test="${projecte2.realitzada==false}">
                                <td style="background-color: red;"></td>
                            </c:if>   
                        </c:when>    
                        <c:otherwise>
                            <td style="background-color: white;"></td>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </c:if>

        </tr>
    </c:forEach>

</c:forEach>
</table>