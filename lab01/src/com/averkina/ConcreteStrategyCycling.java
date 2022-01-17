package com.averkina;

//на велосипеде
public class ConcreteStrategyCycling implements Strategy {
    public void move (String onePoint, String twoPoint){
        System.out.printf("Перемещение на велосипеде из \""
                +onePoint+"\" в \""
                +twoPoint+"\"");
    }
}
