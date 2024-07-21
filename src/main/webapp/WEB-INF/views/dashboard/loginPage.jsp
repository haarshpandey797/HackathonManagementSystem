<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <style>
        .body {
         font-family: Roboto, sans-serif;
            overflow: hidden;
        }

        .container {
            font-family: Roboto, sans-serif;
            display: flex;
            flex-direction: row;
            height: 100vh;
            overflow: hidden;
        }

        .left {
            padding: 10px;
            position: relative;
            overflow: hidden;
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center; /* Center the images vertically */
            margin-top: 0px;
        }

        .left img {
            max-width: 100%;
            margin-bottom: 20px; /* Space between the images */
        }

        .right {
            flex: 1;
            overflow: hidden;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            background: hsl(218deg 50% 91%);
            margin-top: 0px;
        }

        .right h1 {
            margin-top: 60px;
            color:black;
        }

        .login-form {
            width: 300px;
            padding: 40px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            text-align: center;
        }

        .login-form input[type="text"],
        .login-form input[type="password"],
        .login-form input[type="submit"] {
            width: 100%;
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-sizing: border-box;
            font-size: 18px;
        }

        .login-form input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }

        @media screen and (max-width: 768px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
                top: 0; /* Reset top position for smaller screens */
                border-right: none; /* Remove border for smaller screens */
            }
            .content {
                margin-left: 0;
            }
        }

        .content {
            flex-grow: 1;
            padding: 10px;
            background-color: #f8f9fa;
            margin-top: 30px;
            transition: margin-left 0.3s;
            width: 80%;
            margin-left: 0px;
            padding-top: 56px; /* Height of the navbar */
            background-image: url('https://t3.ftcdn.net/jpg/02/83/03/80/360_F_283038002_b0lUl4BSXEEICv0VIZX2Em6mAQe8vMkN.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            overflow: auto;
            padding: 20px;
        }

        .content1 {
            flex-grow: 1;
            padding: 15px;
            background-color: #f8f9fa;
            margin-top: 50px;
            transition: margin-left 0.3s;
            width: 100%;
            margin-left: 0px;
            padding-top: 56px; /* Height of the navbar */
            background-image: url('https://www.startupterminal.com/wp-content/uploads/2021/06/nucleus-software.jpg');
            background-size: cover;
            background-position: center;
            height: 100px;
            overflow: auto;
            padding: 20px;
        }


    </style>
</head>

<body>
    <div class="container">
        <div class="left">
            <div class="content1"></div>
            <div class="content"></div>
            </div>

        <div class="right">
            <h1>Hack-It</h1>
            <form class="login-form" action="login" method="post">
                <h2>Login Here</h2>
                <input type="text" name="username" placeholder="Username" required />
                <input type="password" name="password" placeholder="Password" required />
                <input type="submit" value="Submit" />
            </form>
        </div>
    </div>

</body>

</html>