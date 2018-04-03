<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Quản Lý Đội</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/Resources/css/general.css" /> "/>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="<c:url value="/Resources/js/team.js"/> "></script>
</head>
<body>
<h3>Thêm Đội: </h3>
<form:form method="post" action="/ManageTable/team" modelAttribute="modelteam">
    <div class="table-responsive">
        <table class="table table-bordered" style="width: 900px">
            <tr>
                <form:input type="text" path="id" readonly="true" hidden="true"/>
                <form:input type="text" path="total" readonly="true" hidden="true"/>
                <form:input type="text" path="enable" readonly="true" hidden="true"/>
            </tr>
            <tr>
                <td>Name :</td>
                <td><form:input id="nameTeam" type="text" path="name" placeholder="Tên đội"/></td>
            </tr>
            <tr>
                <td>Ngành Nghề :</td>
                <td>
                    <form:select path="team_id">
                        <form:option value="1">In</form:option>
                        <form:option value="2">Thêu</form:option>
                        <form:option value="3">May</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><a class="btn btn-info" href="detailtable">&#10094 Thông Tin Chi Tiết Bàn</a></td>
                <td><input class="btn btn-info" type="submit" value="Tạo Đội" onchange="return teamScript.teamFormValidate()"
                           onclick="return teamScript.teamFormValidate()"/>
                </td>
            </tr>
        </table>
    </div>
</form:form>
<h3>Danh Sách Đội :</h3>
<table class="table table-bordered" style="width: 900px">
    <thead class="thead">
    <tr>
        <th style="width: 50%">Tên Đội</th>
        <th style="width: 20%">Ngành Nghề</th>
        <th style="width: 20%">Tình Trạng</th>
        <th style="width: 10%">#</th>
    </tr>
    </thead>
    <tbody class="tbody-list">
    <c:forEach items="${listTeamForm}" var="teamform">
        <tr class="tb-row">
            <td>${teamform.name}</td>
            <td>
                <c:if test="${teamform.team_id == 1}">In</c:if>
                <c:if test="${teamform.team_id == 2}">Thêu</c:if>
                <c:if test="${teamform.team_id == 3}">May</c:if>
            </td>
            <td>
                <c:if test="${teamform.enable == true}">Hoạt Động</c:if>
                <c:if test="${teamform.enable == false}">STOP</c:if>
            </td>
            <td>
                <p><a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmEdit(${teamform.id})">&#9998</a></p>
                <p><a class="btn-info btn-sm" onclick="teamScript.teamFormConfirmDelete(${teamform.id})">&#9940</a></p>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>