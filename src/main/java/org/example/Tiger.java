package org.example;

public class Tiger extends Animals {

    @Override
    public void printDoing() {
        System.out.println("Тигр ходит");
    }

    @Override
    public void printSquad() {
        System.out.println("Тигр является хищником");
    }

    @Override
    public void typeFood() {
        System.out.println("Тигр есть говядину");
    }
}
