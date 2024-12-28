<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Empresa Agrícola</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">

    <!-- Tela de login centralizada -->
    <div class="d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4" style="max-width: 400px; width: 100%;">
            <div class="card-body">
                <!-- Logotipo da Empresa (substitua o texto por uma imagem, se necessário) -->
                <div class="text-center mb-4">
                    <h2 class="font-weight-bold text-success">AgroFazenda</h2>
                 
                </div>

                <!-- Título do Formulário -->
                <h5 class="card-title text-center mb-4">Área de Login</h5>

                <!-- Formulário de Login -->
                <form id="loginForm" method="post" action="/agro/AcessoLogin">
                    <!-- Campo de Email -->
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="login" placeholder="Digite login" name="login" required>
                    </div>

                    <!-- Campo de Senha -->
                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" class="form-control" id="password" name="senha" placeholder="Digite sua senha" required>
                    </div>

                    <!-- Checkbox Lembrar de Mim -->
                    <div class="form-check mb-3">
                        <input type="checkbox" class="form-check-input" id="rememberMe">
                        <label class="form-check-label" for="rememberMe">Lembrar de mim</label>
                    </div>

                    <!-- Botão de Login -->
                    <button type="submit" class="btn btn-success btn-block">Entrar</button>
                </form>

                <!-- Link para Esqueci minha senha -->
                <div class="text-center mt-3">
                    <a href="#">Esqueceu sua senha?</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
