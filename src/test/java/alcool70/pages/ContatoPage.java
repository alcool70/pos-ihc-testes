package alcool70.pages;

import alcool70.infra.TipoMensagem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ContatoPage {

    //    @FindBy(xpath = "/html/body/section/div[2]/div[3]/div[3]/a")
    @FindBy(xpath = ".//a[text()='Contato' and @class='btn btn-primary']")
    List<WebElement> buttonContato;

    @FindBy(id = "nome")
    WebElement inputNome;

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(name = "tipo")
    List<WebElement> radioTipoMensagem;

    @FindBy(id = "idade")
    WebElement selectIdade;

    @FindBy(id = "mensagem")
    WebElement textareaMensagem;

    @FindBy(xpath = "//button[contains(text(),'Enviar sua mensagem')]")
    WebElement buttonEnviarSuaMensagem;

    @FindBy(xpath = ".//div[@class='alert alert-dismissable alert-success']/span")
    WebElement toast;

    public ContatoPage(WebDriver drv) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(drv, 100);
        PageFactory.initElements(factory, this);
    }

    public void clicarBotaoContato() {
//        BaseSteps.verificarPresenca(buttonContato);
        buttonContato.get(0).click();
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
        radioTipoMensagem
                .stream()
                .filter(
                        it -> it.getAttribute("value").equalsIgnoreCase(tipo.name())
                )
                .collect(Collectors.toList())
                .get(0)
                .click();
    }

    public void escolherIdade(String idade) {
        new Select(selectIdade).selectByVisibleText(idade);
    }

    public void enviarMensagemDeContato() {
        // buttonEnviarSuaMensagem.click();
        inputEmail.submit();
    }

    public boolean toastText(String str) {
        return toast.getText().equalsIgnoreCase(str);
    }

}
