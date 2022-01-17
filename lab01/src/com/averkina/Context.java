package com.averkina;

public class Context {
    private Strategy strategy;

    Context(String type)
    {
        switch (type) {
            case  ("walking"): //пешком
                this.strategy = new ConcreteStrategyWalking();
                break;
            case  ("cycling"): //на велосипеде
                this.strategy = new ConcreteStrategyCycling();
                break;
            case  ("transit"): //на общественном транспорте
                this.strategy = new ConcreteStrategyTransit();
                break;
            case  ("driving"): //на автомобиле
                this.strategy = new ConcreteStrategyDriving();
                break;
            case  ("flights"): //на самолете
                this.strategy = new ConcreteStrategyFlights();
                break;
        }
    }

    public void move (String onePoint, String twoPoint){
        this.strategy.move(onePoint,twoPoint);
    }
}
