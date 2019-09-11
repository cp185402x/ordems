<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<?php


$db = mysqli_connect('localhost:3307', 'root','','ordems_db');
   if(!$db)
   {
	    echo 'Nao deu para se conectar ao banco de dados8';
		exit;
   }



?>

<!DOCTYPE html>
<head>

    
</head>
<body>

<form class="form-horizontal">
<fieldset>
<div class="panel panel-primary">
    <div class="panel-heading">FAQ</div>
    
    <div class="panel-body">
<div class="form-group">




<div class="form-group">
  <label class="col-md-2 control-label" for="Nome">Titulo <h11>*</h11></label>  
  <div class="col-md-8">
  <input id="Titulo" name="Titulo" placeholder="" class="form-control input-md" required="" type="text">
  </div>
</div>


<div class="form-group">
  <label class="col-md-2 control-label" for="Nome">Descrição <h11>*</h11></label>  
  <div class="col-md-2">
  <input id="cpf" name="cpf" placeholder="" class="form-control input-md" required="" type="text" maxlength="11" pattern="[0-9]+$">
  </div>
  
  <label class="col-md-1 control-label" for="Nome">Data<h11>*</h11></label>  
  <div class="col-md-2">
  <input id="dtnasc" name="dtnasc" placeholder="" class="form-control input-md" required="" type="text" maxlength="10" OnKeyPress="formatar('##/##/####', this)" onBlur="showhide()">
</div>


<div class="form-group">
  <label class="col-md-2 control-label" for="Estado Civil">Tipo <h11>*</h11></label>
  <div class="col-md-2">
    <select required id="Estado Civil" name="Estado Civil" class="form-control">
        <option value=""></option>
      <option value="atendimento">atendimento</option>
      <option value="O.S">O.S</option>
      <option value="Usuarios">Usuarios</option>
      <option value="Cliente">cliente</option>
	  <option value="Frequantes">Frequantes</option>
	  <option value="Visualizacoes">visualizacoes</option>
    </select>
  </div>
  
  
<div class="form-group">
  <label class="col-md-2 control-label" for="Cadastrar"></label>
  <div class="col-md-8">
    <button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
    <button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
  </div>
</div>

</div>
</div>


</fieldset>
</form>

</body>
</html>