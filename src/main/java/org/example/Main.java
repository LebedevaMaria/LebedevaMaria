package org.example;

public class Main {
    public static void main(String[] args){
        //Проверка верблюда
        Camel camel = new Camel();
        camel.printSquad();
        camel.printDoing();
        camel.typeFood();

        System.out.println();
        //Проверка орла
        Eagle eagle = new Eagle();
        eagle.printSquad();
        eagle.printDoing();
        eagle.typeFood();

        System.out.println();
        //Проверка лошади
        Horse horse = new Horse();
        horse.printSquad();
        horse.printDoing();
        horse.typeFood();
    }
}
