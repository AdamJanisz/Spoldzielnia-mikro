<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Bree Serif' rel='stylesheet'>
    <title>Title</title>
    <style>

        body, html {
            height: 100%;
            font-family: 'Bree Serif';font-size: 22px;
            color: black;
            margin: 0px;
        }

        .scroll{
            position: absolute;
            margin-top: 150px;
            margin-left: 20px;
            width: 400px;
            height: 500px;
            background-color: black;
            opacity: 0.7;
            border: 1px solid black;
            overflow: scroll;
            scrollbar-darkshadow-color: black;

        }

        * {
            color: black;
            box-sizing: border-box;
        }


        .topnav {
            overflow: hidden;
            background-color: rgba(192, 192, 192, 0.8);
            position: fixed;
            z-index: 1000;
        }

        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;

        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .active {
            background-color: #4CAF50;
            color: white;
        }

        .topnav .icon {
            display: none;
        }
        .error{
            padding: 20px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #af0e00;
            background-color: #8f6e74;
            border-color: #bce8f1;
        }
        .msg{
            padding: 20px;

            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #0012af;
            background-color: #31708f;
            border-color: #bce8f1;
        }

        .login-box{
            width: 300px;
            padding: 20px;
            margin: 10px auto;

        }

        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child) {display: none;}
            .topnav a.icon {
                float: right;
                display: block;
            }
        }

        @media screen and (max-width: 600px) {
            .topnav.responsive {position: relative;}
            .topnav.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .topnav.responsive a {
                float: none;
                display: block;
                text-align: left;
            }
        }


        .content {
            position: absolute;
            left: 50%;
            top: 40%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }

        .img-circular{

            width: 1000px;
            height: 600px;
            background-position: center;
            background-size:cover;
            display: block;
            border-radius: 50%;
            opacity: 1;

        }
        .img-circular1{

            width: 800px;
            height: 400px;
            background-position: center;
            background-size:cover;
            display: block;
            border-radius: 50%;
            opacity: 1;



        }

        .bg-img {
            /* The image used */
            background: rgba(235, 235, 235, 1);

            height: 100%;
            width: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
            color: white;

        }

        /* Add styles to the form container */
        .container {
            position: center;



            max-width: 450px;
            padding: 16px;
            background: rgba(0,0,0,0);

        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 5px 0;
            border: 2px solid black;
            background: #f1f1f1;
            opacity: 0.7;
        }
        .col_white{
            background: rgba(0,0,0,0);
            color: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: white;
            outline: none;
            opacity: 0.7;
        }
        .vertical-center {
            margin: 0;
            position: absolute;
            top: 50%;
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
        }

        /* Set a style for the submit button */
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.7;
        }

        .btn:hover {
            opacity: 1;
        }

        #infoBox
        {
            position: absolute;
            right: 25px;
            top:40px;
            width: 300px;
            height: 420px;
            border: 2px dotted black;
        }

    </style>
</head>
    <c:if test="${pageContext.request.userPrincipal.name == null}">

<body onload='document.loginForm.username.focus();'>




</div>
</body>
</c:if>


</html>
