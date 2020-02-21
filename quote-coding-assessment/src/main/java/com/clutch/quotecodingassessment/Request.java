package com.clutch.quotecodingassessment;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Request {
	private String request;
	
	  public Request() {
	  }

	  public Request(String request) {
	    this.request = request;
	  }

	  public String getRequest() throws IOException {
		  String[] quoteRequest = request.split("\n");
		  ArrayList<String> quote = new ArrayList<String>();
		  Map<String, Stock> stocks = YahooFinance.get(quoteRequest);
		  for(String req: quoteRequest) {
			  quote.add(stocks.get(req).getQuote().getPrice().toString());
		  }
		  return quote.toString();
	  }

	  public void setRequest(String request) {
	    this.request = request;
	  }

}
