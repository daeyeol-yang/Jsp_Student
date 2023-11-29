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
<h1>학생 등록</h1>
<form method="post" action="${action}">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id"  required /></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"  required /></td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <label>
                    <input type="radio" name="gender" value="M"  required />
                    남
                </label>
                <label>
                    <input type="radio" name="gender" value="F" required />
                    여
                </label>
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="text" name="age"  required /></td>
        </tr>


        </tr>
        </tbody>
    </table>
    <p>
        <button type="submit">등록</button>
    </p>
</form>
</body>
</html>