



 <html>
	<head>
		<title>Ordem-S : Cadastro de FAQ</title>
		<script src="js/jquery.min.js"></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />		
		<link rel="css/dataTables.bootstrap.min.css" />
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.bootstrap.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style>
			body
			{
				margin:0;
				padding:0;
				background-color:#f1f1f1;
			}
			.box
			{
				width:1270px;
				padding:20px;
				background-color:#fff;
				border:1px solid #ccc;
				border-radius:5px;
				margin-top:25px;
			}
		</style>
	</head>
	<body>
		<div class="container box">
			<h1 align="center">ORDEM-S FAQ</h1>
			<div class="table-responsive">
				<div align="right">
					<button type="button" id="add_button" data-toggle="modal" data-target="#userModal" class="btn btn-info btn-lg">+ Adicionar FAQ</button>
				</div>
				<br /><br />
				<table id="data_user" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="10%">#ID</th>
							<th width="35%">TITULO</th>
							<th width="35%">DESCRIÇÃO</th>
							<th width="10%">EDITAR</th>
							<th width="10%">DELETAR</th>
						</tr>
					</thead>
				</table>
				
			</div>
		</div>
	</body>
</html>

<div id="userModal" class="modal fade">
	<div class="modal-dialog">
		<form method="post" id="faq_form" enctype="multipart/form-data">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Adicionar novo FAQ</h4>
				</div>
				<div class="modal-body">
					<label>Digite o título</label>
					<input type="text" name="titulo" id="titulo" class="form-control" />
					<br />
					<label>Digite o texto</label>
					<input type="text" name="descricao" id="descricao" class="form-control" />
					<br />
					<label>Selecionar uma imagem</label>
					<input type="file" name="image" id="image" />
					<span id="image"></span>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="id_faq" id="id_faq" />
					<input type="hidden" name="operation" id="operation" />
					<input type="submit" name="action" id="action" class="btn btn-success" value="Add" />
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript" language="javascript" >
$(document).ready(function(){
	$('#add_button').click(function(){
		$('#faq_form')[0].reset();
		$('.modal-title').text("Cadastrar novo FAQ");
		$('#action').val("Salvar");
		$('#operation').val("Add");
		$('#user_uploaded_image').html('');
	});
	
	var dataTable = $('#data_user').DataTable({
		"processing":true,
		"serverSide":true,
		"order":[],
		"ajax":{
			url:"fetch.php",
			type:"POST"
		}
		//,
		//"columnDefs":[
		//	{
		//		"targets":[0, 3, 4],
		//		"orderable":false,
		//	},
		//],

	});

	$(document).on('submit', '#faq_form', function(event){
		event.preventDefault();
		var titulo = $('#titulo').val();
		var descricao = $('#descricao').val();
		var extension = $('#image').val().split('.').pop().toLowerCase();
		if(extension != '')
		{
			if(jQuery.inArray(extension, ['png','jpg','jpeg']) == -1)
			{
				alert("Arquivo de imagem inválido!");
				$('#image').val('');
				return false;
			}
		}	
		if(titulo != '' && descricao != '')
		{
			$.ajax({
				url:"insert.php",
				method:'POST',
				data:new FormData(this),
				contentType:false,
				processData:false,
				success:function(data)
				{
					alert(data);
					$('#faq_form')[0].reset();
					$('#userModal').modal('hide');
					dataTable.ajax.reload();
				}
			});
		}
		else
		{
			alert("Todos os campos são obrigatórios!");
		}
	});
	
	$(document).on('click', '.update', function(){
		var id_faq = $(this).attr("id_faq");
		$.ajax({
			url:"fetch_single.php",
			method:"POST",
			data:{id_faq:id_faq},
			dataType:"json",
			success:function(data)
			{
				$('#userModal').modal('show');
				$('#titulo').val(data.titulo);
				$('#descricao').val(data.descricao);
				$('.modal-title').text("Editar este FAQ");
				$('#id_faq').val(id_faq);
				$('#user_uploaded_image').html(data.image);
				$('#action').val("Salvar");
				$('#operation').val("Edit");
			}
		})
	});
	
	$(document).on('click', '.delete', function(){
		var id_faq = $(this).attr("id_faq");
		if(confirm("Tem certeza que deseja deletar este FAQ?"))
		{
			$.ajax({
				url:"delete.php",
				method:"POST",
				data:{id_faq:id_faq},
				success:function(data)
				{
					alert(data);
					dataTable.ajax.reload();
				}
			});
		}
		else
		{
			return false;	
		}
	});
	
	
});
</script>