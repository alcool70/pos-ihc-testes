package alcool70.infra;

import io.github.cdimascio.dotenv.Dotenv;

public final class Globals {
    static String APPLITOOLS_API_KEY;

    static {
        Dotenv dotenv = Dotenv.load();
        APPLITOOLS_API_KEY = dotenv.get("APPLITOOLS_API_KEY");
    }
}
