package tests.day16_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ConfigReaderKullanimi {
    /*
    properties de bulunan url vb lerini okuyup koda cevirecek bir aracı lazım buna reader deniyor
    ve bugun bunu işleyecegız

     */

    @Test
    public void method01(){
          /*
    amazona git
    nutella ara
    sonucun aradıgın kelimeyi içeriyor mu
     */
        Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        ReusableMethods.bekle(2);
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAramaKelimesi")+ Keys.ENTER);
        SoftAssert softAssert=new SoftAssert();
        String actualYazi=amazonPage.aramaSonucElementi.getText();
        String expectedKelime=ConfigReader.getProperty("amazonAramaKelimesi");
        softAssert.assertTrue(actualYazi.contains(expectedKelime),"kelime yok");
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        Driver.closeDriver();

    }

}
