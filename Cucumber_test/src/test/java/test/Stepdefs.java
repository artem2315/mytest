package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

class YouShallNotPass {
    static String youShallNotPass(int NumOfill) {
        return (NumOfill < 100) ? "Quarantine is over!" : "Quarantine is going on!";
    }
}

public class Stepdefs {
    private int NumOfill;
    private String actualAnswer;
    private boolean StatusQ;

    @Given("number of ill people is <int>")
    public void number_of_ill_people_is(int NumOfill){
        this.NumOfill = NumOfill;
    }
    @When("I ask whether it's quarantine is over")
    public void i_ask_whether_it_s_quarantine_is_over(){
        actualAnswer = YouShallNotPass.youShallNotPass(NumOfill);
    }
    @Then("I should be told <string>")
    public void I_should_be_told(String expectedAnswer){
        assertEquals(expectedAnswer, actualAnswer);
    }
    @Given("quarantine is over")
    public void quarantine_is_over(){
        StatusQ = true;
    }
    @When("I ask whether i can go to cinema")
    public void I_ask_whether_i_can_go_to_cinema(){
        if(StatusQ) actualAnswer = "Yes, you can!";
    }
}
