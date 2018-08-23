package com.browserstack;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SingleTest extends BrowserStackTestNGTest {


    public WebElement elex(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement eleid(String id) {
        return driver.findElement(By.id(id));
    }

    @Test
    public void test() throws Exception {


        try {
            driver.startActivity("com.google.android.gm", "ConversationListActivityGmail");
        } catch (Exception e) {
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        eleid("com.google.android.gm:id/welcome_tour_got_it").click();
        eleid("com.google.android.gm:id/setup_addresses_add_another").click();
        elex("(//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/account_setup_item'])[1]").click();
        elex("//android.widget.EditText[@resource-id=\"identifierId\"]").sendKeys("your_gmail_id");// Enter your gmail ID
        elex("//android.widget.Button[@resource-id=\"identifierNext\"]").click();
        elex("//android.view.View[@resource-id=\"password\"]//android.widget.EditText").sendKeys("your_gmail_password");// Enter your gmail password
        elex("//android.widget.Button[@resource-id=\"passwordNext\"]").click();
        elex("//android.widget.Button[@resource-id=\"signinconsentNext\"]").click();
        elex("//android.widget.Button[@resource-id=\"com.google.android.gms:id/next_button\"]").click();
        elex("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]").click();
        try {
            elex("//android.widget.Button[@resource-id=\"android:id/button1\"]").click();
        } catch (Exception e) {
        }
        Thread.sleep(15000);
        try {
            driver.startActivity("org.wikipedia.alpha", "org.wikipedia.main.MainActivity");
            ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        } catch (Exception e) {
        }
        Thread.sleep(15000);
    }
}
