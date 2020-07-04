package org.d11.camel.component.selenium;

import org.apache.camel.*;
import org.apache.camel.spi.*;
import org.apache.camel.support.DefaultEndpoint;

/**
 * Camel endpoint for fetching a web page with Selenium Firefox driver.
 */
@UriEndpoint(firstVersion = "1.0", scheme = "selenium", title = "Selenium", syntax="selenium:url", category = Category.HTTP)
public class SeleniumEndpoint extends DefaultEndpoint {
    
    /**
     * Not sure why, but this needs to be here for the code generation to work.
     */
    @UriPath 
    private String uriPath;

    public SeleniumEndpoint(String uri, SeleniumComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new SeleniumProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new SeleniumConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }
    
}
