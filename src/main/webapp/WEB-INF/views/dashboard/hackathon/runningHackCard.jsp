    <!-- Navbar -->
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Running Hackathons</title>
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
            color:blue
        }

        .hack-card:hover {
            transform: translateY(+10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }

        .hack-card-title {
            font-size: 2rem;
            margin-bottom: 10px;
            font-weight:500;
            font-size:2rem;
            color:#303030

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
        <h1 class="mt-4 mb-4" style="margin-bottom:50px;">Running Hackathons</h1>

        <!-- Check if there are running hackathons -->
        <c:if test="${not empty runningHackathons}">
            <c:forEach var="hackathon" items="${runningHackathons}">
                <div class="hack-card">
                    <p class="hack-card-title"><strong>Event Name:</strong>${hackathon.eventName}</p>
                    <p class="hack-card-text"><strong>Event ID:</strong> ${hackathon.eventId}</p>
                    <p class="hack-card-text"><strong>Event Date:</strong> ${hackathon.startDate} to ${hackathon.endDate}</p>
                    <p class="hack-card-text"><strong>Location:</strong> ${hackathon.location}</p>
                    <p class="hack-card-text"><strong>Description:</strong> ${hackathon.description}</p>
                    <p class="hack-card-text"><strong>Type:</strong> ${hackathon.type}</p>
                    <p class="hack-card-text"><strong>Theme:</strong> ${hackathon.theme}</p>
                    <p class="hack-card-text"><strong>Planned Hours:</strong> ${hackathon.plannedHours}</p>
                    <p class="hack-card-text"><strong>Schedule Link:</strong> ${hackathon.scheduleLink}</p>
                    <p class="hack-card-text"><strong>Approved Budget:</strong> ${hackathon.approvedBudget}</p>
                    <p class="hack-card-text"><strong>Organizing Team:</strong> ${hackathon.organisingTeam}</p>

                    <!-- Problem Statements -->
                    <c:if test="${not empty hackathon.problemList}">
                        <h4 class="mt-3">Problem Statements</h4>
                        <ul class="hack-card-list">
                            <c:forEach var="problem" items="${hackathon.problemList}">
                                <li>${problem.problemStatement}</li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <!-- Participating Teams -->
                    <c:if test="${not empty hackathon.teamList}">
                        <h4 class="mt-3">Participating Teams</h4>
                        <ul class="hack-card-list">
                            <c:forEach var="team" items="${hackathon.teamList}">
                                <li>${team.teamName}</li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </div>
            </c:forEach>
        </c:if>

        <!-- Display message if no hackathons are available -->
        <c:if test="${empty runningHackathons}">
            <div class="hack-alert">
                No running hackathons found.
            </div>
        </c:if>
    </div>
</body>
</html>
