
function validarFormulario(){
    // remove a repetiçao automatica
    $('.alert').remove();


    // variáveis
    var nome=$('#nome').val(),
        email=$('#email').val(),
        assunto=$('#assunto').val(),
        mensagem=$('#mensagem').val();

    // valida o nome
    if(nome=="" || nome==null){

        cambiarColor("nome");
        // mostra mensagem de alerta
        mostraAlerta("Seu NOME é muito importante!");
        return false;
    }else{
        var expresion= /^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]*$/;
        if(!expresion.test(nome)){
		// mostra mensagem de alerta
            cambiarColor("nome");
            mostraAlerta("Desculpa, neste campo não é permitido, caracteres especiais e números!");
            return false;
        }
    }

    // valida o email
    if(email=="" || email==null){

        cambiarColor("email");
        // mostra mensagem de alerta
        mostraAlerta("Seu E-MAIL é muito importante!");
        return false;
    }else{
        var expresion= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
        if(!expresion.test(email)){
            // mostra mensagem de alerta
            cambiarColor("email");
            mostraAlerta("Desculpa, o E-MAIL digitado não é aceito ou é inválido!");
            return false;
        }
    }

    // valida o asunto
    if(assunto=="" || assunto==null){

        cambiarColor("assunto");
        // mostra mensagem de alerta
        mostraAlerta("O ASSUNTO é muito importante!");
        return false;
    }else{
        var expresion= /^[,\\.\\a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ ]*$/;
        if(!expresion.test(assunto)){
            // mostrara el mesaje que debe ingresar un nome válido
            cambiarColor("assunto");
            mostraAlerta("Desculpa, neste campo não é permitido, caracteres especiais e números!");
            return false;
        }
    }

     // valida a mensagem
     if(mensagem=="" || mensagem==null){

        cambiarColor("mensagem");
        // mostra mensagem de alerta
        mostraAlerta("Acho que você esqueceu de descrever sua MENSAGEM!");
        return false;
    }else{
        var expresion= /^[,\\.\\a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ ]*$/;
        if(!expresion.test(mensagem)){
            // mostra mensagem de alerta
            cambiarColor("mensagem");
            mostraAlerta("Desculpa, neste campo não é permitido, caracteres especiais e números!");
            return false;
        }
    }

    $('form').submit();
    return true;
    
} 

$('input').focus(function(){
    $('.alert').remove();
    colorDefault('nome');
    colorDefault('email');
    colorDefault('assunto');
});

$('textarea').focus(function(){
    $('.alert').remove();
    colorDefault('mensagem');
});

// função para colorir as bordas dos inputs
function colorDefault(dato){
    $('#' + dato).css({
        border: "1px solid #999"
    });
}

function cambiarColor(dato){
    $('#' + dato).css({
        border: "1px solid #dd5144"
    });
}

// funcion para mostrar o alerta

function mostraAlerta(texto){
    $('#nome').before('<div class="alert">Ops!, '+ texto +'</div>');
}