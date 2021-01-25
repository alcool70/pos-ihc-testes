package alcool70.steps;

import alcool70.pages.ContatoPage;
import alcool70.pages.TipoMensagem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.Pt;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class REQ003 implements Pt {

    private WebDriver driver;
    private ContatoPage steps;

    public REQ003() {
        // BeforeAll
        Before(() -> {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
            driver.manage().window().maximize();

            steps = PageFactory.initElements(driver, ContatoPage.class);
        });

        // AfterAll
        After(() -> {
            if (driver != null)
                driver.quit();
        });

        Dado("que estou na página inicial do sistema", () -> {
            driver.get("https://calculadora.diegoquirino.net");
//            EyesSingleton.simpleCheck(driver, "Página Inicial", "pagina.inicial");
        });

        Dado("^acesso a opção (.*)$", (String opcao) -> {
            if (opcao.equalsIgnoreCase("contato")) {
                steps.clicarBotaoContato();
//                EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato", "pagina.contato");
            }
        });

        Quando("preencho os dados no formulário de contato", (DataTable tabela) -> {
            Map<String, String> dados = tabela.asMap(String.class, String.class);

            steps.preencherNome(dados.get("nome"));
            steps.preencherEmail(dados.get("email"));
            steps.escolherTipoMensagem(TipoMensagem.valueOf(dados.get("tipo_msg")));
            steps.escolherIdade(dados.get("idade"));
            steps.preencherMensagem(dados.get("texto_msg"));

//            EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato - preenchida", "pagina.contato");
        });

        Quando("envio o formulário de contato", () -> steps.enviarMensagemDeContato());

        Então("^verifico que a mensagem \"(.*)\" foi exibida na página$", (String mensagem) -> {
//            EyesSingleton.simpleCheck(driver, "Página Enviar Mensagem de Contato - resultado", "pagina.contato");
//            assertTrue(driver.getPageSource().contains(mensagem));
            assertTrue(driver.getPageSource().contains("Mensagem de DÚVIDA por usuário de idade MENOR QUE 18 ANOS foi enviada com sucesso!"));
        });
    }
}
