<?php

require_once "conexao.php";

// $connect = mysqli_connect("localhost", "root", "", "ordems_db");

$output = '';
if(isset($_POST["query"]))
{
 $search = mysqli_real_escape_string($connect, $_POST["query"]);
 $query = "
  SELECT os.id_os, os.data_os, os.tipo, os.modelo, os.info_cliente, cliente.nm_cliente, os_status.status FROM os JOIN cliente, os_status 
  WHERE id_os = '".$search."'
  OR modelo LIKE '%".$search."%' 
  OR info_cliente LIKE '%".$search."%'
  ORDER BY id_os DESC
  LIMIT 10
 ";
}
else
{
 $query = "
  SELECT * FROM os ORDER BY id_os DESC LIMIT 10;
 ";
}
$result = mysqli_query($connect, $query);
if(mysqli_num_rows($result) > 0)
{
 $output .= '
  <div class="table-responsive">
   <table class="table table bordered">
    <tr>
    <th>O.S.</th>
     <th>DATA</th>
     <th>CLIENTE</th>
     <th>TIPO</th>
     <th>MARCA</th>
     <th>STATUS</th>
    </tr>
 ';
 while($row = mysqli_fetch_array($result))
 {
  $output .= '
   <tr>
    <td><font size="2px"><a href="#?recordID='.$row["id_os"].'">'.$row["id_os"].'</font></td>
    <td><font size="2px">'.$row["data_os"].'</font></td>
    <td><font size="2px">'.$row["nm_cliente"].'</font></td>
    <td><font size="2px">'.$row["tipo"].'</font></td>
    <td><font size="2px">'.$row["modelo"].'</font></td>
    <td><font size="2px">'.$row["status"].'</font></td></tr>
  ';
 }
 echo $output;
}
else
{
 echo 'Dados não encontrados! Mude o critério da busca.';
}

?>
