package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public  class C03_PagesKullanimi {

    /*
       Pages class'lari bir websayfasinda locate etmek istedigimiz
       webElementleri locate edip, sonrasinda ihtiyacimiz oldukca kullanmak icin olusturulur
       pages class'larinda locate edilen webElement'lere erisebilmek icin
       test class'imizda ilgili page class'indan bir obje olustururuz
     */

    //amazon anasayfaya gidelim
    //Nutella için arama yapalım
    //sonucların nutella içerdiginiz test edin


@Test
    public void test01(){
    Driver.getdriver().get("https://www.amazon.com");
    //burada getdriver()'a onlar statşc oldugu için ve static ler static olmayan method ların içinde direkt girebilir
    //dikleri için kullanabildim.
    //ama amazonpage de ki webElemnt ler static olmadıkları için buraya yani methodun içerisine ancak o class tan
    //obje oluşturrak erişebilriiz.
    AmazonPage amazonpage=new AmazonPage();
    amazonpage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);

    String actualText=amazonpage.aramaSonucElementi.getText();
    String expectedText="Nutella";
    SoftAssert softassert=new SoftAssert();
    softassert.assertTrue(actualText.contains(expectedText),"içermiyor");
    softassert.assertAll();
    Driver.closeDriver();

}

}
