<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Running Hackathons</title>
    <link href="https://fonts.googleapis.com/css2?family=Inconsolata&family=VT323&display=swap" rel="stylesheet">
    <style>
        /* General styles that don't need scoping */
        :root {
            --background-color: #f0f0f0;
            --color-primary-light: #ca3782;
            --color-primary-dark: #1e0b36;
            --color-black: #000;
            --color-gray-dark: #aaa;
            --color-gray-light: #eee;
            --color-white: #fff;
        }

        /* Scoped styles for the card animation */
        .artboard {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 4rem;
            height: 100vh; /* Adjusted height */
            background-color: var(--background-color);
        }

        @media (max-width: 37.5em) {
            .artboard {
                padding: 1rem;
            }
        }

        .card {
            position: relative;
            height: 32rem; /* Adjusted height */
            width: 29.76rem; /* Adjusted width */
            perspective: 124rem; /* Adjusted perspective */
            margin: 2rem; /* Adjusted margin */
        }

        .card__side {
            height: 100%;
            transition: all 0.8s ease;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            backface-visibility: hidden;
            border-radius: 3px;
            overflow: hidden;
            box-shadow: 0 2rem 6rem rgba(0, 0, 0, 0.15);
        }

        .card__side--front {
            background-image: linear-gradient(to right bottom, rgba(30, 11, 54, 0.65), rgba(202, 55, 130, 0.7)), url(https://cdn.spacetelescope.org/archives/images/screen/heic0406a.jpg);
        }

        .card__side--back {
            background-color: var(--color-white);
            transform: rotateY(180deg);
        }

        .card:hover .card__side--back {
            transform: rotateY(0);
        }

        .card:hover .card__side--front {
            transform: rotateY(-180deg);
        }

        .card__theme {
            position: absolute;
            top: 54%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 90%;
            text-align: center;
        }

        .card__theme-box {
            color: var(--color-white);
            margin-bottom: 8rem;
        }

        .card__subject {
            font-family: "Inconsolata", monospace;
            letter-spacing: 0.8rem;
            font-size: 1.6rem;
            text-transform: uppercase;
            margin-bottom: 1rem;
        }

        .card__title {
            font-family: "VT323", monospace;
            text-transform: uppercase;
            font-size: 6rem;
            font-weight: 100;
        }

        .card__cover {
            position: relative;
            background-size: cover;
            height: 8rem;
            clip-path: polygon(0 0, 100% 0, 100% 85%, 0 100%);
            border-top-left-radius: 3px;
            border-top-right-radius: 3px;
            background-image: linear-gradient(to top right, rgba(30, 11, 54, 0.65), rgba(202, 55, 130, 0.65)), url(https://cdn.spacetelescope.org/archives/images/screen/heic0406a.jpg);
        }

        .card__heading {
            text-align: center;
            color: var(--color-white);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 75%;
        }

        .card__heading-span {
            font-family: "VT323", monospace;
            font-size: 2.2rem;
            font-weight: 300;
            text-transform: uppercase;
            padding: 0.8rem 1rem;
            color: var(--color-white);
        }

        .card__details {
            font-family: "Inconsolata", monospace;
            padding: 1.5rem 0.7rem;
        }

        .card__details ul {
            list-style: none;
            width: 60%;
            margin: 0 auto;
        }

        .card__details li {
            text-align: center;
            font-size: 1.1rem;
            padding: 0.6rem;
            font-weight: 400;
        }

        .card__details li:not(:last-child) {
            border-bottom: 1px solid var(--color-gray-light);
        }

        @media only screen and (max-width: 37.5em), only screen and (hover: none) {
            .card {
                height: auto;
                border-radius: 3px;
                background-color: var(--color-white);
                box-shadow: 0 2rem 6rem rgba(0, 0, 0, 0.15);
            }

            .card__side {
                height: auto;
                position: relative;
                box-shadow: none;
            }

            .card__side--front {
                clip-path: polygon(0 15%, 100% 0, 100% 100%, 0 100%);
            }

            .card__side--back {
                transform: rotateY(0);
            }

            .card:hover .card__side--front {
                transform: rotateY(0);
            }

            .card__details {
                padding: 1rem 0.8rem;
            }

            .card__theme {
                position: relative;
                top: 0;
                left: 0;
                transform: translate(0);
                width: 100%;
                padding: 5rem 4rem 1.5rem 4rem;
                text-align: right;
            }

            .card__theme-box {
                margin-bottom: 1.5rem;
            }

            .card__title {
                font-size: 2rem;
            }
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <%@ include file="../NotConfirmedUI/navbar.jsp" %>

    <div class="artboard">
        <div class="card">
            <div class="card__side card__side--back">
                <div class="card__cover">
                    <h4 class="card__heading">
                        <span class="card__heading-span">More Details</span>
                    </h4>
                </div>
                <div class="card__details">
                    <ul>
                        <li>Event ID: ${hackathon.eventId}</li>
                        <li>Event Date: ${hackathon.startDate} to ${hackathon.endDate}</li>
                        <li>Location: ${hackathon.location}</li>
                        <li>Planned Hours: ${hackathon.plannedHours}</li>
                        <li>Type: ${hackathon.eventType}</li>
                        <!-- Add more details as needed -->
                        <li>
                            <button class="run-btn">
                                <a href="addDataToEvent" style="display: flex; align-items: center; gap: 10px; background: #318CE7; border: 0.5px solid #DDE3EC; border-radius: 5px; font-size: 16px; line-height: 24px; color: white; cursor: pointer; padding: 5px 20px; transition: all .3s ease-in-out;">
                                    Add Info
                                </a>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="card__side card__side--front">
                <div class="card__theme">
                    <div class="card__theme-box">
                        <p class="card__title">${hackathon.eventName}</p>
                        <p class="card__subject">${hackathon.description}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
