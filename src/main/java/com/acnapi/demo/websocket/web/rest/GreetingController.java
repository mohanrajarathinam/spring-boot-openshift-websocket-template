package com.acnapi.demo.websocket.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.acnapi.demo.websocket.domain.Greeting;
import com.acnapi.demo.websocket.domain.HelloMessage;

@Controller
public class GreetingController {

	private final Logger log = LoggerFactory.getLogger(GreetingController.class);
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    		log.debug("REST - Greetings - Debug level details");
		log.info("REST - Greetings - Info level details");
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
