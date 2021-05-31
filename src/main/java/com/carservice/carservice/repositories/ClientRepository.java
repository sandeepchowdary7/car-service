package com.carservice.carservice.repositories;

import com.carservice.carservice.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Integer> {
    @Query(value="Select * from clients where email=:email", nativeQuery = true)
    List<Clients> getClientByEmail(@Param("email") String email);
}