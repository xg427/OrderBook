package fractalfintech.orderbook;

import fractalfintech.orderbook.OrderBook;
import fractalfintech.orderbook.MarketList;
import fractalfintech.orderbook.Order;
//import fractalfintech.orderbook.OrderItemDao;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.lang.Double;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


@RestController
public class MarketController
{
    private MarketList marketList;

    // Initializes marketplace
    public MarketController()
    {
        marketList = new MarketList();
        marketList.Add("Test");
    }


    @RequestMapping("/market/add/item/{name}")
  	public String AddMarketItem(@PathVariable(value="name") String name) {
        marketList.Add(name);
        return "success";
  	}

    @PostMapping("/market/bid/add")
  	public String AddMarketBid(@ModelAttribute OrderItemDao bid) {
    	marketList.AddBid(bid);
  		return "success";
  	}

    @PostMapping("/market/bid/get")
    @ResponseBody
  	public Map<Double, List<Order>> GetMarketBid(@ModelAttribute OrderItemDao bid) {
    	Map<Double, List<Order>> list = marketList.GetBidMap(bid);
  		return list;
  	}
    
    
    @PostMapping("/market/offer/add")
  	public String AddMarketOffer(@ModelAttribute OrderItemDao offer) {
    	marketList.AddOffer(offer);
 		return "success";
  	}

    @PostMapping("/market/offer/get")
    @ResponseBody
  	public Map<Double, List<Order>> GetMarketOffer(@ModelAttribute OrderItemDao offer) {
    	Map<Double, List<Order>> list = marketList.GetOfferMap(offer);
  		return list;
  	}

    
    @RequestMapping("/")
  	public String index() {
  		return "Greetings from Spring Boot!";
  	}

  }
