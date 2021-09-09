package com.lexical.foodapp.repository;

import com.lexical.foodapp.model.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodModel, Integer> {
}
