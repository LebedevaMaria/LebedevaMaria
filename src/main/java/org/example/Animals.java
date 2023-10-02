package org.example;

public class Animals {
    public String animal;

    public void typeAnimal() {
        if (animal == "Лошадь" || animal == "Верблюд") {
            System.out.println(this.animal + " является травоядным");
        } else {
            System.out.println(this.animal + " является хищником");
        }
    }

    public void moving() {
        if (animal == "Лошадь" || animal == "Тигр" || animal == "Верблюд") {
            System.out.println(this.animal + " идёт");
        } else if (animal == "Дельфин") {
            System.out.println(this.animal + " плывет");
        } else {
            System.out.println(this.animal + " летит");
        }
    }

    public void eating(String[] food) {
        if (animal == "Тигр") {
            for (int i = 0; i < food.length; i++) {
                if (food[i] != "Говядину"){
                    System.out.println(this.animal + " не ест это");
                } else{
                    System.out.println(this.animal + " ест");
                }
            }
        } else if (animal == "Дельфин") {
            for (int i = 0; i < food.length; i++) {
                if (food[i] != "Рыба"){
                    System.out.println(this.animal + " не ест это");
                } else{
                    System.out.println(this.animal + " ест");
                }
            }
        } else if (animal == "Лошадь" || animal == "Верблюд"){
            for (int i = 0; i < food.length; i++) {
                if (food[i] != "Трава"){
                    System.out.println(this.animal + " не ест это");
                } else{
                    System.out.println(this.animal + " ест");
                }
            }
        } else {
            for (int i = 0; i < food.length; i++) {
                if (food[i] == "Трава"){
                    System.out.println(this.animal + " не ест это ");
                } else{
                    System.out.println(this.animal + " ест");
                }
            }
        }
    }
}
