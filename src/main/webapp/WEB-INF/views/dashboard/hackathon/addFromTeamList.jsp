<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <!-- DataTables Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teams List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .makeChange {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        h2 {
            font-size: 24px;
            margin-bottom: 15px;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            background-color: #fff;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        thead {
            background-color: #007bff;
            color: white;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tbody tr:hover {
            background-color: #ddd;
        }
        select, input[type=text], input[type=checkbox], input[type=submit] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
        .form-container {
            margin-top: 20px;
        }
        .error-message {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        @media (max-width: 768px) {
            table, th, td {
                display: block;
                width: 100%;
            }
            th {
                display: none;
            }
            td {
                display: flex;
                justify-content: space-between;
                border: none;
                border-bottom: 1px solid #ddd;
                padding: 8px 12px;
                box-sizing: border-box;
            }
            td::before {
                content: attr(data-label);
                font-weight: bold;
                width: 50%;
            }
        }
    </style>
</head>
<body>
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />

    <div class="makeChange">
        <h2>Teams List</h2>

        <form action="processTeams" method="post">
            <table id="teamTbl" border="1">
                <thead>
                    <tr>
                        <th>Team ID</th>
                        <th>Name</th>
                        <th>Size</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${teams}" var="team">
                        <tr>
                            <td data-label="Team ID">${team.teamId}</td>
                            <td data-label="Name">${team.teamName}</td>
                            <td data-label="Size">${team.teamSize}</td>
                            <td data-label="Select">
                                <input type="checkbox" name="selectedTeams" value="${team.teamId}">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Submit Selected Teams" onclick="validateTeams(event)">
        </form>
    </div>

    <script>
        $(document).ready(function() {
            // Initialize DataTable
            var table = $('#teamTbl').DataTable();
        });

        function validateTeams(event) {
            var checkboxes = document.getElementsByName('selectedTeams');
            var atLeastOneChecked = false;

            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    atLeastOneChecked = true;
                    break;
                }
            }

            if (!atLeastOneChecked) {
                alert("Please select at least one team.");
                event.preventDefault();
            }
        }
    </script>
</body>
</html>
