<?php

$username = 'root';
$password = '';
$connection = new PDO( 'mysql:host=localhost:3307;dbname=ordems_db', $username, $password );
if(!$db)
{
     echo 'Nao deu para se conectar ao banco de dados8';
     exit;
}

?>