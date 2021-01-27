package alcool70.steps;

import io.cucumber.java8.Pt;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BaseSteps implements Pt {

    protected WebDriver driver;

    public BaseSteps() {
        // BeforeAll
        Before(() -> {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--window-size=1400,900", "--no-sandbox", "--headless",
                    "--disable-gpu", "--disable-crash-reporter", "--disable-extensions",
                    "--disable-in-process-stack-traces", "--disable-logging",
                    "--disable-dev-shm-usage", "--log-level=5", "--output=/dev/null");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            int w = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

//            driver.manage().window().setSize(new Dimension(1280, 1024));
            driver.manage().window().setPosition(new Point(2500, 100));
        });

        BeforeStep(() -> {
            // EyesSingleton.simpleCheck(driver, "Página Inicial", "pagina.inicial");
            driver.get("https://calculadora.diegoquirino.net");
        });

        // AfterAll
        After(() -> {
            if (driver != null)
                driver.quit();
        });
    }

    public static void verificarPresenca(WebElement element) {
        await()
                .atMost(Duration.ofSeconds(10))
                .until(element::isDisplayed);
    }
}
