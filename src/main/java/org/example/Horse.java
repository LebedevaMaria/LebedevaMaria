package org.example;

public class Horse extends Animals {
    @Override
    public void printSquad() {
        System.out.println("Лошадь является травоядным");
    }

    @Override
    public void typeFood() {
        System.out.println("Лошадь питается травой");
    }

    @Override
    public void printDoing() {
        System.out.println("Лошадь ходит");
    }
}
