<?php

include('../bd_conectar.php');
include("function.php");

if(isset($_POST["id_faq"]))
{
	$image = get_image_name($_POST["id_faq"]);
	if($image != '')
	{
		unlink("upload/" . $image);
	}
	echo "aqui";
	exit;
	$statement = $connection->prepare(
		"DELETE FROM faq WHERE id_faq = :id_faq"
	);
	$result = $statement->execute(
		array(
			':id_faq'	=>	$_POST["id_faq"]
		)
	);
	
	if(!empty($result))
	{
		echo 'Faq Deletada';
		
	}
	else echo 'Nao foi possivel deletar';
}



?>