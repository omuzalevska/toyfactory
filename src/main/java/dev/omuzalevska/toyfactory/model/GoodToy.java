package dev.omuzalevska.toyfactory.model;

public class GoodToy extends Toy {
    private int recommendedAge;
    private String brand;

    public GoodToy(String id, String name, String category, int recommendedAge, String brand) {
        setId(id);
        setName(name);
        setCategory(category);
        this.recommendedAge = recommendedAge;
        this.brand = brand;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    public String getBrand() {
        return brand;
    }

    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
}