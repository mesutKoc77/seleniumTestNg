package tests.day19_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] aranacakKelimeProvideri() {

        Object[][] aradiklarimiz = {{"nutella"}, {"java"}, {"samsung"}, {"tv"}};
        return aradiklarimiz;
    }
    /*
    amazon anasayfaya gidin
    nutella, java, samsung, tv için aramaa yapın
    arama sonuclarının aranan kelime içerdiigini test edin
     */

    @Test(dataProvider = "aranacakKelimeProvideri")
    public void aramaTesti(String aranacakKelime) {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
        String actualYazi = amazonPage.aramaSonucElementi.getText();
        ReusableMethods.bekle(3);
        Assert.assertTrue(actualYazi.contains(aranacakKelime));
        Driver.closeDriver();
    }


}
