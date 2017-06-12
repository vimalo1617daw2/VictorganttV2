<%-- 
    Document   : index
    Created on : 10-jun-2017, 0:23:13
    Author     : victor
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div>
            <form action="controladorLogin" >
                ${resposta}
                <h2 class="form-signin-heading">Diagrama de Gantt<small> Inicia sesión o registrate</small></h2>
                <label for="inputName" >Usuario</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="Nombre d'usuario" required autofocus>
                <label for="inputPassword" >Contraseña</label>
                <input type="password" name="password" id="inputPassword"  placeholder="Contraseña" required>
                <button name="enviarLogin"  value="iniciar" type="submit">Iniciar sesión</button>
                <button name="enviarLRegistro"  value="registrar" type="submit">Registrar-se</button>
            </form>
        </div>
    </body>
</html>
