# ViaCEP
Projeto em Java para obter CEP do webservice ViaCEP
http://viacep.com.br/

![Screenshot do teste da biblioteca](https://gitlab.com/parg-lgpl/ViaCEP-teste/raw/master/screenshot.png)

## Novidade
Agora o projeto conta com uma interface para eventos (ViaCEPEvents), assim você pode melhorar o seu projeto implementando *onCEPSuccess* e *onCEPError*, veja esse exemplo:

```java
import java.util.Scanner;
import viacep.ViaCEP;
import viacep.ViaCEPEvents;
import viacep.ViaCEPException;

/**
 * Testa a classe ViaCEP
 * @author Pablo Alexander da Rocha Gonçalves
 */
public class ViaCEPTest implements ViaCEPEvents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ViaCEPTest().run();
    }

    public void run() {
        ViaCEP viaCEP = new ViaCEP(this);
        String cep;
        Scanner scan = new Scanner(System.in);

        System.out.println(ViaCEPTest.class.getName() + " - digite sair para fechar o teste!");

        do {
            System.out.print("Digite um cep: ");
            cep = scan.next();
            // consulta
            if (!cep.equals("sair")) {
                try {
                    viaCEP.buscar(cep);
                } catch (ViaCEPException ex) {
                    System.err.println("Ocorreu um erro na classe " + ex.getClasse() + ": " + ex.getMessage());
                }
            }
        } while (!cep.equals("sair"));
    }

    @Override
    public void onCEPSuccess(ViaCEP cep) {
        System.out.println();
        System.out.println("CEP " + cep.getCep() + " encontrado!");
        System.out.println("Logradouro: " + cep.getLogradouro());
        System.out.println("Complemento: " + cep.getComplemento());
        System.out.println("Bairro: " + cep.getBairro());
        System.out.println("Localidade: " + cep.getLocalidade());
        System.out.println("UF: " + cep.getUf());
        System.out.println("Gia: " + cep.getGia());
        System.out.println("Ibge: " + cep.getIbge());
        System.out.println();
    }

    @Override
    public void onCEPError(String cep) {
        System.out.println();
        System.out.println("Não foi possível encontrar o CEP " + cep + "!");
        System.out.println();
    }

}
```

## O que é?
Este é um projeto de Java feito no **NetBeans IDE 8.0.2** usando a **JDK 8**, mas que eu acredito que pode ser adaptado para qualquer JDK ou versão do Java.

Inicialmente o projeto tinha somente o objetivo de teste (https://github.com/parg-programador/ViaCEP-teste) para ver como funciona o procedimento para solictar um CEP e interpletar o JSON de retorno do  webservice **ViaCEP**, sendo que a classe principal do projeto é a *ViaCEP* (**ViaCEP.java**) que tem como dependência as classes da biblioteca **org.json** https://github.com/douglascrockford/JSON-java de @douglascrockford.

## Onde?
Você pode estar se perguntando onde você pode usar essa classe e a resposta é em qualquer lugar que o Java permite, em minha experiência pessoal já usei em *Java Web JSP*, *Java/Swing*, *Android*.

## Dica!
O **ViaCEP** é um serviço gratuito que serve como exemplo para muitos, então não vamos sobrecarregar o serviço com consultas repetitivas, pode usar uma estrutura de consultas internas/externas, onde em nossa base de dados consultamos a tabela CEP e caso não exista consultamos o ViaCEP, depois que a consulta do ViaCEP retornar (caso o CEP exista) cadastramos ele e nossa própria tabela de CEP.

Pode-se até criar um TIMESTAMP para registrar data que o CEP foi criado/atualizado para que a cada um determinado tempo o mesmo seja atualizado novamente através do ViaCEP.

Se todos fizerem o melhor pensando no próximo vamos ter um excelente serviço rápido e estável.
