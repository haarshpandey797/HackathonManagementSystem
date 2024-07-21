<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../NotConfirmedUI/navbar.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Details</title>
    <style>


        .view-container {
            margin-top:50px !important;
            max-width: 900px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1, h2 {
            color: #007bff;
            border-bottom: 2px solid #007bff;
            padding-bottom: 8px;
        }

        .card {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s ease-in-out;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .card a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s;
        }

        .card a:hover {
            color: #0056b3;
        }

        .card strong {
            color: #555;
        }

        .section-title {
            margin-top: 30px;
            margin-bottom: 20px;
        }

        .section-content {
            margin-bottom: 30px;
        }

        /* Responsive adjustments */
        @media (max-width: 768px) {
            .container {
                padding: 15px;
            }
            .card {
                padding: 15px;
            }
        }
    </style>
</head>
<body>
    <div class="view-container">
        <h1>Event Details</h1>

        <div class="section-content" style="margin-top:15px;">
            <div class="card">
                <strong>Event Name:</strong> ${event.eventName}<br>
                <strong>Start Date:</strong> ${event.startDate}<br>
                <strong>End Date:</strong> ${event.endDate}<br>
                <strong>Location:</strong> ${event.location}<br>
                <strong>Description:</strong> ${event.description}<br>
                <strong>Event Type:</strong> ${event.eventType}<br>
                <strong>Theme:</strong> ${event.theme}<br>
            </div>
        </div>

        <div class="section-title">
            <h2>Problem Statements</h2>
        </div>
        <div class="section-content">
            <c:forEach var="problem" items="${event.problemStatements}">
                <div class="card">
                    <strong>Problem Name:</strong> ${problem.problemName}<br>
                    <strong>Description:</strong> ${problem.problemDescription}<br>
                    <strong>Link:</strong> <a href="${problem.problemLink}" target="_blank">${problem.problemLink}</a><br>
                    <strong>Status:</strong> ${problem.status}<br>
                    <strong>Adoption Status:</strong> ${problem.adoptionStatus}<br>
                </div>
            </c:forEach>
        </div>

        <div class="section-title">
            <h2>Judges</h2>
        </div>
        <div class="section-content">
            <c:forEach var="judgeMapping" items="${event.judgeMappings}">
                <div class="card">
                    <strong>Judge Name:</strong> ${judgeMapping.judge.judgeName}<br>
                    <strong>Business Unit:</strong> ${judgeMapping.judge.judgeBU}<br>
                    <strong>Contact Number:</strong> ${judgeMapping.judge.judgeContactNo}<br>
                    <strong>Email:</strong> ${judgeMapping.judge.judgeEmail}<br>
                    <strong>Designation:</strong> ${judgeMapping.judge.judgeDesignation}<br>
                    <strong>Role:</strong> ${judgeMapping.role}<br>
                    <strong>Responsibility:</strong> ${judgeMapping.responsibility}<br>
                </div>
            </c:forEach>
        </div>

        <div class="section-title">
            <h2>Criteria</h2>
        </div>
        <div class="section-content">
            <c:forEach var="criteriaMapping" items="${event.criteriaEventMappings}">
                <div class="card">
                    <strong>Criteria Name:</strong> ${criteriaMapping.criteria.criteriaName}<br>
                    <strong>Description:</strong> ${criteriaMapping.criteria.description}<br>
                    <strong>Max Score:</strong> ${criteriaMapping.maxScore}<br>
                    <strong>Weightage:</strong> ${criteriaMapping.weightage}<br>
                </div>
            </c:forEach>
        </div>

        <div class="section-title">
            <h2>Teams</h2>
        </div>
        <div class="section-content">
            <c:forEach var="team" items="${event.teamList}">
                <div class="card">
                    <strong>Team Name:</strong> ${team.teamName}<br>
                    <strong>Team Size:</strong> ${team.teamSize}<br>
                    <strong>Problem Statement:</strong> ${team.problemStatement.problemName}<br>
                    <strong>Status:</strong> ${team.status}<br>
                    <strong>Code Repository Link:</strong> <a href="${team.codeRepositoryLink}" target="_blank">${team.codeRepositoryLink}</a><br>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
