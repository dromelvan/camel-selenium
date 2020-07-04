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
        
        SeleniumDriver seleniumDriver = new SeleniumDriver();

        String url = getEndpoint().getEndpointUri().replace("selenium://","");
        seleniumDriver.get(url);
        
        Exchange exchange = getEndpoint().createExchange();
        exchange.getMessage().setBody(seleniumDriver.getPageSource());
        
        getProcessor().process(exchange);
    }

}
