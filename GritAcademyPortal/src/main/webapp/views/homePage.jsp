<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="content-type" content="text/html" charset="ISO-8859-1"/>
    <title>Grit Academy REST API</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h1 style=text-align:center;>Joel och Andreas gör grejer</h1>
<!--<p>${message}</p>-->

<div class="divider" style=text-align:center;>
    <p>Klicka här för att se alla kurser</p>
    <a href=http://localhost:8567/courses/ title=Courses><br>
        <button type="button">KURSER</button>
    </a><br>
    <p>Klicka här för studenter</p>
    <a href=http://localhost:8567/students/ title=Students><br>
        <button type="button">STUDENTER</button>
    </a><br>
    <p>Studenter och dess kurser</p>
    <a href=http://localhost:8567/studentsCourses/ title=Home><br>
        <button type="button">STUDENTER OCH DESS KURSER</button>
    </a><br>
</div>
<br>
<hr>

<div>
    <p>Skriv in följande info för att lägga till student</p>
    <form class="Form" action="/students/create" method="POST">
        <p class="ParagraphForm">
            <label class="FormCell" for="fName">Förnamn</label>
            <input class="FormCell" type="text" id="fName" name="fName" required> <br>
        </p>
        <p class="ParagraphForm">
            <label class="FormCell" for="lName">Efternamn</label>
            <input class="FormCell" type="text" id="lName" name="lName" required> <br>
        </p>
        <p class="ParagraphForm">
            <label class="FormCell" for="town">Hemstad</label>
            <input class="FormCell" type="text" id="town" name="town" required>
        </p>
        <br>
        <a href="http://localhost:8567/students/create title=Create Student">
            <input class="btn" type="submit" value="Lägg till student"><br>
        </a>
    </form>
</div>
<br>
<hr>

<div class="divider" style=text-align:center;>
    <p>Skriv in följande info för att lägga till kurs</p>
    <form class="Form" id="createCourse" action="/courses/create" method="POST">
        <p class="ParagraphForm">
            <label class="FormCell" for="name">name</label>
            <input class="FormCell" type="text" id="name" name="name" required> <br>
        </p>
        <p class="ParagraphForm">
            <label class="FormCell" for="YHP">YHP</label>
            <input class="FormCell" type="text" id="YHP" name=YHP required> <br>
        </p>
        <p class="ParagraphForm">
            <label class="FormCell" for="description">description</label>
            <input class="FormCell" type="text" id="description" name="description" required> <br>
        </p>
        <br>
        <a href="http://localhost:8567/courses/create title=Create course">
            <input class="btn" type="submit" value="Lägg till kurs"><br>
        </a>
    </form>
</div>
<br>
<hr>

<div>
    <p>Skriv in följande info för att lägga till en student till en kurs</p>
    <form id="createStudentCourse" action="/studentsCourses/create" method="POST">
        <label for="students_id">Student ID</label>
        <input type="number" name="students_id" required> <br>
        <label for="courses_id">Kurs ID</label>
        <input type="number" name="courses_id" required> <br>
        <br>
        <a href="http://localhost:8567/studentsCourses/create title=Create StudentCourse">
            <input class="btn" type="submit" value="Lägg till elev till kurs"><br>
        </a>
    </form>
</div>
<br>
<hr>
<div>
    <p>Skriv in följande info för att TA BORT en student från en kurs</p>
    <form id="removeStudentCourse" action="/studentsCourses//remove/{id}" method="POST">
        <label for="students_id">Student ID</label>
        <input type="number" id="students_id" name="students_id" required> <br>
        <label for="courses_id">Kurs ID</label>
        <input type="number" id="courses_id" name="courses_id" required> <br>
        <br>
        <a href="http://localhost:8567/studentsCourses/create title=Create StudentCourse">
            <input class="btn" type="submit" value="Lägg till elev till kurs"><br>
        </a>
    </form>
</div>
<br>
<hr>
<div>
    <p>Skriv in ID på den student som ni önskar ta bort</p>
    <form action="students/remove/{id}" method="POST">
        id <input type="text" id="id" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/students/remove/{id} title=Remove Student">
            <input class="btn" type="submit" value="Ta bort student">
        </a>
    </form>
    <br>
    <hr>
</div>
<br>
<hr>
<div>
    <p>Vill du ta bort en kurs? Skriv in ID och kör hårt</p>
    <form action="courses/remove/{id}" method="POST">
        <label for="id">Kurs-ID</label>
        <input type="text" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/courses/remove/{id} title=Remove Course">
            <input class="btn" type="submit" value="Ta bort kurs">
        </a>
    </form>
</div>

<br>
<hr>

<div>
    <p>Skriv in ID på den elev ni önskar för att se vilka kurser den tar</p>
    <form action="students/{id}" method="GET">
        <label for="id">ID</label>
        id <input type="text" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/students/{id} title=Search_Student">
            <input class="btn" type="submit" value="Sök student på ID">
        </a>
    </form>

</div>
<br>
<hr>
<div>
    <p>Skriv in FÖRNAMN på den elev ni önskar för att se vilka kurser den tar</p>
    <form action="students/fname/{fName}" method="GET">
        <label for="fName">Förnamn</label>
        <input type="text" name="fName" required>
        <br>
        <br>
        <a href="http://localhost:8567/students/{fName} title=Search_Student">
            <input class="btn" type="submit" value="Sök student på förnamn">
        </a>
    </form>

</div>
<br>
<hr>
<div>
    <p>Skriv in EFTERNAMN på den elev ni önskar för att se vilka kurser den tar</p>
    <form action="students/lName/{lName}" method="GET">
        <label for="lName">Efternamn</label>
        <input type="text" name="lName" required>
        <br>
        <br>
        <a href="http://localhost:8567/students/lName/{lName} title=Search_Student">
            <input class="btn" type="submit" value="Sök student på efternamn">
        </a>
    </form>
</div>
<br>
<hr>
<div>
    <p>Skriv in STAD för att se vem som kommer därifrån på skolan och vilka kurser de tar</p>
    <form action="students/town/{town}" method="GET">
        <label for="town">Stad</label>
        <input type="text" name="town" required>
        <br>
        <br>
        <a href="http://localhost:8567/students/town/{town} title=Search Student by town">
            <input class="btn" type="submit" value="Sök student med stad">
        </a>
    </form>
    <br>
</div>
<br>
<hr>
<div>
    <p>Skriv in KURSNAMN för att se specifik kurs och dess studenter</p>
    <form action="courses/name/students/{name}" method="GET">
        <label for="name">Stad</label>
        <input type="text" name="name" required>
        <br>
        <br>
        <a href="http://localhost:8567/courses/name/students/{name} title=Search course by name">
            <input class="btn" type="submit" value="Sök kurs efter namn">
        </a>
    </form>
    <br>
</div>
<br>
<hr>

<div>
    <p>Skriv in ID på en kurs för att se specifik den och dess studenter</p>
    <form action="courses/{id}" method="GET">
        <label for="id">ID</label>
        <input type="text" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/courses/{id} title=Search course by ID">
            <input class="btn" type="submit" value="Sök kurs efter ID">
        </a>
    </form>
    <br>
</div>
<br>
<hr>

<div>
    <p>Sök på beskrivning av kurs</p>
    <form action="courses/description/{description}" method="GET">
        <label for="description">ID</label>
        <input type="text" name="description" required>
        <br>
        <br>
        <a href="http://localhost:8567/courses/description/{description} title=Search course by description">
            <input class="btn" type="submit" value="Sök kurs efter beskrivning">
        </a>
    </form>
    <br>
</div>
<br>
<hr>
<div>
    <p>Sök på namn av kurs</p>
    <form action="courses/name/{Name}" method="GET">
        <label for="name">ID</label>
        <input type="text" name="name" required>
        <br>
        <br>
        <a href="http://localhost:8567/courses/name/{Name} title=Search course by description">
            <input class="btn" type="submit" value="Sök kurs efter beskrivning">
        </a>
    </form>
    <br>
</div>
<br>
<hr>
<div>
    <p>Skriv in ID på den kurs ni önskar radera från associationstabellen.</p>
    <form action="removeCourse/{id}" method="Post">
        <label for="id">ID</label>
        <input type="text" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/removeCourse/{id} title=Remove_Association_Course">
            <input class="btn" type="submit" value="Radera">
        </a>
    </form>
</div>
<br>
<hr>
<div>
    <p>Skriv in ID på den elev ni önskar radera från associationstabellen.</p>
    <form action="removeStudent/{id}" method="Post">
        <label for="id">ID</label>
        <input type="text" name="id" required>
        <br>
        <br>
        <a href="http://localhost:8567/removeStudent/{id} title=Remove_Association_Student">
            <input class="btn" type="submit" value="Radera">
        </a>
    </form>
</div>
</body>
</html>