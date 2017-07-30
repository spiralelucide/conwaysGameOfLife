<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Conway's Game of Life Exercise</title>
 
<spring:url value="/resources/core/css/styles.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body> 
<section class="well">
<h1>Solution</h1>
<span>width:</span><span id="width"><c:out value="${width}"/></span>
<span>height:</span><span id="height"><c:out value="${height}"/></span>
<h4>Generation 0</h4>
<div id="oldboard">
<c:forEach var = "rows" begin="0" end="${height-1}">
	<div class="row">
	<c:forEach var = "columns" begin="0" end="${width-1}">
		<c:choose>
		<c:when test="${oldboard[rows][columns] == true}"><div class="gameBlock alive"></div></c:when>
		<c:otherwise><div class="gameBlock"></div></c:otherwise>
		</c:choose>
	</c:forEach>
	</div>
</c:forEach>
</div><br>
<form action="/ConwaysGameOfLife1" method="GET"><input type="submit" value="Reconfigure"/></form><br>
<h4 id="currentGeneration">Generation 1</h4>
<p>Click the cells to toggle their state!</p>
<div id="board">
<c:forEach var = "rows" begin="0" end="${height-1}">
	<div class="row">
	<c:forEach var = "columns" begin="0" end="${width-1}">
		<c:choose>
		<c:when test="${board[rows][columns] == true}"><div class="gameBlock alive"></div></c:when>
		<c:otherwise><div class="gameBlock"></div></c:otherwise>
		</c:choose>
	</c:forEach>
	</div>
</c:forEach>
</div>
<button id="blowsMind">Iterate</button>
<button id="stops">Stop</button>
</section>
 
<spring:url value="/resources/core/js/solution.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery-3.2.1.min.js" var="jqueryjs" />
<script src="${jqueryjs}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
</body>
</html>