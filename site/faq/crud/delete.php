<?php

include('db.php');
include("function.php");

if(isset($_POST["faq_id"]))
{
	$image = get_image_name($_POST["faq_id"]);
	if($image != '')
	{
		unlink("upload/" . $image);
	}
	$statement = $connection->prepare(
		"DELETE FROM users WHERE id = :id"
	);
	$result = $statement->execute(
		array(
			':id'	=>	$_POST["faq_id"]
		)
	);
	
	if(!empty($result))
	{
		echo 'Dados deletador com sucesso!';
	}
}



?>