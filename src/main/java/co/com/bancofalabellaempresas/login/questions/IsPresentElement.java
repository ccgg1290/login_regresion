package co.com.bancofalabellaempresas.login.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
//import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.serenitybdd.core.Serenity.getDriver;
//import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import java.lang.Exception;
import java.lang.Exception.*;

public class IsPresentElement  {

    public By element;

    public IsPresentElement(By element) {
        this.element = element;
    }

  public static Boolean isPresentElement(By element) {
        WebDriver driver = getDriver();
      //Boolean element1 = element.size() != 0;
      Boolean element2;
      try {
          element2 = driver.findElements(element).size() != 0;
          System.out.println("esto es el assert " + element2);
      }
      catch (java.lang.AssertionError exception) {
          throw new java.lang.AssertionError("El elemento no esta visible, por favor validaer");
      }
      return element2;
  }

}
