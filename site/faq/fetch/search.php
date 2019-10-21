<?php
$hostdb = "localhost";// Geralmente Localhost
$userdb = "root";//usuário do seu banco de dados
$passdb = "";// senha do banco de dados
$tabledb = "ordems_db";// tabela do banco de dados

$conecta = mysql_connect($hostdb, $userdb, $passdb) or die (mysql_error());
@mysql_select_db($tabledb, $conecta) or die ("Erro ao conectar com o banco de dados");

$busca = $_POST['palavra'];// palavra que o usuario digitou

$busca_query = mysql_query("SELECT * FROM os WHERE id_os LIKE '$busca'")or die(mysql_error());//faz a busca com as palavras enviadas

if (empty($busca_query)) { //Se nao achar nada, lança essa mensagem
echo "Nenhum registro encontrado.";
}

// quando existir algo em '$busca_query' ele realizará o script abaixo.
while ($dados = mysql_fetch_array($busca_query)) {
echo "ID: $dados[id_os]<br />";
echo "Marca: $dados[modelo]<br />";
echo "Descrição: $dados[descricao]<br />";
echo "<hr>";
}
?>