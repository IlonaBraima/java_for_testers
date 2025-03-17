package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.IssueData;

public class IssueCreationTests extends TestBase {

    @Test
    void canCreateIssue() {
        app.rest().createIssue(new IssueData());
    }

}
