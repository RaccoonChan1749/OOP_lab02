package com.averkina;

//на самолете
public class ConcreteStrategyFlights implements Strategy {
    public void move (String onePoint, String twoPoint){
        System.out.printf("Перемещение на самолете из \""
                +onePoint+"\" в \""
                +twoPoint+"\"");
    }
}
