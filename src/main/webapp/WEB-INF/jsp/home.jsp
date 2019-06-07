<!DOCTYPE html>
<html lang="en">
<head>
    <title>CSS Website Layout</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        /* Style the header */
        .header {
            background-color: #f1f1f1;
            padding: 50px;
            text-align: center;
        }
        .container {
            position: relative;
            width: 100%;
            max-width: 400px;
        }

        .container img {
            width: 100%;
            height: auto;
        }

        .container .btn {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            background-color: #f1f1f1;
            color: black;
            font-size: 16px;
            padding: 16px 30px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            text-align: center;
        }

        .container .btn:hover {
            background-color: black;
            color: white;
        }
        .button {
            display: inline-block;
            border-radius: 4px;
            background-color: #00BFFF;
            border: none;
            color: #FFFFFF;
            text-align: center;
            font-size: 28px;
            padding: 20px;
            width: 500px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 5px;
        }

        .button span {
            cursor: pointer;
            display: inline-block;
            position: relative;
            transition: 0.5s;
        }

        .button span:after {
            content: '\00bb';
            position: absolute;
            opacity: 0;
            top: 0;
            right: -20px;
            transition: 0.5s;
        }

        .button:hover span {
            padding-right: 25px;
        }

        .button:hover span:after {
            opacity: 1;
            right: 0;
        }

        /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
        @media screen and (max-width:600px) {
            .column {
                width: 100%;
                text-align: center;
                background-color: #00BFFF;
            }
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Calculator consumption of Petrol with database</h1>
    <p>Individual Project by Jakub Grygiel</p>
</div>

<br/>
<br/>
</div>
<div class="column">
    <div style="text-align:center;">
        <a href="/list">
            <button class="button" style="vertical-align:middle"><span>Click here to enter! </span></button>
        </a>
    </div>
</div>



</body>
</html>
