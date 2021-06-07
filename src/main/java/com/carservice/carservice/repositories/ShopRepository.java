package com.carservice.carservice.repositories;

import com.carservice.carservice.models.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shops, Integer> {
    @Query(value="Select * from shops where shop_reg_id=:shop_reg_id", nativeQuery = true)
    Optional<Shops> getShopsByRegId(@Param("shop_reg_id") String shop_reg_id);
}