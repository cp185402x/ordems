<?php
/* Sempre que alterar a senha do banco de dados será necessário alterar também no seguintes arquivos:

funcao.php 		- reponsável pelo preload do nome do cliente
fetch_os.php 	- responsável por gerar a consulta do relatório geal
config.inc.php	- respponsável pelo acesso do phpmyadmin, esta na pasta C:\wamp\apps\phpmyadmin4.1.14

*/ 

/*error_reporting(0);
ini_set(“display_errors”, 0 );
*/

$hostname_data = "localhost";
$username_data = "root";
$password_data = "";
$database_data = "ordems_db";
$connet = mysqli_connect($hostname_data, $username_data, $password_data) or die ("Verifique os dados de conexão com o banco...");
mysqli_select_db("$connect; $database_data") or die ("Erro ao tentar conectar-se ao banco...");

echo "Conectato";
exit;

?>
