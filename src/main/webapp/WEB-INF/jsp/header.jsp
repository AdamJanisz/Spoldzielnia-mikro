<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 26.11.2019
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Chango&display=swap" rel="stylesheet">
<style>

    *
    {
        margin:0;
        padding:0;
    }


    #kontakt {
        background-color: #171a1d;
        color: white;
        padding: 5px;
        text-align: center;
        font-size: 13px;
        font-family: Verdana, sans-serif;
        height: 26px;
        line-height: 26px;
    }

    #naglowek {
        position: relative;
    }
    p.uppercaseName {
        width: 296px;
        top:50%;
        margin-top: -18px;
        left: 50%;
        margin-left:-148px;
       position: absolute;
        text-align: center;
        font-size: 36px;
        font-weight: bold;
        font-family: 'Arial Black', Helvetica, sans-serif;
        text-transform: uppercase;
    }


    #listaPoziomaHeader {
        width: 600px;
        left:50%;
        border-top: 1px solid rgba(192, 192, 192, 0.8);
        margin-left: -300px;
        position: absolute;
        top: 150px;
    }


    #listaPoziomaHeader li {
        left:10%;
        list-style-type: none;
        float: left;
        padding: 3px 7px;
        position: relative;
        height: 20px;


    }

    #listaPoziomaHeader li a {
        font-size: 16px;
        font-family: Verdana, sans-serif;
        text-decoration: none;
        display: inline-block;
        float: left;
        text-transform: uppercase;
        color: black;
    }

    #menuGorne #listaPoziomaHeader li .drugiPoziom {
        display: none;
    }

    #menuGorne #listaPoziomaHeader li:hover .drugiPoziom {

        background-color: white;
        border: 2px solid #b3b7bb;
        position: absolute;
        left: 0em;
        top: 1.5em;
        width: 9em;
        padding: 5px;
        line-height: 1em;
        display: inline-block;
        z-index: 50;
    }

    #menuGorne #listaPoziomaHeader li .drugiPoziom li {
        width: 90%;
        text-align: left;
        font-size: 10px;
        font-family: Verdana, sans-serif;
        margin-bottom: 5px;
        padding-bottom: 5px;
        display: block;
    }

    #menuGorne #listaPoziomaHeader li .drugiPoziom li a {
        font-size: 12px;
        position: absolute;
    }

    #menuGorne #listaPoziomaHeader li .drugiPoziom li:hover {
        cursor: pointer;
        background: lightgrey;
        padding-bottom: 5px;
    }

    #container {
        position: relative;
        padding: 0;
    }
</style>

</head>

<body>
<div id="container">
    <div id="naglowek">
        <div id="kontakt">Masz pytania co do stanu lokali lub wysokości czynszu? Skontaktuj się z nami: xxx@email.pl tel.: XXX XXX XXX (pon-pt: 8:00
            - 21:00)
        </div>
        <p class="uppercaseName">osiedle raj<sup>&#174</sup></p>
        <div id="menuGorne">
            <ul id="listaPoziomaHeader">
                <li><a href="#"><span><b>O nas</b></span></a>
                </li>
                <li><a href="#"><span>Nasze lokale</span></a>
                    <ul class="drugiPoziom">
                        <li><a href="#">l1</a></li>
                        <li><a href="#">l2</a></li>
                    </ul>
                </li>
                <li><a href="#"><span>Administracja</span></a>
                    <ul class="drugiPoziom">
                        <li><a href="#">Elżbieta Bąk</a></li>
                        <li><a href="#">Janusz Matejko</a></li>
                        <li><a href="#">Adam Małysz</a></li>
                    </ul>

                </li>
                <li><a href="#"><span>Zarządzaj</span></a>
                    <ul class="drugiPoziom">
                        <li><a href="#">Lokale</a></li>
                        <li><a href="#">Mieszkańcy</a></li>
                        <li><a href="#">Rachunki</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </div>
    </div><!-- naglowek -->
</body>
</html>
