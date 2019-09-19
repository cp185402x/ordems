<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Status da O.S.</title>
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link href="css/bootstrap.min.css" rel="stylesheet" />
 </head>
 <body>
  <div class="container">
   <br />
   <h2 align="center">Digite o número da O.S ou RG...</h2><br />
   <div class="form-group">
    <div class="input-group">
     <span class="input-group-addon">Buscar</span>
     <input type="text" name="search_text" id="search_text" placeholder="Digite o número da O.S ou RG..." class="form-control" />
    </div>
   </div>
   <br />
   <div id="result"></div>
  </div>
 </body>
</html>


<script>
$(document).ready(function(){

 load_data();

 function load_data(query)
 {
  $.ajax({
   url:"search.php",
   method:"POST",
   data:{query:query},
   success:function(data)
   {
    $('#result').html(data);
   }
  });
 }
 $('#search_text').keyup(function(){
  var search = $(this).val();
  if(search != '')
  {
   load_data(search);
  }
  else
  {
   load_data();
  }
 });
});
</script>