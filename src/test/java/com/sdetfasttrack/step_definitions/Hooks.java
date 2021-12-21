package com.sdetfasttrack.step_definitions;


import com.sdetfasttrack.utilities.BrowserUtils;
import com.sdetfasttrack.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){
        System.out.println("------Setting up browser with further details...");
    }


    @After
    public void tearDownScenario(Scenario scenario){
        //if my scenario failed
            // go and take screen shot
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        BrowserUtils.wait(1);
        Driver.closeDriver();
    }
}
