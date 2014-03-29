<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><spring:message code="Cadastro.title.page"/></title>
		<link href="layout/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="layout/css/form.css" rel="stylesheet">
	</head>
	<body>
		<div class="col-md-12">
			<h3 class="page-header titulo"><spring:message code="Cadastro.edit.page.label"/></h3>
			<p><button type="button" class="btn btn-primary" onclick="javascript:window.location.href = 'novo.do'"><spring:message code="Cadastro.novo.label"/></button></p>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th style="width: 8%;"><spring:message code="Cadastro.id.label"/></th>
						<th style="width: 20%;"><spring:message code="Cadastro.nome.label"/></th>
						<th style="width: 9%;"><spring:message code="Cadastro.sexo.label"/></th>
						<th style="width: 11%;"><spring:message code="Cadastro.cpf.label"/></th>
						<th style="width: 10%;"><spring:message code="Cadastro.telefone.label"/></th>
						<th style="width: 10%;"><spring:message code="Cadastro.celular.label"/></th>
						<th style="width: 20%;"><spring:message code="Cadastro.email.label"/></th>
						<th style="width: 6%;"></th>
						<th style="width: 6%;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="c">
						<tr>
							<td>${c.id}</td>
							<td>${c.nome}</td>
							<td>${c.sexo.descricao}</td>
							<td>${c.cpf}</td>
							<td>${c.telefone}</td>
							<td>${c.celular}</td>
							<td>${c.email}</td>
							<td class="botaoAcao">
								<button class="btn btn-primary" onclick="javascript:window.location.href = 'editar.do?id=${c.id}'">
									<spring:message code="Cadastro.editar.label"/>
								</button>
							</td>
							<td class="botaoAcao">
								<button class="btn btn" onclick="javascript:window.location.href = 'excluir.do?id=${c.id}'">
									<spring:message code="Cadastro.excluir.label"/>
								</button>
							</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>