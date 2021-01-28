package alcool70.steps;

import io.cucumber.java8.Pt;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseSteps implements Pt {

    private WebDriver driver;

    public BaseSteps() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--window-size=1400,900", "--no-sandbox", //"--headless",
                "--disable-gpu", "--disable-crash-reporter", "--disable-extensions",
                "--disable-in-process-stack-traces", "--disable-logging",
                "--disable-dev-shm-usage", "--log-level=5", "--output=/dev/null");

        // BeforeAll
        Before(() -> {

            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // EyesSingleton.simpleCheck(driver, "Página Inicial", "pagina.inicial");
            driver.get("https://calculadora.diegoquirino.net");
        });

        //BeforeStep(() -> {});

        // AfterAll
        After(() -> {
            if (driver != null) driver.quit();
        });
    }

    public WebDriver getDriver() {
        return driver;
    }
}
