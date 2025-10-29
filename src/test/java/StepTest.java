import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.GitHubSteps;

public class StepTest {
    private static final String link = "https://github.com/tandr24/qa_guru_8_allure";
    private static final String nameOfBug = "BugBug";

    @Test
    public void simpleStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GitHubSteps gitHubStep = new GitHubSteps();
        gitHubStep.openRepoPage(link);
        gitHubStep.openIssueTab();
        gitHubStep.checkBugByName(nameOfBug);

    }
}
