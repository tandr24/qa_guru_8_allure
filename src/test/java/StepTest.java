
import org.junit.jupiter.api.Test;
import steps.GitHubSteps;

public class StepTest extends TestBase {
    private static final String link = "/tandr24/qa_guru_8_allure";
    private static final String nameOfBug = "BugBug";

    @Test
    public void simpleStepTest() {
        GitHubSteps gitHubStep = new GitHubSteps();
        gitHubStep.openRepoPage(link);
        gitHubStep.openIssueTab();
        gitHubStep.checkBugByName(nameOfBug);
    }
}
