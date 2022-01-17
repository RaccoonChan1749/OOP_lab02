package com.averkina;

import java.io.IOException;

class NotFileException extends IOException {
    public String toString()
    {
        return "Ошибка! Файл не найден!";
    }
}