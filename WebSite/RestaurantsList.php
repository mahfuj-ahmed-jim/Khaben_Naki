<?php 
  include('header.php');
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Demo</title>
   <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
      <script
        src="https://kit.fontawesome.com/64d58efce2.js"
        crossorigin="anonymous"></script>
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
       
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
         -->
   <style>
      /* cover pic */
      .over-img{
      position: absolute;
      top: -270%;
      left:37%;
      }
      .ani{
      transition: transform 0.5s;
      }
      .ani:hover{
      transform: translateY(-8px);
      }
   </style>
</head>
<body>
   <h1 class="text-center pb-5 pt-5" style= "color: #F15B5D;">Restaurants List</h1>
   <div class="row justify-content-center pb-5">
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/hotdogcover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/Hotqueen.png" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Hotdog Queen</h4>
               <h6 class="card-text">Famous For Hotdogs |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 4.5 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href="Restaurant.php">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/pizzacover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/pizzatime.png" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Pizza Time</h4>
               <h6 class="card-text">Famous For Pizzas |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 4.0 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="row justify-content-center pt-5 pb-5">
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/chillox cover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/Krustykrab.png" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Krusty Krab</h4>
               <h6 class="card-text">Famous For Burgers |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 3.5 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/cof cover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/starducks.jpg" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Starducks Coffees</h4>
               <h6 class="card-text">Famous For Coffees |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 3.0 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="row justify-content-center pt-5 pb-5">
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/banglacover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/Pakghor.jpg" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Pakghor</h4>
               <h6 class="card-text">Famous For Deshi Foods |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 3.5 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/chinesecover.jpeg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/HakkaWakka.jpg" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Hakka Wakka</h4>
               <h6 class="card-text">Famous For Chinese Foods |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 3.0 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="row justify-content-center pt-5 pb-5">
      <div class="col-lg-5 ani justify-content-center">
         <div class="card bg-white" style="border: rgba(35, 35, 35, 0.415) 1px solid; width: 650px;">
            <div class="Info pics">
               <div class="cover">
                  <img src="img/kababcover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 270px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
               </div>
               <div class="row text-center pb-3">
                  <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
                     <img src="img/Diamond Kabab.jpg" class="rounded-circle over-img" style="width: 200px; height: 200px; margin:0; border: 1px solid #000000; border-radius: 100%;">
                  </div>
               </div>
            </div>
            <div class="card-body">
               <h4 class="card-title">Diamond Kabab House</h4>
               <h6 class="card-text">Famous For Kababs |  Delivery Charge ৳30</h6>
               <h6 class="card-text">Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</h6>
               <h5 class="card-title">
                  <div class="pb-4 rating">
                     <h6>Rating:<span class="text-dark"> 3.5 </span><i class=" text-warning fa fa-star"></i></h6>
                  </div>
               </h5>
               <div class= "text-center pt-2">
                  <a href href="">
                     <h6><button type="button" class="btn btn-warning btn-lg">Visit</button>
                  </a>
                  </h6>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!--     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script> -->
   <?php include('footer.php') ?>
</body>
</html>