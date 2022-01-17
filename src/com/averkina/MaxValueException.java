package com.averkina;

class MaxValueException extends ArithmeticException {
    public String toString()
    {
        return "Ошибка! Превышено макс. кол-во элементов!";
    }
}