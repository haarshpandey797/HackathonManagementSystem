<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Problem Statements</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <!-- DataTables JS -->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .problemDiv {
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

    <div class="problemDiv">
        <h2>Problem Statements</h2>

        <form id="problemForm" action="processProblems" method="post">
            <table id="problemTbl">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Link</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${problems}" var="problem">
                        <tr>
                            <td>${problem.problemStatementId}</td>
                            <td>${problem.problemName}</td>
                            <td><a href="#" onclick="showDescriptionModal('${problem.problemStatementId}', '${problem.problemDescription}')">${problem.problemDescription}</a></td>
                            <td><a href="${problem.problemLink}" target="_blank">Link</a></td>
                            <td><input type="checkbox" name="selectedProblems" value="${problem.problemStatementId}"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Button to process selected problem statements -->
            <button type="button" class="btn btn-primary mt-3" onclick="submitForm()">Process Selected Problems</button>
        </form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="descriptionModal" tabindex="-1" role="dialog" aria-labelledby="descriptionModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="descriptionModalLabel">Problem Description</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="descriptionModalBody">
                    <!-- Problem description content will be loaded here -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            // Initialize DataTable
            $('#problemTbl').DataTable();
        });

        function showDescriptionModal(problemId, description) {
            $('#descriptionModalBody').text(description);
            $('#descriptionModal').modal('show');
        }

        function submitForm() {
            document.getElementById("problemForm").submit();
        }
    </script>
</body>
</html>
