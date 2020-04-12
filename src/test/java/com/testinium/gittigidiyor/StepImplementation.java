package com.testinium.gittigidiyor;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import io.appium.java_client.MobileElement;

public class StepImplementation extends Driver {


    @Step("Arama alanına tıklanır")
    public void clickSearchBox()  throws Exception{
        MobileElement elementOne = (MobileElement) appiumDriver.findElementById("actionSearchBoxACT");
        elementOne.click();
    }

    @Step("Arama kısmına <key> yazılır")
    public void search(String key) {
        MobileElement elementTwo = (MobileElement) appiumDriver.findElementById("actionSearchBoxACT");
        elementTwo.sendKeys(key);
     }

     @Step("Vazgeç butonuna tıklanır")
    public void clickCancel() {
        MobileElement elementThree = (MobileElement) appiumDriver.findElementById("cancelButton");
        elementThree.click();
     }
}
