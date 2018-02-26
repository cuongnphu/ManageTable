<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Detail Table Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<h3> Detail Information Table </h3>

	<form:form method="get"  modelAttribute="tableForm" >

	</form:form>

	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>Name</th>
			<th>Pre_Weight</th>
			<th>After_Weight</th>
			<th>Name Product / Quantity</th>
		</tr>
		<c:forEach items="${listTableForm}" var="tabform" >

			<tr>
				<td width="60" align="center">${tabform.orderTable.name}</td>
				<td width="60" align="center">${tabform.orderTable.pre_weight}</td>
				<td width="60" align="center">${tabform.orderTable.after_weight}</td>
				<td>
					<table class="table table-bordered">
						<c:forEach items="${tabform.prods}" var="prod" >
								<tr>
									<td width="60" align="center">${prod.name}</td>
									<td width="60" align="center">${prod.quantity}</td>
								</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>