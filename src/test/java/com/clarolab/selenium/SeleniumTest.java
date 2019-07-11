package com.clarolab.selenium;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest extends BaseTest {

    @Test
    public void passSeleTest() {
        openBrowser();
        Assert.assertTrue(true, "this should pass");
    }

    @Test
    public void failSeleTest() {
        openBrowser();
        Assert.assertFalse(true, "this is intended to fail");
    }

    @Test
    public void exceptionSeleTest() {
        openBrowser();
        try {
            String text = null;
            text.substring(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openBrowser() {
        try {
            getBrowser().openPageByURL("http://google.com");
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}