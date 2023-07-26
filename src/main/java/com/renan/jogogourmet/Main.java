package main.java.com.renan.jogogourmet;

import main.java.com.renan.jogogourmet.service.FoodService;
import main.java.com.renan.jogogourmet.view.FoodView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        FoodService foodService = new FoodService();
        JFrame main = FoodView.showMainPane(foodService);
        main.setVisible(true);
    }

}