<?php

error_reporting(0);
ini_set(“display_errors”, 0 );

$hostname_data = "127.0.0.1";
$database_data = "ordems_db";
$username_data = "root";
$password_data = "";
$data = mysql_connect($hostname_data, $username_data, $password_data) or trigger_error(mysql_error(),E_USER_ERROR);
mysql_select_db("$database_data,$data");

   if(!$data)
   {
	    echo 'Erro ao conectar-se com o banco de dados';
		exit;
   }
?>

