<%-- 
    Document   : errorLogin
    Created on : 10-jun-2017, 0:25:16
    Author     : victor
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Usuario o contraseña incorrectos!</h1>
        <form action="controladorLogin">
            <button name="inicio" value="inicio" type="submit">Volver al inicio</button>
        </form>
    </body>
</html>

