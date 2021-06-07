package com.carservice.carservice.controllers;

import com.carservice.carservice.services.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    private Object getAllshops() {
        return shopService.getAllShops();
    }

    @GetMapping("/shop/{shopRegId}")
    private Object getShopByRegId(@PathVariable("shopRegId") String shop_reg_id) {
        return shopService.getShopByRegId(shop_reg_id);
    }
}