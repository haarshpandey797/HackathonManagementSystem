  <!-- Navbar -->
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />
    <style>
            @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');
            * {
              margin: 0;
              padding: 0;
              box-sizing: border-box;
            }
            .navbar {
              background-color: #6A64F1;
              color: white;
              padding: 10px 0;
              text-align: center;
              font-weight: 600;
              font-size: 20px;
            }
            .button-container {
              display: flex;
              justify-content: center;
              align-items: center;
              margin-top: 50px;
            }
            .button {
              background-color: #6A64F1;
              color: white;
              font-size: 18px;
              font-weight: 600;
              border: none;
              border-radius: 5px;
              padding: 15px 30px;
              margin: 10px;
              cursor: pointer;
              transition: background-color 0.3s ease;
            }
            .button:hover {
              background-color: #524de1;
            }
        </style>

    <div class="navbar">
        Add More Information
    </div>
    <div class="button-container">
        <a href="addJudgeToEvent" class="button">Add Judge</a>
        <a href="addProblemStatementsToEvent" class="button">Add Problems</a>
        <a href="addTeamsToEvent" class="button">Add Teams</a>
        <a href="addCriteriaToEvent" class="button">Add Criteria</a>
    </div>
