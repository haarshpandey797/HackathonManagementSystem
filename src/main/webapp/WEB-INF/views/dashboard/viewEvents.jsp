<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Running Hackathon</title>
    <style>
        .hack-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
        }

        .hack-card {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }

        .hack-card:hover {
            transform: translateY(+10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }

        .hack-card-title {
            font-size: 2rem;
            margin-bottom: 10px;
            font-weight: 500;
            color: #303030;
        }

        .hack-card-text {
            color: #666;
            margin-bottom: 8px;
        }

        .hack-card-text strong {
            color: #333;
        }

        .hack-card-list {
            list-style-type: none;
            padding-left: 0;
            margin-top: 10px;
        }

        .hack-card-list li {
            margin-bottom: 5px;
            color: #555;
        }

        .hack-alert {
            margin-top: 20px;
            padding: 10px;
            background-color: #ffe4e1;
            border: 1px solid #f08080;
            color: #cc0000;
            border-radius: 6px;
            font-weight: bold;
        }

        h4 {
            font-size: 1.5rem;
            margin-top: 1.5rem;
            margin-bottom: 1rem;
            color: #555;
        }
    </style>
</head>
<body class="hack-body">
    <div class="hack-container">
        <h1 class="mt-4 mb-4">Your Current Hackathon</h1>

        <!-- Check if event is not null -->
        <c:if test="${not empty event}">
            <div class="hack-card">
                <p class="hack-card-title"><strong>Event Name:</strong> ${event.eventName}</p>
                <p class="hack-card-text"><strong>Event Date:</strong> ${event.startDate} to ${event.endDate}</p>
                <p class="hack-card-text"><strong>Location:</strong> ${event.location}</p>
                <p class="hack-card-text"><strong>Description:</strong> ${event.description}</p>
                <p class="hack-card-text"><strong>Type:</strong> ${event.eventType}</p>
                <p class="hack-card-text"><strong>Theme:</strong> ${event.theme}</p>
                <p class="hack-card-text"><strong>Planned Hours:</strong> ${event.plannedHours}</p>
                <p class="hack-card-text"><strong>Schedule Link:</strong> ${event.scheduleLink}</p>
                <p class="hack-card-text"><strong>Approved Budget:</strong> ${event.approvedBudget}</p>
                <a href="showGrid" >Button  </a>

                <!-- Problem Statements -->
                <c:if test="${not empty event.problemStatements}">
                    <h4 class="mt-3">Problem Statements</h4>
                    <ul class="hack-card-list">
                        <c:forEach var="problem" items="${event.problemStatements}">
                            <li>${problem.problemStatement}</li>
                        </c:forEach>
                    </ul>
                </c:if>

                <!-- Participating Teams -->
                <c:if test="${not empty event.teamList}">
                    <h4 class="mt-3">Participating Teams</h4>
                    <ul class="hack-card-list">
                        <c:forEach var="team" items="${event.teamList}">
                            <li>${team.teamName}</li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </c:if>

        <!-- Display message if event is null -->
        <c:if test="${empty event}">
            <div class="hack-alert">
                Event not found or does not exist.
            </div>
        </c:if>
    </div>
</body>
</html>
