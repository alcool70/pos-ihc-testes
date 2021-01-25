package alcool70.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContatoPage {

    @FindBy(xpath = ".//a[text()='Contato' and @class='btn btn-primary']")
    public static WebElement buttonContato;

    @FindBy(id = "nome")
    public static WebElement inputNome;

    @FindBy(id = "email")
    public static WebElement inputEmail;

    @FindBy(name = "tipo")
    public static List<WebElement> radioTipoMensagem;

    @FindBy(id = "idade")
    public static WebElement selectIdade;

    @FindBy(id = "mensagem")
    public static WebElement textareaMensagem;

    @FindBy(xpath = "//button[contains(text(),'Enviar sua mensagem')]")
    public static WebElement buttonEnviarSuaMensagem;

    public void clicarBotaoContato() {
        buttonContato.click();
    }

    public void preencherNome(String nome) {
        inputNome.clear();
        inputNome.sendKeys(nome);
    }

    public void preencherEmail(String email) {
        inputNome.clear();
        inputNome.sendKeys(email);
    }

    public void preencherMensagem(String mensagem) {
        inputNome.clear();
        inputNome.sendKeys(mensagem);
    }

    public void escolherTipoMensagem(TipoMensagem tipo) {
        for (WebElement e : radioTipoMensagem) {
            String value = e.getAttribute("value");
            if (value.equalsIgnoreCase(tipo.name())) {
                e.click();
            }
        }
    }

    public void escolherIdade(String idade) {
        new Select(selectIdade).selectByVisibleText(idade);
    }

    public void enviarMensagemDeContato() {
        inputEmail.submit();
//        buttonEnviarSuaMensagem.click();
    }

}
