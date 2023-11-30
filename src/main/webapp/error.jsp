<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2023/11/30
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Error Page</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>

<table>
  <tbody>
  <tr>
    <th>status_code</th>
    <td>${status_code}</td><!-- todo status_code 출력 -->
  </tr>
  <tr>
    <th>exception_type</th>
    <td>${exception_type}</td><!-- todo exception_type 출력 -->
  </tr>
  <tr>
    <th>message</th>
    <td>${message}</td><!-- todo message 출력 -->
  </tr>
  <tr>
    <th>exception</th>
    <td>${exception}</td><!-- todo exception 출력 -->
  </tr>
  <tr>
    <th>request_uri</th>
    <td>${request_uri}</td><!-- todo request_uri 출력 -->
  </tr>
  </tbody>
</table>
</body>
</html>

