<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Detail Table Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> " />
</head>
<body>
    <a class="btn btn-info" href="tables">Thêm Bàn Mới</a>
    <h3> Thông Tin Chi Tiết Bàn: </h3>
    <table class="table table-bordered"  style="width: 1400px">
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