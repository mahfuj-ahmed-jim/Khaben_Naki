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
      <script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-app.js"></script>
      <script src="https://www.gstatic.com/firebasejs/8.3.1/firebase-auth.js"></script> <!-- firebase authentication library  -->
      <script src="https://www.google.com/recaptcha/api.js"></script>
      <link rel="stylesheet" href="style.css" />
      <title>Login & Sign up Form</title>
   </head>
   <body>
      <div>
      </div>
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
               <form action="#" class="sign-up-form">
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
                  <div id = "recapthca-container"></div>
                  <button type="button" class="btn" id="signupbtn"> Sign up </button>
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
      <script>
         var signupphone = document.getElementById("signupbtn");
         var phonenumber = document.getElementById("sign_up_phone");
         var phonenumber = document.getElementById("sign_up_phone");
         
         signupphone.onclick = function(){
           window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('recaptcha-container', {
               'size': 'normal',
               'callback': (response) => {
                     // reCAPTCHA solved, allow signInWithPhoneNumber.
                     // ...
                 },
               'expired-callback': () => {
                     // Response expired. Ask user to solve reCAPTCHA again.
                     // ...
                 }
           });
         
           var recaptcha = window.recaptchaVerifier;
         
           firebase.auth().signInWithPhoneNumber(phonenumber.value,recaptcha)
           .then(function(response) {
             console.log(response);
           
           })
           .catch(function(error) {
             console.log(error);
             // Error; SMS not sent
             // ...
           });
         }
         
      </script>
      <!-- <script src="verification.js"></script> -->
      <script src="app.js"></script>
      <div>
         <?php include('footer.php'); ?>
      </div>
   </body>
</html>
