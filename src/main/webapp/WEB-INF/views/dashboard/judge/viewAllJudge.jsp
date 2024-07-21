<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Judges</title>
    <!-- Navbar -->
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />
    <style>
        /* Custom styles */



        .judge-container {
            max-width: 960px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h2 {
            margin-bottom: 20px;
            font-size: 28px;
            color: #007bff;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #ffffff;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background-color: #f0f0f0;
            font-weight: bold;
            color: #333;
            text-transform: uppercase;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .pagination a {
            padding: 8px 12px;
            text-decoration: none;
            border: 1px solid #007bff;
            margin: 0 4px;
            color: #007bff;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }

        .pagination a.active,
        .pagination a:hover {
            background-color: #007bff;
            color: #fff;
            border-color: #007bff;
        }

        .no-data {
            text-align: center;
            font-size: 18px;
            padding: 20px;
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
        }

        /* Responsive styles */
        @media (max-width: 768px) {
            .judge-container {
                padding: 10px;
            }
            table {
                font-size: 12px;
            }
            h2 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body class="judge-body">
    <div class="judge-container">
        <h2>View All Judges</h2>

        <c:choose>
            <c:when test="${empty allJudges}">
                <div class="no-data">
                    No judge data available.
                </div>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>Judge ID</th>
                            <th>Judge Name</th>
                            <th>Business Unit</th>
                            <th>Designation</th>
                            <th>Contact No</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${allJudges}" var="judge">
                            <tr>
                                <td>${judge.judgeId}</td>
                                <td>${judge.judgeName}</td>
                                <td>${judge.judgeBU}</td>
                                <td>${judge.judgeDesignation}</td>
                                <td>${judge.judgeContactNo}</td>
                                <td>${judge.judgeEmail}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- Pagination -->
                <div class="pagination">
                    <c:forEach begin="1" end="5" varStatus="loop">
                        <c:choose>
                            <c:when test="${loop.index == currentPage}">
                                <a href="?page=${loop.index}" class="active">${loop.index}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="?page=${loop.index}">${loop.index}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
