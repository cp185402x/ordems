<?php
if(!isset ($_SESSION)){
	session_start();
}

if (!isset($_SESSION['codigoUsuarioLogado'])){
	echo "cccc";
	header("Location: /ordems/login/index.php");
}



?>
