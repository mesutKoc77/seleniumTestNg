package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverKullanimi {

    //bir test methodu oluştururn,
    //amazon a gidin
    //başlıgının amazon içerdigğini test edin
    //nutella için arama yapin
    //ve sonucların nutella içerdiğini test edin
    //wisequarter sayfasına gidip Url in wisequarter içerdiğini dogrulayın edin

    @Test
    public void test01(){

            // 1- amazon'a gidin, basliginin amazon icerdigini dogrulayin

                // 1- amazon'a gidin, basliginin amazon icerdigini dogrulayin
                Driver.getdriver().get("https://www.amazon.com");
                String expectedKelime="Amazon";
                String actualTitle=Driver.getdriver().getTitle();

                SoftAssert softAssert=new SoftAssert();
                softAssert.assertTrue(actualTitle.contains(expectedKelime),"baslik amazon icermiyor");

                // 2- nutella icin arama yapin ve sonuclarin nutella icerdigini dogrulayin

                WebElement aramaKutusu=Driver.getdriver().findElement(By.id("twotabsearchtextbox"));
                aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

                WebElement aramaSonucElementi=
                        Driver.getdriver().findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
                String arananKelime="Nutella";
                String actualAramaSonucu= aramaSonucElementi.getText();

                softAssert.assertTrue(actualAramaSonucu.contains(arananKelime),"Arama sonucu nutella icermiyor");

                // 3- wisequarter sayfasina gidip, url'in wisequarter icerdigini dogrulayin
                Driver.getdriver().get("https://www.wisequarter.com");

                String arananUrlKelime="wisequarter";
                String actualUrl= Driver.getdriver().getCurrentUrl();

                softAssert.assertTrue(actualUrl.contains(arananUrlKelime),"url wisequarter icermiyor");
                softAssert.assertAll();
                ReusableMethods.bekle(2);
                Driver.closeDriver();

    }

}
