
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest extends TestBase {

    private static final String link = "/tandr24/qa_guru_8_allure";
    private static final String nameOfBug = "Bug2";

    @Test
    public void simpleLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open github repo", () -> {
            open(link);
        });


        step("Click on \"Issue\" tab", () -> {
            $("#issues-tab").click();
        });

        step("Check that bug with name {name} exists", () -> {
            $$("[data-testid=issue-pr-title-link]").shouldHave(anyMatch(
                    "element exist",
                    el -> el.getText().contains(nameOfBug)
            ));
        });

    }
}
