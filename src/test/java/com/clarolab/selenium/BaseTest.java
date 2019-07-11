package com.clarolab.selenium;

import com.clarolab.selenium.pages.browser.LocalBrowserBuilder;
import com.clarolab.selenium.pages.browser.RemoteBrowserBuilder;
import com.clarolab.selenium.pages.browser.web.WebBrowser;
import com.clarolab.selenium.pages.exception.FrameworkWebDriverException;
import com.clarolab.selenium.pages.pages.SubPage;
import com.clarolab.selenium.pages.pages.TopLevelPage;
import lombok.extern.java.Log;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log()
public class BaseTest {

    WebBrowser browser;
    WebDriver driver;


    private WebBrowser createRemoteBrowser(String url) throws FrameworkWebDriverException {
        return RemoteBrowserBuilder
                .getChromeBuilder(url, "http://dev.clarolab.com:4444/wd/hub")
                .build();
    }

    private WebBrowser createLocalBrowser(String url) throws FrameworkWebDriverException {
        return LocalBrowserBuilder
                .getChromeBuilder(url)
                .build();
    }

    @BeforeMethod(alwaysRun = true)
    protected void initTest() throws FrameworkWebDriverException {
        //browser = createLocalBrowser("");
        browser = createRemoteBrowser("");
        driver = browser.getWebDriver();
    }

    protected void takeScreenShot() {
        try {
            String pathname = "screenshot" + RandomUtils.nextInt(100, 999999) + ".png";
            browser.saveScreenshotToFile(pathname);
        } catch (NullPointerException e) {

        }
    }

    @AfterMethod(alwaysRun = true)
    protected void cleanTest() {
        takeScreenShot();
        try {
            browser.cleanSession();
            log.info("cleansession");
            browser.quit();
            log.info("browser quit");
            driver.quit();
            log.info("driver quit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public <T extends TopLevelPage> T loadTopPage(Class<T> pageClass) {
        return getBrowser().loadTopLevelPage(pageClass);
    }

    public <T extends SubPage> T loadSubPage(Class<T> pageClass) {
        return getBrowser().loadSubPage(pageClass);
    }

    protected WebBrowser getBrowser() {
        return browser;
    }
}
