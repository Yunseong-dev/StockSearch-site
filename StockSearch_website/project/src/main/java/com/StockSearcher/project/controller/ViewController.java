package com.StockSearcher.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainPage() {
        return "MainPage";
    }


    @GetMapping("/stock")
    public String getStockViewPage(@RequestParam(name = "stockName") String stockName, Model model) {
        StockController stockCroling = new StockController();
        String[] stockData = stockCroling.getStockData(stockName);
        model.addAttribute("stockName", stockName);
        model.addAttribute("money", stockData[0]);
        model.addAttribute("moneyType", stockData[1]);

        return "StockViewPage";
    }
}

