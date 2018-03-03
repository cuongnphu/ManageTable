<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Manage Information Material</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<h3> Add/Edit Information Materials </h3>

	<form:form method="post" action="/ManageTable/material" modelAttribute="tableForm" >
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 400px">
				<tr>
					<td>Table Name:</td>
					<td><form:input type="text" path="orderTable.name" readonly="true" style="color:#999999;background-color:#F4F4F4" /></td>
				</tr>
				<c:forEach items="${tableForm.materialList}" varStatus="status" >
					<tr>
						<form:input type="text" path="materialList[${status.index}].id" readonly="true" hidden="true" />
					</tr>
					<tr>
						<form:input type="text" path="materialList[${status.index}].table_id" readonly="true" hidden="true" />
					</tr>
					<tr>
						<td>Name :</td>
						<td><form:input type="text" path="materialList[${status.index}].name" /></td>
					</tr>
					<tr>
						<td>Weight :</td>
						<td><form:input type="text" path="materialList[${status.index}].weight" /></td>
					</tr>
					<tr>
						<td>Num_class :</td>
						<td><form:input type="text" path="materialList[${status.index}].num_class" /></td>
					</tr>
					<tr>
						<td>Quantity :</td>
						<td><form:input type="text" path="materialList[${status.index}].quantity" /></td>
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
	<h3> List of Information Materials : </h3>
	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>Name</th>
			<th>Weight</th>
			<th>Num_class</th>
			<th>Quantity</th>
			<th>Edit  | Delete</th>
		</tr>
		<c:forEach items="${materialList}" var="material">
			<tr>
				<td width="60" align="center">${material.name}</td>
				<td width="60" align="center">${material.weight}</td>
				<td width="60" align="center">${material.num_class}</td>
				<td width="60" align="center">${material.quantity}</td>
				<td width="60" align="center"><a class="btn-primary btn-sm" href="${material.table_id}/edit/${material.id}">Edit</a> | <a class="btn-primary btn-sm" href="${material.table_id}/delete/${material.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary btn-sm" href="../tables" >Cancel</a>
</body>
</html>