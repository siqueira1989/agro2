<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<a class="navbar-brand" href="#"> 
	<h3 class="font-weight-bold text-white">AgroFazenda</h3></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link active" href="http://localhost:8080/agro/index.jsp">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Relat�rios</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Configura��o</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="http://localhost:8080/agro/view/admin/classificacao.jsp">Classifica��o</a> 
					<a class="dropdown-item" href="http://localhost:8080/agro/view/admin/despesascustos.jsp">Custos e Despesas</a>
					<a class="dropdown-item" href="http://localhost:8080/agro/view/admin/parceiro.jsp">Parceiro</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Algo mais aqui</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="#">Perfil</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Sair</a></li>
		</ul>
	</div>
</nav>
 <!--  let id = $('#exclusaoId').val();
                // Adicione a l�gica para excluir a despesa/custo
               // alert('Parceiro ' + id + ' exclu�do com sucesso!');
                //$('#modalExclusao').modal('hide');
                // Atualiza a tabela ap�s a exclus�o
                url: '/agro/ControllerParceiro',
                method: 'POST',
                data: {
                    acao: 'delete',
                    idparceiro: id
                },
                success: function(response) {
                    alert('Despesa exclu�da com sucesso!');
                    $('#modalExclusao').modal('hide');
                    tabela.ajax.reload();
                },
                error: function(xhr) {
                    alert('Aten��o: ' + xhr.responseText);
                }
            });
            };
        }); -->