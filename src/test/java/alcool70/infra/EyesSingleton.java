package alcool70.infra;

import com.applitools.eyes.exceptions.DiffsFoundException;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class EyesSingleton {

    private static Eyes eyes = null;

    private EyesSingleton() {
    }

    public static Eyes get() {
        if (eyes == null) {
            eyes = new Eyes();
            eyes.setApiKey(Globals.APPLITOOLS_API_KEY);
        }
        return eyes;
    }

    public static void open(WebDriver driver, String testName) {
        get().open(driver, "Calculadora de Descontos T5.2021.01", testName);
    }

    public static void close() {
        get().close();
    }

    public static void simpleCheck(WebDriver driver, String testName, String tag) {
        try {
            open(driver, testName);
            get().checkWindow(tag);
            close();
        } catch (DiffsFoundException e) {
            System.out.println("*** Diferenças encontradas");
            e.printStackTrace();
        }
    }

}
