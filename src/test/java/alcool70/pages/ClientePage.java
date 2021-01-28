package alcool70.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClientePage {

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    List<WebElement> listProdutos;

    @FindBy(name = "tipoCliente")
    WebElement tipocliente;

    @FindBy(name = "quantidade")
    WebElement inputItem;

    @FindBy(xpath = "//a[starts-with(text(),'Calcular Desconto') and @class='btn btn-primary']")
    WebElement linkAcessoCalculoDesconto;

    @FindBy(xpath = "//button[text()='Calcular Desconto!']")
    WebElement buttonAcessoCalculoDesconto;

    @FindBy(xpath = "//div[@id='success.msg']/strong[contains(text(),'Operação realizada com sucesso')]")
    WebElement descontomsg;

    @FindBy(xpath = "//div[@class='panel panel-info']/div[@class='panel-body']/p[3][text()]")
    WebElement fatorobtido;

    public ClientePage(WebDriver driver) {
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        // PageFactory.initElements(driver, ContatoPage.class);
        PageFactory.initElements(driver, this);
    }

    public void acesseProduto() {
        listProdutos.get(0).click();
    }

    public void informarTipoCliente(String cliente) {
        new Select(tipocliente).selectByVisibleText(cliente);
    }

    public void informarQtdItem(String quantidade) {
        inputItem.sendKeys(quantidade);
    }

    public void acessarCalcularDesconto() {
        linkAcessoCalculoDesconto.click();
    }

    public void calcularDesconto() {
        buttonAcessoCalculoDesconto.click();
    }

    public String getMsg() {
        return descontomsg.getText();
    }

    public String getFator() {
        return fatorobtido.getText();
    }
}
