<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Edit Order Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script>
        function myFunction() {
            var table = document.getElementById("myTable");
            var numrow = table.rows.length;
            var row = table.insertRow(numrow);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            cell1.innerHTML = "NEW CELL1";
            cell2.innerHTML = "NEW CELL2";
        }
    </script>
</head>

<body>
	<h3> Edit Information OrderTable </h3>

	<form:form method="post" action="/ManageTable/InfoDetail" modelAttribute="tableForm">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 1200px">
				<tr>
					<form:input type="text" path="orderTable.id" readonly="true" hidden="true" />
				</tr>
                <tr>
                    <th>Name</th>
                    <th>Pre_Weight</th>
                    <th>After_Weight</th>
                    <th> Products </th>
                </tr>
				<tr>
					<td><form:input type="text" path="orderTable.name" /></td>
                    <td><form:input type="text" path="orderTable.pre_weight" /></td>
                    <td><form:input type="text" path="orderTable.after_weight" /></td>
                    <td>
                        <table id="myTable" class="table table-bordered">
                            <c:forEach items="${tableForm.productList}" varStatus="status">
                                <tr>
                                    <form:input type="text" path="productList[${status.index}].id" readonly="true" hidden="true" />
                                    <form:input type="text" path="productList[${status.index}].table_id" readonly="true" hidden="true" />
                                    <td><form:input type="text" path="productList[${status.index}].name" /></td>
                                    <td><form:input type="text" path="productList[${status.index}].quantity" /></td>
                                    <td><a class="button" onclick="myFunction()">+</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
				</tr>
				<tr>
                    <td><button class="btn btn-primary btn-sm" type="submit">Submit</button> | <button class="btn btn-primary btn-sm" onclick="history.back()" />Cancel</button> </td>
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