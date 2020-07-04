package org.d11.camel.component.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver extends FirefoxDriver {
    
    public SeleniumDriver() {
        super(new SeleniumDriverOptions());
        manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
