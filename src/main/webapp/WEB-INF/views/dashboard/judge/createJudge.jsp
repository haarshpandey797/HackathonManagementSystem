<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../NotConfirmedUI/navbar.jsp" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Judge Form</title>
    <style>
        .form-container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table tr td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }
        input[type="text"], input[type="number"], input[type="email"], select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus, input[type="number"]:focus, input[type="email"]:focus, select:focus {
            border-color: #007bff;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 4px;
            cursor: pointer;
            border: none;
            font-size: 16px;
            margin-top: 20px;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        @media (max-width: 768px) {
            .form-container {
                width: 90%;
                padding: 15px;
            }
            table tr td {
                display: block;
                width: 100%;
                box-sizing: border-box;
                text-align: left;
            }
            table tr td:first-child {
                font-weight: bold;
                margin-bottom: 5px;
            }
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Judge Form</h2>
        <form:form action="${pageContext.request.contextPath}/saveJudge" method="post" modelAttribute="judge">
            <table>
                <tr>
                    <td>Judge Name:</td>
                    <td><form:input path="judgeName" required="true" /></td>
                </tr>
                <tr>
                    <td>Judge BU:</td>
                    <td>
                        <form:select path="judgeBU">
                            <form:options items="${businessUnits}" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Contact No:</td>
                    <td><form:input path="judgeContactNo" required="true" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="judgeEmail" required="true" /></td>
                </tr>
                <tr>
                    <td>Designation:</td>
                    <td><form:input path="judgeDesignation" required="true" /></td>
                </tr>
                <tr>
                    <td>Employee ID:</td>
                    <td><form:input path="judgeEmployeeId" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="Save Judge" />
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
