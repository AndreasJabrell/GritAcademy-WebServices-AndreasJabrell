<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="content-type" content="text/html" charset="ISO-8859-1" />
    <title>HomE Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h1>Demo JSP webpage showing rest endpoints</h1>
<!--<p>${message}</p>-->
<p>Skriv in följande info för att lägga till student</p>
<form id="createStudent" action="/createStudent" method="POST">
    <label for="fName" >fName</label>
    <input type="text" id="fName" name="fName" required>    <br>
    <label for="lName">lName</label>
    <input type="text" id="lName" name="lName" required>    <br>
    <label for="town">town</label>
    <input type="text" id="town" name="town" required>    <br>
    <br>
    <a href="http://localhost:8567/createStudent title=Create Student">
    <input class="btn" type="submit" value="Lägg till student"><br>
    </a>
</form>
<br>
<hr>

<div style=text-align:center;>
    <p>Klicka här för att se alla kurser</p>
    <a href=http://localhost:8567/courses/ title=Courses><br>
        <button type="button">KURSER</button>
    </a><br>
    <h4>Klicka här för studenter</h4>
    <a href=http://localhost:8567/students title=Students><br>
        <button type="button">STUDENTER</button>
    </a><br>
    <h4>Hem</h4>
    <a href=http://localhost:8567/ title=Home><br>
        <button type="button">HEM</button>
    </a><br>
</div>
<br>
<form action="removeStudent/{id}" method="POST">
    id <input type="text" id="id" name="id" required>
    <br>
    <br>
    <a href="http://localhost:8567/removeStudent/{id} title=Remove Student">
    <input class="btn" type="submit" value="Ta bort student">
    </a>
</form>
<br>
<hr>
<br>
<button class="btn" onclick=location.href='/students'>SHOW ALL STUDENTS</button>
<br>
<hr>
<br>
<button class="btn" onclick=location.href='/students/1/courses'>SHOW ALL COURSES FOR STUDENTS 1</button>

</body>
</html>