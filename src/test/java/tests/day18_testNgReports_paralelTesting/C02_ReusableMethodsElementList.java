package tests.day18_testNgReports_paralelTesting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;
public class C02_ReusableMethodsElementList {
    AmazonPage amazonpage=new AmazonPage();
    @Test
    public void test01(){
        //amazon a gidin
        //arama kutusunun yanındaki dropdown menuyu locate edin
        //DD menudeki tum options listesini oluşturup,
        // menude electronics başlıgı oldugunu test edin

        Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));
        Select select=new Select(amazonpage.dropdownMenu);
        List<WebElement> optionslar= select.getOptions();

        // menude electronics başlıgı oldugunu test edin

        //yukarıdaki option Element List webelementlerden oluşuyor
        //electronics String inin listede olup olmadıgını test etmek için öncelikle string lerden oluşan bir
        //liste olmalı

        List<String> optionsString=ReusableMethods.getElementsText(optionslar);
        Assert.assertTrue(optionsString.contains(ConfigReader.getProperty("amazonArananOptions")));
        Driver.closeDriver();
    }
}
