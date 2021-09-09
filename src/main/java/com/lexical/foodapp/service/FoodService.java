package com.lexical.foodapp.service;

import com.lexical.foodapp.model.FoodModel;
import com.lexical.foodapp.repository.FoodRepository;
import com.lexical.foodapp.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodModel> getAllFood() {

        List<FoodModel> foods = foodRepository.findAll();

        if (foods.size() > 0) {
            return foods.stream().collect(Collectors.toList());
        } else {
            return foods;
        }
    }

    public FoodModel createFood(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }
}
