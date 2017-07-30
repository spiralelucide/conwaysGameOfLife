<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Conway's Game of Life Exercise</title>

<spring:url value="/resources/core/css/styles.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<section class="well">
<h1>Conway's Game of Life</h1>
<c:url var="formAction" value="/" />
<form action="${formAction}" method="POST">
	<label>Width</label>
	<input id="width" name="width" type="number" maxlength="2" step="1" value="8" min="3" max="100" title="3-100" /> 
	<label>Height</label> 
	<input id="height" name="height" type="number" maxlength="2" step="1" value="6" min="3" max="100" title="3-100" /><br>
	<label>Probability that the Cell Starts Alive</label>
	<input id="probability" name="probability" type="number" step=".01" value=".25" min=".01" max="1" /> <br>
	<input type="submit" value="Calculate" />
</form>
</section>

<spring:url value="/resources/core/js/home.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>