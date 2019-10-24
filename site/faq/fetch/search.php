<?php include_once("db.php");?>
<?php

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
	echo "Não há OS relacionadas à ".$busca."";//Mensagem de erro, caso não ache nada
}

//Caso haja resultados: 
else{
	echo "<ul>";
	while($os = mysqli_fetch_array($sql))
	{

		echo "<li><a href=os.php?id='".$os['id_os']."'>".$os['id_os']."</a>".$os['modelo']." | ".$os['info_cliente']." | ".$os['info_tecnico']."</li>";//Escreve a informações do cliente
		
	}
	echo "</ul>";
}
?>