<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Manage Order Table</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> " />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/tables.js"/> "></script>
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
					<td><form:input id="nameTable" type="text" path="name" placeholder="Ba`n xxx" /></td>
				</tr>
				<tr>
					<td>Pre_Weight :</td>
					<td><form:input id="pre_weight" type="text" path="pre_weight" placeholder=".kg" /></td>
				</tr>
				<tr>
					<td>After_Weight :</td>
					<td><form:input id="after_weight" type="text" path="after_weight" placeholder=".kg"/></td>
				</tr>
				<tr>
					<td><a class="btn btn-primary btn-sm" href="detailtable" >View Info Detail</a></td>
					<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" onchange="return tableScript.tableFormValidate()" onclick="return tableScript.tableFormValidate()"/></td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<br>
	<h3>List of OrderTable :</h3>
	<table class="table table-bordered" id="tb-list" style="width: 1400px">
		<tr class="tb-row">
			<th>Name</th>
			<th>Pre_Weight</th>
			<th>After_Weight</th>
			<th>Name Product | Quantity</th>
            <th>Printer | Price | Quantity</th>
            <th>Embroidery | Price | Quantity</th>
            <th>Sewing | Price | Quantity</th>
            <th>Material | Weight | Num_Class | Quantity</th>
			<th>Edit | Delete</th>
		</tr>
		<c:forEach items="${listTableForm}" var="tabform">
			<tr class="tb-row">
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
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.printerList}" var="print" >
                            <tr>
                                <td width="60" align="center">${print.name}</td>
                                <td width="60" align="center">${print.price}</td>
                                <td width="60" align="center">${print.quantity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.embroideryList}" var="embroid" >
                            <tr>
                                <td width="60" align="center">${embroid.name}</td>
                                <td width="60" align="center">${embroid.price}</td>
                                <td width="60" align="center">${embroid.quantity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.sewingList}" var="sew" >
                            <tr>
                                <td width="60" align="center">${sew.name}</td>
                                <td width="60" align="center">${sew.price}</td>
                                <td width="60" align="center">${sew.quantity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.materialList}" var="material" >
                            <tr>
                                <td width="60" align="center">${material.name}</td>
                                <td width="60" align="center">${material.weight}</td>
                                <td width="60" align="center">${material.num_class}</td>
                                <td width="60" align="center">${material.quantity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
				<td width="120" align="center"><a class="btn-primary btn-sm" href="edit/${tabform.orderTable.id}">Edit</a> | <a class="btn-primary btn-sm" href="delete/${tabform.orderTable.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>