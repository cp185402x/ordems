<?php
include('db.php');
include('function.php');
if(isset($_POST["operation"]))
{
	if($_POST["operation"] == "Add")
	{
		$image = '';
		if($_FILES["user_image"]["name"] != '')
		{
			$image = upload_image();
		}
		$statement = $connection->prepare("
			INSERT INTO faq (titulo, descricao, image) 
			VALUES (:titulo, :descricao, :image)
		");
		$result = $statement->execute(
			array(
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'		=>	$image
			)
		);
		if(!empty($result))
		{
			echo 'FAQ cadastrado com sucesso! ';
		}
	}
	if($_POST["operation"] == "Edit")
	{
		$image = '';
		if($_FILES["user_image"]["name"] != '')
		{
			$image = upload_image();
		}
		else
		{
			$image = $_POST["hidden_user_image"];
		}
		$statement = $connection->prepare(
			"UPDATE faq 
			SET titulo = :titulo, descricao = :descricao, image = :image  
			WHERE id = :id
			"
		);
		$result = $statement->execute(
			array(
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'		=>	$image,
				':id'			=>	$_POST["user_id"]
			)
		);
		if(!empty($result))
		{
			echo 'FAQ atualizado com sucesso!';
		}
	}
}

?>