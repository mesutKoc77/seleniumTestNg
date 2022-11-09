package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegatifLoginTesti {
    MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();
    @BeforeClass
    public  void setUp(){
        // Mycoursedemy anasayfasina gidin
        // login linkine basin
        Driver.getdriver().get(ConfigReader.getProperty("myUrl"));
        myCoursedemyPage.loginLinki.click();
        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(1);
    }
    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin

    @Test()
    public void yanlisKullaniciTesti(){
        // 1- yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        myCoursedemyPage.loginButonu.click();
        //başarılı olarak girişlemedigini test edin
        //bunun için hala login linkinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }
    @Test()
    public void yanlisPasswordTesti(){
        // 2- gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        myCoursedemyPage.loginButonu.click();
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }

    @Test ()
    public void hemKullanicihemPasswordTesti(){
        // 3- yanlis kullanici adi, yanlis password
        // Login butonuna basarak login olmaya calisin
        // Basarili olarak giris yapilamadigini test edin
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        myCoursedemyPage.loginButonu.click();
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
    }

    @AfterClass
    public void tearDown(){
        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }
}
