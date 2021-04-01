<?php
    include('header.php'); 
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo</title>
    
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"></script>
      
      <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
     
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->

<style>
    /* cover pic */
    .over-img{
    position: absolute;
    top: -400%;
    left:40%;
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

    <h1 class="text-center pb-3" style= "color: #F15B5D;">Restaurant Information</h1>
    
    <div class="Info pics">
        <div class="cover">
            <img src="img/chillox cover.jpg" class="center" alt="Responsive image" style = "width: 100%; height: 660px; overflow: hidden;  object-fit: cover; border: 1px solid #000000; display: block;">
        </div>
        
        <div class="row text-center pb-5 pt-2">
        <div class="col-12 profile" style="padding-bottom: 50px; position: relative;">
            <img src="img/Hotqueen.png" class="rounded-circle over-img" style="width: 300px; height:300px; margin:0; border: 1px solid #000000; border-radius: 100%;">
         </div>
       </div>
</div>

<div class= "Info Text" style="padding-top: 20px;">
  <h2 class="text-center"style= "color: #F15B5D;"> Hotdog Queen</h2>
  <p class= "text-center" >Address: House-397/B 1st Floor, Shahid Baki Sarak, Chowdhury Para, Khilgaon</p>
  <p class= " text-center pt-3" style="border-top: dashed gray;"> Famous For Hotdogs |  Delivery Charge ৳30</p>
   
<div class="row pt-2 pb-2">
    <div class="col-lg-6">
  <div class="pb-4 text-center rating">
    <h5 class= "link-info pt-3"><a href="#">Ratings and Reviews:</a> <span class="text-dark"> 4.5 </span><i class=" text-warning fa fa-star"></i> </h5>
   </div>
  </div>
  <div class="col-lg-6 text-center">
      <a href=""><button class="btn btn-warning btn-lg text-dark"><i style= "color:black" class="fas fa-shopping-cart"></i>My Cart</div></button></a>
</div>  
 
</div>  

 <div class= "Menu">

     
    <h3 class="text-center">Menu</h3>


    <div class="row justify-content-center pt-3">
        <h4 class="text-center pb-2">Hotdogs</h4>

        <div class="col-lg-3 ani">
                <div class="card bg-white">
                        <img class="card-img-top" src="img/double-cheeseburger-details.png" alt="nu" style="width: 350px; height:350px;">
                        <div class="card-body">
                            <h4 class="card-title">Double CheeseBurger</h4>
                            <h5 class="card-title">Price: ৳750  </h5>
                            <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                        </div>
                </div>
         </div>
         

     <div class="col-lg-3 ">
        <div class="card bg-white ani">
                <img class="card-img-top"src="img/whooper.png" alt="ter" style="width: 350px; height:350px;">
                <div class="card-body">
                    <h4 class="card-title">Whooper</h4>
                    <h5 class="card-title">Price: ৳ 600  </h5>
                    <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                </div>
        </div>
 </div>

 <div class="col-lg-3 ani">
    <div class="card bg-white">
            <img class="card-img-top" src="img/mushroom.png" alt="da" style="width: 350px; height:350px;" >
            <div class="card-body">
                <h4 class="card-title">Double Mushroom Swiss</h4>
                <h5 class="card-title">Price: ৳ 800  </h5>
                <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
            </div>
    </div>
</div>
    </div>

    <div class="row justify-content-center pt-3">
        <h4 class="text-center pb-2">Burgers</h4>

        <div class="col-lg-3 ani">
                <div class="card bg-white">
                        <img class="card-img-top" src="img/double-cheeseburger-details.png" alt="nu" style="width: 350px; height:350px;">
                        <div class="card-body">
                            <h4 class="card-title">Double CheeseBurger</h4>
                            <h5 class="card-title">Price: ৳750  </h5>
                            <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                        </div>
                </div>
         </div>
         

     <div class="col-lg-3 ">
        <div class="card bg-white ani">
                <img class="card-img-top"src="img/whooper.png" alt="ter" style="width: 350px; height:350px;">
                <div class="card-body">
                    <h4 class="card-title">Whooper</h4>
                    <h5 class="card-title">Price: ৳ 600  </h5>
                    <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                </div>
        </div>
 </div>

 <div class="col-lg-3 ani">
    <div class="card bg-white">
            <img class="card-img-top" src="img/mushroom.png" alt="da" style="width: 350px; height:350px;" >
            <div class="card-body">
                <h4 class="card-title">Double Mushroom Swiss</h4>
                <h5 class="card-title">Price: ৳ 800  </h5>
                <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
            </div>
    </div>
</div>
    </div>



    <div class="row justify-content-center pt-3 ">
        <h4 class="text-center pb-2 pt-5">Beverages</h4>

        <div class="col-lg-3 ani">
                <div class="card bg-white">
                        <img class="card-img-top" src="img/icetea.png" alt="" style="width: 350px; height:350px;">
                        <div class="card-body">
                            <h4 class="card-title">Iced Lemon Tea</h4>
                            <h5 class="card-title">Price: ৳750  </h5>
                            <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                        </div>
                </div>
         </div>
         

     <div class="col-lg-3 ani ">
        <div class="card bg-white">
                <img class="card-img-top"src="img/fanta.png" alt="" style="width: 350px; height:350px;">
                <div class="card-body">
                    <h4 class="card-title">Panta Grape</h4>
                    <h5 class="card-title">Price: ৳ 600  </h5>
                    <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
                </div>
        </div>
 </div>

 <div class="col-lg-3 ani">
    <div class="card bg-white">
            <img class="card-img-top" src="img/milo.png" alt="" style="width: 350px; height:350px;" >
            <div class="card-body">
                <h4 class="card-title">Nilo Choco Juice</h4>
                <h5 class="card-title">Price: ৳ 800  </h5>
                <div class= "text-center pt-2"><a href=""><button type="button" class="btn btn-warning">Add to Cart</button></a></div>
            </div>
    </div>
</div>
    </div>


 </div>
 

  



   <!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script> -->

   <?php
        include('footer.php');
    ?>
</body>
</html>