package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EndToEndTesti {

    /*
    E2E (End to End Testi), uctan uca bir işlevin tum asamalarını gerecekleştirierek,
    işlevin çalıştıgını test etmek demektir.

    //MyCoursedemy sayfaasına gidin gecerli kullanıcı adı ve şifre girereek sisteme login olun
    mycourses linkini tıklayın
    yeni bir course oluştrumak için istenen bilgileri girin
    yeni kursun oluşturuldugunu test edin

     */

    @Test
    public void e2eKursOlusturmaTesti(){
        // MyCoursedemy sayfasina gidin
        Driver.getdriver().get(ConfigReader.getProperty("myUrl"));
        // gecerli kullanici adi ve sifre girerek sisteme login olun
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(1);
        myCoursedemyPage.loginMethodu();
        // Instructor linkini tiklayin
        myCoursedemyPage.instructorLinki.click();
        // course manager linkine tiklayin
        myCoursedemyPage.courseManagerLinki.click();
        // add New Course butonuna tiklayin
        myCoursedemyPage.addNewCourseButonu.click();
        ReusableMethods.bekle(1);
        // course title bilgisi girin
        myCoursedemyPage.courseTitleKutusu.sendKeys(ConfigReader.getProperty("myCourseTitle"));
        // category menusune tiklayin
        myCoursedemyPage.categoryMenusu.click();
        // ilgili kurs kategorisini secin
        myCoursedemyPage.categorySecimi.click();
        //burada javaScript executor da kullanılabilir.
        ReusableMethods.bekle(1);
        // next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        ReusableMethods.bekle(1);
        // price kutusuna fiyati yazdiralim
        myCoursedemyPage.coursePrice.sendKeys(ConfigReader.getProperty("myCoursePrice"));
        // indirim kutusuna %50 yazalim
        myCoursedemyPage.discountKutusu.sendKeys(ConfigReader.getProperty("myDiscount"));
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        ReusableMethods.bekle(1);
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // meta keywords kutusuna java kursu yazdiralim
        myCoursedemyPage.metaKeywordsKutusu.sendKeys(ConfigReader.getProperty("myMetaKeywords"));
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        ReusableMethods.bekle(1);
        // submit butonuna basalim
        myCoursedemyPage.submitButonu.click();
        ReusableMethods.bekle(1);
        // yeni kursun olusturuldugunu test edin
        Assert.assertTrue(myCoursedemyPage.backToCourseListButonu.isEnabled());
        Driver.closeDriver();
    }
    /*
    a tag i ile başlıyorsa linkText ten gidilebilir.
    textten sadece  bir adet var ve a değilse ve de tagı onemli degilse o zaman tag ı ne olursa olsun diyerek
    text uzeırnden gidilebilr..
    t
     */

}
