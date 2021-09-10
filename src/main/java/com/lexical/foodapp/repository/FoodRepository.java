package com.lexical.foodapp.repository;

import com.lexical.foodapp.model.food.FoodModel;
import com.lexical.foodapp.model.food.SearchFoodModel;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<FoodModel, Integer> {

    @Query(value = "SELECT * FROM tab_food " +
            "WHERE food_price LIKE %?1% ", nativeQuery = true)
    Slice<SearchFoodModel> getFoodByPrice(String price);
}
