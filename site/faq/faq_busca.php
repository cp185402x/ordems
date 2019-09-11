<?php

require_once "i_topo.php";

if (isset($_POST['busca'])){
		$busca = $_POST['busca'];
}else{
	$busca = 'a';
}


require_once "bd_conectar.php";


require_once "i_busca.php"
?>



<section class="cd-faq js-cd-faq container max-width-md margin-top-lg margin-bottom-lg">
	<ul class="cd-faq__categories">
		<li><a href="faq.php" >Voltar ao FAQ</a></li>
	</ul> <!-- cd-faq__categories -->

	<div class="cd-faq__items">
		<ul id="basics" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Resultado da busca da palavra: <?php echo $busca; ?></h2></li>

			<?php

							
				$query = "select * from Faq where (descricao like '%".$busca."%' or titulo like '%".$busca."%')";
				$result = mysqli_query($db,$query);



				for ($i=0; $i < mysqli_num_rows($result); $i++)
				{
					$row = mysqli_fetch_array($result);
				
				?>

					<li class="cd-faq__item">
						<a class="cd-faq__trigger" href="#0"><span><?php echo $row['titulo'];?></span></a>
						<div class="cd-faq__content">
						<div class="text-component">
							<p><?php echo $row['descricao'];?></p>
						</div>
						</div> <!-- cd-faq__content -->
					</li>

							<?php

				}
				mysqli_close ($db);
				

				?>


</ul> <!-- cd-faq__group -->
			

		




	<a href="#0" class="cd-faq__close-panel text-replace">Close</a>
  
  <div class="cd-faq__overlay" aria-hidden="true"></div>
</section> <!-- cd-faq -->
<script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
<script src="assets/js/main.js"></script> 
</body>
</html>