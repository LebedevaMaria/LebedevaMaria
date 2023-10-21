package org.example;

public class Camel extends Animals{
    @Override
    public void printDoing() {
        System.out.println("Верблюд ходит");
    }

    @Override
    public void printSquad() {
        System.out.println("Верблюд травоядный");
    }

    @Override
    public void typeFood() {
        System.out.println("Верблюд есть траву");
    }
}
