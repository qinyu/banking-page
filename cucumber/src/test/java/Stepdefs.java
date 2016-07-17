import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Stepdefs {
    @Given("^I start App$")
    public void i_start_App() throws Throwable {
        $("body").should(appear);
    }

    @Then("^I should see main menu:$")
    public void i_should_see_main_menu(DataTable mainMenu) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        ElementsCollection elements = $("ion-side-menu-content").$("ion-list").$$("ion-item");
        elements.shouldHaveSize(6);

        String[] items = mainMenu.asList(String.class).toArray(new String[6]);
        elements.shouldBe(CollectionCondition.texts(items));
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String menuItem) throws Throwable {
        $(By.linkText(menuItem)).click();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void i_should_see(String playlist) throws Throwable {
        $("ion-side-menu-content").$("ion-view[nav-view=\"active\"]").shouldBe(text(playlist));
    }

    @When("^I click side menu icon$")
    public void i_click_side_menu_icon() throws Throwable {
        $("div.nav-bar-block[nav-bar=\"active\"]").$("button.button.button-icon.button-clear.ion-navicon").click();
    }

    @Then("^I should see menu items:$")
    public void i_should_see_menu_items(DataTable sideMenuTexts) throws Throwable {
        ElementsCollection elements = $("ion-side-menu").$("ion-list").$$("ion-item");
        elements.shouldHaveSize(4);

        String[] items = sideMenuTexts.asList(String.class).toArray(new String[4]);
        elements.shouldBe(CollectionCondition.texts(items));
    }
}
