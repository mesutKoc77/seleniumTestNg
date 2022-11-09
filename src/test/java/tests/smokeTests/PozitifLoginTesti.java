package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){
        //mycoursedemy anasayfasına gidin
        //login linkine basın
        //kullanıcı e mail i olarak valid e mail girin
        //kullanıcı sifresi olarak valid sifre girin
        //login butonuna basarak login olun
        //basarılı olarak giris yapılabildigibni test edin

        MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();
        Driver.getdriver().get(ConfigReader.getProperty("myUrl"));
        myCoursedemyPage.loginLinki.click();
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(2);
        myCoursedemyPage.loginButonu.click();
        Assert.assertTrue(myCoursedemyPage.basariliLogin.isDisplayed());
        Driver.closeDriver();
    }
}
