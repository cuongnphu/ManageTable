<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	<h3>Nhập Thông Tin Bàn: </h3>
	<form:form method="post" action="/ManageTable/InfoDetail" modelAttribute="tableForm">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 1400px;">
                <thead class="thead">
                    <tr>
                        <th style="width: 5%" >Bàn</th>
                        <th style="width: 15%">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-6">S.Phẩm</div>
                                    <div class="col-sm-6">S.Lượng</div>
                                </div>
                            </div>
                        </th>
                        <th style="width: 19%">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-4">In</div>
                                    <div class="col-sm-4">Giá (đ)</div>
                                    <div class="col-sm-4">S.Lượng</div>
                                </div>
                            </div>
                        </th>
                        <th style="width: 19%">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-4">Thêu</div>
                                    <div class="col-sm-4">Giá (đ)</div>
                                    <div class="col-sm-4">S.Lượng</div>
                                </div>
                            </div>
                        </th>
                        <th style="width: 19%">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-4">May</div>
                                    <div class="col-sm-4">Giá (đ)</div>
                                    <div class="col-sm-4">S.Lượng</div>
                                </div>
                            </div>
                        </th>
                        <th style="width: 23%">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-3">N.Liệu</div>
                                    <div class="col-sm-4">Số (Kg)</div>
                                    <div class="col-sm-2">S.Lớp</div>
                                    <div class="col-sm-3">S.Lg</div>
                                </div>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <form:input type="text" path="orderTable.id" readonly="true" hidden="true" />
                        <form:input type="text" path="orderTable.pre_weight" readonly="true" hidden="true" />
                        <form:input type="text" path="orderTable.after_weight" readonly="true" hidden="true"/>
                    </tr>
                    <tr>
                        <td><form:input type="text" path="orderTable.name" /></td>
                        <td>
                            <div id="myProduct" class="container-fluid">
                                <c:if test="${tableForm.productList.size() > 0}" >
                                    <c:forEach items="${tableForm.productList}" var="prod" varStatus="status">
                                        <div class="row">
                                            <div class="col-sm-6 p-0">
                                                <form:input type="text" path="productList[${status.index}].id" readonly="true"
                                                            hidden="true"/>
                                                <form:input type="text" path="productList[${status.index}].table_id"
                                                            readonly="true"
                                                            hidden="true"/>
                                                <form:input type="text" path="productList[${status.index}].name"/>
                                                <br>
                                            </div>
                                            <div class="col-sm-5 p-0">
                                                <form:input type="text" path="productList[${status.index}].quantity"/>
                                            </div>
                                            <div class="col-sm-1 p-0">
                                                <a class="btn-danger btn-xs" href="product/${prod.table_id}/delete/${prod.id}">-</a>
                                            </div>
                                        </div>
                                        <br>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <div>
                                <a class="btn-success btn-sm" onclick="addProduct(${tableForm.orderTable.id},${tableForm.productList.size()})">+</a>
                            </div>
                        </td>
                        <td>
                            <div id="myPrinter" class="container-fluid">
                                <c:if test="${tableForm.printerList.size() > 0}">
                                    <c:forEach items="${tableForm.printerList}" var="print" varStatus="status">
                                        <div class="row">
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="printerList[${status.index}].id" readonly="true" hidden="true" />
                                                <form:input type="text" path="printerList[${status.index}].table_id" readonly="true" hidden="true" />
                                                <form:input type="text" path="printerList[${status.index}].name" />
                                                <br>
                                            </div>
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="printerList[${status.index}].price" />
                                            </div>
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="printerList[${status.index}].quantity" />
                                            </div>
                                            <div class="col-sm-1 p-0">
                                                <a class="btn-danger btn-xs" href="printer/${print.table_id}/delete/${print.id}">-</a>
                                            </div>
                                        </div>
                                        <br>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <div>
                                <a class="btn-success btn-sm" onclick="addPrinter(${tableForm.orderTable.id},${tableForm.printerList.size()})">+</a>
                            </div>
                        </td>
                        <td>
                            <div id="myEmbroidery" class="container-fluid">
                                <c:if test="${tableForm.embroideryList.size() > 0}">
                                    <c:forEach items="${tableForm.embroideryList}" var="embroid" varStatus="status">
                                        <div class="row">
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="embroideryList[${status.index}].id" readonly="true" hidden="true" />
                                                <form:input type="text" path="embroideryList[${status.index}].table_id" readonly="true" hidden="true" />
                                                <form:input type="text" path="embroideryList[${status.index}].name" />
                                                <br>
                                            </div>
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="embroideryList[${status.index}].price" />
                                            </div>
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="embroideryList[${status.index}].quantity" />
                                            </div>
                                            <div class="col-sm-1 p-0">
                                                <a class="btn-danger btn-xs" href="embroidery/${embroid.table_id}/delete/${embroid.id}">-</a>
                                            </div>
                                        </div>
                                        <br>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <div>
                                <a class="btn-success btn-sm" onclick="addEmbroidery(${tableForm.orderTable.id},${tableForm.embroideryList.size()})">+</a>
                            </div>
                        </td>
                        <td>
                            <div id="mySewing" class="container-fluid">
                                <c:if test="${tableForm.sewingList.size() > 0}">
                                    <c:forEach items="${tableForm.sewingList}" var="sew" varStatus="status">
                                        <div class="row">
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="sewingList[${status.index}].id" readonly="true" hidden="true" />
                                                <form:input type="text" path="sewingList[${status.index}].table_id" readonly="true" hidden="true" />
                                                <form:input type="text" path="sewingList[${status.index}].name" />
                                                <br>
                                            </div>
                                            <div class="col-sm-4 p-0">
                                                <form:input type="text" path="sewingList[${status.index}].price" />
                                            </div>
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="sewingList[${status.index}].quantity" />
                                            </div>
                                            <div class="col-sm-1 p-0">
                                                <a class="btn-danger btn-xs" href="sewing/${sew.table_id}/delete/${sew.id}">-</a>
                                            </div>
                                        </div>
                                        <br>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <div>
                                <a class="btn-success btn-sm" onclick="addSewing(${tableForm.orderTable.id},${tableForm.sewingList.size()})">+</a>
                            </div>
                        </td>
                        <td>
                            <div id="myMaterial" class="container-fluid">
                                <c:if test="${tableForm.materialList.size() > 0}">
                                    <c:forEach items="${tableForm.materialList}" var="mate" varStatus="status">
                                        <div class="row">
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="materialList[${status.index}].id" readonly="true" hidden="true" />
                                                <form:input type="text" path="materialList[${status.index}].table_id" readonly="true" hidden="true" />
                                                <form:input type="text" path="materialList[${status.index}].name" />
                                               <br>
                                            </div>
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="materialList[${status.index}].weight" />
                                            </div>
                                            <div class="col-sm-2 p-0">
                                                <form:input type="text" path="materialList[${status.index}].num_class" />
                                            </div>
                                            <div class="col-sm-3 p-0">
                                                <form:input type="text" path="materialList[${status.index}].quantity" />
                                            </div>
                                            <div class="col-sm-1 p-0">
                                                <a class="btn-danger btn-xs" href="material/${mate.table_id}/delete/${mate.id}">-</a>
                                            </div>
                                        </div>
                                        <br>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <div>
                                <a class="btn-success btn-sm" onclick="addMaterial(${tableForm.orderTable.id},${tableForm.materialList.size()})">+</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" align="right">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-sm-9 p-0">
                                        <button class="btn-info btn-xs" type="submit" onclick="return editTableFormValidate()" >Cập Nhật</button>
                                        <a class="btn-info btn-sm" onclick="window.location.replace('/ManageTable/tables')" >Hủy</a>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
			</table>
		</div>
	</form:form>
	<br>
    <h3> Danh Sách Chi Tiết Bàn: </h3>
    <table class="table table-bordered" style="width: 1400px">
        <thead class="thead">
            <tr>
                <th style="width: 5%" >Bàn</th>
                <th style="width: 15%">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-6">S.Phẩm</div>
                            <div class="col-sm-6">S.Lượng</div>
                        </div>
                    </div>
                </th>
                <th style="width: 19%">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-4">In</div>
                            <div class="col-sm-4">Giá (đ)</div>
                            <div class="col-sm-4">S.Lượng</div>
                        </div>
                    </div>
                </th>
                <th style="width: 19%">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-4">Thêu</div>
                            <div class="col-sm-4">Giá (đ)</div>
                            <div class="col-sm-4">S.Lượng</div>
                        </div>
                    </div>
                </th>
                <th style="width: 19%">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-4">May</div>
                            <div class="col-sm-4">Giá (đ)</div>
                            <div class="col-sm-4">S.Lượng</div>
                        </div>
                    </div>
                </th>
                <th style="width: 23%">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-3">N.Liệu</div>
                            <div class="col-sm-4">Số (Kg)</div>
                            <div class="col-sm-2">S.Lớp</div>
                            <div class="col-sm-3">S.Lg</div>
                        </div>
                    </div>
                </th>
            </tr>
        </thead>
        <tbody class="tbody-list">
            <c:forEach items="${listTableForm}" var="tabform">
                <tr class="tb-row">
                    <td>${tabform.orderTable.name}</td>
                    <td>
                        <div class="container-fluid">
                            <c:forEach items="${tabform.productList}" var="prod">
                                <div class="row" style="border: 1px dashed darkgrey">
                                    <div class="col-sm-6">${prod.name}</div>
                                    <div class="col-sm-6">${prod.quantity}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                    <td>
                        <div class="container-fluid">
                            <c:forEach items="${tabform.printerList}" var="print">
                                <div class="row" style="border: 1px dashed darkgrey">
                                    <div class="col-sm-4">${print.name}</div>
                                    <div class="col-sm-4">${print.price}</div>
                                    <div class="col-sm-4">${print.quantity}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                    <td>
                        <div class="container-fluid">
                            <c:forEach items="${tabform.embroideryList}" var="embroid">
                                <div class="row" style="border: 1px dashed darkgrey">
                                    <div class="col-sm-4">${embroid.name}</div>
                                    <div class="col-sm-4">${embroid.price}</div>
                                    <div class="col-sm-4">${embroid.quantity}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                    <td>
                        <div class="container-fluid">
                            <c:forEach items="${tabform.sewingList}" var="sew">
                                <div class="row" style="border: 1px dashed darkgrey">
                                    <div class="col-sm-4">${sew.name}</div>
                                    <div class="col-sm-4">${sew.price}</div>
                                    <div class="col-sm-4">${sew.quantity}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                    <td>
                        <div class="container-fluid">
                            <c:forEach items="${tabform.materialList}" var="material">
                                <div class="row" style="border: 1px dashed darkgrey">
                                    <div class="col-sm-3">${material.name}</div>
                                    <div class="col-sm-4">${material.weight}</div>
                                    <div class="col-sm-2">${material.num_class}</div>
                                    <div class="col-sm-3">${material.quantity}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>