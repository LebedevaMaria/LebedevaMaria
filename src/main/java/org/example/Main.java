package org.example;

public class Main {
    public static void main(String[] args) {
        //Проверка лошади
        Horse horse = new Horse();
        horse.printSquad();
        horse.printDoing();
        horse.typeFood();

        System.out.println();
        //Проверка дельфина
        Dolphin dolphin = new Dolphin();
        dolphin.printSquad();
        dolphin.printDoing();
        dolphin.typeFood();

        System.out.println();
        //Проверка орла
        Eagle eagle = new Eagle();
        eagle.printSquad();
        eagle.printDoing();
        eagle.typeFood();

        System.out.println();
        //Проверка верблюда
        Camel camel = new Camel();
        camel.printSquad();
        camel.printDoing();
        camel.typeFood();

        System.out.println();
        //Проверка тигра
        Tiger tiger = new Tiger();
        tiger.printSquad();
        tiger.printDoing();
        tiger.typeFood();
    }
}