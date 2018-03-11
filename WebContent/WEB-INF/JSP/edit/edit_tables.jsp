<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Edit Information OrderTable</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/infodetail.js" /> "></script>
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
                    <th>Name Product | Quantity</th>
                </tr>
				<tr>
					<td><form:input type="text" path="orderTable.name" /></td>
                    <td><form:input type="text" path="orderTable.pre_weight" /></td>
                    <td><form:input type="text" path="orderTable.after_weight" /></td>
                    <td>
                        <table class="table table-bordered">
                            <c:forEach items="${tableForm.productList}" var="prod" varStatus="status">
                                <tr>
                                    <form:input type="text" path="productList[${status.index}].id" readonly="true" hidden="true" />
                                    <form:input type="text" path="productList[${status.index}].table_id" readonly="true" hidden="true" />
                                    <td><form:input type="text" path="productList[${status.index}].name" /></td>
                                    <td><form:input type="text" path="productList[${status.index}].quantity" /></td>
                                    <td><a class="btn-primary btn-sm" href="${prod.table_id}/delete/${prod.id}">-</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a class="btn btn-primary btn-sm" onclick="myFunction(${tableForm.orderTable.id})">add product</a>
                    </td>
				</tr>
				<tr>
                    <td><button class="btn btn-primary btn-sm" type="submit">Submit</button> | <a class="btn btn-primary btn-sm" onclick="window.location.replace('/ManageTable/tables')" >Cancel</a> </td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<br>
    <h3> List Detail Information Table </h3>
    <table class="table table-bordered" style="width: 1400px">
        <tr>
            <th>Name</th>
            <th>Pre_Weight</th>
            <th>After_Weight</th>
            <th>Name Product | Quantity</th>
        </tr>
        <c:forEach items="${listTableForm}" var="tabform" >
            <tr>
                <td width="60" align="center">${tabform.orderTable.name}</td>
                <td width="60" align="center">${tabform.orderTable.pre_weight}</td>
                <td width="60" align="center">${tabform.orderTable.after_weight}</td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.productList}" var="prod" >
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