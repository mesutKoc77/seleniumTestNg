package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGIlktest extends TestBase {
    /*
    testng test methodalrını isim sırasına göre calıştırır
    eger sıralamyı degiştirmek istersk
    priority kullanılabilir.

    priorrity yazan methdolar kucukten buyuge gore sıralanaır.
    eger priorty belirtilmeyen method varsa priority=0 kabul edilir.
    ayni priority degerine sahip birden fazla method varsa bunlar harf sırasına göre çalışır ve test edilir.

     */


    @Test(priority = 10)
    public void test01(){
        driver.get("https://www.amazon.com");
    }



    @Test (priority = 11)
    public void test02(){
        driver.get("https://www.youtube.com");
    }



    @Test(priority = 12)
    public void test03(){
        driver.get("https://www.wisequarter.com");
    }

}
