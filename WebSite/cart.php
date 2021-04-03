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
     
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->
      
    
    <style>
        /* cart items */

        .cart-page{
            margin: 80px auto;
        }
        table{
            width: 100%;
            border-collapse: collapse;

        }
        .cart-info{
            display:flex;
            flex-wrap: wrap;

        }
        th{
            text-align: left;
            padding: 5px;
            color:#fff;
            background: #F15B5D;
            font-weight:normal;
        }
        td{
            padding: 10px 5px;
        }
        td input{
            width: 40px;
            height: 30px;
            padding: 5px;
        }
        td a{
            color:red;
            font-size: 12px;
        }
        td img{
            width: 150px;
            height: 150px;
            margin-right: 10px;
        }

        .total-price{
            display:flex;
            justify-content: flex-end;
        }
        .total-price table{
            border-top: 3px solid #F15B5D;
            width: 100%;
            max-width: 400px;
        }
        td:last-child{
            text-align: right;
        }
        th:last-child{
            text-align: right;
        }

    </style>

</head>
<body>
   <div class="container cart-page" style="margin-top: -40px;">
      <table>
         <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Subtotal</th>
         </tr>
         <tr>
            <td>
               <div class="cart-info">
                  <img src="img/mushroom.png" alt="">
                  <div>
                     <p>
                     <h6>Double Mushroom Swiss</h6>
                     </p>
                     <small>Price: ৳ 800</small>
                     <br>
                     <a href="#">Remove</a>
                  </div>
               </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>৳ 800</td>
         </tr>
         <tr>
            <td>
               <div class="cart-info">
                  <img src="img/fanta.png" alt="">
                  <div>
                     <p>
                     <h6>Fanta Grape</h6>
                     </p>
                     <small>Price: ৳ 800</small>
                     <br>
                     <a href="#">Remove</a>
                  </div>
               </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>৳ 600</td>
         </tr>
         <tr>
            <td>
               <div class="cart-info">
                  <img src="img/whooper.png" alt="">
                  <div>
                     <p>
                     <h6>Whooper</h6>
                     </p>
                     <small>Price: ৳ 800</small>
                     <br>
                     <a href="#">Remove</a>
                  </div>
               </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>৳ 800</td>
         </tr>
         <tr>
            <td>
               <div class="cart-info">
                  <img src="img/milo.png" alt="">
                  <div>
                     <p>
                     <h6>Milo Choco Juice</h6>
                     </p>
                     <small>Price: ৳ 600</small>
                     <br>
                     <a href="#">Remove</a>
                  </div>
               </div>
            </td>
            <td><input type="number" value="1" min="1"></td>
            <td>৳ 600</td>
         </tr>
      </table>
      <div class="total-price">
         <table>
            <tr>
               <td>Subtotal</td>
               <td>৳ 2000</td>
            </tr>
            <tr>
               <td>Delivery Charge</td>
               <td>৳ 30</td>
            </tr>
            <tr>
               <td>Total</td>
               <td>৳ 2030</td>
            </tr>
         </table>
      </div>
   </div>
   <!--     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script> -->
   <?php
      include('footer.php');
      ?>
</body>
</html>