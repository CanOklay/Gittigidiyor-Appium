package com.testinium.gittigidiyor;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StepImplementation extends Driver {



    @Step("Arama alanına tıklanır")
    public void clickSearchBox() throws Exception {
        MobileElement elementOne = (MobileElement) appiumDriver.findElementById("actionSearchBoxACT");
        elementOne.click();
    }

    @Step("Arama kısmına <key> yazılır")
    public void search(String key) {
        MobileElement elementTwo = (MobileElement) appiumDriver.findElementById("actionSearchBoxACT");
        elementTwo.sendKeys(key);
    }

    @Step("Açılan sekmeye tıklanır")
    public void clickOne() {
        MobileElement elementThree = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView\n");
        elementThree.click();
    }

    @Step("Açılan ürünlerden ilki seçilir")
    public void pickProduct() {
        MobileElement elementFour = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout");
        elementFour.click();
    }


    @Step("Sepete ekle butonuna tıklanır")
    public void addBasket() {
        scroll(852, 1065, 906, 329);
        MobileElement elementFive = (MobileElement) appiumDriver.findElementById("btnAddBasket");
        elementFive.click();
    }

    @Step("Sepetim sekmesine gidilir")
    public void basketPage() {
        MobileElement elementSix = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]");
        elementSix.click();
    }

    @Step("Üründen <key> adet ekle")
    public void increaseProduct(String key) {
        if (key.equals("iki")) {
            MobileElement increaseProduct = (MobileElement) appiumDriver.findElementById("btnPlusVariant");
            increaseProduct.click();
        } else if (key.equals("üç")) {
            for (int i = 0; i < 2; i++) {
                MobileElement increaseProduct = (MobileElement) appiumDriver.findElementById("btnPlusVariant");
                increaseProduct.click();
            }
        }
    }

    @Step("Ekran görüntüsü al ve <picturename> ismiyle kaydet")
    public void takesScreenshot(String pictureName) throws IOException {
        String filename = "images/" + (pictureName) + ".png";
        File file = new File("reports/html-report/" + filename);
        if (file.exists())
            file.delete();
        File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, file);
        Gauge.writeMessage("<img src='../" + filename + "' width = '800' height = '480'");
    }

    @Step("<key> email adresine mail gönderilir")
    public void sendEmail(String key) throws EmailException, MessagingException {
        System.out.println("-----Email gönderme başladı-----");
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("canoklay@gmail.com", "642378111fco"));
        email.setSSLOnConnect(true);
        email.setFrom("canoklay@gmail.com");
        email.setSubject("Test Raporu");
        email.setMsg("Seleniumdan mesaj");
        email.addTo(key);
        email.send();
        System.out.println("----Email gönderildi-----");
    }

    @Step("Kayda başla ve bitir")
    public void record() throws ATUTestRecorderException, InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
        Date date = new Date();
        ATUTestRecorder recorder = new ATUTestRecorder("reports/html-report/records", "SenaryoKaydı-" + dateFormat.format(date), false);
        recorder.start();
        System.out.println("Kayda başla");
        Thread.sleep(4000);
        recorder.stop();
    }

    public void scroll(int startx, int starty, int endx, int endy) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();

    }

    @Step("Hesabım kısmına tıklanır")
    public void account() {
        MobileElement account = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[4]");
        account.click();
    }

    @Step("Email bilgisi <email> girilir")
    public void enterEmail(String key) {
        MobileElement email = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
        email.click();
        email.sendKeys("testiniumproje@gmail.com");
    }

    @Step("Password bilgisi <password> girilir")
    public void password(String key) {
        MobileElement password = (MobileElement) appiumDriver.findElementById("password");
        password.click();
        password.sendKeys("1301010010Fc");
    }

    @Step("Giriş yap butonuna tıklanır")
    public void clickLogin() {
        MobileElement login = (MobileElement) appiumDriver.findElementById("loginBtn");
        login.click();
    }
}
