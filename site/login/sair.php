<?php
if(!isset ($_SESSION)){
	session_start();
	}

$_SESSION['codigoUsuarioLogado'] = 0;

session_destroy();
	header("Location: index.php");


?>