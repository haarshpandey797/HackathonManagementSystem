<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Past Hackathons</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .hack-container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .hack-heading {
            font-size: 24px;
            margin-bottom: 15px;
            color: #333;
        }
        .hack-paragraph {
            color: #777;
            margin-top: 10px;
        }
        .hack-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        .hack-table th, .hack-table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .hack-table th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        .hack-table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .hack-table tbody tr:hover {
            background-color: #ddd;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        @media (max-width: 768px) {
            .hack-table, .hack-table th, .hack-table td {
                display: block;
                width: 100%;
            }
            .hack-table th {
                display: none;
            }
            .hack-table td {
                display: flex;
                justify-content: space-between;
                border: none;
                border-bottom: 1px solid #ddd;
                padding: 8px 12px;
                box-sizing: border-box;
            }
            .hack-table td::before {
                content: attr(data-label);
                font-weight: bold;
                width: 50%;
            }
        }
    </style>
</head>
<body>
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />

    <div class="hack-container">
        <h2 class="hack-heading">Past Hackathons</h2>

        <c:choose>
            <c:when test="${empty runningHackathons}">
                <p class="hack-paragraph">No past hackathons found.</p>
            </c:when>
            <c:otherwise>
                <table class="hack-table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Location</th>
                            <th>Description</th>
                            <th>Event Type</th>
                            <th>Theme</th>
                            <th>More Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="event" items="${runningHackathons}">
                            <tr>
                                <td data-label="Title">${event.eventName}</td>
                                <td data-label="Start Date">${event.startDate}</td>
                                <td data-label="End Date">${event.endDate}</td>
                                <td data-label="Location">${event.location}</td>
                                <td data-label="Description">${event.description}</td>
                                <td data-label="Event Type">${event.eventType}</td>
                                <td data-label="Theme">${event.theme}</td>
                                <td data-label="Schedule Link"><a href="${pageContext.request.contextPath}/admin/viewAllDetails/${event.eventId}" target="_blank">Click Here</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
