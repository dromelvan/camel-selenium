package org.d11.camel.component.selenium;

import java.io.File;
import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.spi.annotations.Component;
import org.apache.camel.support.DefaultComponent;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

@Component("selenium")
public class SeleniumComponent extends DefaultComponent {

    static {
        String driver = "";
        if(SystemUtils.IS_OS_MAC) {         
            driver = "geckodriver-mac";
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        } else if(SystemUtils.IS_OS_LINUX) {
            driver = "geckodriver-linux";
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        }

        File geckoDriverFile = new File("lib/geckodriver/" + driver);
        if(geckoDriverFile.exists()) {
            System.setProperty("webdriver.gecko.driver", "lib/geckodriver/" + driver);
        } else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/" + driver);
        }        
    }
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        SeleniumEndpoint endpoint = new SeleniumEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
