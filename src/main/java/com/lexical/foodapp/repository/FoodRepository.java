package com.lexical.foodapp.repository;

import com.lexical.foodapp.model.food.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodModel, Integer> {

    @Query(value = "SELECT * FROM tab_food " +
            "WHERE food_price >= ?1 " +
            "AND food_price <= ?2 ", nativeQuery = true)
    List<FoodModel> getFoodByFilterPrice(int min, int max);
}
