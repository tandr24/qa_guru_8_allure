import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;


import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Selenide.*;

public class SeleinideTest {

    @Test
    @Owner("Tatiana")
    @Severity(SeverityLevel.BLOCKER)
    void simpleSeleinideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/tandr24/qa_guru_8_allure");
        $("#issues-tab").click();
        $$("[data-testid=issue-pr-title-link]").shouldHave(anyMatch(
                "element exist",
                el -> el.getText().contains("Bug2")
        ));
    }
}
