package todomvc;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.Start;
import todomvc.ui.TheItems;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;

public class AddNewTasksStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void set_the_stage(){
        System.setProperty("webdriver.chrome.driver","F:\\Arun-Studies\\Drivers\\chromedriver.exe");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void that_James_has_an_empty_todo_list(String actorName) throws Exception {
            OnStage.theActorCalled(actorName)
                   .attemptsTo(Start.withAnEmptyList());
    }

    @Given("^that (?:.*) has a list containing (.*)$")
    public void has_a_list_containing(List<String> tasks) throws Exception {
        // TODO
        throw new PendingException();
    }

    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddATodoItem.called(taskName)
        );
    }

    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName) throws Exception {
        OnStage.theActorInTheSpotlight().should(seeThat(
                "the items displayed", TheItems.displayed(), hasItem(taskName)
        ));
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks) throws Exception {
        // TODO
        throw new PendingException();
    }
}
