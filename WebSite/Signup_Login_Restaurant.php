<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
    <style>
        .account-page{
            padding: 50px 0;
            /* background: radial-gradient(#fff, #FDBAAD); */
        }
        
        .form-container{
            background: #fff;
            width: 500px;
            height: 700px;
            position: relative;
            text-align: center;
            padding: 20px 0;
            margin-left: 200px;
            /* margin: auto; */
            box-shadow: 0 0 20px 0px rgba(0,0,0,0.1);
            overflow: hidden;
        
        }
        
        .form-container span{
            font-weight: bold;
            padding: 0 10px;
            color: rgb(0, 0, 0);
            cursor: pointer;
            width: 100px;
            display: inline-block;
        
        }
        
        .form-btn{
            display: inline-block;
        
        }
        
        .form-btn span:hover{
            color: #F15B5D;
        }
        .form-container form{
            max-width: 500px;
            padding:  0 20px;
            position: absolute;
            top: 130px;
            transition: transform 1s;
        }
        
        form input{
            width: 100%;
            height: 30px;
            margin: 10px 0;
            padding: 0 10px;
            border: 1px solid #ccc;
        }
        
        form .btn{
            width: 25%;
            border: none;
            cursor: pointer;
            margin: 10px 0;
            background: #F15B5D;
            color: #fff;
        }
        
        form .btn:focus{
            outline: none;
        }
        
        #LoginForm{
            left: -500px;
        }
        #SignupForm{
            left: 0;
        }
            
        form a{
            font-size: 12px;
        }
        
        #Indicator{
            width: 52%;
            border: none;
            background: #F15B5D;
            height: 5px;
            margin-top: 8 px;
            transform: translateX(100px);
            transition: transform 1s;
        }
        
    </style>

</head>

<body>
    <div class="account-page">
        <div class="container-fluid">
            <div class="row">

                <div class="col-lg-6">
                    <h1 class="text-center" style="font-family: 'Dancing Script', cursive; right: 100%; padding-left: 100px; padding-top: 50px;"><img src="img/cook.svg" alt="" style=" width: 500px;">
                </div>

                <div class="col-lg-5">
                    <div class="form-container">
                        <div class="form-btn">
                            <span onclick="Login()">Login</span>
                            <span onclick="Signup()">Sign Up</span>
                            <hr id="Indicator">
                        </div>
                        <form id="LoginForm">
                           
                            <h4 class="pb-3">Welcome Back!</h4>

                            <input type="text" placeholder="Username">

                            <input type="password" placeholder="Password">

                            <button type="submit" class="btn mt-3">Login</button>
                            <br><a href="#">Forgot Password</a>

                        </form>

                        <form id="SignupForm">
                            
                            <h4 class="pb-3">Join and Earn with us!</h4>

							<input type="text" placeholder="Restaurant Name"/>

                            <input type="text" placeholder="Owner's Name"/>

                            <input type="number" placeholder="Phone No:">

							<input type="text" placeholder="Address"/>

                            <input type="number" placeholder="Restaurant License Number">

							<input type="password" placeholder="Password">

                            <input type="password" placeholder="Confirm Password">

                            <button type="submit" class="btn mt-5">Signup</button>

                        </form>
                    </div>
                </div>




            </div>
        </div>
    </div>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


    <script>
        var LoginForm = document.getElementById("LoginForm");
        var SignupForm= document.getElementById("SignupForm");
        var Indicator = document.getElementById("Indicator");
        
        function Signup(){
            SignupForm.style.transform = "translateX(0px)";
            LoginForm.style.transform = "translateX(0px)";
            Indicator.style.transform = "translateX(100px)";
        }
        
        function Login(){
            SignupForm.style.transform = "translateX(500px)";
            LoginForm.style.transform = "translateX(500px)";
            Indicator.style.transform = "translateX(0px)";
        }
        
    </script>



</body>

</html>