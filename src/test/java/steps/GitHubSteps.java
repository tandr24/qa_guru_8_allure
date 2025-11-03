package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.anyMatch;

import static com.codeborne.selenide.Selenide.*;

public class GitHubSteps {
    final private SelenideElement issueTab = $("#issues-tab");
    final private ElementsCollection bugByNameField = $$("[data-testid=issue-pr-title-link]");

    @Step("Open github repo")
    public void openRepoPage(String link) {
        open(link);
    }

    @Step("Click on \"Issue\" tab")
    public void openIssueTab() {
        issueTab.click();
    }

    @Step("Check that bug with {name} exists")
    public void checkBugByName(String name) {
        bugByNameField.shouldHave(anyMatch(
                "element exist",
                el -> el.getText().contains(name)
        ));
    }
}
