<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Login Page</title>
</head>
<body>
<h1> Vennligst skriv inn passordet for å bruke denne tjenesten </h1>
    <form method="post">
        <br> <input type="password" name="password" placeholder="Password" /> <br>
        <br>
        <button>Logg inn</button>
    </form>
    
    <p style="color: red">${errorMsg}</p>
</body>

</html>
