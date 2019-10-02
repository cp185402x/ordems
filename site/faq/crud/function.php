<?php

function upload_image()
{
	if(isset($_FILES["image"]))
	{
		$extension = explode('.', $_FILES['image']['name']);
		$new_name = rand() . '.' . $extension[1];
		$destination = './upload/' . $new_name;
		move_uploaded_file($_FILES['image']['tmp_name'], $destination);
		return $new_name;
	}
}

function get_image_name($id_faq)
{
	include('../bd_conectar.php');
	$statement = $connection->prepare("SELECT * FROM faq WHERE id_faq = '$id_faq'");
	$statement->execute();
	$result = $statement->fetchAll();
	foreach($result as $row)
	{
		return $row["image"];
	}
}

function get_total_all_records()
{
	include('../bd_conectar.php');
	$statement = $connection->prepare("SELECT * FROM faq");
	$statement->execute();
	$result = $statement->fetchAll();
	return $statement->rowCount();
}

?>