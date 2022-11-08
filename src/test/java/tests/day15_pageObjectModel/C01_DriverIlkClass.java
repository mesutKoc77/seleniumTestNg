package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkClass {
    /*
    java non altına pages adında package  oluşturduk ki sureklı webElement oluşturmayalım
    com.testNg nin altına sonuna .properties yazacak şekilde bir file dosyası attık. url leri ordan alabilmek için.

     */

     /*
      POM de 4 farkli dosyadan ihtiyacimiz olan bilgileri aliriz
      1- Driver class == driver
      2- pages package altindaki page class'lari == locate
      3- configurtaion.properties dosyasi == test datalari
      4- Reusable methods class == ihtiyac duyabilecegimiz pratik method'lar
      Daha once kullandigimiz extends keyword ile inheritance sadece 1 class'a olabileceginden
      POM'de tercih edilmemistir
      Java'da bir class'daki class uyelerini kullanmanin farkli yollari vardir
      1- extends ile inherit edip direk kullanma
      2- class uyelerini static tanimlayip classAdi.uyeAdi seklinde kullanabiliriz
      3- istedigimiz class'dan obje olusturarak class uyelerini kullanabiliriz
      POM 2 yontemi de kullanir.
     */

    @Test
    public void test01() throws InterruptedException {
        Driver.getdriver().get("https://www.amazon.com");
        /*
        biz get driver() methodu her çalıştırdıgımızda method içinde bulunan driver=new Chrome driver()
        talimati her seferinde yeni bir chrome penceresi açmaktadır.
        bizm istegimiz ise şu:
        bir test methodu çalıştırdıgımızda yeni pencere açtoysa o pencereden devam etsin ve buradaki new Chrome Driver
        satırını pas geçsin.
        şoyle yapacgz
        methoda gidecegz o satıra varmadan once eger zaten halihazrıda bir pencere var veya hiç pencere yoksa yenisini
        aç deriz.
        ama yeni bir pencere yoksa tabii ki if in içine gir ve yeni bir pencere açarak yoluna ve talimatlarqa devam et.

         */
        // arama kutusuna Nutella yazdirip aratalim
        Thread.sleep(3000);
        WebElement aramaKutusu= Driver.getdriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        Driver.getdriver().get("https://www.wisequarter.com");

        Driver.closeDriver();



    }

    @Test
    public void test02(){
        Driver.closeDriver();
    }





}
