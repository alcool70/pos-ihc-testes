package alcool70.infra;

import com.applitools.eyes.exceptions.DiffsFoundException;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public final class EyesSingleton {

    private static volatile Eyes _instance;

    private EyesSingleton() {
    }

    /*
     * See https://refactoring.guru/pt-br/design-patterns/singleton/java/example#example-2
     */

    public static Eyes getInstance() {
        Eyes res = _instance;
        if (res != null) return res;

        synchronized (EyesSingleton.class) {
            if (_instance == null) {
                _instance = new Eyes();
                _instance.setApiKey(Globals.APPLITOOLS_API_KEY);
            }

            return _instance;
        }
    }

    public static void open(WebDriver driver, String testName) {
        getInstance()
                .open(
                        driver,
                        "Alcool70 - Calculadora de Descontos T5.2021.01",
                        testName);
    }

    public static void close() {
        getInstance().close();
    }

    public static void simpleCheck(WebDriver driver, String testName, String tag) {
        try {
            open(driver, testName);
            getInstance().checkWindow(tag);
            close();
        } catch (DiffsFoundException e) {
            System.out.println("*** Diferenças encontradas");
            e.printStackTrace();
        }
    }
}
