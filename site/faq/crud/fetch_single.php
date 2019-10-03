<?php
include('db.php');
include('function.php');
if(isset($_POST["faq_id"]))
{
	$output = array();
	$statement = $connection->prepare(
		"SELECT * FROM faq 
		WHERE id = '".$_POST["faq_id"]."' 
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
			$output['faq_image'] = '<img src="upload/'.$row["image"].'" class="img-thumbnail" width="50" height="35" /><input type="hidden" name="hidden_faq_image" value="'.$row["image"].'" />';
		}
		else
		{
			$output['faq_image'] = '<input type="hidden" name="hidden_faq_image" value="" />';
		}
	}
	echo json_encode($output);
}
?>