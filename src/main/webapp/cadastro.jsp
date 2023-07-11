<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Cadastro de Jogos</title>
</head>
<script>
	
</script>
<body>
	<h1>Cadastro de Jogos</h1>
	<form action="cadastrar" method="post">
		<input type="hidden" name="action" value="cadastrar"> <label
			for="imagemUrl">URL da Imagem:</label> <input type="text"
			id="imagemUrl" name="imagemUrl"><br> <label for="nome">Nome:</label>
		<input type="text" id="nome" name="nome"><br> <label
			for="dataLancamento">Data de Lançamento:</label> <input type="text"
			id="dataLancamento" name="dataLancamento"><br> <label
			for="empresaProducao">Empresa de Produção:</label> <input type="text"
			id="empresaProducao" name="empresaProducao"><br> <label
			for="empresaPublicacao">Empresa de Publicação:</label> <input
			type="text" id="empresaPublicacao" name="empresaPublicacao"><br>
		<input id="botaoCadastro" type="submit" value="Cadastrar"> <br>
		<div>
		
			<%
			//não quer funcionar de forma alguma!
			String mensagem = (String) request.getAttribute("mensagem"); 
			if (mensagem != null) {
				out.print(mensagem);
			}
			%>
		</div>

	</form>
</body>
</html>
