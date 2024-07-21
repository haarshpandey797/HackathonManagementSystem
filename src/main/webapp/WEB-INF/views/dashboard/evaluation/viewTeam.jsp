<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Teams</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .my-container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        .team-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }
        .team-table th, .team-table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        .team-table th {
            background-color: #007bff;
            color: white;
        }
        .team-table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .team-table tr:hover {
            background-color: #ddd;
        }
        h2 {
            font-size: 24px;
            margin-bottom: 15px;
            color: #333;
        }
        .no-teams {
            font-style: italic;
            color: #888;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        @media (max-width: 768px) {
            .team-table, .team-table th, .team-table td {
                display: block;
                width: 100%;
            }
            .team-table th {
                display: none;
            }
            .team-table td {
                display: flex;
                justify-content: space-between;
                border: none;
                border-bottom: 1px solid #ddd;
                padding: 8px 12px;
                box-sizing: border-box;
            }
            .team-table td::before {
                content: attr(data-label);
                font-weight: bold;
                width: 50%;
            }
        }
    </style>
</head>
<body>
    <jsp:include page="../judgeNavbar.jsp" />

    <div class="my-container">
        <h2>Teams</h2>
        <c:choose>
            <c:when test="${empty teams}">
                <p class="no-teams">No teams available.</p>
            </c:when>
            <c:otherwise>
                <table class="team-table">
                    <thead>
                        <tr>
                            <th>Team ID</th>
                            <th>Team Name</th>
                            <th>Team Size</th>
                            <th>Status</th>
                            <th>Code Repository Link</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="team" items="${teams}">
                            <tr>
                                <td data-label="Team ID">${team.teamId}</td>
                                <td data-label="Team Name">${team.teamName}</td>
                                <td data-label="Team Size">${team.teamSize}</td>
                                <td data-label="Status">${team.status}</td>
                                <td data-label="Code Repository Link"><a href="${team.codeRepositoryLink}" target="_blank">${team.codeRepositoryLink}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
