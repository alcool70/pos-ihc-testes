package alcool70.steps;

import alcool70.infra.TipoMensagem;
import alcool70.pages.ContatoPage;
import io.cucumber.datatable.DataTable;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class REQ003 extends BaseSteps {

    ContatoPage page;

    public REQ003() {

        page = new ContatoPage(driver);


        Dado("^acesso a opção \"([^\"]*)\"$", (String opcao) -> {
//                EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato", "pagina.contato");
            if (opcao.equalsIgnoreCase("contato"))
                page.clicarBotaoContato();

        });

        Quando("preencho com dados válidos o formulário", (DataTable tabela) -> {
            Map<String, String> dados = tabela.asMap(String.class, String.class);

            page.preencherNome(dados.get("nome"));
            page.preencherEmail(dados.get("email"));
            page.escolherTipoMensagem(TipoMensagem.valueOf(dados.get("tipo")));
            page.escolherIdade(dados.get("idade"));
            page.preencherMensagem(dados.get("mensagem"));

//            EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato - preenchida", "pagina.contato");
        });

        Quando("submeto o formulário de contato", () -> page.enviarMensagemDeContato());

        Então("^verifico que a mensagem \"([^\"]*)\" foi exibida na página$", (String mensagem) -> {
//            EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato - resultado", "pagina.contato");
            assertFalse(page.toastText(mensagem));
//            assertTrue(steps.toastText("Mensagem de DÚVIDA por usuário de idade MENOR QUE 18 ANOS foi enviada com sucesso!"));
        });
    }
}
