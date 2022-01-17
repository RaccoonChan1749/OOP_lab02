package com.averkina;

//на общественном транспорте
public class ConcreteStrategyTransit implements Strategy {
    public void move (String onePoint, String twoPoint){
        System.out.printf("Перемещение на общественном транспорте из \""
                +onePoint+"\" в \""
                +twoPoint+"\"");
    }
}
