package tests.day19_dataProvider_crossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginDataProvider {
    @DataProvider
    public static Object[][] mailVeSifrelerinProvideri() {

        Object[][] bilgilerimiz = {
                {"abc@gmail.com", "12345"}
                , {"gfre@gmail.com", "12455"}
                , {"abcde@gmail.com", "5hfgt"}
                , {"soner@gmail.com", "9jdgfr"}
                , {"Fatih@gmail.com", "jhhgf65"}
                , {"Nevzat@gmail.com", "6645gd"}
                , {"Murat@gmail.com", "7fghrt"}
                , {"Ahmet@gmail.com", "hfgdt"}
                , {"yghdr48@gmail.com", "5dgder"}
                , {"budason@gmail.com", "7y65f"}
        };
        return bilgilerimiz;
    }
    /*
    negatif Login testi için verilen 10 adwt kullanıcı ve sifreyi deneyip
    giriş yapılamadıgını test edinn

     */
    //38.40

    @Test(dataProvider = "mailVeSifrelerinProvideri")
    public void test01(String email, String sifre) {
        // Mycoursedemy anasayfasina gidin
        Driver.getdriver().get(ConfigReader.getProperty("myUrl"));
        // login linkine basin
        MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();
        myCoursedemyPage.loginLinki.click();

        // 1- verilen listeden kullanici adi ve password yazalim
        myCoursedemyPage.emailKutusu.sendKeys(email);
        myCoursedemyPage.passwordKutusu.sendKeys(sifre);
        // Login butonuna basarak login olmaya calisin
        if (myCoursedemyPage.cookies.isDisplayed()){
            myCoursedemyPage.cookies.click();
        }
        ReusableMethods.waitForClickablility(myCoursedemyPage.loginButonu,10);
        ReusableMethods.bekle(1);
        myCoursedemyPage.loginButonu.click();
        ReusableMethods.bekle(1);
        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());


    }
}
