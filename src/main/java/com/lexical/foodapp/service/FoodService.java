package com.lexical.foodapp.service;

import com.lexical.foodapp.model.food.FoodModel;
import com.lexical.foodapp.model.food.SearchFoodModel;
import com.lexical.foodapp.repository.FoodRepository;
import com.lexical.foodapp.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

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

    public FoodDto getFoodDetail(int foodId) {
        Optional<FoodModel> foodExists = foodRepository.findById(foodId);

        if (foodExists.isEmpty()) {
            return null;
        }

        FoodDto food = new FoodDto();
        food.setFoodId(foodExists.get().getFoodId());
        food.setFoodName(foodExists.get().getFoodName());
        food.setPrice(foodExists.get().getFoodPrice());
        food.setStock(foodExists.get().getFoodStock());
        food.setFoodDetails(foodExists.get().getFoodDetails());

        return food;
    }

    public Slice<SearchFoodModel> getFoodByPrice(String foodPrice) {

        return foodRepository.getFoodByPrice(foodPrice);
    }
}
