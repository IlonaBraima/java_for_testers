import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
        app.init();
    }
}
