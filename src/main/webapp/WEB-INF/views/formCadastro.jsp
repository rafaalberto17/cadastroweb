<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title><spring:message code="Cadastro.title.page"/></title>
		<link href="layout/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="layout/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="layout/jquery/jquery.maskedinput-1.1.4.pack.js"></script>
		<link href="layout/css/form.css" rel="stylesheet">
	</head>
	<body>
		<div class="col-md-12">
			<h3 class="page-header titulo"><spring:message code="Cadastro.edit.page.label"/></h3>
			<form:form class="form-horizontal" method="post" action="salvar.do" modelAttribute="model">
				<form:hidden path="id" id="id"/>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.nome.label"/></label>
					<div class="col-sm-4">
						<form:input type="text" class="form-control" path="nome" id="nome"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.sexo.label"/></label>
						<div class="col-sm-4">
							<label class="radio-inline">
								<form:radiobutton path="sexo" value="M"/><spring:message code="Cadastro.sexo.masculino.label"/>	
							</label>
							<label class="radio-inline">
								<form:radiobutton path="sexo" value="F"/><spring:message code="Cadastro.sexo.feminino.label"/>	
							</label>
						</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.cpf.label"/></label>
						<div class="col-sm-2">
							<form:input type="text" class="form-control" path="cpf" id="cpf" />
						</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.telefone.label"/></label>
						<div class="col-sm-2">
							<form:input type="text" class="form-control" path="telefone" id="telefone" />
						</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.celular.label"/></label>
						<div class="col-sm-2">
							<form:input type="text" class="form-control" path="celular" id="celular" />
						</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"><spring:message code="Cadastro.email.label"/></label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" path="email" id="email" />
						</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-2">
						<button type="submit" class="btn btn-primary"><spring:message code="Cadastro.salvar.label"/></button>
						<button type="button" class="btn btn" onclick="javascript:window.history.back()"><spring:message code="Cadastro.voltar.label"/></button>
					</div>
				</div>
			</form:form>
		</div>
	</body>
	<script type="text/javascript" src="layout/javascript/cadastro.js"></script>
</html>