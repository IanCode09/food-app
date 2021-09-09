package com.lexical.foodapp.controller;

import com.lexical.foodapp.model.FoodModel;
import com.lexical.foodapp.response.DataResponse;
import com.lexical.foodapp.response.HandlerResponse;
import com.lexical.foodapp.service.FoodService;
import com.lexical.foodapp.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/food", produces = {"application/json"})
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/", produces = {"application/json"})
    public void getAllFood(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DataResponse<List<FoodModel>> foodResponse = new DataResponse<>();
        List<FoodModel> foods = foodService.getAllFood();
        foodResponse.setData(foods);

        HandlerResponse.responseSuccessWithData(response, foodResponse);
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void createFood(HttpServletRequest request, HttpServletResponse response,
                           @Valid @NotNull @ModelAttribute("food_name") String foodName,
                           @Valid @NotNull @ModelAttribute("food_price") String foodPrice,
                           @Valid @NotNull @ModelAttribute("food_stock") int foodStock,
                           @Valid @NotNull @ModelAttribute("food_details") String foodDetails) throws IOException {

        try {
            FoodModel foodModel = new FoodModel();
            foodModel.setFoodName(foodName);
            foodModel.setFoodPrice(foodPrice);
            foodModel.setFoodStock(foodStock);
            foodModel.setFoodDetails(foodDetails);

            foodService.createFood(foodModel);
            HandlerResponse.responseSuccessCreated(response, "Food created successfuly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
