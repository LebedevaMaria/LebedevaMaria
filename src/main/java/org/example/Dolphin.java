package org.example;

public class Dolphin extends Animals {

    @Override
    public void printDoing() {
        System.out.println("Дельфин плавает");
    }

    @Override
    public void printSquad() {
        System.out.println("Дельфин является хищником");
    }

    @Override
    public void typeFood() {
        System.out.println("Дельфин есть рыбу");
    }

}
