package com.averkina;

//на автомобиле
public class ConcreteStrategyDriving implements Strategy {
    public void move (String onePoint, String twoPoint){
        System.out.printf("Перемещение на автомобиле из \""
                +onePoint+"\" в \""
                +twoPoint+"\"");
    }
}
