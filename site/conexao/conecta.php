<?php

$hostname = "127.0.0.1";
$database = "ordems_db";
$username = "root";
$password = "";
//$connect = new PDO($hostname,  $database, $username, $password);

$connection = new PDO( 'mysql:'$hostname, $database, $username, $password);

   if(!$connection)
   {
	    echo 'Erro ao conectar-se com o banco de dados';
		exit;
   }
?>

