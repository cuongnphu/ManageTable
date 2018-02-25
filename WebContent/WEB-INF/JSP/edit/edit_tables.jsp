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
	<h3> Edit Information OrderTable!!!</h3>

	<form:form method="post" action="/ManageTable/table" modelAttribute="modeltable">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 400px">
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
					<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /> | <input class="btn btn-primary btn-sm" type="submit" value="Cancel" onclick="history.back()" />  </td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<br>
	<h3>List of OrderTable :</h3>
	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>Name</th>
			<th>Pre_Weight</th>
			<th>After_Weight</th>

		</tr>
		<c:forEach items="${orderTableList}" var="ordertab">

			<tr>
				<td width="60" align="center">${ordertab.name}</td>
				<td width="60" align="center">${ordertab.pre_weight}</td>
				<td width="60" align="center">${ordertab.after_weight}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>