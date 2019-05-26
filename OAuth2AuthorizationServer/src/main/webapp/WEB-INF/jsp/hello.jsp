<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h2>Current Time : ${dateandTIme}</h2>
            <c:forEach var="i" begin="1" end="5">
	          <p>${i}</p>
             </c:forEach>
        </div>
    </div>
</body>
</html>