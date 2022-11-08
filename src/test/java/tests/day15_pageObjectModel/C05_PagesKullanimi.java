package tests.day15_pageObjectModel;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PagesKullanimi {
    //1- https://www.facebook.com/ adresine gidin
    //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    //4- Basarili giris yapilamadigini test edin

    FacebookPage facebookPage=new FacebookPage();
    Faker faker=new Faker();
    SoftAssert softassert=new SoftAssert();
    @Test
    public void test01(){
        Driver.getdriver().get("https://www.facebook.com");
        ReusableMethods.bekle(5);
        facebookPage.cerezleriKabulet.click();
        facebookPage.emailKutusu
                .sendKeys(faker.internet().emailAddress()+ Keys.TAB);
        facebookPage.sifreKutusu.sendKeys(faker.internet().password()+Keys.TAB);
        ReusableMethods.bekle(1);
        facebookPage.girisButonu.click();
        softassert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed(),"girilemedi gorunmuyor");
        ReusableMethods.bekle(1);
        softassert.assertAll();
        Driver.closeDriver();
    }

}
