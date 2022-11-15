package tests.day18_testNgReports_paralelTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


import java.util.List;

public class C03_RaporluTestOlusturma extends TestBaseRapor {
    AmazonPage amazonPage=new AmazonPage();

    @Test
    public void test01(){

        extentTest=extentReports.createTest("DropDown Testi","Dropdown da istenen elemanın " +
                "mevcudiyeti");

        //amazon a gidin
        //arama kutusunun yanındaki dropdown menuyu locate edin
        //DD menudeki tum options listesini oluşturup,
        // menude electronics başlıgı oldugunu test edin

        Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon anasyafay agidildi");
        Select select=new Select(amazonPage.dropdownMenu);
        extentTest.info("dropdown menu locate edildi");
        List<WebElement> optionslar= select.getOptions();

        // menude electronics başlıgı oldugunu test edin

        //yukarıdaki option Element List webelementlerden oluşuyor
        //electronics String inin listede olup olmadıgını test etmek için öncelikle string lerden oluşan bir
        //liste olmalı

        List<String> optionsString= ReusableMethods.getElementsText(optionslar);
        extentTest.info("dropdown ddaki tum optionsların text i alındı ve list e kaydedildi");
        Assert.assertTrue(optionsString.contains(ConfigReader.getProperty("amazonArananOptions")));
        extentTest.pass("dropdown menude aranan kelime oldugu test edildi");
        Driver.closeDriver();

    }



}
