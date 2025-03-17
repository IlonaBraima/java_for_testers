package ru.stqa.mantis.manager;
import org.checkerframework.checker.signature.qual.Identifier;
import ru.stqa.mantis.model.IssueData;

public class RestApiHelper extends HelperBase {

    public RestApiHelper(ApplicationManager manager) {
        super(manager);
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
        Authorization.setApiKey(manager.property("apiKey"));
    }

    public void createIssue(IssueData issueData) {
        Issue issue = new Issue();
        issue.setSummary(issueData.summary());
        issue.setDescription(issueData.description());
        var projectId = new Identifier();
        projectId = new Identifier();
        projectId.setId(issueData.project());
        issue.setProjects(projectId);
        var categoryId = new Identifier();
        categoryId.setId(issueData.category());
        issue.setCategory(CategoryId());

        IssuesApi apiInstance = new IssuesApi();
        try {
            apiInstance.issueAdd(body);
        } catch (ApiException e) {
           new RuntimeException(e);
        }
    }
}
