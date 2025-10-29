package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.anyMatch;

import static com.codeborne.selenide.Selenide.*;

public class GitHubSteps {
    @Step("Open github repo")
    public void openRepoPage(String link) {
        open(link);
    }

    @Step("Click on \"Issue\" tab")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Check that bug with {name} exists")
    public void checkBugByName(String name) {
        $$("[data-testid=issue-pr-title-link]").shouldHave(anyMatch(
                "element exist",
                el -> el.getText().contains(name)
        ));
    }
}
