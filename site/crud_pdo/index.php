<html>
	<head>
		<title>FAQ PROJETO ORDEMS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>		
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
			<h2 align="center">FAQ PROJETO ORDEMS</h2>
			<br />
			<div class="table-responsive">
				<br />
				<div align="right">
					<button type="button" id="add_button" data-toggle="modal" data-target="#faqModal" class="btn btn-info btn-lg">Adicionar</button>
				</div>
				<br /><br />
				<table id="faq_data" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th width="10%">IMAGE</th>
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

<div id="faqModal" class="modal fade">
	<div class="modal-dialog">
		<form method="post" id="faq_form" enctype="multipart/form-data">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Adicionar novo FAQ</h4>
				</div>
				<div class="modal-body">
					<label>Titulo</label>
					<input type="text" name="titulo" id="titulo" class="form-control" />
					<br />
					<label>Descrição</label>
					<input type="text" name="descricao" id="descricao" class="form-control" />
					<br />
					<label>Imagem</label>
					<input type="file" name="faq_image" id="faq_image" />
					<span id="faq_uploaded_image"></span>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="faq_id" id="faq_id" />
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
		$('.modal-title').text("Adicionar FAQ");
		$('#action').val("Salvar");
		$('#operation').val("Add");
		$('#faq_uploaded_image').html('');
	});
	
	var dataTable = $('#faq_data').DataTable({
		"processing":true,
		"serverSide":true,
		"order":[],
		"ajax":{
			url:"fetch.php",
			type:"POST"
		},
		"columnDefs":[
			{
				"targets":[0, 3, 4],
				"orderable":false,
			},
		],

	});

	$(document).on('submit', '#faq_form', function(event){
		event.preventDefault();
		var firstName = $('#titulo').val();
		var lastName = $('#descricao').val();
		var extension = $('#faq_image').val().split('.').pop().toLowerCase();
		if(extension != '')
		{
			if(jQuery.inArray(extension, ['png','jpg','jpeg']) == -1)
			{
				alert("Arquuivo de imagem inválido!");
				$('#faq_image').val('');
				return false;
			}
		}	
		if(firstName != '' && lastName != '')
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
					$('#faqModal').modal('hide');
					dataTable.ajax.reload();
				}
			});
		}
		else
		{
			alert("Campos obrigatórios");
		}
	});
	
	$(document).on('click', '.update', function(){
		var faq_id = $(this).attr("id");
		$.ajax({
			url:"fetch_single.php",
			method:"POST",
			data:{faq_id:faq_id},
			dataType:"json",
			success:function(data)
			{
				$('#faqModal').modal('show');
				$('#titulo').val(data.titulo);
				$('#descricao').val(data.descricao);
				$('.modal-title').text("Editar FAQ");
				$('#faq_id').val(faq_id);
				$('#faq_uploaded_image').html(data.faq_image);
				$('#action').val("Editar");
				$('#operation').val("Edit");
			}
		})
	});
	
	$(document).on('click', '.delete', function(){
		var faq_id = $(this).attr("id");
		if(confirm("Tem certeza que deseja deletar este FAQ?"))
		{
			$.ajax({
				url:"delete.php",
				method:"POST",
				data:{faq_id:faq_id},
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