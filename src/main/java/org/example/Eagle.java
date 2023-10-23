package org.example;

public class Eagle extends Animals {
    @Override
    public void printDoing() {
        System.out.println("Орел летает");
    }

    @Override
    public void printSquad() {
        System.out.println("Орел является хищником");
    }

    @Override
    public void typeFood() {
        System.out.println("Орел есть любое мясо");
    }
}
