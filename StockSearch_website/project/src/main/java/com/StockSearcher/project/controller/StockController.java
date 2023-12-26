package com.StockSearcher.project.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StockController {
    public static String[] getStockData(String stockSymbol) {
        String[] stockData = new String[2];
        try {
            String url = "https://www.google.com/search?q=" + stockSymbol + " + 주가";
            Document doc = Jsoup.connect(url).get();

            Elements money = doc.getElementsByAttributeValue("jsname", "vWLAgc");
            Elements moneyType = doc.getElementsByAttributeValue("jsname", "T3Us2d");

            stockData[0] = money.first().text();
            stockData[1] = moneyType.first().text();

        } catch (Exception e) {
            stockData[0] = "인터넷 연결을 확인해주세요";
            stockData[1] = "";
        }
        return stockData;
    }
}
