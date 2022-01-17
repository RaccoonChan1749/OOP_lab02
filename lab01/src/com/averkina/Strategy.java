package com.averkina;

public interface Strategy {
    int a = 5;
    void move(String onePoint, String twoPoint);

    // метод по умолчанию
    default int getOne(){
        return 0;
    }
    // приватный метод
    private static int getTwo(){
        return 0;
    }
}
