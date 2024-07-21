    <!-- Navbar -->
    <jsp:include page="../NotConfirmedUI/navbar.jsp" />

    <div class="formbold-main-wrapper">
        <div class="formbold-form-wrapper">

            <form action="handleForm" method="POST">

            <form action="https://formbold.com/s/FORM_ID" method="POST">

            <form action="admin/handleHackathonData" method="POST">

                <div class="formbold-steps">
                    <ul>
                        <li class="formbold-step-menu1 active">
                            <span>1</span>
                            Basic Info
                        </li>
                        <li class="formbold-step-menu2">
                            <span>2</span>
                            Additional Info
                        </li>
                        <li class="formbold-step-menu3">
                            <span>3</span>
                            Confirm
                        </li>
                    </ul>
                </div>

                <div class="formbold-form-step-1 active">
                    <div class="formbold-input-flex">
                        <div>
                            <label for="eventName" class="formbold-form-label"> Event name </label>
                            <input type="text" name="eventName" placeholder="Name of event" id="eventName" class="formbold-form-input" required />
                        </div>
                        <div>
                            <label for="theme" class="formbold-form-label"> Theme </label>
                            <input type="text" name="theme" placeholder="Theme of event" id="theme" class="formbold-form-input" required />
                        </div>
                    </div>

                    <div class="formbold-input-flex">
                        <div>
                            <label for="startDate" class="formbold-form-label"> Start Date </label>
                            <input type="date" name="startDate" id="startDate" class="formbold-form-input" required />
                        </div>
                        <div>
                            <label for="endDate" class="formbold-form-label"> End Date </label>
                            <input type="date" name="endDate" id="endDate" class="formbold-form-input" required />
                        </div>
                    </div>

                    <div>
                        <label for="location" class="formbold-form-label"> Location </label>
                        <input type="text" name="location" id="location" placeholder="3rd Floor, 2nd Unit, Nucleus Software" class="formbold-form-input" required />
                    </div>
                </div>

                <div class="formbold-form-step-2">
                    <div class="formbold-input-flex">
                        <div>
                            <label for="type" class="formbold-form-label"> Type </label>
                            <select name="type" id="type" class="formbold-form-input" required>
                                <option value="Offline">Offline</option>
                                <option value="Online">Online</option>
                            </select>
                        </div>
                        <div>
                            <label for="budget" class="formbold-form-label"> Budget </label>
                            <input type="number" name="budget" id="budget" placeholder="0" class="formbold-form-input" required />
                        </div>
                    </div>

                    <div>
                        <label for="description" class="formbold-form-label"> Description </label>
                        <textarea rows="6" name="description" id="description" placeholder="Type your description" class="formbold-form-input" required></textarea>
                    </div>
                </div>

                <div class="formbold-form-step-3">
                    <div class="formbold-form-confirm">
                        <p> Thank you for creating an Event. You can add further details in the next step. </p>

                    </div>
                </div>

                <div class="formbold-form-btn-wrapper">
                    <button type="button" class="formbold-back-btn"> Back </button>
                    <button type="button" class="formbold-btn"> Next Step
                        <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M10.7814 7.33312L7.20541 3.75712L8.14808 2.81445L13.3334 7.99979L8.14808 13.1851L7.20541 12.2425L10.7814 8.66645H2.66675V7.33312H10.7814Z" fill="white"/>
                        </svg>
                    </button>
                </div>
                <button type="submit" hidden>asdasd</button>
            </form>
        </div>
    </div>

      <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');
        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
        }
        body {
          font-family: "Inter", sans-serif;
        }
        .formbold-main-wrapper {
          display: flex;
          align-items: center;
          justify-content: center;
          padding: 48px;
        }

        .formbold-form-wrapper {
          margin: 0 auto;
          max-width: 550px;
          width: 100%;
          background: white;
        }

        .formbold-steps {
          padding-bottom: 18px;
          margin-bottom: 35px;
          border-bottom: 1px solid #DDE3EC;
        }
        .formbold-steps ul {
          padding: 0;
          margin: 0;
          list-style: none;
          display: flex;
          gap: 40px;
        }
        .formbold-steps li {
          display: flex;
          align-items: center;
          gap: 14px;
          font-weight: 500;
          font-size: 16px;
          line-height: 24px;
          color: #536387;
        }
        .formbold-steps li span {
          display: flex;
          align-items: center;
          justify-content: center;
          background: #DDE3EC;
          border-radius: 50%;
          width: 36px;
          height: 36px;
          font-weight: 500;
          font-size: 16px;
          line-height: 24px;
          color: #536387;
        }
        .formbold-steps li.active {
          color: #07074D;;
        }
        .formbold-steps li.active span {
          background: #6A64F1;
          color: #FFFFFF;
        }

        .formbold-input-flex {
          display: flex;
          gap: 20px;
          margin-bottom: 22px;
        }
        .formbold-input-flex > div {
          width: 50%;
        }
        .formbold-form-input {
          width: 100%;
          padding: 13px 22px;
          border-radius: 5px;
          border: 1px solid #DDE3EC;
          background: #FFFFFF;
          font-weight: 500;
          font-size: 16px;
          color: #536387;
          outline: none;
          resize: none;
        }
        .formbold-form-input:focus {
          border-color: #6a64f1;
          box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
        }
        .formbold-form-label {
          color: #07074D;
          font-weight: 500;
          font-size: 14px;
          line-height: 24px;
          display: block;
          margin-bottom: 10px;
        }

        .formbold-form-confirm {
          border-bottom: 1px solid #DDE3EC;
          padding-bottom: 35px;
        }
        .formbold-form-confirm p {
          font-size: 16px;
          line-height: 24px;
          color: #536387;
          margin-bottom: 22px;
          width: 75%;
        }
        .formbold-form-confirm > div {
          display: flex;
          gap: 15px;
        }

        .formbold-confirm-btn {
          display: flex;
          align-items: center;
          gap: 10px;
          background: #FFFFFF;
          border: 0.5px solid #DDE3EC;
          border-radius: 5px;
          font-size: 16px;
          line-height: 24px;
          color: #536387;
          cursor: pointer;
          padding: 10px 20px;
          transition: all .3s ease-in-out;
        }
        .formbold-confirm-btn {
          box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.12);
        }
        .formbold-confirm-btn.active {
          background: #6A64F1;
          color: #FFFFFF;
        }

        .formbold-form-step-1,
        .formbold-form-step-2,
        .formbold-form-step-3 {
          display: none;
        }
        .formbold-form-step-1.active,
        .formbold-form-step-2.active,
        .formbold-form-step-3.active {
          display: block;
        }

        .formbold-form-btn-wrapper {
          display: flex;
          align-items: center;
          justify-content: flex-end;
          gap: 25px;
          margin-top: 25px;
        }
        .formbold-back-btn {
          cursor: pointer;
          background: #FFFFFF;
          border: none;
          color: #07074D;
          font-weight: 500;
          font-size: 16px;
          line-height: 24px;
          display: none;
        }
        .formbold-back-btn.active {
          display: block;
        }
        .formbold-btn {
          display: flex;
          align-items: center;
          gap: 5px;
          font-size: 16px;
          border-radius: 5px;
          padding: 10px 25px;
          border: none;
          font-weight: 500;
          background-color: #6A64F1;
          color: white;
          cursor: pointer;
        }
        .formbold-btn:hover {
          box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
        }

      </style>


    <script>
        const stepMenuOne = document.querySelector('.formbold-step-menu1');
        const stepMenuTwo = document.querySelector('.formbold-step-menu2');
        const stepMenuThree = document.querySelector('.formbold-step-menu3');

        const stepOne = document.querySelector('.formbold-form-step-1');
        const stepTwo = document.querySelector('.formbold-form-step-2');
        const stepThree = document.querySelector('.formbold-form-step-3');

        const formSubmitBtn = document.querySelector('.formbold-btn');
        const formBackBtn = document.querySelector('.formbold-back-btn');

        formSubmitBtn.addEventListener("click", function(event) {
            event.preventDefault();
            if (stepMenuOne.classList.contains('active')) {
                stepMenuOne.classList.remove('active');
                stepMenuTwo.classList.add('active');

                stepOne.classList.remove('active');
                stepTwo.classList.add('active');

                formBackBtn.classList.add('active');
            } else if (stepMenuTwo.classList.contains('active')) {
                stepMenuTwo.classList.remove('active');
                stepMenuThree.classList.add('active');

                stepTwo.classList.remove('active');
                stepThree.classList.add('active');

                formBackBtn.classList.remove('active');
                formSubmitBtn.textContent = 'Submit';
            } else if (stepMenuThree.classList.contains('active')) {
                 var submitButton = document.querySelector('button[type="submit"]');
                 submitButton.click();
            }
        });

        formBackBtn.addEventListener("click", function(event) {
            event.preventDefault();
            if (stepMenuTwo.classList.contains('active')) {
                stepMenuTwo.classList.remove('active');
                stepMenuOne.classList.add('active');

                stepTwo.classList.remove('active');
                stepOne.classList.add('active');

                formBackBtn.classList.remove('active');
                formSubmitBtn.textContent = 'Next Step';
            } else if (stepMenuThree.classList.contains('active')) {
                stepMenuThree.classList.remove('active');
                stepMenuTwo.classList.add('active');

                stepThree.classList.remove('active');
                stepTwo.classList.add('active');

                formSubmitBtn.textContent = 'Next Step';
            }
        });
    </script>
