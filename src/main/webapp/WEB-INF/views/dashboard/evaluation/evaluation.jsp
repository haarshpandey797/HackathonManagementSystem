<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../judgeNavbar.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Evaluation Grid</title>
    <style>
        .eval-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 0;
            padding-top: 20px;
        }

        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            color: #333;
            font-weight: bold;
        }

        td {
            background-color: #fff;
            color: #333;
        }

        input[type="number"] {
            width: 60px;
            padding: 6px 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            text-align: center;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        @media print {
            body * {
                visibility: hidden;
            }

            .eval-container {
                visibility: visible;
            }

            .eval-container * {
                visibility: visible;
            }
        }
    </style>
</head>
<body>
<div class="eval-container">
    <h2>Evaluation Grid</h2>
    <form id="evaluationForm" action="${pageContext.request.contextPath}/judge/submitEvaluation" method="post">
        <table>
            <thead>
            <tr>
                <th>Teams</th> <!-- Updated to reflect teams as rows -->
                <c:forEach items="${criteriaList}" var="criteria">
                    <th>${criteria.criteriaName}</th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${teams}" var="team">
                <tr>
                    <td>${team.teamName}</td> <!-- Teams shown as rows -->
                    <c:forEach items="${criteriaList}" var="criteria">
                        <td>
                            <input type="number" name="scores[${team.teamName}][${criteria.criteriaName}]"
                                   min="1" max="5" required>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <div style="display: flex; ">

            <input type="submit" style="margin-right:30px;" value="Submit Evaluation">
            <button class="btn" onclick="printPage()" style="margin-top: 20px;">Print Page</button>

        </div>

    </form>
</div>
 <script>

        function printPage() {
          const evalContainer = document.querySelector('.eval-container');
          const styles = document.querySelectorAll('style, link[rel="stylesheet"]');
          const printWindow = window.open('', '_blank');
          printWindow.document.write('<html><head>');
          Array.prototype.forEach.call(styles, function(style) {
            printWindow.document.write(style.outerHTML);
          });
          printWindow.document.write('</head><body>');
          printWindow.document.write(evalContainer.outerHTML);
          printWindow.document.write('</body></html>');
          printWindow.document.close();
          printWindow.print();
          printWindow.close();
        }

        document.addEventListener("DOMContentLoaded", function() {
            const inputs = document.querySelectorAll('input[type="number"]');

            inputs.forEach((input) => {
                input.addEventListener("keydown", function(event) {
                    const arrowKeys = ["ArrowLeft", "ArrowRight", "ArrowUp", "ArrowDown"];
                    if (arrowKeys.includes(event.key)) {
                        event.preventDefault();
                        const currentIndex = Array.from(inputs).indexOf(input);
                        let nextIndex = currentIndex;

                        if (event.key === "ArrowLeft") {
                            nextIndex = currentIndex - 1;
                        } else if (event.key === "ArrowRight") {
                            nextIndex = currentIndex + 1;
                        } else if (event.key === "ArrowUp") {
                            const currentRow = parseInt(input.getAttribute("data-row"));
                            const currentCol = parseInt(input.getAttribute("data-col"));
                            nextIndex = currentRow > 0 ? currentIndex - teams.length : currentIndex;
                        } else if (event.key === "ArrowDown") {
                            const currentRow = parseInt(input.getAttribute("data-row"));
                            const currentCol = parseInt(input.getAttribute("data-col"));
                            nextIndex = currentRow < criteriaList.length - 1 ? currentIndex + teams.length : currentIndex;
                        }

                        if (nextIndex >= 0 && nextIndex < inputs.length) {
                            inputs[nextIndex].focus();
                        }
                    }
                });
            });
        });
    </script>
</body>
</html>
