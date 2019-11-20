<!-- bootstrap-3.3.7 -->
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="jquery/jquery.js"></script>
<link href="style/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" language="javascript" src="style/style.js"></script>
<?php 

include_once("db.php");

$busca = $_GET['b'];//salva na variável o que foi buscado
//$busca = mysql_real_escape_string($busca);//mysql_real_escape_string() para evitar erros no MySQL

//Verifica se a busca estiver vazia
//Se estiver, redireciona para a index
if($busca == null){
header("location: index.php");
}


$query = "SELECT * FROM os WHERE id_os LIKE '%".$busca."%' ORDER BY id_os DESC";
$sql = mysqli_query($db, $query);
//Procura no banco registros que contenham no texto número da OS relacionadas à busca

$cont = mysqli_num_rows($sql);//Conta quantos registros existem no BD

//Se não houver registros:
if($cont == 0){
	echo "O número da O.S. digitado ( ".$busca." ), não foi localizado, tente novamente!  ";//Mensagem de erro, caso não ache nada
}

//Caso haja resultados: 
else{

		
	while($os = mysqli_fetch_array($sql))
	{
	
	echo"<div class='container'>";
		echo"<div class='card card-body'>";
		echo"<h3 align='center'>Resultado da sua consulta de O.S</h3>";
        echo"<table width='600px' border='1' align='center' cellpadding='4' cellspacing='0'>";
		echo"<tr>";
		echo"<th>Data de entrada</th>";
		echo"<td>".$os['data_os']."</td>";
		echo"</tr>";
		echo"<tr>";
		echo"<th>O.S.:</th>";
		echo"<td>".$os['id_os']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>Marca:</th>";
        echo"<td>".$os['marca']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>Modelo:</th>";
        echo"<td>".$os['modelo']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>N/S</th>";
		echo"<td>".$os['serie']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>Informação do Cliente:</th>";
        echo"<td>".$os['info_cliente']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>Informação do técnico:</th>";
        echo"<td>".$os['info_tecnico']."</td>";
        echo"</tr>";
        echo"<tr>";
        echo"<th>Status:</th>";
        echo"<td>".$os['status_id']."</td>";
        echo"</tr>";
        echo"</table>";
		echo"<button type='button' class='btn btn-outline-success'><a href='javascript:history.back()'>Voltara</a></button>";
		echo"</div>";
		echo"</div>";
		
	}
}
?>
