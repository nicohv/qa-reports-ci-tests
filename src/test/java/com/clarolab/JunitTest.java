package com.clarolab;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test
    public void passJUTest() {
        Assert.assertTrue("This test should pass", true);
    }

    @Test
    public void failJUTest() {
        Assert.assertFalse("This test is ok to fail", true);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void exceptionJUTest() {
        String text = null;
        text.substring(1);
    }

}