<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Manage Information Printer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
	<h3> Add / Edit Information Embroidery </h3>

	<form:form method="post" action="/ManageTable/embroidery" modelAttribute="tableForm" >
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 400px">
				<tr>
					<td>Table Name:</td>
					<td><form:input type="text" path="orderTable.name" readonly="true" style="color:#999999;background-color:#F4F4F4" /></td>
				</tr>
				<c:forEach items="${tableForm.embroideryList}" varStatus="status" >
					<tr>
						<form:input type="text" path="embroideryList[${status.index}].id" readonly="true" hidden="true" />
					</tr>
					<tr>
						<form:input type="text" path="embroideryList[${status.index}].table_id" readonly="true" hidden="true" />
					</tr>
					<tr>
						<td>Name :</td>
						<td><form:input type="text" path="embroideryList[${status.index}].name" /></td>
					</tr>
					<tr>
						<td>Price :</td>
						<td><form:input type="text" path="embroideryList[${status.index}].price" /></td>
					</tr>
					<tr>
						<td>Quantity :</td>
						<td><form:input type="text" path="embroideryList[${status.index}].quantity" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>			
					<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /> | <input class="btn btn-primary btn-sm" type="submit" value="Cancel" onclick="history.back()" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	
	<br>
	<br>
	
	<h3> List of Information Embroideries : </h3>
	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>

		</tr>
		<c:forEach items="${embroideryList}" var="embroid">
			<tr>
				<td width="60" align="center">${embroid.name}</td>
				<td width="60" align="center">${embroid.price}</td>
				<td width="60" align="center">${embroid.quantity}</td>
				<td width="60" align="center">${embroid.total}</td>

			</tr>
		</c:forEach>
	</table>



</body>
</html>