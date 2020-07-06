package org.d11.camel.component.selenium;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;

public class SeleniumProducer extends DefaultProducer {

    public SeleniumProducer(SeleniumEndpoint endpoint) {
        super(endpoint);
    }

    public void process(Exchange exchange) throws Exception {        
        SeleniumDriver seleniumDriver = new SeleniumDriver();       
        
        try {
            String url = getEndpoint().getEndpointUri().replace("selenium://","");
            seleniumDriver.get(url);
        
            exchange.getMessage().setBody(seleniumDriver.getPageSource());
        } finally {
            seleniumDriver.quit();
        }
    }

}
