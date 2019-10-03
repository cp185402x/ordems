<?php

require_once "i_topo.php";
require_once "bd_conectar.php";
require_once "i_busca.php"
?>



<section class="cd-faq js-cd-faq container max-width-md margin-top-lg margin-bottom-lg">
	<ul class="cd-faq__categories">
		<li><a class="cd-faq__category cd-faq__category-selected truncate" href="#basics">Atendimento</a></li>
		<li><a class="cd-faq__category truncate" href="#os">OS</a></li>
		<li><a class="cd-faq__category truncate" href="#usuario">Usuários</a></li>
		<li><a class="cd-faq__category truncate" href="#cliente">Clientes</a></li>
		<li><a class="cd-faq__category truncate" href="#frequente">Frequentes</a></li>
		<li><a class="cd-faq__category truncate" href="#visualizacao">Visualização</a></li>
	</ul> <!-- cd-faq__categories -->

	<div class="cd-faq__items">
		<ul id="basics" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Atendimento</h2></li>

			<?php

							
				$query = "select * from Faq where tipo_faq_id = 1";
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

				

				?>


</ul> <!-- cd-faq__group -->
			

		<ul id="os" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Ordem de serviço</h2></li>

			<?php

							
				$query = "select * from Faq where tipo_faq_id = 2";
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

				

				?>


			
		</ul> <!-- cd-faq__group -->

		<ul id="usuario" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Usuarios</h2></li>
			
			<?php

							
				$query = "select * from Faq where tipo_faq_id = 3";
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

				

				?>

		<ul id="cliente" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Clientes</h2></li>
			<?php

							
				$query = "select * from Faq where tipo_faq_id = 4";
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

				

				?>

		<ul id="frequente" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Frequentes</h2></li>
			<?php

							
				$query = "select * from Faq where tipo_faq_id = 5";
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

				

				?>


		<ul id="visualizacao" class="cd-faq__group">
			<li class="cd-faq__title"><h2>Visualizacao</h2></li>
			<?php

							
				$query = "select * from Faq where tipo_faq_id = 6";
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

	</div> <!-- cd-faq__items -->

<?php

//mysqli_close ($db);

?>


	<a href="#0" class="cd-faq__close-panel text-replace">Close</a>
  
  <div class="cd-faq__overlay" aria-hidden="true"></div>
</section> <!-- cd-faq -->
<script src="assets/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
<script src="assets/js/main.js"></script> 
</body>
</html>