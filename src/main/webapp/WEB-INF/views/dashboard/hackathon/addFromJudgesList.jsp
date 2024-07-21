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
    <title>Judges List</title>
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
        <h2>Judges List</h2>

        <form action="processJudges" method="post">
            <table id="judgeTbl" border="1">
                <thead>
                    <tr>
                        <th>Judge ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>BU</th>
                        <th>Role</th>
                        <th>Responsibility</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${judges}" var="judge">
                        <tr>
                            <td data-label="Judge ID">${judge.judgeId}</td>
                            <td data-label="Name">${judge.judgeName}</td>
                            <td data-label="Email">${judge.judgeEmail}</td>
                            <td data-label="BU">${judge.judgeBU}</td>
                            <td data-label="Role">
                                <select name="roles_${judge.judgeId}" id="role_${judge.judgeId}" disabled>
                                    <option value="" selected disabled hidden>Choose Role</option>
                                    <c:forEach items="${roles}" var="role">
                                        <option value="${role}">${role}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td data-label="Responsibility">
                                <input type="text" name="responsibility_${judge.judgeId}" id="responsibility_${judge.judgeId}" disabled>
                            </td>
                            <td data-label="Select">
                                <input type="checkbox" name="selectedJudges" value="${judge.judgeId}" onchange="toggleFields(this, 'role_${judge.judgeId}', 'responsibility_${judge.judgeId}')">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <input type="submit" value="Submit Selected Judges" onclick="validateLeadJudge(event)">
        </form>
    </div>

    <script>
        $(document).ready(function() {
                   // Initialize DataTable
                   var table = $('#judgeTbl').DataTable();
               });
        function toggleFields(checkbox, roleFieldId, responsibilityFieldId) {
            var roleField = document.getElementById(roleFieldId);
            var responsibilityField = document.getElementById(responsibilityFieldId);

            if (checkbox.checked) {
                roleField.disabled = false;
                responsibilityField.disabled = false;
                roleField.required = true;
                responsibilityField.required = true;
            } else {
                roleField.disabled = true;
                responsibilityField.disabled = true;
                roleField.required = false;
                responsibilityField.required = false;
            }
        }

        function countLeadJudges() {
            var leadJudgeCount = 0;
            var checkboxes = document.getElementsByName('selectedJudges');

            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    var judgeId = checkboxes[i].value;
                    var roleSelect = document.getElementById('role_' + judgeId);
                    var selectedRole = roleSelect.options[roleSelect.selectedIndex].value;

                    if (selectedRole === 'LEAD_JUDGE') {
                        leadJudgeCount++;
                    }
                }
            }
            return leadJudgeCount;
        }

        function validateLeadJudge(event) {
            var leadJudgeCount = countLeadJudges();

            if (leadJudgeCount > 1) {
                alert("Only one judge can be assigned as LEAD_JUDGE.");
                event.preventDefault();
            }
        }
    </script>
</body>
</html>
