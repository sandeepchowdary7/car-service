package com.carservice.carservice.services;

import com.carservice.carservice.models.Shops;
import com.carservice.carservice.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Object getAllShops() {
        List<Shops> shops = new ArrayList<>();
        shopRepository.findAll().forEach(shops1 -> shops.add(shops1));

        if (shops.isEmpty()) {
            return "No Shops Found";
        }
        return shops;
    }

    public Object getShopId(int id) {
        Optional<Shops> shop = shopRepository.findById(id);

        if (!shop.isPresent()) {
            return "No Shop Found with this "+ id;
        }
        return shop;
    }

    public Object getShopByRegId(String shop_reg_id) {
        Optional<Shops> shop = shopRepository.getShopsByRegId(shop_reg_id);

        if (!shop.isPresent()) {
            return "No Shop Found with this " + shop_reg_id;
        }
        return shop;
    }

    public Object saveShop(Shops shop) {
        return shopRepository.save(shop);
    }

    public Object updateShop(Shops newShop, int id) {
        return shopRepository.findById(id)
                .map(shop -> {
                    shop.setName(newShop.getName());
                    shop.setCountry(newShop.getCountry());
                    shop.setState(newShop.getState());
                    shop.setCity(newShop.getCity());
                    shop.setStreet_address(newShop.getStreet_address());
                    shop.setZipcode(newShop.getZipcode());
                    shop.setPhone_number(newShop.getPhone_number());
                    shop.setSecondary_phone_number(newShop.getSecondary_phone_number());
                    shop.setEmail(newShop.getEmail());
                    return shopRepository.save(shop);
                })
                .orElseGet(() ->{
                    newShop.setId(id);
                    return shopRepository.save(newShop);
                });
    }

    public Object deleteShopById(int id) {
        Optional<Shops> shop = shopRepository.findById(id);

        if (!shop.isPresent()) {
            return "No Shop Found with this id " + id;
        }

        shopRepository.deleteById(id);
        return "Shop was Deleted Successfully.";
    }
}