package com.carservice.carservice.controllers;

import com.carservice.carservice.models.Shops;
import com.carservice.carservice.services.ShopService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/shop")
    private Object saveShop(@RequestBody Shops shop) {
        return shopService.saveShop(shop);
    }

    @PutMapping("/shop/{shopId}")
    private Object updateShop(@RequestBody Shops shop, @PathVariable("shopId") int id) {
        return shopService.updateShop(shop, id);
    }

    @DeleteMapping("/shop/{shopId}")
    private Object deleteShop(@PathVariable("shopId") int id) {
        return shopService.deleteShopById(id);
    }
}