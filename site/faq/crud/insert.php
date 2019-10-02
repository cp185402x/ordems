<?php



include('../bd_conectar.php');
include('function.php');
if(isset($_POST["operation"]))
{

	if($_POST["operation"] == "Add")
	{


		$image = '';
		if($_FILES["image"]["name"] != '')
		{
			$image = upload_image();
		}
			

		$statement = $connection->prepare("
			INSERT INTO faq (titulo, descricao, image) 
			VALUES (:titulo,:descricao,:image)");
		$result = $statement->execute(
			array(
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'     => $image
			)
		);


		if(!empty($result))
		{
			echo 'Data Inserted';
		}else
		echo"Erro";

		exit;
	}
	if($_POST["operation"] == "Edit")
	{
		$image = '';
		if($_FILES["image"]["name"] != '')
		{
			$image = upload_image();
		}
		else
		{
			$image = $_POST["hidden_image"];
		}
		$statement = $connection->prepare(
			"UPDATE faq
			SET titulo = :titulo, descricao= :descricao, image = :image  
			WHERE id_faq = :id_faq
			"
		);
		$result = $statement->execute(
			array(
				':titulo'	=>	$_POST["titulo"],
				':descricao'	=>	$_POST["descricao"],
				':image'		=>	$image,
				':id_faq'			=>	$_POST["id_faq"]
			)
		);
		if(!empty($result))
		{
			echo 'Data Updated';
		}
	}
}

?>