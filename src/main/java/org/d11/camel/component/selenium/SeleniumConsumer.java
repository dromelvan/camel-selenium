package org.d11.camel.component.selenium;

import org.apache.camel.*;
import org.apache.camel.support.DefaultConsumer;

public class SeleniumConsumer extends DefaultConsumer {

    public SeleniumConsumer(SeleniumEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

    @Override
    protected void doStart() throws Exception {
        super.doStart();        
        
        Exchange exchange = getEndpoint().createExchange();
        SeleniumDriver seleniumDriver = new SeleniumDriver();

        try {
            String url = getEndpoint().getEndpointUri().replace("selenium://","");
            seleniumDriver.get(url);
                    
            exchange.getMessage().setBody(seleniumDriver.getPageSource());
        } finally {
            seleniumDriver.quit();
        }            
        
        getProcessor().process(exchange);
    }

}
