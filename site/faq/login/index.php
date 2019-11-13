
<!DOCTYPE HTML>
<html>
<head>
<title>Ordem-S Logar no FAQ</title>

<!-- bootstrap-3.3.7 -->
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>

<!-- JQUERY -->
<script type="text/javascript" language="javascript" src="jquery/jquery.js"></script>

<link href="style/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" language="javascript" src="style/style.js"></script>

</head>
<body>

<div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="img/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="login.php" method="POST">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" id="txLogin" name="txLogin" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
                <br>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  name="btLogin">Logar</button>
            </form>
            
        </div>
</div>

</body>
</html>
