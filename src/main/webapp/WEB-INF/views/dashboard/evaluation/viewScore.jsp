<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../judgeNavbar.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Evaluation Scores</title>
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

        h3 {
            color: #4CAF50;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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

        td strong {
            color: #4CAF50;
        }

        /* Responsive table styles */
        @media screen and (max-width: 600px) {
            table {
                width: 100%;
            }
            table, thead, tbody, th, td, tr {
                display: block;
            }
            thead tr {
                position: absolute;
                top: -9999px;
                left: -9999px;
            }
            tr { border: 1px solid #ccc; }
            td {
                border: none;
                border-bottom: 1px solid #eee;
                position: relative;
                padding-left: 50%;
                white-space: normal;
                text-align:left;
            }
            td:before {
                position: absolute;
                top: 6px;
                left: 6px;
                width: 45%;
                padding-right: 10px;
                white-space: nowrap;
                text-align: left;
                color: #4CAF50;
            }
            .btn{
              background: #5E5DF0;
              border-radius: 999px;
              box-shadow: #5E5DF0 0 10px 20px -10px;
              box-sizing: border-box;
              color: #FFFFFF;
              cursor: pointer;
              font-family: Inter,Helvetica,"Apple Color Emoji","Segoe UI Emoji",NotoColorEmoji,"Noto Color Emoji","Segoe UI Symbol","Android Emoji",EmojiSymbols,-apple-system,system-ui,"Segoe UI",Roboto,"Helvetica Neue","Noto Sans",sans-serif;
              font-size: 16px;
              font-weight: 700;
              line-height: 24px;
              opacity: 1;
              outline: 0 solid transparent;
              padding: 8px 18px;
              user-select: none;
              -webkit-user-select: none;
              touch-action: manipulation;
              width: fit-content;
              word-break: break-word;
              border: 0;
            }

    </style>
</head>
<body>
    <div class="eval-container">
        <h2>Evaluation Scores</h2>

        <c:forEach var="teamName" items="${teamScores.keySet()}">
            <h3>${teamName}</h3>
            <table>
                <thead>
                    <tr>
                        <th>Criteria</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="criteria" items="${teamScores[teamName].keySet()}">
                        <tr>
                            <td>${criteria}</td>
                            <td>${teamScores[teamName][criteria]}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><strong>Total</strong></td>
                        <td><strong>${teamTotalScores[teamName]}</strong></td>
                    </tr>
                </tbody>
            </table>
            <br>
        </c:forEach>

        <!-- Print Button -->


    <button class="btn" onclick="printPage()" style="margin-top: 20px;">Print Page</button>

    </div>

    <!-- JavaScript Function to Print Page -->
        <script>
            function printPage() {
                window.print();
            }
        </script>
</body>
</html>
