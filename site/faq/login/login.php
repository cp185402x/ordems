<?php

$login = $_POST['txLogin'];
$senha = $_POST['senha'];

require_once "db.php";

$query = "select * from usuario where login = '". $login ."'"; 	

$result  = mysqli_query($db, $query);
$row = mysqli_fetch_array($result);

if($senha == $row['senha']){
	
	echo "OK!";
	
}else {
	echo "N OK";
	
	
}

var_dump ($row);

?>