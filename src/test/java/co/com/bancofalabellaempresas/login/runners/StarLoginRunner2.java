package co.com.bancofalabellaempresas.login.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/starLogin.feature",
        glue = {"co.com.bancofalabellaempresas.login.Hooks",
                "co.com.bancofalabellaempresas.login.stepdefinitions"},
        tags = "@LoginWithEmptyFields",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class StarLoginRunner2 {
}
