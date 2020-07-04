package org.d11.camel.component.selenium;

import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumDriverOptions extends FirefoxOptions {

    private static final long serialVersionUID = 1L;

    public SeleniumDriverOptions() {
        addPreference("permissions.default.image", 2);
        addPreference("permissions.default.stylesheet", 2);
        setHeadless(true);        
    }
    
}
