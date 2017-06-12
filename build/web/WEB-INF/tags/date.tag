<%-- 
    Document   : date
    Created on : 11-jun-2017, 13:52:55
    Author     : victor
--%>

<%@tag description="Dates Form" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="dia" required="true"%>
<%@ attribute name="mes" required="true"%>
<%@ attribute name="any" required="false"%>

<%-- any content can be specified here e.g.: --%>
<select name="${dia}" >
    <c:forEach begin="01" end="31" var="dia">
        <option> ${dia}</option>
    </c:forEach>
</select>
<select  name="${mes}">
  <%--  <option value="01">enero</option>
    <option value="02">febrero</option> --%>
    <option value="06">Junio</option>
    <%--  <option value="04">abril</option>
    <option value="05">mayo</option>
    <option value="06">junio</option>
    <option value="07">julio</option>
    <option value="08">agosto</option>
    <option value="09">septiembre</option>
    <option value="10">octubre</option>
    <option value="11">noviembre</option>
    <option value="12">diciembre</option>--%>
</select>
<select  name="${any}">
    <c:forEach begin="2017" end="2017" var="ano">
        <option> ${ano}</option>
    </c:forEach>
</select>