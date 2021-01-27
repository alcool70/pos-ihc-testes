package alcool70.steps;

import alcool70.pages.ClientePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public final class REQ001 extends BaseSteps {

    ClientePage page;

    public REQ001() {

        page = PageFactory.initElements(driver, ClientePage.class);

        Dado("que estou na página inicial do sistema", () -> {
        });

        Dado("^seleciono o produto$", () -> page.acesseProduto());

        Quando("^preencho com dados do cliente$", (DataTable tabela) -> {
            Map<String, String> dados = tabela.asMap(String.class, String.class);
            page.informarTipoCliente(dados.get("cliente"));
            page.informarQtdItem(dados.get("quantidade"));
        });

        Quando("^calculo o desconto$", () -> page.calcularDesconto());

        Então("^verifico se a mensagem foi exibida com sucesso$", () -> {
            assertThat(
                    page.getMsg(),
                    containsStringIgnoringCase("Operação realizada com sucesso!")
            );
        });

        Então("^verifico se a mensagem de erro foi exibida$", () -> {
            assertThat(
                    page.getMsg(),
                    containsStringIgnoringCase("A quantidade informada deve ser maior ou igual a 01 (um)!")
            );
        });
    }
}
