<!DOCTYPE html>

<?php 

include_once("db.php");

$query = "SELECT * FROM faq";
$sql = mysqli_query($db, $query);


$cont = mysqli_num_rows($sql);//Verifica os registro do banco


?>

<html>
<head>
    <meta charset="utf-8" />
    <title>Ordem-S : FAQ do sistema</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

<div class="page-header">
    <h1><a href="../index.html">Ordem-S </a><small>FAQ do sistema</small></h1>
</div>

<!-- Bootstrap FAQ - START -->
<div class="container">

    <div class="panel-group" id="accordion">
        <div class="faqHeader">Questões gerais</div>
<?php
//Se não houver registros:
if($cont == 0){
	
	echo"Nenhum faq cadastrado";//Mensagem de erro, caso não ache nada
}

//Caso haja resultados 
else{

		
	while($faq = mysqli_fetch_array($sql))
	{
?>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#<?php echo $faq['id']; ?>"><?php echo"<h3>".$faq['titulo']."</h3>";?></a>
                </h4>
            </div>
            <div id="<?php echo $faq['id'];?>" class="panel-collapse collapse in">
                <div class="panel-body"><?php echo"<p>".$faq['descricao']."</p>";?>
                </div>
            </div>
        </div>
<?php	} 
	
}
?>
    </div>
</div>

<style>
    .faqHeader {
        font-size: 24px;
        margin: 30px;
    }

    .panel-heading [data-toggle="collapse"]:before {
        font-family: 'Glyphicons Halflings';
        content: "\e072"; /* "play" icon */
        float: right;
        color: #23f5f2;
        font-size: 18px;
        line-height: 22px;
        /* rotate "play" icon from > (right arrow) to down arrow */
        -webkit-transform: rotate(-90deg);
        -moz-transform: rotate(-90deg);
        -ms-transform: rotate(-90deg);
        -o-transform: rotate(-90deg);
        transform: rotate(-90deg);
    }

    .panel-heading [data-toggle="collapse"].collapsed:before {
        /* rotate "play" icon from > (right arrow) to ^ (up arrow) */
        -webkit-transform: rotate(90deg);
        -moz-transform: rotate(90deg);
        -ms-transform: rotate(90deg);
        -o-transform: rotate(90deg);
        transform: rotate(90deg);
        color: #454444;
    }
</style>

<!-- Bootstrap FAQ - END -->

</div>

</body>
</html>