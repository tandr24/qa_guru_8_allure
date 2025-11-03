import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
     @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1200";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @BeforeEach
    void beforeSingle() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
