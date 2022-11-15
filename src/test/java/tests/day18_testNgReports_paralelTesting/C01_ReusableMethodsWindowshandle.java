package tests.day18_testNgReports_paralelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ReusableMethodsWindowshandle {
    // Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro

    // https://the-internet.herokuapp.com/iframe adresine gidin
    // elemental selenium linkini tiklayin
   // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
   // ve yazinin Elemental Selenium oldugunu test edin

    @Test
    public void test01(){
        Driver.getdriver().get("https://the-internet.herokuapp.com/iframe");
        Driver.getdriver().findElement(By.linkText("Elemental Selenium")).click();
        /*
        burda linke tıkladıgımızda ikinci sayfa açılacak ve bizim de driver imizi o
        sayfaya yonlendiremeiz gerekiyor.
         */
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        WebElement actualText=Driver.getdriver().findElement(By.tagName("h1"));
        Assert.assertTrue(actualText.isDisplayed());
        Driver.closeDriver();
    }

}
