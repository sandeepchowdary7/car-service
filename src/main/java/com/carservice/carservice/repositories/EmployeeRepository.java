package com.carservice.carservice.repositories;

import com.carservice.carservice.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    @Query(value="Select * from employees where shop_id=:shop_id", nativeQuery = true)
    Optional<Employees> getEmployeesByShopId(@Param("shop_id") String shop_id);
}
