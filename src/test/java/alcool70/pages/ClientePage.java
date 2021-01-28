package alcool70.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientePage {

    @FindBy(className = "btn-primary")
    WebElement btproduto;

    @FindBy(id = "tipoCliente")
    WebElement tipocliente;

    @FindBy(name = "quantidade")
    WebElement inputItem;

    @FindBy(id = "calculardesconto.button.calcular")
    WebElement btcalcular;

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
        btproduto.click();
    }

    public void informarTipoCliente(String cliente) {
        new Select(tipocliente).selectByVisibleText(cliente);
    }

    public void informarQtdItem(String quantidade) {
        inputItem.sendKeys(quantidade);
    }

    public void calcularDesconto() {
        btcalcular.click();
    }

    public String getMsg() {
        return descontomsg.getText();
    }

    public String getFator() {
        return fatorobtido.getText();
    }
}
