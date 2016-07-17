import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by yqin on 7/16/16.
 */
public class Hooks {

    @Before
    public void beforeScenario() {
        Configuration.screenshots = false;
    }


    @After
    public void afterScenario() {
        WebDriverRunner.closeWebDriver();
    }

}
