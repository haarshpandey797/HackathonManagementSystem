<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  /* style.css */
  @import url("https://fonts.googleapis.com/css2?family=Inter:wght@200;300;400;500;600;700&display=swap");

  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Inter", sans-serif;
  }

  :root {
    --dark-grey: #333333;
    --medium-grey: #636363;
    --light-grey: #eeeeee;
    --ash: #f4f4f4;
    --primary-color: #2b72fb;
    --white: white;
    --border: 1px solid var(--light-grey);
    --shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px,
      rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
  }

  body {
    font-family: inherit;
    background-color: var(--white);
    color: var(--dark-grey);
    letter-spacing: -0.4px;
  }

  ul {
    list-style: none;
  }

  a {
    text-decoration: none;
    color: inherit;
  }

  button {
    border: none;
    background-color: transparent;
    cursor: pointer;
    color: inherit;
  }

  .btn {
    display: block;
    background-color: #318CE7;
    color: var(--white);
    text-align: center;
    padding: 0.6rem 1.4rem;
    font-size: 1rem;
    font-weight: 500;
    border-radius: 5px;
  }

  .icon {
    padding: 0.5rem;
    background-color: var(--light-grey);
    border-radius: 10px;
  }

  .logo {
    margin-right: 1.5rem;
  }

  #nav-menu {
    border-bottom: var(--border);
  }

  .container {
    display: flex;
    align-items: center;
    justify-content: space-between;
    column-gap: 2rem;
    height: 90px;
    padding: 1.2rem 3rem;
  }

  .menu {
    position: relative;
    background: var(--white);
  }

  .menu-bar li:first-child .dropdown {
    flex-direction: initial;
  }

  .menu-bar li:first-child ul:nth-child(1) {
    border-right: var(--border);
  }

  .menu-bar li:nth-child(n + 2) ul:nth-child(1) {
    border-bottom: var(--border);
  }

  .menu-bar .dropdown-link-title {
    font-weight: 600;
  }

  .menu-bar .nav-link {
    font-size: 1rem;
    font-weight: 500;
    letter-spacing: -0.6px;
    padding: 0.3rem;
    min-width: 60px;
    margin: 0 0.6rem;
  }

  .menu-bar .nav-link:hover,
  .dropdown-link:hover {
    color: var(--primary-color);
  }

  .nav-start,
  .nav-end,
  .menu-bar,
  .right-container,
  .right-container .search {
    display: flex;
    align-items: center;
  }

  .dropdown {
    display: flex;
    flex-direction: column;
    min-width: 230px;
    background-color: var(--white);
    border-radius: 10px;
    position: absolute;
    top: 36px;
    z-index: 1;
    visibility: hidden;
    opacity: 0;
    transform: scale(0.97) translateX(-5px);
    transition: 0.1s ease-in-out;
    box-shadow: var(--shadow);
  }

  .dropdown.active {
    visibility: visible;
    opacity: 1;
    transform: scale(1) translateX(5px);
  }

  .dropdown ul {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    padding: 1.2rem;
    font-size: 0.95rem;
  }

  .dropdown-btn {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 0.15rem;
  }

  .dropdown-link {
    display: flex;
    gap: 0.5rem;
    padding: 0.5rem 0;
    border-radius: 7px;
    transition: 0.1s ease-in-out;
  }

  .dropdown-link p {
    font-size: 0.8rem;
    color: var(--medium-grey);
  }

  .right-container {
    display: flex;
    align-items: center;
    column-gap: 1rem;
  }

  .right-container .search {
    position: relative;
  }

  .right-container img {
    border-radius: 50%;
  }

  .search input {
    background-color: var(--ash);
    border: none;
    border-radius: 6px;
    padding: 0.7rem;
    padding-left: 2.4rem;
    font-size: 16px;
    width: 100%;
    border: var(--border);
  }

  .search .bx-search {
    position: absolute;
    left: 10px;
    top: 50%;
    font-size: 1.3rem;
    transform: translateY(-50%);
    opacity: 0.6;
  }

  #hamburger {
    display: none;
    padding: 0.1rem;
    margin-left: 1rem;
    font-size: 1.9rem;
  }

  @media (max-width: 1100px) {
    #hamburger {
      display: block;
    }

    .container {
      padding: 1.2rem;
    }

    .menu {
      display: none;
      position: absolute;
      top: 87px;
      left: 0;
      min-height: 100vh;
      width: 100vw;
    }

    .menu-bar li:first-child ul:nth-child(1) {
      border-right: none;
      border-bottom: var(--border);
    }

    .dropdown {
      display: none;
      min-width: 100%;
      border: none !important;
      border-radius: 5px;
      position: static;
      top: 0;
      left: 0;
      visibility: visible;
      opacity: 1;
      transform: none;
      box-shadow: none;
    }

    .menu.show,
    .dropdown.active {
      display: block;
    }

    .dropdown ul {
      padding-left: 0.3rem;
    }

    .menu-bar {
      display: flex;
      flex-direction: column;
      align-items: stretch;
      row-gap: 1rem;
      padding: 1rem;
    }

    .menu-bar .nav-link {
      display: flex;
      justify-content: space-between;
      width: 100%;
      font-weight: 600;
      font-size: 1.2rem;
      margin: 0;
    }

    .menu-bar li:first-child .dropdown {
      min-width: 100%;
    }

    .menu-bar > li:not(:last-child) {
      padding-bottom: 0.5rem;
      border-bottom: var(--border);
    }
  }

  @media (max-width: 600px) {
    .right-container {
      display: none;
    }
  }
</style>
<header id="nav-menu" aria-label="navigation bar">
  <div class="container">
    <div class="nav-start">
      <a class="logo" href="/">
        <img
          src="https://upload.wikimedia.org/wikipedia/commons/c/c1/Hackathon_logo.jpg"
          width="35"
          height="35"
          alt="Inc Logo"
        />
      </a>
      <nav class="menu">
        <ul class="menu-bar">
          <li>
            <button
              class="nav-link dropdown-btn"
              data-dropdown="dropdown1"
              aria-haspopup="true"
              aria-expanded="false"
              aria-label="browse"
            >
              Hackathons
              <i class="bx bx-chevron-down" aria-hidden="true"></i>
            </button>
            <div id="dropdown1" class="dropdown">
              <ul role="menu">
                <li role="menuitem">
                  <a class="dropdown-link" href="runningHackathons">
<?xml version="1.0" ?><svg enable-background="new 0 0 128 128" height=37 width=37 id="Layer_1" version="1.1" viewBox="0 0 128 128" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="  M105,109V25c0-2.2091389-1.790863-4-4-4H85c-2.209137,0-4,1.7908611-4,4v84" fill="none" stroke="#00AEEF" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="4"/><path d="  M73,109V53c0-2.2091408-1.790863-4-4-4H53c-2.2091408,0-4,1.7908592-4,4v56" fill="none" stroke="#00AEEF" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="4"/><path d="  M41,109V81c0-2.209137-1.7908592-4-4-4H21c-2.2091389,0-4,1.790863-4,4v28" fill="none" stroke="#00AEEF" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="4"/><line fill="none" stroke="#00AEEF" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="4" x1="9" x2="113" y1="109" y2="109"/></svg>

                    <div>
                      <span class="dropdown-link-title"
                        >Running Hackathons</span
                      >
                      <p>In Progress</p>
                    </div>
                  </a>
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="pastHackathons" >
                    <?xml version="1.0" ?><svg viewBox="0 0 512 512" height=37 width=37 xmlns="http://www.w3.org/2000/svg"><defs><style>.cls-1{fill:#00659d;}.cls-2{fill:#bdecdc;}.cls-3{fill:#338dbf;}.cls-4{fill:#59cea7;}.cls-5{fill:#cbe2ef;}.cls-6{fill:#46c89d;}.cls-7{fill:#a1c9bc;}.cls-8{fill:#2c78a3;}.cls-9{fill:#4cb08e;}.cls-10{fill:#00b378;}.cls-11{fill:#096;}</style></defs><title/><g data-name="/ FILLED_OUTLINE" id="_FILLED_OUTLINE"><path class="cls-1" d="M56,144H408a32,32,0,0,1,32,32V456.00006A31.99994,31.99994,0,0,1,408.00006,488H56a32,32,0,0,1-32-32V176a32,32,0,0,1,32-32Z"/><path class="cls-2" d="M435.31372,75.31372,388.68628,28.68628A15.99933,15.99933,0,0,0,377.37256,24H128a16.00008,16.00008,0,0,0-16,16V224H440V86.62744A15.99967,15.99967,0,0,0,435.31372,75.31372Z"/><path class="cls-3" d="M456,216H120a32,32,0,0,0-32,32V456a32.00012,32.00012,0,0,1-31.99994,32H456a32.00018,32.00018,0,0,0,32-32V248A32,32,0,0,0,456,216Z"/><rect class="cls-4" height="16" width="232" x="136" y="96"/><rect class="cls-4" height="16" width="280" x="136" y="136"/><rect class="cls-4" height="16" width="280" x="136" y="176"/><rect class="cls-4" height="16" width="216" x="136" y="56"/><path class="cls-5" d="M241.14014,307.88379l-15.61335,26.02246a64.01224,64.01224,0,0,1,96.59089-68.06445l8.543-13.5293A79.98448,79.98448,0,0,0,209.20532,333.794l-21.08911-12.6543-8.23242,13.7207,46.86035,28.11524,28.11572-46.85938Z"/><path class="cls-5" d="M396.11621,305.13965l-46.86035-28.11524-28.11572,46.85938,13.71972,8.23242,15.61768-26.02978a64.01647,64.01647,0,0,1-96.93311,67.85791L244.918,387.419A80.01236,80.01236,0,0,0,368,320a80.76338,80.76338,0,0,0-1.17114-13.77344l21.05493,12.63379Z"/><path class="cls-6" d="M435.31372,75.31372,388.68628,28.68628A15.99933,15.99933,0,0,0,377.37256,24H376V64a16.00008,16.00008,0,0,0,16,16h46.54364A15.97424,15.97424,0,0,0,435.31372,75.31372Z"/><path class="cls-7" d="M431.682,80A192.06632,192.06632,0,0,1,248,216H439.99982V86.62744A15.97788,15.97788,0,0,0,438.54352,80Z"/><path class="cls-8" d="M216.00024,488.15479H456a32.00018,32.00018,0,0,0,32-32v-208A32.03988,32.03988,0,0,0,486.94781,240C474.868,379.05176,358.18512,488.15479,216.00024,488.15479Z"/><path class="cls-9" d="M416,152V136H403.93341a192.905,192.905,0,0,1-12.84454,16Z"/><path class="cls-9" d="M341.009,192H416V176H365.289A192.23423,192.23423,0,0,1,341.009,192Z"/><rect class="cls-10" height="32" rx="15.99998" width="256" x="160" y="424"/><polygon class="cls-4" points="316.686 456 339.314 456 371.314 424 348.686 424 316.686 456"/><polygon class="cls-4" points="268.686 456 291.314 456 323.314 424 300.686 424 268.686 456"/><polygon class="cls-4" points="220.686 456 243.314 456 275.314 424 252.686 424 220.686 456"/><path class="cls-4" d="M172.97992,455.70605A16.02754,16.02754,0,0,0,176,456h19.314l32-32H204.686Z"/><path class="cls-11" d="M399.91382,424H391.176A272.49156,272.49156,0,0,1,344,456h55.91382a16.00008,16.00008,0,0,0,16-16h0A16.00008,16.00008,0,0,0,399.91382,424Z"/><path d="M456,208h-8V86.62695a23.84385,23.84385,0,0,0-7.02979-16.9707l-46.627-46.62695A23.84254,23.84254,0,0,0,377.37256,16H128a24.02718,24.02718,0,0,0-24,24v96H56a40.04552,40.04552,0,0,0-40,40V456a40.04552,40.04552,0,0,0,40,40H456a40.04552,40.04552,0,0,0,40-40V248A40.04552,40.04552,0,0,0,456,208ZM384,35.314,420.686,72H392a8.00917,8.00917,0,0,1-8-8ZM120,40a8.00917,8.00917,0,0,1,8-8H368V64a24.02718,24.02718,0,0,0,24,24h40V208H120ZM80,456a24,24,0,0,1-48,0V176a24.0275,24.0275,0,0,1,24-24h48v59.3501A40.05181,40.05181,0,0,0,80,248Zm400,0a24.0275,24.0275,0,0,1-24,24H87.981A39.79461,39.79461,0,0,0,96,456V248a24.0275,24.0275,0,0,1,24-24H456a24.0275,24.0275,0,0,1,24,24Z"/><rect height="16" width="232" x="136" y="96"/><rect height="16" width="280" x="136" y="136"/><rect height="16" width="280" x="136" y="176"/><rect height="16" width="216" x="136" y="56"/><path d="M254.85986,316.11621l-13.71972-8.23242-15.61335,26.02246a64.01224,64.01224,0,0,1,96.59089-68.06445l8.543-13.5293A79.98448,79.98448,0,0,0,209.20532,333.794l-21.08911-12.6543-8.23242,13.7207,46.86035,28.11524Z"/><path d="M334.85986,332.11621l15.61768-26.02978a64.01647,64.01647,0,0,1-96.93311,67.85791L244.918,387.419A80.01236,80.01236,0,0,0,368,320a80.76338,80.76338,0,0,0-1.17114-13.77344l21.05493,12.63379,8.23242-13.7207-46.86035-28.11524-28.11572,46.85938Z"/><path d="M400,416H176a24,24,0,0,0,0,48H400a24,24,0,0,0,0-48ZM180.686,448H176a8,8,0,0,1,0-16h20.686Zm48,0H203.314l16-16H244.686Zm48,0H251.314l16-16H292.686Zm48,0H299.314l16-16H340.686ZM400,448H347.314l16-16H400a8,8,0,0,1,0,16Z"/></g></svg>

                    <div>
                      <span class="dropdown-link-title">Past Hackathons</span>
                      <p>View All</p>
                    </div>
                  </a>
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="createHackathons">
                  <?xml version="1.0" ?><svg height="37" viewBox="0 0 60 60" width="37" xmlns="http://www.w3.org/2000/svg"><defs><style>
                        .cls-1 {
                          fill: #699f4c;
                          fill-rule: evenodd;
                        }
                      </style></defs><path class="cls-1" d="M1080,270a30,30,0,1,1,30-30A30,30,0,0,1,1080,270Zm14-34h-10V226a4,4,0,0,0-8,0v10h-10a4,4,0,0,0,0,8h10v10a4,4,0,0,0,8,0V244h10A4,4,0,0,0,1094,236Z" id="add" transform="translate(-1050 -210)"/></svg>
                    <div>
                      <span class="dropdown-link-title"
                        >Create a Hackathon</span
                      >
                      <p>Create new</p>
                    </div>
                  </a>
                </li>
              </ul>
            </div>
          </li>
          <li>
            <button
              class="nav-link dropdown-btn"
              data-dropdown="dropdown2"
              aria-haspopup="true"
              aria-expanded="false"
              aria-label="discover"
            >
              Teams
              <i class="bx bx-chevron-down" aria-hidden="true"></i>
            </button>
            <div id="dropdown2" class="dropdown">
              <ul role="menu">
                <li role="menuitem">
                  <a href="createTeam" class="dropdown-link">Create Team</a>
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="bulkUploadTeams">Upload Team</a>
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="viewAllTeam"
                    >View All Team</a>
                </li>
              </ul>
            </div>
          </li>
          <li>
            <button
              class="nav-link dropdown-btn"
              data-dropdown="dropdown3"
              aria-haspopup="true"
              aria-expanded="false"
              aria-label="participants"
            >
              Participants
              <i class="bx bx-chevron-down" aria-hidden="true"></i>
            </button>
            <div id="dropdown3" class="dropdown">
              <ul role="menu">
                <li role="menuitem">
                  <a href="createParticipants" class="dropdown-link">Create Participant</a>
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="uploadParticipants"
                    >Upload Participants</a
                  >
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="viewAllParticipants"
                    >View All Participants</a
                  >
                </li>
              </ul>
            </div>
          </li>
          <li>
            <button
              class="nav-link dropdown-btn"
              data-dropdown="dropdown4"
              aria-haspopup="true"
              aria-expanded="false"
              aria-label="problems"
            >
              Problem Statements
              <i class="bx bx-chevron-down" aria-hidden="true"></i>
            </button>
            <div id="dropdown4" class="dropdown">
              <ul role="menu">
                <li role="menuitem">
                  <a href="createProblemStatement" class="dropdown-link">Create Problem</a>
                </li>
                <li role="menuitem">
                  <a  href="bulkUploadProblems"
                    >Upload Problems</a
                  >
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="viewAllProblemStatement"
                    >View All Problems</a
                  >
                </li>
              </ul>
            </div>
          </li>
          <li>
            <button
              class="nav-link dropdown-btn"
              data-dropdown="dropdown5"
              aria-haspopup="true"
              aria-expanded="false"
              aria-label="problems"
            >
              Judges
              <i class="bx bx-chevron-down" aria-hidden="true"></i>
            </button>
            <div id="dropdown5" class="dropdown">
              <ul role="menu">
              <li role="menuitem">
               <a class="dropdown-link" href="createJudge"
               >Create Judges</a>
               </li>

                <li role="menuitem">
                  <a class="dropdown-link" href="bulkUploadJudges"
                    >Upload Judges</a
                  >
                </li>
                <li role="menuitem">
                  <a class="dropdown-link" href="viewAllJudge"
                    >View All Judges</a
                  >
                </li>
              </ul>
            </div>
          </li>
        </ul>
      </nav>
    </div>

    <div class="nav-end">
      <div class="right-container">
        <form class="search" role="search">
          <input type="search" name="search" placeholder="Search" />
          <i class="bx bx-search" aria-hidden="true"></i>
        </form>
        <button class="btn btn-secondary">Profile</button>
      </div>
      <button
        id="hamburger"
        aria-label="hamburger"
        aria-haspopup="true"
        aria-expanded="false"
      >
        <i class="bx bx-menu" aria-hidden="true"></i>
      </button>
    </div>
  </div>
</header>

<!-- Page markup: Not important -->

<script>
  const dropdownBtn = document.querySelectorAll(".dropdown-btn");
  const dropdown = document.querySelectorAll(".dropdown");
  const hamburgerBtn = document.getElementById("hamburger");
  const navMenu = document.querySelector(".menu");
  const links = document.querySelectorAll(".dropdown a");

  function setAriaExpandedFalse() {
    dropdownBtn.forEach((btn) => btn.setAttribute("aria-expanded", "false"));
  }

  function closeDropdownMenu() {
    dropdown.forEach((drop) => {
      drop.classList.remove("active");
      drop.addEventListener("click", (e) => e.stopPropagation());
    });
  }

  function toggleHamburger() {
    navMenu.classList.toggle("show");
  }

  dropdownBtn.forEach((btn) => {
    btn.addEventListener("click", function (e) {
      const dropdownIndex = e.currentTarget.dataset.dropdown;
      const dropdownElement = document.getElementById(dropdownIndex);

      dropdownElement.classList.toggle("active");
      dropdown.forEach((drop) => {
        if (drop.id !== btn.dataset["dropdown"]) {
          drop.classList.remove("active");
        }
      });
      e.stopPropagation();
      btn.setAttribute(
        "aria-expanded",
        btn.getAttribute("aria-expanded") === "false" ? "true" : "false"
      );
    });
  });

  // close dropdown menu when the dropdown links are clicked
  links.forEach((link) =>
    link.addEventListener("click", () => {
      closeDropdownMenu();
      setAriaExpandedFalse();
      toggleHamburger();
    })
  );

  // close dropdown menu when you click on the document body
  document.documentElement.addEventListener("click", () => {
    closeDropdownMenu();
    setAriaExpandedFalse();
  });

  // close dropdown when the escape key is pressed
  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape") {
      closeDropdownMenu();
      setAriaExpandedFalse();
    }
  });

  // toggle hamburger menu
  hamburgerBtn.addEventListener("click", toggleHamburger);
</script>
