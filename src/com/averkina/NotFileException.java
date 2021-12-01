package com.averkina;

class NotFileException extends java.lang.Exception {
    public String toString()
    {
        return "Ошибка! Файл не найден!";
    }
}