<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<link href="/style.css" rel="stylesheet">
<title>Handleliste</title>
</head>

<body>
    <h1>Min handleliste</h1><br>
    <form action="handleliste" method="post">
        <div class="leggtil"> 
            <input class="test" type="text" name="vare" placeholder="Skriv inn en vare" />
            <p>
                <input type="submit" value="Legg til i handlelisten" />
            </p>
        </div>
    </form>    
    <p style="color: red">${errorMsg}</p>
    
    
<div class="container">
    <div class="table-row">
     <div class="table-cell">
        <c:forEach var="item" items="${vare.varer}">
            <p>${item.navn}<p>
        </c:forEach>
    </div>

    
    
    
    <div class="table-cell">
    <c:forEach items="${vare.varer}" var="slett">
         <form action="slettpost" method=post>
            <input type="hidden" name="vare" value="${slett.navn}" />
            <p> </p>
            <input type="submit" value="fjern" name="${slett.navn}"/>
         </form>
    </c:forEach>
    </div>
</div>
</div>
   
</body>
</html>