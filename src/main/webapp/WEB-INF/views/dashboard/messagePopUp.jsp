<!-- Import JSTL Core Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- CSS for Custom Popup -->
<style>
  .custom-popup {
    position: fixed;
    top: 20px;
    right: 20px;
    background-color: #4CAF50;
    color: white;
    padding: 15px;
    border-radius: 5px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    z-index: 9999;
    opacity: 0; /* Hidden initially */
    transition: opacity 0.3s ease-in-out;
  }

  .custom-popup.show {
    opacity: 1;
  }

  .popup-content {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .popup-message {
    margin-right: 10px;
  }

  .close-btn {
    cursor: pointer;
    font-size: 18px;
    color: white;
    transition: color 0.3s ease-in-out;
  }

  .close-btn:hover {
    color: #ccc;
  }
</style>

<!-- Custom Popup HTML -->
<div class="custom-popup" id="customPopup">
  <div class="popup-content">
    <span class="popup-message" id="popupMessage"></span>
    <span class="close-btn" id="closePopup">&times;</span>
  </div>
</div>

<!-- JavaScript to Show/Hide Popup -->
<script>
  document.addEventListener("DOMContentLoaded", function() {
    var message = "${message}";

    if (message) {
      var popup = document.getElementById('customPopup');
      var popupMessage = document.getElementById('popupMessage');
      var closePopup = document.getElementById('closePopup');

      popupMessage.textContent = message;
      popup.classList.add('show');

      closePopup.addEventListener('click', function() {
        popup.classList.remove('show');
      });

      setTimeout(function() {
        popup.classList.remove('show');
      }, 5000); // 5000 milliseconds = 5 seconds
    }
  });
</script>