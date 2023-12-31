
package co.com.bancofalabellaempresas.login.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static co.com.bancofalabellaempresas.login.interactions.ChooseOptionDropDown.selectOptionDropDown;
import static co.com.bancofalabellaempresas.login.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import net.serenitybdd.screenplay.waits.WaitUntil;
public class LoginTask implements Task {

    private final List<Map<String, String>> data;
    public LoginTask(List<Map<String, String>> data) {

        this.data = data;
    }
    public static LoginTask intoPage(List<Map<String, String>> data) {
        return Tasks.instrumented(LoginTask.class,data);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {


        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CLIENTE_EMPRESARIAL, isCurrentlyVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(data.get(0).get("ClienteEmpresarial")).into(CLIENTE_EMPRESARIAL),
                //selectOptionDropDown(TIPO_DE_IDENTIFICACION,data.get(0).get("TipoDeIdentificación")),
                SelectFromOptions.byVisibleText(data.get(0).get("TipoDeIdentificación")).from(TIPO_DE_IDENTIFICACION),
                WaitUntil.the(NUMERO_DE_IDENTIFICACION, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.get(0).get("NúmeroDeIdentificación")).into(NUMERO_DE_IDENTIFICACION),
                WaitUntil.the(CLAVE_PERSONAL, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.get(0).get("ClavePersonal")).into(CLAVE_PERSONAL),
                WaitUntil.the(CLAVE_TOKEN, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.get(0).get("ClaveToken")).into(CLAVE_TOKEN),
                WaitUntil.the(BTN_SIGIN, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SIGIN)
                //WaitUntil.the(LABEL_ERROR, isCurrentlyVisible()).forNoMoreThan(60).seconds()



        );
    }
}
