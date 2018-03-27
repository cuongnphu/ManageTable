<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Edit Information OrderTable</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> " />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/product.js" /> "></script>
    <script src="<c:url value="/Resources/js/printer.js" /> "></script>
    <script src="<c:url value="/Resources/js/embroidery.js" /> "></script>
    <script src="<c:url value="/Resources/js/sewing.js" /> "></script>
    <script src="<c:url value="/Resources/js/material.js" /> "></script>
    <script src="<c:url value="/Resources/js/tables.js" /> "></script>
</head>
<body>
	<h3> Edit Information OrderTable </h3>
	<form:form method="post" action="/ManageTable/InfoDetail" modelAttribute="tableForm">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 1400px;">
                <tr>
                    <th style="width: 8%">Name</th>
                    <th style="width: 6%">Pre Weight</th>
                    <th style="width: 6%">After Weight</th>
                    <th style="width: 11%">Name Product | Quantity</th>
                    <th style="width: 11%">Printer | Price | Quantity</th>
                    <th style="width: 11%">Embroidery | Price | Quantity</th>
                    <th style="width: 11%">Sewing | Price | Quantity</th>
                    <th style="width: 36%">Material | Weight | Num_Class | Quantity</th>
                </tr>
                <tr>
                    <form:input type="text" path="orderTable.id" readonly="true" hidden="true" />
                </tr>
				<tr>
					<td><form:input type="text" path="orderTable.name" /></td>
                    <td><form:input type="text" path="orderTable.pre_weight" /></td>
                    <td><form:input type="text" path="orderTable.after_weight" /></td>
                    <td>
                        <div id="myProduct" class="container-fluid">
                            <c:if test="${tableForm.productList.size() > 0}" >
                                <c:forEach items="${tableForm.productList}" var="prod" varStatus="status">
                                    <div class="row">
                                        <div style="float: left;width: 90%" class="p-0">
                                            <form:input type="text" path="productList[${status.index}].id" readonly="true"
                                                        hidden="true"/>
                                            <form:input type="text" path="productList[${status.index}].table_id"
                                                        readonly="true"
                                                        hidden="true"/>
                                            <form:input type="text" path="productList[${status.index}].name"/>
                                            <br>
                                            <form:input type="text" path="productList[${status.index}].quantity"/>
                                            <br>
                                            <br>
                                        </div>
                                        <div style="float: right;width: 8%" class="p-1">
                                            <a class="btn-primary btn-xs" href="product/${prod.table_id}/delete/${prod.id}">-</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <a class="btn btn-primary btn-sm" onclick="addProduct(${tableForm.orderTable.id},${tableForm.productList.size()})">add product</a>
                        </div>
                    </td>
                    <td>
                        <div id="myPrinter" class="container-fluid">
                            <c:if test="${tableForm.printerList.size() > 0}">
                                <c:forEach items="${tableForm.printerList}" var="print" varStatus="status">
                                    <div class="row">
                                        <div style="float: left;width: 90%" class="p-0">
                                            <form:input type="text" path="printerList[${status.index}].id" readonly="true" hidden="true" />
                                            <form:input type="text" path="printerList[${status.index}].table_id" readonly="true" hidden="true" />
                                            <form:input type="text" path="printerList[${status.index}].name" />
                                            <br>
                                            <form:input type="text" path="printerList[${status.index}].price" />
                                            <br>
                                            <form:input type="text" path="printerList[${status.index}].quantity" />
                                        </div>
                                        <div style="float: right;width: 8%" class="p-1">
                                            <a class="btn-primary btn-xs" href="printer/${print.table_id}/delete/${print.id}">-</a>
                                        </div>
                                    </div>
                                    <br>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <a class="btn btn-primary btn-sm" onclick="addPrinter(${tableForm.orderTable.id},${tableForm.printerList.size()})">add printer</a>
                        </div>
                    </td>
                    <td>
                        <div id="myEmbroidery" class="container-fluid">
                            <c:if test="${tableForm.embroideryList.size() > 0}">
                                <c:forEach items="${tableForm.embroideryList}" var="embroid" varStatus="status">
                                    <div class="row">
                                        <div style="float: left;width: 90%" class="p-0">
                                            <form:input type="text" path="embroideryList[${status.index}].id" readonly="true" hidden="true" />
                                            <form:input type="text" path="embroideryList[${status.index}].table_id" readonly="true" hidden="true" />
                                            <form:input type="text" path="embroideryList[${status.index}].name" />
                                            <br>
                                            <form:input type="text" path="embroideryList[${status.index}].price" />
                                            <br>
                                            <form:input type="text" path="embroideryList[${status.index}].quantity" />
                                        </div>
                                        <div style="float: right;width: 8%" class="p-1">
                                            <a class="btn-primary btn-xs" href="embroidery/${embroid.table_id}/delete/${embroid.id}">-</a>
                                        </div>
                                    </div>
                                    <br>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <a class="btn btn-primary btn-sm" onclick="addEmbroidery(${tableForm.orderTable.id},${tableForm.embroideryList.size()})">add embroidery</a>
                        </div>
                    </td>
                    <td>
                        <div id="mySewing" class="container-fluid">
                            <c:if test="${tableForm.sewingList.size() > 0}">
                                <c:forEach items="${tableForm.sewingList}" var="sew" varStatus="status">
                                    <div class="row">
                                        <div style="float: left;width: 90%" class="p-0">
                                            <form:input type="text" path="sewingList[${status.index}].id" readonly="true" hidden="true" />
                                            <form:input type="text" path="sewingList[${status.index}].table_id" readonly="true" hidden="true" />
                                            <form:input type="text" path="sewingList[${status.index}].name" />
                                            <br>
                                            <form:input type="text" path="sewingList[${status.index}].price" />
                                            <br>
                                            <form:input type="text" path="sewingList[${status.index}].quantity" />
                                        </div>
                                        <div style="float: right;width: 8%" class="p-1">
                                            <a class="btn-primary btn-xs" href="sewing/${sew.table_id}/delete/${sew.id}">-</a>
                                        </div>
                                    </div>
                                    <br>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <a class="btn btn-primary btn-sm" onclick="addSewing(${tableForm.orderTable.id},${tableForm.sewingList.size()})">add Sewing</a>
                        </div>
                    </td>
                    <td>
                        <div id="myMaterial" class="container-fluid">
                            <c:if test="${tableForm.materialList.size() > 0}">
                                <c:forEach items="${tableForm.materialList}" var="mate" varStatus="status">
                                    <div class="row">
                                        <div style="float: left;width: 95%" class="p-0">
                                            <form:input type="text" path="materialList[${status.index}].id" readonly="true" hidden="true" />
                                            <form:input type="text" path="materialList[${status.index}].table_id" readonly="true" hidden="true" />
                                            <form:input type="text" path="materialList[${status.index}].name"  cssStyle="width: 30%; "/>
                                            <form:input type="text" path="materialList[${status.index}].weight" cssStyle="width: 22%; "/>
                                            <form:input type="text" path="materialList[${status.index}].num_class" cssStyle="width: 22%; " />
                                            <form:input type="text" path="materialList[${status.index}].quantity" cssStyle="width: 23%; " />
                                        </div>
                                        <div style="float: right;width: 3%" class="p-1">
                                            <a class="btn-primary btn-xs" href="material/${mate.table_id}/delete/${mate.id}">-</a>
                                        </div>
                                    </div>
                                    <br>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div>
                            <a class="btn btn-primary btn-sm" onclick="addMaterial(${tableForm.orderTable.id},${tableForm.materialList.size()})">add Material</a>
                        </div>
                    </td>
				</tr>
				<tr>
                    <td colspan="8" align="center">
                        <button class="btn btn-primary btn-sm" type="submit" onclick="return editTableFormValidate()" >Submit</button>|
                        <a class="btn btn-primary btn-sm" onclick="window.location.replace('/ManageTable/tables')" >Cancel</a>
                    </td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<br>
    <h3> List Detail Information Table </h3>
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
        </tr>
        <c:forEach items="${listTableForm}" var="tabform" >
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
            </tr>
        </c:forEach>
    </table>
</body>
</html>