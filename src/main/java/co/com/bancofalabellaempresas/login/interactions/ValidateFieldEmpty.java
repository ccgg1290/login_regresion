package co.com.bancofalabellaempresas.login.interactions;

import com.sun.xml.bind.v2.model.core.ID;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
//import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;
import java.util.HashMap;




public class ValidateFieldEmpty {

    public static List<Map<String, String>> validateFieldEmpty(List<Map<String, String>> data){

        List<Map<String, String>> data1=data;
        String value=data1.get(0).get("TipoDeIdentificación");
        System.out.println("valor tipo de identificacin: "+value);
        if (value==null){
            System.out.println("La opcion del dropdown viene vacia");
            Map<String, String> colors = new HashMap<>();
            colors.put("TipoDeIdentificación", "-- SELECCIONE --");
            System.out.println(colors);
            data1.get(0).put("TipoDeIdentificación1", "-- SELECCIONE --");
        }
        else{
            System.out.println("El valor no venia vacio y es: "+value);
        }
        return data1;


    }
}

