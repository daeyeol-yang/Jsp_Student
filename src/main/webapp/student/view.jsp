<%@ page import="com.nhnacademy.student.Student" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2023/11/28
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>학생-조회</title>
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


<table>
<tbody>
<tr>
  <th>ID</th>
  <td>${student.id}</td>
</tr>
<tr>
  <th>이름</th>
  <td>${student.name}</td>
</tr>
<tr>
  <th>성별</th>
  <td>${student.gender}</td>
</tr>
<tr>
  <th>나이</th>
  <td>${student.age}</td>
</tr>
<tr>
  <th>등록일</th>
  <td><${student.createdAt}/td>
</tr>


  </tbody>
</table>
<ul>
  <li><a href="/student/list">리스트</a></li>
  <li>
    <!-- todo ${update_link} 설정 c:url -->
  <c:url value="/student/update" var="update_link">
    <c:param name="id" value="${student.id}" />
  </c:url>
    <a href="${update_link}">수정</a>
  </li>
  <li>
    <!-- todo 삭제버튼 구현, method=post-->
    <form method="post" action="/student/delete">
      <input type="hidden" name="id" value="${student.id}">

      <button type="submit">삭제</button>
    </form>

  </li>

</ul>

</body>
</html>
