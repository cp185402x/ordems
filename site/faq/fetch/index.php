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
   <h2 align="center">Digite o número da O.S</h2><br />
   <div class="form-group">
    <div class="input-group">
     <span class="input-group-addon">Buscar</span>
	 <form action="search.php" method="post">
		<input class="btn input_margintop" type="search" name="busca" placeholder="Buscar Sonho...">
		<input class="btn btn_textcenter bg-white" type="submit" class="solid" value="Buscar">
	</form>
     <!--<input type="text" name="search_text" id="search_text" placeholder="Digite o número da O.S" class="form-control" />-->
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