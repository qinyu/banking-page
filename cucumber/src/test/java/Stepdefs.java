import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class Stepdefs {
    @Given("^I start App$")
    public void i_start_App() throws Throwable {
        $("body").should(appear);
    }
}
