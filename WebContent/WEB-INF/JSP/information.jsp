<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Manage Information Product</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<h3> Add / Edit Information Product </h3>

	<form:form method="post" action="/ManageTable/infotable" modelAttribute="tableForm" >
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 400px">
				<c:forEach items="${tableForm.prods}" var="prod" varStatus="status" >
					<tr>
						<form:input type="text" path="prods[${status.index}].id" readonly="true" hidden="true" />
					</tr>
					<tr>
						<td>Table_id :</td>
						<td><form:input type="text" path="prods[${status.index}].table_id" readonly="true" style="color:#999999;background-color:#F4F4F4" /></td>
					</tr>
					<tr>
						<td>Name :</td>
						<td><form:input type="text" path="prods[${status.index}].name" /></td>
					</tr>
					<tr>
						<td>Quantity :</td>
						<td><form:input type="text" path="prods[${status.index}].quantity" /></td>
					</tr>				
				</c:forEach>
				<tr>
					<td></td>			
					<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	
	<br>
	<br>
	
	<h3> List of Information Product : </h3>
	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>Name</th>
			<th>Table_id</th>
			<th>Quantity</th>
			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${prodList}" var="empl">

			<tr>
				<td width="60" align="center">${empl.name}</td>
				<td width="60" align="center">${empl.table_id}</td>
				<td width="60" align="center">${empl.quantity}</td>
				<td width="60" align="center"><a href="${empl.table_id}/edit/${empl.id}">Edit</a>/<a href="${empl.table_id}/delete/${empl.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>