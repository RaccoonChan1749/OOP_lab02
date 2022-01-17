package com.averkina;

//пешком
public class ConcreteStrategyWalking implements Strategy {

    public void move (String onePoint, String twoPoint){
        System.out.printf("Перемещение пешком из \""
                +onePoint+"\" в \""
                +twoPoint+"\"");
    }
}
