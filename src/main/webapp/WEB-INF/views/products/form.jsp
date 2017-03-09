<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>

<body>
	<!-- Bug tosco do Eclipe -> build() apresenta erro de compilação-->
	<form:form method="post"
		action='${spring:mvcUrl("saveProduct").build()}' commandName="product">

		<div>
			<label for="title">Titulo</label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<label for="description">Descrição</label>
			<form:textarea path="description" rows="10" cols="20" />
		</div>
		<div>
			<label for="pages">Número de paginas</label> <input type="text"
				name="pages" id="pages" />
			<form:errors path="pages" />
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
			<label for="releaseDate">Data de lançamento</label> <input
				type="date" name="releaseDate" />
			<form:errors path="releaseDate" />
		</div>

		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form:form>

</body>
</html>