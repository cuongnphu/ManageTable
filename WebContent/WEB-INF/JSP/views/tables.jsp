<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Manage Order Table</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> "/>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/tables.js"/> "></script>
</head>
<body>
<h3>Thêm Bàn: </h3>
<form:form method="post" action="/ManageTable/table" modelAttribute="modeltable">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 900px">
            <tr>
                <form:input type="text" path="id" readonly="true" hidden="true"/>
            </tr>
            <tr>
                <td>Name :</td>
                <td><form:input id="nameTable" type="text" path="name" placeholder="Ba`n xxx"/></td>
            </tr>
            <tr>
                <td><a class="btn btn-info" href="detailtable">&#10094 Thông Tin Chi Tiết Bàn</a></td>
                <td><input class="btn btn-info" type="submit" value="Tạo Bàn"
                           onchange="return tableScript.tableFormValidate()"
                           onclick="return tableScript.tableFormValidate()"/></td>
            </tr>
        </table>
    </div>
</form:form>
<h3>Danh Sách Bàn :</h3>
<table class="table table-bordered" style="width: 1400px">
    <thead class="thead">
    <tr>
        <th style="width: 2%">Bàn</th>
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
                    <div class="col-sm-4">&#9977In</div>
                    <div class="col-sm-4">$(đ)</div>
                    <div class="col-sm-4">S.Lượng</div>
                </div>
            </div>
        </th>
        <th style="width: 19%">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-4">&#9977Thêu</div>
                    <div class="col-sm-4">$(đ)</div>
                    <div class="col-sm-4">S.Lượng</div>
                </div>
            </div>
        </th>
        <th style="width: 19%">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-4">&#9977May</div>
                    <div class="col-sm-4">$(đ)</div>
                    <div class="col-sm-4">S.Lượng</div>
                </div>
            </div>
        </th>
        <th style="width: 23%">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3">N.Liệu</div>
                    <div class="col-sm-3">&#9878(Kg)</div>
                    <div class="col-sm-3">S.Lớp</div>
                    <div class="col-sm-3">S.Lượng</div>
                </div>
            </div>
        </th>
        <th style="width: 3%">#</th>
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
                            <div class="col-sm-3">${material.weight}</div>
                            <div class="col-sm-3">${material.num_class}</div>
                            <div class="col-sm-3">${material.quantity}</div>
                        </div>
                    </c:forEach>
                </div>
            </td>
            <td>
                <p><a class="btn-info btn-sm" href="edit/${tabform.orderTable.id}">&#9998</a></p>
                <p><a class="btn-info btn-sm" href="delete/${tabform.orderTable.id}">&#9940</a></p>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>