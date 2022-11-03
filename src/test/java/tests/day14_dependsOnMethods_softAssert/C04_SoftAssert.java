package tests.day14_dependsOnMethods_softAssert;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_SoftAssert extends TestBase {
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Online banking menusu icinde Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
    // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
    // "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        WebElement loginKutusu= driver.findElement(By.id("user_login"));

        Actions actions=new Actions(driver);
        actions.click(loginKutusu).sendKeys("username").
                sendKeys(Keys.TAB).
                sendKeys("password").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        driver.navigate().back();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
      WebElement online=wait.until(ExpectedConditions.elementToBeClickable(By.id("online-banking")));
      online.click();
      bekle(2);
      driver.findElement(By.id("pay_bills_link")).click();
      bekle(1);
      driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
      WebElement currency=driver.findElement(By.id("pc_currency"));
      Select DDM=new Select(currency);
      DDM.selectByValue("EUR");

      String expected="Eurozone (euro)";
      String actualText=DDM.getFirstSelectedOption().getText();
      SoftAssert softAssert=new SoftAssert();
      softAssert.assertEquals(actualText,expected,"Eurozone secilmedi");
    bekle(1);

       List<WebElement> options=DDM.getOptions();
       List<String> stringOptions=new ArrayList<>();

        for (WebElement each:options
             ) {
         stringOptions.add(each.getText());
        }
        bekle(1);
      //  System.out.println("deneme: "+stringOptions);
        // [Select One, Australia (dollar), Canada (dollar), Switzerland (franc), China (yuan), Denmark (krone),
        // Eurozone (euro), Great Britain (pound), Hong Kong (dollar), Japan (yen), Mexico (peso), Norway (krone),
        // New Zealand (dollar), Sweden (krona), Singapore (dollar), Thailand (baht)]

        String [] expectedUzun={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedSon= Arrays.asList(expectedUzun);
        bekle(1);

        //  System.out.println("deneme : "+son);
        //[Select One, Australia (dollar), Canada (dollar), Switzerland (franc), China (yuan), Denmark (krone),
        // Eurozone (euro), Great Britain (pound), Hong Kong (dollar), Japan (yen), Mexico (peso), Norway (krone),
        // New Zealand (dollar), Sweden (krona), Singapore (dollar), Thailand (baht)]
        softAssert.assertEquals(stringOptions,expectedSon,"Kurlar farklı ");
        softAssert.assertAll();
    }

}


