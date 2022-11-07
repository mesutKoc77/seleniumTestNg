package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C04_PagesKullanimi {
    // Amazon anasayfaya gidin
    // 3 test method'u olusturun
    // Herbir method'da Nutella, Java, Bicycle icin arama yapip,
    // sonuclarin arama yaptigimiz kelimeleri icerdigini test edin

    String actual;
    String expected;

    AmazonPage amazonPage=new AmazonPage();
    SoftAssert softassert=new SoftAssert();
    @Test
    public void test01(){
        Driver.getdriver().get("https://www.amazon.com");
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        actual=amazonPage.aramaSonucElementi.getText();
        expected="Nutella";
        softassert.assertTrue(actual.contains(expected),"nutella yok");
        softassert.assertAll();
    }

    @Test(dependsOnMethods ="test01")
    public void test02(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Java"+Keys.ENTER);
        actual=amazonPage.aramaSonucElementi.getText();
        expected="Java";
        softassert.assertTrue(actual.contains(expected)," java yok");
        softassert.assertAll();

    }
    @Test(dependsOnMethods = "test01")
    public void test03(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Bicycle"+Keys.ENTER);
        actual=amazonPage.aramaSonucElementi.getText();
        expected="Bicycle";
        softassert.assertTrue(actual.contains(expected),"bicycle yok");
        softassert.assertAll();
        Driver.closeDriver();

    }

}
