<?php
include('../bd_conectar.php');
include('function.php');
if(isset($_POST["id_faq"]))
{
	$output = array();
	$statement = $connection->prepare(
		"SELECT * FROM faq
		WHERE id_faq = '".$_POST["id_faq"]."' 
		LIMIT 1"
	);
	$statement->execute();
	$result = $statement->fetchAll();
	foreach($result as $row)
	{
		$output["titulo"] = $row["titulo"];
		$output["descricao"] = $row["descricao"];
		if($row["image"] != '')
		{
			$output['image'] = '<img src="upload/'.$row["image"].'" class="img-thumbnail" width="50" height="35" /><input type="hidden" name="hidden_image" value="'.$row["image"].'" />';
		}
		else
		{
			$output['image'] = '<input type="hidden" name="hidden_image" value="" />';
		}
	}
	echo json_encode($output);
}
?>