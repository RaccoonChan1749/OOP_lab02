package com.averkina;

public class QueueException extends OutOfMemoryError {
    public String toString()
    {
        return "Ошибка! Переполнена очередь!";
    }
}