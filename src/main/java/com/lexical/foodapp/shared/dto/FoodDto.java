package com.lexical.foodapp.shared.dto;

public class FoodDto {

    private int foodId;
    private String foodName;
    private String price;
    private int stock;
    private String foodDetails;

    public FoodDto(int foodId, String foodName, String price, int stock, String foodDetails) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.stock = stock;
        this.foodDetails = foodDetails;
    }

    public FoodDto() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }
}
