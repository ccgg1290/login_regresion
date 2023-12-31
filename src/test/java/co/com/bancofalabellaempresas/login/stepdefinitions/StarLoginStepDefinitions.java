package co.com.bancofalabellaempresas.login.stepdefinitions;

import co.com.bancofalabellaempresas.login.tasks.LoginTask;
import co.com.bancofalabellaempresas.login.userinterfaces.LoginPage;
import co.com.bancofalabellaempresas.login.utils.KillBrowser;

import static co.com.bancofalabellaempresas.login.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.login.questions.IsPresentElement.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static co.com.bancofalabellaempresas.login.interactions.WindowsManager.changeWindow;
//import static co.com.bancofalabellaempresas.login.userinterfaces.ValidateFieldEmpty.validateFieldEmpty;
import static co.com.bancofalabellaempresas.login.userinterfaces.LoginPage.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class StarLoginStepDefinitions {
    @Given("I want enter to Bancofalabella Empresas")
    public void IwantEnterToBancofalabellaEmpresas() throws InterruptedException {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                Open.browserOn().the(LoginPage.class));
    }
    @When("I log in with correct credentials")
    public void ILogIntoWithCorrectCredentials(DataTable data) throws InterruptedException {
        List<Map<String, String>> newdata = data.asMaps();
        WebDriver driver=getDriver();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata),
                changeWindow(driver)
        );

    }
    @Then("See my name in the home page")
    public void SeeMyNameInTheHomePage(DataTable data) throws InterruptedException{
        List<Map<String, String>> newdata = data.asMaps();
        assertEquals(NAME_HOME.getText(), newdata.get(0).get("NameUser"));
    }
    @When("I log in with incorrect credentials")
    public void ILogInWithIncorrectCredentials(DataTable data) throws InterruptedException {
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
        );
    }
    @When("I enter with empty fields")
    public void IEnterWithEmptyFields(DataTable data) throws InterruptedException {
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
        );
    }
    @When("I enter special characters in some field")
    public void IEnterSpecialCharactersInSomeField(DataTable data) throws InterruptedException {
        List<Map<String, String>> newdata = data.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
        );
    }
    @Then("see error Los datos ingresados no son validos")
    public void SeeErrorLosDatosIngresadosNoSonValidos() {
        //assertTrue(isPresentElement(LABEL_ERROR));

        theActorInTheSpotlight().should(
                seeThat("El elemento es:",
                        theTextOfTheElementIs(LABEL_ERROR),
                        equalTo("Los datos ingresados no son válidos.")
                )
        );

    }

}

