package main.java.com.renan.jogogourmet.service;

import main.java.com.renan.jogogourmet.entities.Food;
import main.java.com.renan.jogogourmet.view.FoodView;

public class FoodService {

    private Food foodTree;
    private final int YES = 0;
    private final int NO = 1;


    public FoodService() {
        initFoodTree();
    }

    public Food getFoodTree() {
        return foodTree;
    }

    public void setFoodTree(Food foodTree) {
        this.foodTree = foodTree;
    }

    private void initFoodTree() {

        Food lasanha = new Food("Lasanha", null, null);
        Food boloDeChocolate = new Food("Bolo de Chocolate", null, null);
        Food massa = new Food("massa", lasanha, boloDeChocolate);
        setFoodTree(massa);
    }

    public void startActivity() {
        nextFood(foodTree);
    }

    public Food nextFood(Food current) {
        int choice = FoodView.showPaneIsFoodQuestion(current.getName());
        Food newFood = null;
        switch (choice) {
            case YES:
                if (current.getMatch() == null) {
                    FoodView.showPaneVictoryMessage();
                    newFood = null;
                } else {
                    newFood = nextFood(current.getMatch());
                    if (newFood != null) {
                        current.setMatch(newFood);
                        newFood = null;
                    }
                }
                break;

            case NO:
                if (current.getNoMatch() == null) {
                    newFood = createNewFood (current);
                } else {
                    newFood = nextFood(current.getNoMatch());
                    if (newFood != null) {
                        current.setNoMatch(newFood);
                        newFood = null;
                    }
                }
                break;
        }
        return newFood;
    }


    public Food createNewFood (Food current) {
        String newFoodName = FoodView.showPaneFoodNameQuestion();

        if(newFoodName != null){
            newFoodName =  newFoodName.trim();
            if(!newFoodName.equals("")){
                Food userNewFood = new Food();
                userNewFood.setName(newFoodName);
                userNewFood.setMatch(null);
                userNewFood.setNoMatch(null);

                String differentFoodName = FoodView.showPaneFoodDifferenceQuestion(newFoodName, current.getName());

                Food questionDifferentFood = new Food();
                questionDifferentFood.setName(differentFoodName);
                questionDifferentFood.setMatch(userNewFood);
                questionDifferentFood.setNoMatch(current);

                return questionDifferentFood;
            }
        }
        return null;
    }

}
