<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Trabalho Devops</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://kit.fontawesome.com/303e0ef7a4.js" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			$('#formulario').submit(function(event) {
				// Impedir que o formulário seja enviado normalmente
				event.preventDefault();
				// Enviar o formulário via AJAX
				$.ajax({
					url: '/league/' + document.getElementById("nome").value,
					type: 'post',
					data: $(this).serialize(),
					success: function(data) {
						// Processar a resposta do servidor aqui
						alert('Formulário enviado com sucesso!');
						window.location.reload();
					},
					error: function() {
						// Lidar com erros de requisição aqui
						alert('Ocorreu um erro ao enviar o formulário.');
					}
				});
			});

			// Requisição AJAX para preencher a tabela
			$.ajax({
				url: '/league',
				type: 'get',
				dataType: 'json',
				success: function(data) {
					$.each(data, function(index, league) {
						var row = $('<tr><td>' + league.name + '</td><td>' + league.startDate + '</td><td><button id="lixeira"><i class="fa-solid fa-trash"></i></button></tr>');
						row.find('#lixeira').click(function() {
							$.ajax({
								url: '/league/' + league.id,
								type: 'delete',
								data: {
									name: league.name
								},
								success: function() {
									alert('Liga removida com sucesso!');
									window.location.reload();
								},
								error: function() {
									alert('Ocorreu um erro ao remover a liga.');
								}
							});
						});
						$('#tabela-ligas').append(row);
					});
				},
				error: function() {
					alert('Ocorreu um erro ao carregar a tabela de ligas.');
				}
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;padding: 3%;">Olá, professor!</h1>
		<h3>Crie um regristro:</h3>
		<form id="formulario">
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" id="nome" class="form-control">
			</div>
			<div class="form-group" style="padding-bottom: 3%;">
				<button type="submit" class="btn btn-primary">Salvar</button>
			</div>
		</form>

		<h3>Tabela de regristros:</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Data de Criação</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tabela-ligas">
			</tbody>
		</table>
	</div>
</body>
</html>
