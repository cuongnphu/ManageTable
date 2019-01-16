<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Thống Kê Báo Cáo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> "/>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/statistics.js"/> "></script>
</head>
<body>
<h3>Nhập Thông Tin Đội: </h3>
<form:form modelAttribute="tableForm">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 900px">
            <thead>
            <tr>
                <th style="width: 50%"></th>
                <th style="width: 50%">&#9636 Chọn Đội</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Ngành Nghề :</td>
                <td>
                    <form:select path="teamList[0].team_id">
                        <c:if test="${tableForm.teamList.get(0).team_id == 1}">
                            <form:option value="1" selected="selected">In</form:option>
                            <form:option value="2">Thêu</form:option>
                            <form:option value="3">May</form:option>
                        </c:if>
                        <c:if test="${tableForm.teamList.get(0).team_id == 2}">
                            <form:option value="1">In</form:option>
                            <form:option value="2" selected="selected">Thêu</form:option>
                            <form:option value="3">May</form:option>
                        </c:if>
                        <c:if test="${tableForm.teamList.get(0).team_id == 3}">
                            <form:option value="1">In</form:option>
                            <form:option value="2">Thêu</form:option>
                            <form:option value="3" selected="selected">May</form:option>
                        </c:if>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Tên :</td>
                <td>
                    <form:select path="teamList[0].name">
                        <c:forEach items="${tableForm.teamList}" var="team">
                            <form:option value="${team.name}">${team.name}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><a class="btn btn-info" onclick="window.location.replace('/ManageTable/detailtable')">&#10094 Thông
                    Tin Chi Tiết Bàn</a></td>
                <td>
                    <input id="statistic" class="btn btn-info" value="Thống Kế"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</form:form>
<h3>Thống Kê Chi Tiết :</h3>
<table class="table table-bordered" style="width: 1200px">
    <thead class="thead">
    <tr>
        <th style="width: 20%">Tên Đội</th>
        <th style="width:10%">Ngành</th>
        <th style="width: 50%">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3">Tên Bàn</div>
                    <div class="col-sm-3">$(đ)</div>
                    <div class="col-sm-3">S.Lượng</div>
                    <div class="col-sm-3">Total</div>
                </div>
            </div>
        </th>
        <th style="width: 20%">Tổng Cộng</th>
    </tr>
    </thead>
    <tbody id="report" class="tbody-list">
    <tr class="tb-row">
        <td id="name"></td>
        <td id="team_id"></td>
        <td>
            <div class="container-fluid">
            </div>
        </td>
        <td id="totalall"></td>
    </tr>
    </tbody>
</table>
</body>
</html>