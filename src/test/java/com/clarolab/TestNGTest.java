package com.clarolab;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest {

    @Test
    @Description("This is a generic description")
    public void passNGTest() {
        Assert.assertTrue(true, "this should pass");
    }

    @Test
    public void failNGTest() {
        Assert.assertFalse(true, "this is intended to fail");
    }

    @Test
    public void exceptionNGTest() {
        String text = null;
        text.substring(1);
    }
}