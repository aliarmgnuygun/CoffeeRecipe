package models;

import java.util.ArrayList;
import java.util.List;

public class CoffeeRecipe {
    private List<String> ingredients;
    private String brewingInstructions;
    private int servingSize;
    private List<String> categories;
    private List<String> tags;
    private List<Integer> ratings;
    private double impact;

    public CoffeeRecipe(List<String> ingredients, String brewingInstructions, int servingSize, List<String> categories, List<String> tags) {
        this.ingredients = ingredients;
        this.brewingInstructions = brewingInstructions;
        this.servingSize = servingSize;
        this.categories = categories;
        this.tags = tags;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getBrewingInstructions() {
        return brewingInstructions;
    }

    public void setBrewingInstructions(String brewingInstructions) {
        this.brewingInstructions = brewingInstructions;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public double getImpact() {
        return impact;
    }

    public void addRating(int rating) {
        ratings.add(rating);
    }

    public double calculateImpact(boolean useAverageRating) {
        if (useAverageRating) {
            int sum = 0;
            for (int rating : ratings) {
                sum += rating;
            }
            impact = sum / (double) ratings.size();
        } else {
            impact = ratings.size();
        }
        return impact;
    }
}
