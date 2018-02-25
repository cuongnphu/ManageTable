<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Manage Order Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<h3>Add / Edit Information OrderTable!!!</h3>

	<form:form method="post" action="/ManageTable/table" modelAttribute="modeltable">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 900px">
				<tr>
					<form:input type="text" path="id" readonly="true" hidden="true" />
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input type="text" path="name" /></td>
				</tr>
				<tr>
					<td>Pre_Weight :</td>
					<td><form:input type="text" path="pre_weight" /></td>
				</tr>
				<tr>
					<td>After_Weight :</td>
					<td><form:input type="text" path="after_weight" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<br>
	<h3>List of OrderTable :</h3>
	<table class="table table-bordered" style="width: 900px">
		<tr>
			<th>Name</th>
			<th>Pre_Weight</th>
			<th>After_Weight</th>
			<th>Edit/Delete</th>
			<th>Add info Products</th>
			<th>Add info Printer</th>
			<th>Add info Embroidery</th>
			<th>Add info Sewing</th>
		</tr>
		<c:forEach items="${orderTableList}" var="ordertab">

			<tr>
				<td width="60" align="center">${ordertab.name}</td>
				<td width="60" align="center">${ordertab.pre_weight}</td>
				<td width="60" align="center">${ordertab.after_weight}</td>
				<td width="120" align="center"><a class="btn-primary btn-sm" href="edit/${ordertab.id}">Edit</a> | <a class="btn-primary btn-sm" href="delete/${ordertab.id}">Delete</a></td>
				<td width="120" align="center"><a class="btn-primary btn-sm" href="product/${ordertab.id}">Add Products</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>