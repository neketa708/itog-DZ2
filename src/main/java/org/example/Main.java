package org.example;

import org.example.data.Toy;
import org.example.model.ToyShop;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String FILENAME = "toys.csv";
    public static void main(String[] args) {
        try {
            ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);

            if (!toyFile.exists()){
                toyFile.createNewFile();
                shop.add(new Toy(1, "dddd", 5, 20));
                shop.add(new Toy(2, "ss", 1, 5));
                shop.add(new Toy(3, "dxx", 10, 40));
                shop.saveToFile(FILENAME);
            }else {
                shop.loadFromFile(FILENAME);
            }
            shop.setWeight(1,30);
            ArrayList<String> toyList = shop.getToyList();
            for (String toy:toyList) {
                System.out.println(toy);
            }
            ArrayList<Toy> winners = shop.playGame(3);
            System.out.println("выиграли");
            for (Toy t : winners){
                System.out.println(t.getName());
            }

            shop.saveToFile(FILENAME);
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}