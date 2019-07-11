package com.clarolab;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class CucumberSteps {

    private Map<String, Integer> numberList;
    private int total;

    @Given("^I want the test to pass$")
    public void i_want_the_test_to_pass() {
    }

    @Then("^The test will pass$")
    public void the_test_will_pass() {
        System.out.println("pass");
    }

    @Given("^I don't want the test to pass$")
    public void i_don_t_want_the_test_to_pass() {
    }

    @Then("^The test will fail$")
    public void the_test_will_fail() {
        System.out.println("fail");
        Assert.fail();
    }

    @Given("^I want the test to break$")
    public void i_want_the_test_to_break() {
    }

    @Then("^The test will break$")
    public void the_test_will_break() {
        System.out.println("beak");
        String text = null;
        text.substring(1);
    }

    @Given("^I have this list$")
    public void iHaveThisList(Map<String, Integer> numberList) {
        this.numberList = numberList;
    }

    @When("^I add them$")
    public void iAddThem() {
        numberList.forEach((s, integer) -> total+=integer);
    }

    @Then("^I should get (\\d+)$")
    public void iShouldGet(int arg0) {
        Assert.assertEquals(total, arg0);
    }

}