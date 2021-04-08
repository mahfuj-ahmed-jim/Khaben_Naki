<?php 
    include('DB_connection.php');
    include('header.php');
?>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <script
         src="https://kit.fontawesome.com/64d58efce2.js"
         crossorigin="anonymous"
         ></script>
      
      <!-- <script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-auth.js"></script> --> <!-- firebase authentication library  -->
      <!-- <script src="https://www.google.com/recaptcha/api.js"></script> -->
      <link rel="stylesheet" href="style.css" />
      <title>Login & Sign up Form</title>
   </head>
   <body>
      <div class="container">
         <div class="forms-container">
            <div class="signin-signup">
               <form action="#" class="sign-in-form" method="post">
                  <h2 class="title">Login</h2>
                  <div class="input-field">
                     <i class="fas fa-user"></i>
                     <input type="text" placeholder="Username" name="username"/>
                  </div>
                  <div class="input-field">
                     <i class="fas fa-lock"></i>
                     <input type="password" placeholder="Password" name="password"/>
                  </div>
                  <input type="submit" value="Login" class="btn solid" />
                  <p class="social-text">Or Login with social platforms</p>
                  <div class="social-media">
                     <a href="#" class="social-icon social-icon-fb">
                     <i class="fab fa-facebook-f"></i>
                     </a>
                     <a href="#" class="social-icon social-icon-g">
                     <i class="fab fa-google"></i>
                     </a>
                  </div>
               </form>
               <form action="#" class="sign-up-form" >

                  <h2 class="title">Sign up</h2>
                  <div class="input-field">
                     <i class="fas fa-user"></i>
                     <input type="text" placeholder="Username" id="sign_up_userid" />
                  </div>
                  <div class="input-field">
                     <i class="fas fa-phone-alt"></i>
                     <input type="text" placeholder="Mobile No." id="sign_up_phone"/>
                  </div>
                  <div class="input-field">
                     <i class="fas fa-lock"></i>
                     <input type="password" placeholder="Password" id="sign_up_passward" />
                  </div>
                  <div id="recaptcha-container"></div>
                  <button type="button" class="btn" id="signupbtn" onclick="phoneAuth();"> Sign up </button>
                  <p class="social-text">Or Sign up with social platforms</p>
                  <div class="social-media">
                     <a href="#" class="social-icon social-icon-fb">
                     <i class="fab fa-facebook-f"></i>
                     </a>
                     <a href="#" class="social-icon social-icon-g">
                     <i class="fab fa-google"></i>
                     </a> 
                  </div>
               </form>
            </div>
         </div>
         <div class="panels-container">
            <div class="panel left-panel">
               <div class="content">
                  <h3>New here ?</h3>
                  <p>
                     Are you a Foodie just like us? Take a moment to sign up and join the Republic of Foodies!
                  </p>
                  <button class="btn transparent" id="sign-up-btn">
                  Sign up
                  </button>
               </div>
               <img src="img/log.svg" class="image" alt="" />
            </div>
            <div class="panel right-panel">
               <div class="content">
                  <h3>One of us ?</h3>
                  <p>
                     Already joined Khaben Naki? Please Login from here!
                  </p>
                  <button class="btn transparent" id="sign-in-btn">
                  Login
                  </button>
               </div>
               <img src="img/register.svg" class="image" alt="" />
            </div>
         </div>
      </div>

      <!-- The core Firebase JS SDK is always required and must be listed first -->
      <script src="https://www.gstatic.com/firebasejs/8.3.2/firebase.js"></script>

      <!-- TODO: Add SDKs for Firebase products that you want to use
           https://firebase.google.com/docs/web/setup#available-libraries -->
      <!-- <script src="https://www.gstatic.com/firebasejs/8.3.2/firebase-analytics.js"></script> -->

      <script>
        // Your web app's Firebase configuration
        // For Firebase JS SDK v7.20.0 and later, measurementId is optional
        var firebaseConfig = {
          apiKey: "AIzaSyAfSTmTWKlIihT7Nh2ImRKUKnTwhLS5bYg",
          authDomain: "khabennaki-81411.firebaseapp.com",
          databaseURL: "https://khabennaki-81411-default-rtdb.firebaseio.com",
          projectId: "khabennaki-81411",
          storageBucket: "khabennaki-81411.appspot.com",
          messagingSenderId: "1001394332802",
          appId: "1:1001394332802:web:ec73d5992c0d6f8244409b",
          measurementId: "G-TMXSF4CKEX"
        };
        // Initialize Firebase
        firebase.initializeApp(firebaseConfig);
        firebase.analytics();
      </script>

      <script src="verification.js"></script>
      <script src="app.js"></script>
      <div>

         <?php include('footer.php'); ?>
      </div>
   </body>
</html>
