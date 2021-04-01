<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"></script>
      
      <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
     
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
      
    <style>
        .nav {
          height:110px;
        }
        .navbar-nav {
          margin:auto;
        }
        .nav-link {
          margin:10px 20px;
          color:#fff;
        }
        .custom-toggler .navbar-toggler-icon{
          background-image: url(
          "data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(241, 91, 93, 0.9)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E");
        }
        .nav-link:hover {
          color:#F15B5D;
        }
        .dropdown-item{
          color: #fff;
        }
        .dropdown-item:hover{
          background-color:#F15B5D;
          color: #fff;
        }

        .box {
          width:100%;
          height:30px;
          background-color:#000;
          position:relative;
        }
        .box-1 {
          width:50%;
          background-color:#fff;
          height:100%;
          /* border-radius:0px 1000px 0px 0px; */
          border-top:5px solid #F15B5D;
          border-right:0px solid #F15B5D;
        }
        .box-2 {
         position:absolute;
         background-color:#fff;
         height:100%;
         width:50%;
         right:0;
         top:0;
         /* border-radius:1000px 0px 0px 0px; */
         border-top:5px solid #F15B5D;
         border-left:0px solid #F15B5D;
        }
    </style>

</head>
<body>
    <header>
          <div class="cont" style="padding-bottom: 100px;">
            <div style="background-color: black;">
                
              <img src="img/khabennaki-dark.png" alt="logo" href="#" style="display: block; margin-left: auto; margin-right: auto; width: 170px;">
            
            </div>

            <nav class="navbar navbar-expand-lg" style="background-color: black; color: white;">
                <button class="navbar-toggler custom-toggler" style="border-color: black;" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="index.php">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Hot Deals</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Restaurant.php">Restaurants</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Posts</a>
                </li>
                
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Earn With Khaben Naki</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="background-color: black; margin-left: 30px;">
                      <a class="dropdown-item" href="#">Run your Restaurant</a>
                      <a class="dropdown-item" href="#">Become a Rider</a>
                      <a class="dropdown-item" href="#">Be a Top Foodie</a>
                    </div>
                  </li>
                  
                  <form class="form-inline my-2 my-lg-0" id="srch" style=" padding-top: 10px;">
                    <input class="form-control mr-sm-2"  type="search" placeholder="Search" aria-label="Search">
                  </form>
                  <button style= "width: 40px; height: 40px; margin-top: 10px; background-color: black; color:#F15B5D;"><i class="fas fa-search"></i></button>
          
                  <li class="nav-item dropdown navbar-right" style="margin-left: 200px; float: right;">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Signup/Login</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" style="background-color: black; margin-left: 20px;">
                      <a class="dropdown-item" href="Signin_Login.php">As a Foodie</a>
                      <a class="dropdown-item" href="#">As a Restaurant</a>
                      <a class="dropdown-item" href="#">As a Rider</a>
                    </div>
                  </li>
              
              
              
                </ul>
            </div>
          </nav>

          <div class="box">
            <div class="box-1"></div>
            <div class="box-2"></div>
          </div>

        </div>
    </header>
    
    
    
    


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


</body>
</html>