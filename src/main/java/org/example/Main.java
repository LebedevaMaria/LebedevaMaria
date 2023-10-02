package org.example;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Animals();
        animal.animal = "Лошадь";
        animal.typeAnimal();
        animal.moving();
        String[] food = {"Трава", "Мясо"};
        animal.eating(food);
    }
}