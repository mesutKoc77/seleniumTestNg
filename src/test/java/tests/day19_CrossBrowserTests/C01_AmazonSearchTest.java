package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {
    @Test
    public void test01() {
        //amazona git
        //nutella için arama yap
        //sonuçların içerdigini test edin
        driver.get(ConfigReader.getProperty("amazonUrl"));
        //burada amazonPage deki webelemtnleri kullanamayız cunku ordaki driver farklı
        ReusableMethods.bekle(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        String aramaSonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expextedKelime="nutella";
        Assert.assertTrue(aramaSonucYazisi.contains(expextedKelime));
        ReusableMethods.bekle(5);
    }

}
