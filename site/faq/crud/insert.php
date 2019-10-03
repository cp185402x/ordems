<?php
include('db.php');
include('function.php');
if(isset($_POST["operation"]))
{
	if($_POST["operation"] == "Add")
	{
		$image = '';
		if($_FILES["faq_image"]["name"] != '')
		{
			$image = upload_image();
		}
		$statement = $connection->prepare("
			INSERT INTO faq (tipo_faq_id, titulo, descricao, image) 
			VALUES (:tipo_faq_id, :titulo, :descricao, :image)
		");
		$result = $statement->execute(
			array(
				':tipo_faq_id'	=>	$_POST["tipo_faq_id"],
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'		=>	$image
			)
		);
		if(!empty($result))
		{
			echo 'Dados cadastrados com sucesso!';
		}
	}
	if($_POST["operation"] == "Edit")
	{
		$image = '';
		if($_FILES["faq_image"]["name"] != '')
		{
			$image = upload_image();
		}
		else
		{
			$image = $_POST["hidden_faq_image"];
		}
		$statement = $connection->prepare(
			"UPDATE users 
			SET titulo = :titulo, descricao = :descricao, image = :image  
			WHERE id = :id
			"
		);
		$result = $statement->execute(
			array(
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'		=>	$image,
				':id'			=>	$_POST["faq_id"]
			)
		);
		if(!empty($result))
		{
			echo 'Dados atualizados com sucesso!';
		}
	}
}

?>