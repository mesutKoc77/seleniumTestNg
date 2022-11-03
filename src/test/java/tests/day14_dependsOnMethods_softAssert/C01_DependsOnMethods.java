package tests.day14_dependsOnMethods_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C01_DependsOnMethods extends TestBaseClass {
    /*
     // Uc test method'u olusturun
    // 1. testin ismi amazon testi olsun,
    //    amazon anasayfasina gidip, amazona gittigimizi test edin
    // 2. testin ismi nutella testi olsun
    //    nutella icin arama yapip, sonuclarin nutella icerdigini test edin
    // 3. testin ismi arama sonuc testi olsun
    //    sonuc sayisinin 100'den fazla oldugunu test edin

    // Uc-Testmethode erstellen
     // Der Name des 1. Tests sei der Amazon-Test,
     // Gehe zur Amazon-Homepage und teste, dass wir zu Amazon gehen
     // Der zweite Test soll Nutella-Test genannt werden
     // Suche nach Nutella und teste, ob die Ergebnisse Nutella enthalten
     // Der Name des 3. Tests sei der Suchergebnistest
     // testen, ob die Anzahl der Ergebnisse mehr als 100 beträgt

     */


    /*
      DependsOnMethods="BagliOlunanTestAdi"
      iki test method'unu birbirine baglar
      Bu sekilde bagli olunan test failed olursa,
      bagli olan test ignore edilir, hic calismaz

     */

    @Test
    public void amazonTesti(){
        // Der Name des 1. Tests sei der Amazon-Test,
        // Gehe zur Amazon-Homepage und teste, dass wir zu Amazon gehen
        driver.get("https://www.amazon.com");
        String erwartet="amazon.com";
        String aktuell=driver.getCurrentUrl();
        assertTrue(aktuell.contains(erwartet));
    }

    @Test(priority = 2,dependsOnMethods ="amazonTesti")
    public void nutellaTesti(){
        // Der zweite Test soll Nutella-Test genannt werden
        // Suche nach Nutella und teste, ob die Ergebnisse Nutella enthalten

      WebElement suchen=driver.findElement(By.id("twotabsearchtextbox"));
      suchen.sendKeys("Nutella"+Keys.ENTER);

        WebElement ergebnisseTexteElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String erwatetText="Nutella";
        assertTrue(ergebnisseTexteElement.getText().contains(erwatetText));
    }

    @Test (priority = 5, dependsOnMethods = "nutellaTesti")
    public void aramaSonucTesti() throws InterruptedException {
        // Der Name des 3. Tests sei der Suchergebnistest
        // testen, ob die Anzahl der Ergebnisse mehr als 100 beträgt

        Thread.sleep(5);
        WebElement ergebnisseTexteElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String dieTextederErgebnisseText=ergebnisseTexteElement.getText();//1-48 of 108 results for "Nutella"

        int indexOf=dieTextederErgebnisseText.indexOf("of");
        int indexResult=dieTextederErgebnisseText.indexOf("results");
        String yuzsekiz=dieTextederErgebnisseText.substring(indexOf+3,indexResult-1);
        int intyuzsekiz=Integer.parseInt(yuzsekiz);
        int beklenenSayi=100;
        assertTrue(intyuzsekiz>beklenenSayi);
    }

}
