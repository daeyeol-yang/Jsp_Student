<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2023/11/28
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="/style.css" />
    <style>
    table {
    border-collapse: collapse;
    width: 100%;
    }

    th, td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    }

    tr:nth-child(even) {
    background-color: #f2f2f2;
    }
    </style>
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register" >학생(등록)</a></p>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>cmd</th>
    </tr>
    </thead>
    <tbody>
    <!--todo list 구현하기 c:foreach -->
    <c:forEach  var = "studentList" items="${studentList}">
        <tr>
            <td>${studentList.id}</td>
            <td>${studentList.name}</td>
            <td>${studentList.gender}</td>
            <td>${studentList.age}</td>
            <td>
                <a href="/student/view?id=${studentList.id}">조회</a>
            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
