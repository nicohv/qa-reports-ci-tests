package com.clarolab;

import com.clarolab.selenium.pages.browser.RemoteBrowserBuilder;
import com.clarolab.selenium.pages.browser.web.WebBrowser;
import com.clarolab.selenium.pages.exception.FrameworkWebDriverException;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;

@RobotKeywords
public class MyRobotKeywords {

    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    WebBrowser browser;
    WebDriver driver;


    private WebBrowser createRemoteBrowser(String url) throws FrameworkWebDriverException {
        return RemoteBrowserBuilder
                .getChromeBuilder(url, "http://dev.clarolab.com:4444/wd/hub")
                .build();
    }

    private void openBrowser() {
        try {
            getBrowser().openPageByURL("http://google.com");
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private WebBrowser getBrowser() {
        return browser;
    }

    @RobotKeyword
    public void initTest() throws FrameworkWebDriverException {
        browser = createRemoteBrowser("");
        driver = browser.getWebDriver();
    }

    @RobotKeyword
    public void cleanTest() {
        try {
            browser.cleanSession();
            browser.quit();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RobotKeyword
    public void passTest() {
        openBrowser();
        Assert.assertTrue(true, "this should pass");
    }

    @RobotKeyword
    public boolean failTest() {
        openBrowser();
        return false;
    }

    @RobotKeyword
    public void exceptionTest() {
        openBrowser();
        String text = null;
        text.substring(1);
    }

    @RobotKeyword
    public void takeScreenShot() {
        try {
            String pathname = "screenshot" + RandomUtils.nextInt(100, 999999) + ".png";
            browser.saveScreenshotToFile(pathname);
        } catch (NullPointerException e) {

        }
    }
}