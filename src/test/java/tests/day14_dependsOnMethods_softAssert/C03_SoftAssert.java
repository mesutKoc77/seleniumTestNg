package tests.day14_dependsOnMethods_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssert {

@Test
    public void hardAssertionTesti(){
    /*
          // verilen bir sifrenin sartlari saglayip saglamadigini test edin
        // 1- Ilk harf Buyuk harf olmali
        // 2- Son harf kucuk harf olmali
        // 3- sifre bosluk icermemeli
        // 4- uzunlugu en az 8 karakter olmali

        Not:

          assertion islemi yapilirken
          ilk bulunan hatada kodun calismasi durdurulur (stop execution)

            Assert class'indaki method'lar static olduklari icin
            classIsmi.methodIsmi ile cagrilirlar

     */

    String sifre="JavAahJava";
    // 1- Ilk harf Buyuk harf olmali //Der erste Buchstabe muss ein Großbuchstabe sein

    boolean ersteBuchStabe=sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
    Assert.assertTrue(ersteBuchStabe,"Der erste Buchstabe muss ein Großbuchstabe sein");

    // 2- Son harf kucuk harf olmali //Der letzte Buchstabe ein Kleinbuchstabe sein

    boolean derLetzteBuchstabe=sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
    Assert.assertTrue(derLetzteBuchstabe,"der letzte Buchstabe muss ein Kleinbuchstabe sein");

    // 3- sifre bosluk icermemeli

    Assert.assertFalse(sifre.contains(" "),"der Password soll nicht Lücke enthalten");

    // 4- uzunlugu en az 8 karakter olmali //Die Lange des Passwords soll mindestens acht Characker sein.

    boolean lange=sifre.length()>=8;
    Assert.assertTrue(lange,"das Password muss mindestens acht Charackter sein");

    // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
    //Wenn das Password alle Bedigungen erfüllt , drucken Sie dass das Password erfolgreich gespeichert wurde.
    System.out.println("sifre basari ile kaydedildi");

}

@Test
    public void softAssertTesti(){
      /*
          jUnit'de de kullandigimiz Assert class'i ilk failed olan assertion'da
          calismayi durdurur ve hata mesaji verir

          Eger ilk hatada durmasini degil, devam edip sona kadar tum testleri yapmasini
          ve en sonunda durumu raporlayip, failed olan varsa
          calismayi durdurmasini istiyorsaniz
          SoftAssert class'ini kullanabilirsiniz

          SoftAssert clas'indaki method'lar static degildir,
          SoftAssert class'indaki method'lari kullanmak icin obje olusturmaliyiz


          Genellikle
          hard Assertion kullanmamiz istendiginde test edin (Test)
          soft Assertion kullanmamiz istendiginde dogrulayin (Verify) kelimeleri kullanilir.
         */

     //A. objemizii oluşturduk
    SoftAssert softAssert=new SoftAssert();
    //B. istenen tum assertion ları softAssert objesini kullanarak yaptık
    String sifre="JavAa123i";
    // 1- Ilk harf Buyuk harf olmali //Der erste Buchstabe muss ein Großbuchstabe sein

    boolean ersteBuchStabe=sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
    softAssert.assertTrue(ersteBuchStabe,"Der erste Buchstabe muss ein Großbuchstabe sein");

    // 2- Son harf kucuk harf olmali //Der letzte Buchstabe ein Kleinbuchstabe sein

    boolean derLetzteBuchstabe=sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
    softAssert.assertTrue(derLetzteBuchstabe,"der letzte Buchstabe muss ein Kleinbuchstabe sein");

    // 3- sifre bosluk icermemeli

    softAssert.assertFalse(sifre.contains(" "),"der Password soll nicht Lücke enthalten");

    // 4- uzunlugu en az 8 karakter olmali //Die Lange des Passwords soll mindestens acht Characker sein.

    boolean lange=sifre.length()>=8;
    softAssert.assertTrue(lange,"das Password muss mindestens acht Charackter sein");

    //C. tum testler bitince isimiz bitti yapılan tum assertleri raporla demeliyiz
    //    bir tane bile failed varsa bu satirda kodun calismasi durdurulur

    softAssert.assertAll();

    // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin


    //1.47








}




}
