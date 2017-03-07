<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<spring:hasBindErrors name="product">
	<ul>
		<c:forEach var="error" items="${errors.allErrors}">
			<li><spring:message code="${error.code}"
					text="${error.defaultMessage}" /></li>
		</c:forEach>
	</ul>
</spring:hasBindErrors>
<body>
	<form method="post" action="/spring-mvc-masm/produtos">

		<div>
			<label for="title"> Título</label> <input type="text" name="title"
				id="title" />
		</div>
		<div>
			<label for="description">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		<div>
			<label for="pages">Número de paginas</label> <input type="text"
				name="pages" id="pages" />
		</div>
		<div>
			<c:forEach items="${bookTypes}" var="bookType" varStatus="status">
				<div>
					<label for="preco_${bookType}">${bookType}</label> <input
						type="text" name="prices[${status.index}].value"
						id="preco_${bookType}" /> <input type="hidden"
						name="prices[${status.index}].bookType" value="${bookType}" />
				</div>
			</c:forEach>
		</div>
		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form>

</body>
</html>