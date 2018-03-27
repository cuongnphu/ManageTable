<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Detail Table Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
    <a class="btn btn-info" href="tables">Thêm Bàn Mới</a>
    <h3> Thông Tin Bàn </h3>
    <table class="table table-bordered" style="width: 1400px">
        <tr>
            <th style="width: 5%">Tên</th>
            <th style="width: 16%">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm">Tên SP</div>
                        <div class="col-sm">S.Lượng</div>
                    </div>
                </div>
            </th>
            <th>Người In, Giá , S.Lượng</th>
            <th>Người Thêu, Giá , S.Lượng</th>
            <th>Người May, Giá , S.Lượng</th>
            <th>Nguyên Liệu , S.Kg , S.Lớp , S.Lượng</th>
        </tr>
        <c:forEach items="${listTableForm}" var="tabform">
            <tr>
                <td width="60" align="center">${tabform.orderTable.name}</td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.productList}" var="prod">
                            <tr>
                                <td width="60" align="center">${prod.name}</td>
                                <td width="60" align="center">${prod.quantity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table class="table table-bordered">
                        <c:forEach items="${tabform.printerList}" var="print">
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
                        <c:forEach items="${tabform.embroideryList}" var="embroid">
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
                        <c:forEach items="${tabform.sewingList}" var="sew">
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
                        <c:forEach items="${tabform.materialList}" var="material">
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