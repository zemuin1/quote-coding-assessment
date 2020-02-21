package com.clutch.quotecodingassessment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class QuoteController {
	@MessageMapping("/request")
	@SendTo("/topic/quote")
	public Quote quote(Request request) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Quote(HtmlUtils.htmlEscape(request.getRequest()));
		/*
		 * request.getRequest(); return null;
		 */	}
}
